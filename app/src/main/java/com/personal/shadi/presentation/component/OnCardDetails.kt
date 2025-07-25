package com.personal.shadi.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.personal.shadi.domain.model.User

@Composable
fun OnCardDetails(
    modifier: Modifier = Modifier,
    data: User
) {
    Row (
        modifier = modifier.fillMaxWidth().padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column (modifier = Modifier.weight(0.5f)) {
            Text(text = "${data.name.first}, ${data.dob.age}")
            Text(text = data.location.timezone.description)
        }
        IconButton(
            modifier = Modifier.size(64.dp),
            onClick = {},
            colors = IconButtonDefaults.iconButtonColors(containerColor = Color(0xFFAA0031))
        ) {
            Icon(
                modifier = Modifier.size(32.dp),
                imageVector = Icons.Outlined.FavoriteBorder,
                contentDescription = ""
            )
        }
    }
}