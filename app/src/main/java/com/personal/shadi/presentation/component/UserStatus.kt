package com.personal.shadi.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun UserStatus(text: String, color: Color) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .background(color = color)
        .heightIn(min = 40.dp),
        contentAlignment = Alignment.Center) {
        Text(
            text = text,
            modifier = Modifier
                .fillMaxSize()
                .background(color = color),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 20.sp
        )
    }

}