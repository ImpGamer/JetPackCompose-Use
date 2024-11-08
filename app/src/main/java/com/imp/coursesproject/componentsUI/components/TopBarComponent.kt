package com.imp.coursesproject.componentsUI.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarComponent(title:String,style:TextStyle,icon:ImageVector,onIconClicked:()->Unit) {
    CenterAlignedTopAppBar(title = {
        Text(text = title,
            style = style
        )
    },
       colors = TopAppBarDefaults.largeTopAppBarColors(
           containerColor = MaterialTheme.colorScheme.primary,
           titleContentColor = Color.White
       ),
        navigationIcon = {
            IconButton(onClick = {onIconClicked()}) {
                Icon(imageVector = icon,
                    contentDescription = "Menu",
                    tint = Color.White)
            }
        },
        actions = {
            Icon(
                imageVector = Icons.Filled.Info,
                contentDescription = "Info",
                tint = Color.White
            )
        },
        modifier = Modifier.fillMaxWidth()
    )
}