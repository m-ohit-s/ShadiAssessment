package com.personal.shadi.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.personal.shadi.common.Constants.PAGE_SIZE
import com.personal.shadi.common.Resource
import com.personal.shadi.domain.use_case.GetUsersUseCase
import com.personal.shadi.presentation.state.UserListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase
): ViewModel() {
    private val _state = MutableStateFlow(UserListState())
    val state: StateFlow<UserListState> = _state.asStateFlow()

    private var isFetching = true
    val pageSize = PAGE_SIZE

    init {
        getUsers()
    }

    fun getUsers() {
        val current = _state.value
        if (current.isLoading || current.endReached) return
        getUsersUseCase(results = pageSize, page = current.page).onEach { result ->
            when(result) {
                is Resource.Loading -> {
                    _state.value = _state.value.copy(isLoading = true, error = "")
                }
                is Resource.Success -> {
                    val newUsers = result.data ?: emptyList()
                    val allUsers = _state.value.users + newUsers
                    _state.value = _state.value.copy(
                        users = allUsers,
                        error = "",
                        isLoading = false,
                        page = current.page + 1,
                        endReached = newUsers.isEmpty()
                    )
                }
                is Resource.Error -> {
                    _state.value = _state.value.copy(
                        isLoading = false,
                        error = result.message ?: "An unexpected error occurred"
                    )
                }
            }
            isFetching = false
        }.launchIn(viewModelScope)
    }

    fun clearError() {
        _state.value = _state.value.copy(error = "")
    }
}