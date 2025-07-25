package com.personal.shadi.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.personal.shadi.presentation.component.ProfileCard
import com.personal.shadi.presentation.component.RetrySection

@Composable
fun ProfileListScreen(
    modifier: Modifier = Modifier,
    viewModel: UserListViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsState().value
    val itemCount = state.users.size
    Column(modifier =modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.weight(1f).padding(horizontal = 24.dp)) {
            items(itemCount) { index ->
                if (index >= itemCount - 1 && !state.endReached && !state.isLoading) {
                    viewModel.getUsers()
                }
                ProfileCard(user = state.users[index])
                Spacer(modifier = Modifier.height(20.dp))
            }
        }

        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth()) {
            if(state.isLoading) {
                CircularProgressIndicator(color = MaterialTheme.colorScheme.primary)
            }
            if(state.error.isNotEmpty()) {
                RetrySection(
                    error = state.error,
                ) {
                    viewModel.getUsers()
                }
            }
        }
    }
}