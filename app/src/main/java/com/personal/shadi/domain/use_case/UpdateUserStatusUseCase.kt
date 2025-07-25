package com.personal.shadi.domain.use_case

import com.personal.shadi.common.ProfileStatus
import com.personal.shadi.domain.repository.UserRepository
import javax.inject.Inject

class UpdateUserStatusUseCase @Inject constructor(
    private val repository: UserRepository
) {
    suspend operator fun invoke(userId: String, status: ProfileStatus) = repository.updateUserStatus(userId, status)
}