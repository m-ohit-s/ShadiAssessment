package com.personal.shadi.data.remote.api.dto

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
    val picture: Picture,
    val registered: Registered
)

fun Result.toUser(): User {
    return User(
        id = id,
        cell = cell,
        dob = dob,
        email = email,
        gender = gender,
        location = location,
        name = name,
        phone = phone,
        picture = picture,
        registered = registered
    )
}