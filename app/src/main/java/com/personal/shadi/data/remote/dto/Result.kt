package com.personal.shadi.data.remote.dto

import com.personal.shadi.data.local.UserEntity
import com.personal.shadi.domain.model.User

data class Result(
    val cell: String,
    val dob: Dob,
    val email: String,
    val gender: String,
    val id: Id,
    val location: Location,
    val login: Login,
    val name: Name,
    val nat: String,
    val phone: String,
    val picture: Picture
)

fun Result.toUser(): User {
    return User(
        id = login.username,
        dob = dob,
        email = email,
        gender = gender,
        location = location,
        name = name,
        phone = phone,
        picture = picture.large
    )
}

fun Result.toEntity(): UserEntity {
    return UserEntity(
        id = login.username,
        title = name.title,
        firstName = name.first,
        lastName = name.last,
        email = email,
        phone = phone,
        picture = picture.large,
        city = location.city,
        country = location.country,
        dob = dob.date,
        age = dob.age,
        postcode = location.postcode,
        state = location.state,
        streetName = location.street.name,
        streetNumber = location.street.number,
        latitude = location.coordinates.latitude,
        longitude = location.coordinates.longitude,
        description = location.timezone.description,
        offset = location.timezone.offset,
        gender = gender
    )
}