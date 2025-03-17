package org.example.project.presentation.homeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import coffeeshop.composeapp.generated.resources.Res
import coffeeshop.composeapp.generated.resources.arrow_down
import coffeeshop.composeapp.generated.resources.container
import coffeeshop.composeapp.generated.resources.filter
import coffeeshop.composeapp.generated.resources.location
import coffeeshop.composeapp.generated.resources.location_text
import coffeeshop.composeapp.generated.resources.search
import coffeeshop.composeapp.generated.resources.sora_regular
import coffeeshop.composeapp.generated.resources.sora_semi_bold
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun HomeScreen(navController: NavController) {

    ConstraintLayout(modifier = Modifier) {
        val (backgroundImage, backgroundShape, searchBar, locationText, currentLocationText, icon, filterButton, startButton) = createRefs()
        Image(
            painterResource(Res.drawable.container),
            contentDescription = "",
            modifier = Modifier
                .constrainAs(backgroundShape) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                }
                .fillMaxWidth()
                .height(280.dp),
            contentScale = ContentScale.Crop
        )

        Text(
            stringResource(Res.string.location),
            modifier = Modifier
                .constrainAs(locationText) {
                    top.linkTo(parent.top, 24.dp)
                    start.linkTo(parent.start, 24.dp)
                }
                .wrapContentWidth(),
            Color(0xA2A2A2A2),
            fontSize = 12.sp,
            fontFamily = FontFamily(Font(Res.font.sora_regular)),
            textAlign = TextAlign.Center
        )

        Text(
            stringResource(Res.string.location_text),
            modifier = Modifier
                .constrainAs(currentLocationText) {
                    top.linkTo(locationText.bottom, 5.dp)
                    start.linkTo(locationText.start)
                }
                .wrapContentWidth(),
            Color(0xA2FFFFFF),
            fontSize = 14.sp,
            fontFamily = FontFamily(Font(Res.font.sora_semi_bold)),
            textAlign = TextAlign.Center)
        Icon(
            painter = painterResource(Res.drawable.arrow_down),
            contentDescription = "Icon",
            modifier = Modifier
                .constrainAs(icon) {
                    top.linkTo(currentLocationText.top)
                    start.linkTo(currentLocationText.end, 6.dp)
                    bottom.linkTo(currentLocationText.bottom)
                }
                .size(24.dp),
            tint = Color.White
        )

        Row(
            modifier = Modifier
                .constrainAs(searchBar) {
                    top.linkTo(currentLocationText.bottom, 24.dp)
                    start.linkTo(currentLocationText.start)
                    end.linkTo(filterButton.start)
                }) {
            // Search Bar Box
            Box(
                modifier = Modifier
                    .defaultMinSize(250.dp)
                    .height(54.dp)
                    .background(Color.White, shape = RoundedCornerShape(12.dp))
            ) {
                Icon(
                    painter = painterResource(Res.drawable.search),
                    contentDescription = "Search",
                    modifier = Modifier.size(24.dp),
                    tint = Color.Gray
                )

                BasicTextField(
                    value = "",
                    onValueChange = { /* handle text change */ },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Search
                    ),
                    keyboardActions = KeyboardActions(
                        onSearch = {
                            // Implement search action if needed
                        }
                    ),
                    modifier = Modifier.padding(start = 8.dp),
                    textStyle = LocalTextStyle.current.copy(fontSize = 16.sp, color = Color.Black),
                    decorationBox = { innerTextField ->
                        Box(modifier = Modifier) {
                            if ("" == "") {
                                Text(
                                    text = "Search...",
                                    color = Color.Gray,
                                    modifier = Modifier.align(Alignment.CenterStart)
                                )
                            }
                            innerTextField()
                        }
                    }
                )
            }
        }

        // Icon Button (Filter)
        IconButton(
            onClick = {},
            modifier = Modifier
                .constrainAs(filterButton) {
                    top.linkTo(searchBar.top)
                    end.linkTo(parent.end, 24.dp)
                    bottom.linkTo(searchBar.bottom)
                }
                .wrapContentWidth()
                .wrapContentHeight()
                .background(Color(0xFFC67C4E), shape = RoundedCornerShape(12.dp))
        ) {
            Icon(
                painter = painterResource(Res.drawable.filter),
                contentDescription = "Filter Icon",
                tint = Color.White,
                modifier = Modifier.size(30.dp)
            )
        }
    }
}

@Composable
@Preview
fun new() {
    Text("sdjfksd")
}

@Composable
@Preview
fun preview() {
    new()
}
