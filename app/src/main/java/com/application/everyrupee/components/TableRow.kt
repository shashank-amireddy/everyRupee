package com.application.everyrupee.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.application.everyrupee.R
import com.application.everyrupee.ui.theme.Destructive
import com.application.everyrupee.ui.theme.TextPrimary
import com.application.everyrupee.ui.theme.Typography

@Composable
fun TableRow(label: String, onClick: (String)-> Unit ,hasArrow:Boolean = false, isDestructive:Boolean = false){
        val textColor = if(isDestructive) Destructive else TextPrimary

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onClick(label) }
                .padding(horizontal = 16.dp, vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(text = label, style = Typography.bodyMedium, color = textColor)
            if (hasArrow) {
                Icon(
                    painterResource(id = R.drawable.right),
                    contentDescription = "Right arrow",

                    )
            }
        }

}