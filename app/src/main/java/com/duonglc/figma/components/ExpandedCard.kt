package com.duonglc.figma.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.duonglc.figma.ui.theme.Shapes


@OptIn(ExperimentalMaterialApi::class)

@Composable
fun ExpandedCard(
    title: String,
    titleFontSize: TextUnit = MaterialTheme.typography.h6.fontSize,
    titleFontWeight: FontWeight = FontWeight.Bold,
    description: String,
    descriptionFontSize: TextUnit = MaterialTheme.typography.subtitle1.fontSize,
    descriptionFontWeight: FontWeight = FontWeight.Normal,
    descriptionMaxLines: Int = 4,
    shape: Shape = Shapes.medium,
    padding: Dp = 12.dp

) {
    var isExpanded by remember { mutableStateOf(false) }

        // renderCard
        Card(modifier = Modifier
                .fillMaxWidth()
                .animateContentSize(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = LinearOutSlowInEasing
                    )
                ), shape = shape, onClick = { isExpanded = !isExpanded }){
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(padding)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text = title,
                        fontSize = titleFontSize,
                        fontWeight = titleFontWeight,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                   IconButton(
                          modifier = Modifier
                            .alpha(ContentAlpha.medium),
                       onClick = { isExpanded = !isExpanded }
                   ) {
                       Icon(
                           imageVector = if (!isExpanded) Icons.Default.ArrowDropDown else Icons.Filled.KeyboardArrowUp,
                           contentDescription = "Expandable Icon"
                       )
                   }


                }
                if (isExpanded) {
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = description,
                        fontSize = descriptionFontSize,
                        fontWeight = descriptionFontWeight,
                        maxLines = descriptionMaxLines,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }

        }


}


@ExperimentalMaterialApi

@Composable
@Preview

fun PreviewExpandedCard() {
    ExpandedCard(
        title = "Expanded Card",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
                "sed do eiusmod tempor incididunt ut labore et dolore magna " +
                "aliqua. Ut enim ad minim veniam, quis nostrud exercitation " +
                "ullamco laboris nisi ut aliquip ex ea commodo consequat."

    )
}


