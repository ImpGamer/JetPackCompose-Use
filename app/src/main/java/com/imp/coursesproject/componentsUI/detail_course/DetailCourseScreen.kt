package com.imp.coursesproject.componentsUI.detail_course

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.imp.coursesproject.R
import com.imp.coursesproject.componentsUI.components.IconTextComponent
import com.imp.coursesproject.componentsUI.components.TopAppBarComponent
import com.imp.coursesproject.data.Course
import com.imp.coursesproject.ui.theme.Background

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailCourseScreen(course:Course,navController: NavController) {
    val prefixPicture:String = "https://edteam-media.s3.amazonaws.com/courses/original/"
    Scaffold(modifier = Modifier.fillMaxWidth(),
        topBar = {
            TopAppBarComponent(title = "Detalle Curso",
                style = MaterialTheme.typography.bodyLarge,
                icon = Icons.Filled.ArrowBack,
                onIconClicked = {
                    navController.popBackStack()
                }
            )
        }) {paddingValues ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
            verticalArrangement = Arrangement.spacedBy(5.dp)) {
            AsyncImage(model = ImageRequest.Builder(LocalContext.current)
                .data("$prefixPicture${course.picture}")
                .crossfade(500)
                .build(),
                contentDescription = course.name,
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1.5f),
                contentScale = ContentScale.Crop)

            Card(modifier = Modifier
                .fillMaxWidth()
                .weight(3f)
                .padding(8.dp),
                border = BorderStroke(1.dp, Color.Black),
                colors = CardDefaults.cardColors(
                    containerColor = Background,
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)) {
                    Text(text = course.name,
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Text(text = course.subtitle,
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(text = stringResource(R.string.what_will_you_learn),
                        style = MaterialTheme.typography.bodyLarge)
                    IconTextComponent(
                        icon = Icons.Filled.CheckCircle,
                        text = "lorem ipsum strong lopem amfum impurium",
                        color = Color.Green)

                    Spacer(modifier = Modifier.height(25.dp))
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly) {

                        IconTextComponent(
                            icon = Icons.Filled.DateRange,
                            text = course.start)
                        IconTextComponent(
                            icon = Icons.Outlined.PlayArrow,
                            text = course.duration)
                        IconTextComponent(
                            icon = Icons.Filled.Info,
                            text = course.level)
                    }

                    Spacer(modifier = Modifier.height(30.dp))
                    Button(onClick = {println("Redireccionando a la compra...")},
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.onPrimaryContainer
                        ),
                        border = BorderStroke(2.dp,Color.White),
                        shape = RoundedCornerShape(8.dp)) {
                        Text(text = stringResource(R.string.buy_button),
                            style = MaterialTheme.typography.bodyMedium)
                    }

                }
            }
        }
    }
}

/*@Preview(showSystemUi = true)
@Composable
fun DetailCourseScreenPreview() {
    DetailCourseScreen(Course("","","","","","","",""))
}*/