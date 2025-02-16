package com.example.prueba1.client

import android.content.Context
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.prueba1.util.Properties

object Clients {

    fun instance(context: Context) : Retrofit{
        return Retrofit.Builder()
            .baseUrl(Properties.getProperty("api.url", context))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}