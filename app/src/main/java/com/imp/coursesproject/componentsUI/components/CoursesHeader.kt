package com.imp.coursesproject.componentsUI.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CoursesHeader(title:String,style:TextStyle) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = title,
            style = style)
        Spacer(modifier = Modifier.height(4.dp))
        Divider(
            thickness = 1.dp,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun CoursesHeaderPreview() {
    CoursesHeader("Cursos", TextStyle(fontSize = 20.sp,color = Color.Black))
}