package com.personal.shadi.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.personal.shadi.domain.model.User

@Composable
fun OnCardDetails(
    modifier: Modifier = Modifier,
    data: User
) {
    Column(
        modifier = modifier.fillMaxWidth().padding(8.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        Text(text = "${data.name.first} ${data.name.last}, ${data.dob.age}", fontWeight = FontWeight.Bold, fontSize = 28.sp)
        Text(text = data.location.timezone.description)
    }
}