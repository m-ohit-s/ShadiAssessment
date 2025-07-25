package com.personal.shadi.domain.model

import com.personal.shadi.common.ProfileStatus
import com.personal.shadi.data.remote.dto.Dob
import com.personal.shadi.data.remote.dto.Location
import com.personal.shadi.data.remote.dto.Name

data class User(
    val dob: Dob,
    val email: String,
    val gender: String,
    val id: String,
    val location: Location,
    val name: Name,
    val phone: String,
    val picture: String,
    val status: ProfileStatus = ProfileStatus.NONE
)
