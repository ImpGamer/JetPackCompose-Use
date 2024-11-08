package com.imp.coursesproject.componentsUI.courses

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.imp.coursesproject.R
import com.imp.coursesproject.componentsUI.components.CourseComponent
import com.imp.coursesproject.componentsUI.components.CoursesHeader
import com.imp.coursesproject.componentsUI.components.TopAppBarComponent
import com.imp.coursesproject.data.Course
import java.io.IOException
import java.io.InputStream
import java.net.URLEncoder

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoursesScreen(navController: NavController) {
    val context = LocalContext.current

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface),
        topBar = {
            TopAppBarComponent(
                title = stringResource(R.string.courses_title),
                style = MaterialTheme.typography.bodyLarge,
                icon = Icons.Filled.Menu,
                onIconClicked = {TODO()}
            )
        }
    ) {paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues)
                .padding(top = 8.dp),
            contentPadding = PaddingValues(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                CoursesHeader(title = stringResource(R.string.available_courses),
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Medium,
                        fontFamily = FontFamily.Monospace
                    )
                )
            }
            val gson = Gson() //Creacion de un objeto GSON
            val jsonCourses = loadData(context,"data_course.json") //Carga del archivo y alamcenamiento de la data en una variable String
            val itemType = object : TypeToken<List<Course>>() {}.type //Declaracion el tipo de dato de conversion
            val courses = gson.fromJson<List<Course>>(jsonCourses,itemType)

            items(courses) {course ->
                CourseComponent(course = course,
                    onClick = {
                        val courseJson = Gson().toJson(it)
                        // Codificar el JSON para hacerlo URL-safe
                        val encodedCourseJson = URLEncoder.encode(courseJson, "UTF-8")
                        navController.navigate("detail_course_screen/$encodedCourseJson")
                    })
            }

        }
    }
}

fun loadData(context:Context,file:String):String {
    var content:String = ""
    try {
        val stream:InputStream = context.assets.open(file)
        val size:Int = stream.available()
        val buffer = ByteArray(size)
        stream.read(buffer)
        stream.close()
        content = String(buffer)

    }catch (ex: IOException) {
        throw ex
    }
    return content
}

/*@Preview(showSystemUi = true)
@Composable
fun CoursesScreenPreview() {
    CoursesScreen()
}*/