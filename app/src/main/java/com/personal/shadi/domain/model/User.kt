package com.personal.shadi.domain.model

import com.personal.shadi.data.remote.api.dto.Dob
import com.personal.shadi.data.remote.api.dto.Id
import com.personal.shadi.data.remote.api.dto.Location
import com.personal.shadi.data.remote.api.dto.Name
import com.personal.shadi.data.remote.api.dto.Picture
import com.personal.shadi.data.remote.api.dto.Registered

data class User(
    val cell: String,
    val dob: Dob,
    val email: String,
    val gender: String,
    val id: Id,
    val location: Location,
    val name: Name,
    val phone: String,
    val picture: Picture,
    val registered: Registered
)
