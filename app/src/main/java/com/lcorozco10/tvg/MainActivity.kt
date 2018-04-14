package com.lcorozco10.tvg

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.location.LocationManager.*
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),View.OnClickListener, SensorEventListener {

    private lateinit var backButton:Button
    private lateinit var locationButton:Button
    private lateinit var nextButton:Button

    private lateinit var edtSomeText:EditText

    private lateinit var proximityValueTextView:TextView
    private lateinit var welcomeTextView:TextView
    private lateinit var locationTextView:TextView

    private lateinit var sensorManager: SensorManager
    private lateinit var sensor:Sensor
    private var locationManager : LocationManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        proximityValueTextView = findViewById(R.id.proximityValueTextView)
        welcomeTextView = findViewById(R.id.welcomeTextView)
        locationTextView =  findViewById(R.id.locationTextView)


        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY)

        // Create persistent LocationManager reference
        locationManager = getSystemService(LOCATION_SERVICE) as LocationManager?



        var extras = intent.extras
        if (extras!= null){
            var user = extras["Username"]
            welcomeTextView.text = "${welcomeTextView.text} $user"
        }

        backButton = findViewById(R.id.backButton)
        locationButton = findViewById(R.id.locationButton)
        nextButton = findViewById(R.id.nextButton)

        backButton.setOnClickListener(this)
        nextButton.setOnClickListener(this)
        locationButton.setOnClickListener(this)
    }

    override fun onResume() {
        super.onResume()
        sensorManager.registerListener(
                this,
                sensor,
                SensorManager.SENSOR_DELAY_NORMAL
        )
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onClick(p0: View?) {
        when {
            p0?.id == R.id.backButton -> {
                val intent = Intent( this, LoginActivity::class.java)
                startActivity(intent)
            }
            p0?.id == R.id.locationButton ->{

                if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    if (shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_FINE_LOCATION)) {
                        return
                    }
                }

                try {
                    // Request location updates
                    locationManager?.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0L, 0f, locationListener)
                } catch (ex: SecurityException) {
                    Log.d("myTag", "Security Exception, no location available")
                }
            }
            p0?.id == R.id.nextButton ->{
                val intent = Intent(this, ListViewActivity::class.java)
                startActivity(intent)
            }
            else -> proximityValueTextView.text = "Nada"
        }

        Log.d("click", "Test")
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }

    override fun onSensorChanged(p0: SensorEvent?) {
        proximityValueTextView.text = p0!!.values[0].toString()

        /*textValue.text =  p0!!.values.zip("XYZ".toList()).fold("") { acc, pair ->
            "$acc${pair.second}: ${pair.first}\n"
        }*/
    }

    //define the listener
    private val locationListener: LocationListener = object : LocationListener {
        override fun onLocationChanged(location: Location) {
            locationTextView.text = "(${location.longitude} , ${location.latitude})"
        }
        override fun onStatusChanged(provider: String, status: Int, extras: Bundle) {}
        override fun onProviderEnabled(provider: String) {}
        override fun onProviderDisabled(provider: String) {}
    }
}
