package com.example.tutonder.network

data class User(
    val id: String,
    val nombre: String,
    val carrera: String,
    val contacto: String,
    val password: String,
    val tipo: Int,
    val cursos: List<String>?,
    val detalles: String?,
    val calificacion: Double?,
    val comentarios: List<String>?
)