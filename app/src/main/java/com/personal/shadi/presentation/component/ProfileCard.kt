package com.personal.shadi.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.personal.shadi.domain.model.User

@Composable
fun ProfileCard(modifier: Modifier = Modifier, user: User) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center
        ) {
            ProfileImage(url = user.picture.large)
            Spacer(modifier = Modifier.height(8.dp))
            OnCardDetails(data = user)
            Spacer(modifier = Modifier.height(8.dp))
            UserActionButtons(onAccept = {}, onReject = {})
        }
    }
}
