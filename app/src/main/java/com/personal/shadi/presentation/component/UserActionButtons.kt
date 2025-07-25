package com.personal.shadi.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.Clear
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
    onReject: () -> (Unit)
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp, vertical = 16.dp)
    ) {
        IconButton(
            modifier = Modifier.size(64.dp),
            onClick = onReject,
            colors = IconButtonDefaults.iconButtonColors(containerColor = Color(0xFF860031))
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
            colors = IconButtonDefaults.iconButtonColors(containerColor = Color(0xFF008631))
        ) {
            Icon(
                modifier = Modifier.size(32.dp),
                imageVector = Icons.Outlined.Check,
                contentDescription = ""
            )
        }
    }
}