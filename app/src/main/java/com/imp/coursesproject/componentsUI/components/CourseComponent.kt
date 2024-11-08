package com.imp.coursesproject.componentsUI.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.imp.coursesproject.data.Course
import com.imp.coursesproject.ui.theme.Background

@Composable
fun CourseComponent(
    course: Course,
    onClick:(Course)-> Unit) {
    val prefixPicture:String = "https://edteam-media.s3.amazonaws.com/courses/original/"

    Card(
        border = BorderStroke(1.dp, Color.Black),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { onClick(course) },
        shape = RoundedCornerShape(8.dp)) {
        Column(modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data("$prefixPicture${course.picture}")
                    .crossfade(1000)
                    .build(),
                contentDescription = course.name,
                contentScale = ContentScale.Crop)
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.background(Background)
                    .fillMaxWidth()
                    .padding(4.dp)
            ) {
                Text(
                    text = course.name,
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Nivel: ${course.level}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.White
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun CourseComponentPreview() {
    CourseComponent(Course("Pe","pe","pe","pe","pe","pe","pe","pe"), onClick = {course ->
        println(course)
    })

}