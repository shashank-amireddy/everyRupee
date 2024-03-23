package com.application.everyrupee.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle

import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.takeOrElse
import androidx.compose.ui.text.Placeholder
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
                       textStyle: TextStyle = LocalTextStyle.current,
                       label: @Composable (() -> Unit)? = null,
                       placeholder: @Composable (() -> Unit)? = null,
                       arrangement: Arrangement.Horizontal = Arrangement.Start,
                       leadingIcon: @Composable (() -> Unit)? = null,
                       trailingIcon: @Composable (() -> Unit)? = null,
                       supportingText: @Composable (() -> Unit)? = null,
                       isError: Boolean = false,
                       visualTransformation: VisualTransformation = VisualTransformation.None,
                       keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
                       keyboardActions: KeyboardActions = KeyboardActions.Default,
                       singleLine: Boolean = false,
                       maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE,
                       interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
                       shape: Shape = TextFieldDefaults.shape,
                       colors: TextFieldColors = TextFieldDefaults.colors()
)

    {

        val textColor = TextPrimary
        val mergedTextStyle = textStyle.merge(TextStyle(color = textColor))
            BasicTextField(
                value = value,
//                modifier = modifier
//                    .defaultMinSize(
//                        minWidth = TextFieldDefaults.MinWidth,
//                        minHeight = TextFieldDefaults.MinHeight
//                    ),
                onValueChange = onValueChange,
                enabled = enabled,
                readOnly = readOnly,
                textStyle = mergedTextStyle,
                cursorBrush = SolidColor(Primary),
                visualTransformation = visualTransformation,
                keyboardOptions = keyboardOptions,
                keyboardActions = keyboardActions,
                interactionSource = interactionSource,
                singleLine = singleLine,
                maxLines = maxLines,

                decorationBox = @Composable { innerTextField ->
                    TextFieldDefaults.DecorationBox(
                        value = value,
                        innerTextField = innerTextField,
                        visualTransformation = visualTransformation,
                        placeholder = {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = arrangement,
                                verticalAlignment = CenterVertically
                            ) {
                                placeholder?.invoke()
                            }
                        },
                        label = label,
                        leadingIcon = leadingIcon,
                        trailingIcon = trailingIcon,
                        supportingText = supportingText,
                        shape = shape,
                        singleLine = singleLine,
                        enabled = enabled,
                        isError = isError,
                        interactionSource = interactionSource,
                        contentPadding = PaddingValues(horizontal = 16.dp),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            disabledContainerColor = Color.Transparent,
                            focusedTextColor = TextPrimary,
                            unfocusedTextColor = TextPrimary,
                            disabledTextColor = TextPrimary,
                            cursorColor = Primary,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent,
                        ),

                    )
                })
        }



