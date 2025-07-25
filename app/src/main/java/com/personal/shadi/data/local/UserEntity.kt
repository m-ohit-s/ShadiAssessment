package com.personal.shadi.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.personal.shadi.common.ProfileStatus
import com.personal.shadi.data.remote.dto.Coordinates
import com.personal.shadi.data.remote.dto.Dob
import com.personal.shadi.data.remote.dto.Location
import com.personal.shadi.data.remote.dto.Name
import com.personal.shadi.data.remote.dto.Street
import com.personal.shadi.data.remote.dto.Timezone
import com.personal.shadi.domain.model.User

@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey
    val id: String,
    val title: String,
    val firstName: String,
    val lastName: String,
    val email: String,
    val phone: String,
    val picture: String,
    val city: String,
    val country: String,
    val dob: String,
    val age: Int,
    val postcode: String,
    val state: String,
    val streetNumber: Int,
    val streetName: String,
    val latitude: String,
    val longitude: String,
    val description: String,
    val offset: String,
    val gender: String,
    val status: String = ProfileStatus.NONE.name
)


fun UserEntity.toUser(): User {
    return User(
        id = id,
        email = email,
        phone = phone,
        picture = picture,
        name = Name(first = firstName, last = lastName, title = title),
        gender = gender,
        dob = Dob(age = age, date = dob),
        location = Location(
            city = city,
            country = country,
            postcode = postcode,
            state = state,
            street = Street(name = streetName, number = streetNumber),
            timezone = Timezone(
                description = description,
                offset = offset
            ),
            coordinates = Coordinates(latitude = latitude, longitude = longitude)
        ),
        status = status.toProfileStatus()
    )
}

private fun String.toProfileStatus(): ProfileStatus {
    return when (this) {
        ProfileStatus.LIKED.name -> ProfileStatus.LIKED
        ProfileStatus.DISLIKED.name -> ProfileStatus.DISLIKED
        ProfileStatus.FAVORITE.name -> ProfileStatus.FAVORITE
        else -> ProfileStatus.NONE
    }
}

