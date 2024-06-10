package dev.jaysonguillen.personapp.data.model


import com.google.gson.annotations.SerializedName

data class PersonRemote(
    @SerializedName("cell")
    val cell: String,
    @SerializedName("dob")
    val dob: Dob,
    @SerializedName("email")
    val email: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("location")
    val location: Location,
    @SerializedName("name")
    val name: Name,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("picture")
    val picture: Picture,
)