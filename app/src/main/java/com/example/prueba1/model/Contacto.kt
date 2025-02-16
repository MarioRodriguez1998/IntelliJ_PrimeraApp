package com.example.prueba1.model
import java.util.Date

data class Contacto(
    @SerializedName("id") val id: Long,
    @SerializedName("nombre") val nombre: String,
    @SerializedName("fechaNacimiento") val fechaNacimiento: LocalDate,
    @SerializedName("correo") val correo: String,
    @SerializedName("telefono") val telefono: String,
    @SerializedName("fotoRuta") val fotoRuta: String,
    @SerializedName("direccion") val direccion: Int,
)
