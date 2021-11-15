package com.example.orderapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("games/{id}")
    fun game(@Path("id") id: String, @Query("key") key: String = Info.tokenAPI): Call<Game>
}