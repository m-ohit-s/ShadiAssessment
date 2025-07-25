package com.personal.shadi.presentation.state

import com.personal.shadi.domain.model.User

data class UserListState(
    val isLoading: Boolean = false,
    val users: List<User> = emptyList(),
    val error: String = "",
    val page: Int = 1,
    val endReached: Boolean = false
)