package com.personal.shadi.presentation

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.personal.shadi.presentation.component.ProfileCard

@Composable
fun ProfileListScreen(
    modifier: Modifier = Modifier,
    viewModel: UserListViewModel = hiltViewModel()
) {
    val users = viewModel.userPagingData.collectAsLazyPagingItems()
    val context = LocalContext.current

    LaunchedEffect(users.loadState) {
        if (users.loadState.refresh is LoadState.Error) {
            Toast.makeText(
                context, (users.loadState.refresh as LoadState.Error).error.message,
                Toast.LENGTH_LONG
            ).show()
        }
    }
    Box(modifier = Modifier.fillMaxSize()) {
        if (users.loadState.refresh is LoadState.Loading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        } else {
            Column(modifier = modifier.fillMaxSize()) {
                LazyColumn(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 24.dp),
                    contentPadding = PaddingValues(vertical = 16.dp)
                ) {
                    items(users.itemCount, key = { index -> users[index]?.id ?: index }) { index ->
                        val user = users[index]
                        user?.let {
                            ProfileCard(user = it)
                            Spacer(modifier = Modifier.height(20.dp))
                        }
                    }
                    item {
                        if (users.loadState.append is LoadState.Loading) {
                            CircularProgressIndicator()
                        }
                    }
                }
            }
        }
    }
}