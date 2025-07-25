package com.personal.shadi.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.personal.shadi.common.ProfileStatus
import com.personal.shadi.domain.model.User
import com.personal.shadi.presentation.UserListViewModel

@Composable
fun ProfileCard(
    modifier: Modifier = Modifier,
    user: User,
    viewModel: UserListViewModel = hiltViewModel()
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center
        ) {
            ProfileImage(url = user.picture)
            Spacer(modifier = Modifier.height(8.dp))
            OnCardDetails(data = user)
            Spacer(modifier = Modifier.height(8.dp))

            when (user.status) {
                ProfileStatus.LIKED -> UserStatus("LIKED", Color(0xFF6dbfb8))
                ProfileStatus.DISLIKED -> UserStatus("DISLIKED", Color(0xFFff706f))
                ProfileStatus.FAVORITE -> UserStatus("FAVORITE", Color(0xFF71a3c1))
                ProfileStatus.NONE -> {
                    UserActionButtons(
                        onAccept = { viewModel.onStatusChange(user.id, ProfileStatus.LIKED) },
                        onReject = { viewModel.onStatusChange(user.id, ProfileStatus.DISLIKED) },
                        onFav = { viewModel.onStatusChange(user.id, ProfileStatus.FAVORITE) }
                    )
                }
            }
        }
    }
}
