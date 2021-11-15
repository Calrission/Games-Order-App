package com.example.orderapp

import android.app.AlertDialog
import android.content.Context
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun initRetrofit(): Api{
    return Retrofit.Builder()
        .baseUrl("https://api.rawg.io/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(Api::class.java)
}

fun showDialogAlert(context: Context, title: String, message: String){
    AlertDialog.Builder(context)
        .setTitle(title)
        .setMessage(message)
        .setNegativeButton("OK", null)
        .show()
}

fun showDialogAlert(context: Context, title: String, t: Throwable){
    AlertDialog.Builder(context)
        .setTitle(title)
        .setMessage(t.message)
        .setNegativeButton("OK", null)
        .show()
}

fun showDialogAlert(context: Context, title: String){
    AlertDialog.Builder(context)
        .setTitle(title)
        .setMessage("Повторите попытку позже !")
        .setNegativeButton("OK", null)
        .show()
}