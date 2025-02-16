package com.example.prueba1.service

import com.example.prueba1.model.Contacto
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

internal interface ContactoService {
    @POST("contacto")
    fun getAll(): Call<List<Contacto>>

    @POST("contacto/add")
    fun add(@Body contacto: Contacto): Call<Contacto>

    @POST("contacto/edit/{id}")
    fun edit(@Path("id") id: Long, @Body contacto: Contacto): Call<Contacto>

    @POST("contacto/remove/{id}")
    fun remove(@Path("id") id: Long): Call<Contacto>

    @POST("contacto/get/{id}")
    fun get(@Path("id") id: Long): Call<Void>
}