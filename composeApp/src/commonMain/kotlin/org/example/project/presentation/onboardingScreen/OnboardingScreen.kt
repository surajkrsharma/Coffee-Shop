package org.example.project.presentation.onboardingScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import coffeeshop.composeapp.generated.resources.Res
import coffeeshop.composeapp.generated.resources.Welcome_to_our_cozy_coffee_text
import coffeeshop.composeapp.generated.resources.backgroundimage
import coffeeshop.composeapp.generated.resources.fall_in_love_text
import coffeeshop.composeapp.generated.resources.get_started
import coffeeshop.composeapp.generated.resources.sora_regular
import coffeeshop.composeapp.generated.resources.sora_semi_bold
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun OnboardingScreen(navController: NavController) {

    ConstraintLayout {
        val (backgroundImage, backgroundShape, headingText, text, startButton) = createRefs()
        Image(
            painter = painterResource(Res.drawable.backgroundimage),
            contentDescription = "",
            modifier = Modifier.constrainAs(backgroundImage) {
                start.linkTo(parent.start)
                top.linkTo(parent.top)
            }.fillMaxWidth(),
            contentScale = ContentScale.Crop,
        )
        Box(
            modifier = Modifier.constrainAs(backgroundShape) {
                top.linkTo(backgroundImage.bottom, (-80).dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }.fillMaxWidth().fillMaxHeight().background(
                brush = Brush.linearGradient(
                    colors = listOf(Color.Transparent, Color.Black),
                    start = Offset(100f, 0f),
                    end = Offset(100f, 200f)
                ), shape = RoundedCornerShape(0.dp)
            )
        )
        Text(
            stringResource(Res.string.fall_in_love_text),
            modifier = Modifier.constrainAs(headingText) {
                top.linkTo(backgroundImage.bottom)
                bottom.linkTo(backgroundImage.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }.wrapContentWidth(),
            color = Color.White,
            fontFamily = FontFamily(Font(Res.font.sora_semi_bold)),
            fontSize = 33.sp,
            letterSpacing = 2.sp,
            lineHeight = 50.sp,
            textAlign = TextAlign.Center
        )
        Text(
            stringResource(Res.string.Welcome_to_our_cozy_coffee_text),
            modifier = Modifier.constrainAs(text) {
                top.linkTo(headingText.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }.wrapContentWidth(),
            Color(0xA2A2A2A2),
            fontSize = 14.sp,
            letterSpacing = 2.sp,
            fontFamily = FontFamily(Font(Res.font.sora_regular)),
            textAlign = TextAlign.Center
        )
        Button(
            onClick = {
                navController.navigate("homeScreen") {
                    popUpTo("onboardingScreen") { inclusive = true }
                }
            },
            modifier = Modifier.constrainAs(startButton) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(text.bottom, 8.dp)
            }.padding(16.dp).fillMaxWidth().height(56.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFC67C4E),
                contentColor = Color.White,
                disabledContainerColor = Color.Gray,
                disabledContentColor = Color.LightGray,
            ),
            shape = RoundedCornerShape(16.dp)
        ) {

            Text(
                stringResource(Res.string.get_started),
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(Res.font.sora_semi_bold)),
            )
        }
    }
}