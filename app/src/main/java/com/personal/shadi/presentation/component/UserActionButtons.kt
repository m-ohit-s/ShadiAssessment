package com.personal.shadi.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun UserActionButtons(
    modifier: Modifier = Modifier,
    onAccept: () -> (Unit),
    onReject: () -> (Unit),
    onFav: () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .padding(bottom = 16.dp)
    ) {
        Column {
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                IconButton(
                    modifier = Modifier.size(64.dp),
                    onClick = onFav,
                    colors = IconButtonDefaults.iconButtonColors(containerColor = Color(0xFF71a3c1))
                ) {
                    Icon(
                        modifier = Modifier.size(32.dp),
                        imageVector = Icons.Outlined.FavoriteBorder,
                        contentDescription = ""
                    )
                }
            }

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                IconButton(
                    modifier = Modifier.size(64.dp),
                    onClick = onReject,
                    colors = IconButtonDefaults.iconButtonColors(containerColor = Color(0xFFff706f))
                ) {
                    Icon(
                        modifier = Modifier.size(32.dp),
                        imageVector = Icons.Outlined.Clear,
                        contentDescription = ""
                    )
                }

                IconButton(
                    modifier = Modifier.size(64.dp),
                    onClick = onAccept,
                    colors = IconButtonDefaults.iconButtonColors(containerColor = Color(0xFF6dbfb8))
                ) {
                    Icon(
                        modifier = Modifier.size(32.dp),
                        imageVector = Icons.Outlined.Check,
                        contentDescription = ""
                    )
                }
            }
        }
    }
}