package com.personal.shadi.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.personal.shadi.common.Constants.PAGE_SIZE
import com.personal.shadi.common.ProfileStatus
import com.personal.shadi.common.Resource
import com.personal.shadi.domain.model.User
import com.personal.shadi.domain.use_case.GetUsersUseCase
import com.personal.shadi.domain.use_case.UpdateUserStatusUseCase
import com.personal.shadi.presentation.state.UserListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase,
    private val updateUserStatusUseCase: UpdateUserStatusUseCase
): ViewModel() {

    private val _currentPage = MutableStateFlow(1)
    val currentPage = _currentPage.asStateFlow()

    val pageSize = PAGE_SIZE
    val current = currentPage

    val userPagingData: Flow<PagingData<User>> = getUsersUseCase(pageSize, currentPage.value)
        .cachedIn(viewModelScope)

    fun onStatusChange(userId: String, status: ProfileStatus) {
        viewModelScope.launch {
            updateUserStatusUseCase(userId, status)
        }
    }
}