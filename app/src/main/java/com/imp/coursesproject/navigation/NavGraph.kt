package com.imp.coursesproject.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.gson.Gson
import com.imp.coursesproject.componentsUI.courses.CoursesScreen
import com.imp.coursesproject.componentsUI.detail_course.DetailCourseScreen
import com.imp.coursesproject.data.Course
import java.net.URLDecoder

@Composable
fun NavigationSetUp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "courses_screen", //Primera pantalla al iniciar
    ) {
        //Configurar las pantallas o composables que habra en la aplicacion
        composable(route = "courses_screen") {
            CoursesScreen(navController) //Pasarle como parametro al composable que hara la controlacion de navegacion
        }
        //Creacion de una "endpoint" con un parametro
        composable(route = "detail_course_screen/{courseJSON}") { backStackEntry  ->
            val encodedCourseJSON: String? = backStackEntry .arguments?.getString("courseJSON")
            // Decodificar el JSON
            val courseJSON = encodedCourseJSON?.let{
                URLDecoder.decode(it, "UTF-8")
            }
            val course = Gson().fromJson(courseJSON, Course::class.java)

            DetailCourseScreen(course,navController)
        }
    }
}