package com.application.everyrupee.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.application.everyrupee.ui.theme.Primary
import com.application.everyrupee.ui.theme.TextPrimary


@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun UnstyledTextField (value: String,
                       onValueChange: (String) -> Unit,
                       modifier: Modifier = Modifier,
                       enabled: Boolean = true,
                       readOnly: Boolean = false,
                       textStyle: TextStyle = TextStyle.Default,
                       keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
                       keyboardActions: KeyboardActions = KeyboardActions.Default,
                       singleLine: Boolean = false,
                       maxLines: Int = Int.MAX_VALUE,
                       visualTransformation: VisualTransformation = VisualTransformation.None,
                       onTextLayout: (TextLayoutResult) -> Unit = {},
                       interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
                       cursorBrush: Brush = SolidColor(Primary),
                       decorationBox: @Composable (innerTextField: @Composable () -> Unit) -> Unit =
                           @Composable { innerTextField -> innerTextField() }
)
{
    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        modifier= modifier.padding(3.dp).defaultMinSize(minWidth = 80.dp, minHeight = 44.dp).wrapContentHeight(align = Alignment.CenterVertically),
        enabled = enabled,
        readOnly = readOnly,
        textStyle = textStyle.merge(TextStyle(
            color = TextPrimary,
            fontSize = 16.sp,
            )
        ),
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        singleLine= singleLine,
        maxLines = maxLines,
        visualTransformation = visualTransformation,
        onTextLayout = onTextLayout,
        interactionSource = interactionSource,
        cursorBrush = cursorBrush,
        decorationBox = decorationBox
    )
}