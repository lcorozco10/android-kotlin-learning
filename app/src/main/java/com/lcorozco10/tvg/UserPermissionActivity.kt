package com.lcorozco10.tvg

import android.Manifest
import android.content.pm.PackageManager
import android.location.LocationManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

class UserPermissionActivity : AppCompatActivity(),View.OnClickListener  {

    val ACCESS_FINE_LOCATION_REQUEST_CODE = 1
    private lateinit var getLocationButton:Button
    private lateinit var latitudeText:TextView
    private lateinit var longitudeText:TextView
    private  var locationManager:LocationManager? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_permission)
        getLocationButton = this.findViewById(R.id.locationButton)
        latitudeText = this.findViewById(R.id.latitudeTextView)
        longitudeText = this.findViewById(R.id.longitudeTextView)
        getLocationButton.setOnClickListener(this)

        locationManager = getSystemService(LOCATION_SERVICE) as LocationManager?
    }

    override fun onClick(p0: View?) {
        when{
            p0?.id == R.id.locationButton ->{
                var permission = ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)

                if (permission != PackageManager.PERMISSION_GRANTED)
                {
                    // Should we show an explanation?
                    if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                                    Manifest.permission.ACCESS_FINE_LOCATION)) {


                        Log.d("Permission:", "explanation")
                        // Show an explanation to the user *asynchronously* -- don't block
                        // this thread waiting for the user's response! After the user
                        // sees the explanation, try again to request the permission.

                    } else {

                        // No explanation needed, we can request the permission.

                        ActivityCompat.requestPermissions(this,arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),ACCESS_FINE_LOCATION_REQUEST_CODE)
                        Log.d("REQUEST:", " $permission")

                        // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                        // app-defined int constant. The callback method gets the
                        // result of the request.
                    }

                }

                Log.d("Permission:", " $permission")
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            ACCESS_FINE_LOCATION_REQUEST_CODE -> {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                    Log.d("Permission:", "granted: ${grantResults[0]}")

                } else {

                    Log.d("Permission:", "denied: ${grantResults[0]}")
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return
            }
        }// other 'case' lines to check for other
        // permissions this app might request
    }
}
