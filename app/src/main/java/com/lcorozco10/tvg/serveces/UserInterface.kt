package com.lcorozco10.tvg.serveces

import com.lcorozco10.tvg.pojo.Users
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

interface UserInterface {

    @retrofit2.http.GET("./")
    fun GetUser(@retrofit2.http.Query("q") query: String): Observable<List<Users>>

    companion object Factory {
        fun create(): UserInterface {
            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://ff119036.ngrok.io/")
                    .build()

            return retrofit.create(UserInterface::class.java)
        }
    }
}

class SearchRepository(val apiService: UserInterface) {
    fun GetUsers(query: String): Observable<List<Users>> {
        return apiService.GetUser(query = "location:$query")
    }
}

object SearchRepositoryProvider {
    fun SearchRepository(): SearchRepository {
        return SearchRepository(UserInterface.create())
    }
}
