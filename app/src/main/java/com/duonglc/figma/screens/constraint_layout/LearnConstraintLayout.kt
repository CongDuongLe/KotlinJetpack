package com.duonglc.figma.screens.constraint_layout

import android.inputmethodservice.Keyboard
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.duonglc.figma.ui.theme.*
import com.duonglc.figma.R

@Composable
fun LearnConstraintLayout() {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White,
    ){
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
    ){
        IngredientItem(
            icon = R.drawable.weed,
            modifier = Modifier.size(104.dp),
            iconSize = 44,
            value = 8,
            name = "Minl Leaves",
        )
        IngredientItem(
            icon = R.drawable.lemon,
            modifier = Modifier.size(104.dp),
            iconSize = 44,
            value = 2,
            name = "Lemon Wedges",
        )
        IngredientItem(
            icon = R.drawable.juice,
            modifier = Modifier.size(104.dp),
            iconSize = 44,
            value = 30,
            unit = "ml",
            name = "Lemon Juice",
        )
    }

    }



}



@Composable
fun IngredientItem(
    @DrawableRes icon : Int,
    modifier: Modifier = Modifier,
    iconSize: Int = 50,
    value: Int = 30,
    name : String = "Lemon",
    unit : String? = null,
){

    val backgroundColor = Color(0xFFFEF9E4)
    val borderColor =Color(0xB2FBE897)
    val valueTextColor = Color(0xFFFB7D8A)


    ConstraintLayout (
        modifier = modifier.
            background(
                color = backgroundColor,
                shape = CircleShape
            )
            .border(
                width = 1.dp,
                color = borderColor,
                shape = CircleShape
            )
            .padding(1.dp)
    ){
        val horizontalGuideLine50percent = createGuidelineFromTop(0.5f)
        val verticalGuideLine50percent = createGuidelineFromStart(0.5f)

        val imageIcon = createRef()

        val (textValue, textName, textUnit) = createRefs()

        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            contentScale = ContentScale.FillHeight,
            modifier = Modifier
                .constrainAs(imageIcon){
                    top.linkTo(parent.top)
                    bottom.linkTo(horizontalGuideLine50percent)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    height = Dimension.fillToConstraints
                }
                .size(iconSize.dp)
        )

        Text(
            text = value.toString(),
            style = TextStyle(
                fontWeight = FontWeight.SemiBold,
                fontSize = 28.sp,
                lineHeight = 14.sp,
                color = valueTextColor,
                textAlign = TextAlign.Center,
            ),
            modifier = Modifier
                .constrainAs(textValue){
                    top.linkTo(horizontalGuideLine50percent, margin = 1.dp)
                    end.linkTo(verticalGuideLine50percent, margin = 1.dp)
                }
        )

        unit?.let{
            Text(
                text = unit,
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 14.sp,
                    fontWeight = FontWeight(600),
                    color = valueTextColor,
                    textAlign = TextAlign.Center,
                ),
                modifier = Modifier
                    .constrainAs(textUnit){
                        top.linkTo(textValue.bottom)
                        end.linkTo(textValue.end)
                    }
            )
        }


    }
}










@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PreviewLearnConstraintLayout() {
    LearnConstraintLayout()
}