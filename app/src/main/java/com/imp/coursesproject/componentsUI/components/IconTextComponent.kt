package com.imp.coursesproject.componentsUI.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Icon
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun IconTextComponent(icon:ImageVector,text:String,color: Color? = null) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Icon(imageVector = icon,
            contentDescription = text,
            tint = color?:Color.White
        )
        Text(text = text,
            style = MaterialTheme.typography.bodySmall)
    }
}
