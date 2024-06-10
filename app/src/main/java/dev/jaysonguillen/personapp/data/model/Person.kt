package dev.jaysonguillen.personapp.data.model


import com.google.gson.annotations.SerializedName

data class Person(
    @SerializedName("results")
    val personResponse: List<PersonRemote>
)