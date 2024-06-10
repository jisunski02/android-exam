package dev.jaysonguillen.personapp.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(
    tableName = "persons"
)
data class PersonLocal(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    @ColumnInfo("mobileNumber")
    @SerializedName("mobileNumber")
    val mobileNumber: String,
    @ColumnInfo("dateOfBirth")
    @SerializedName("dateOfBirth")
    val dateOfBirth: String,
    @ColumnInfo("email")
    @SerializedName("email")
    val email: String,
    @ColumnInfo("gender")
    @SerializedName("gender")
    val gender: String,
    @ColumnInfo("location")
    @SerializedName("location")
    val location: String,
    @ColumnInfo("fullName")
    @SerializedName("fullName")
    val fullName: String,
    @ColumnInfo("age")
    @SerializedName("age")
    val age: String,
    @ColumnInfo("phone")
    @SerializedName("phone")
    val phone: String,
    @ColumnInfo("urlPicture")
    @SerializedName("urlPicture")
    val urlPicture: String,
): Serializable
