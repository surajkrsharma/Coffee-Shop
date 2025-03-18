package org.example.project

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coffeeshop.composeapp.generated.resources.Res
import coffeeshop.composeapp.generated.resources.arrow_down
import coffeeshop.composeapp.generated.resources.banner_img_1
import coffeeshop.composeapp.generated.resources.product_img_1
import coffeeshop.composeapp.generated.resources.product_img_2
import coffeeshop.composeapp.generated.resources.product_img_3
import coffeeshop.composeapp.generated.resources.product_img_4
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

@Composable
fun HomeScreen() {
    // List of coffee categories
    val coffeeCategories = listOf(
        "Espresso",
        "Cappuccino",
        "Latte",
        "Americano",
        "Mocha",
        "Macchiato",
        "Macchiato",
        "Flat White",
        "Cold Brew"
    )

    // Data class for product
    data class ProductModel(
        val image: Painter,
        val price: String
    )

    val productModelss = listOf(
        ProductModel(painterResource(Res.drawable.product_img_1), "₹500"),
        ProductModel(painterResource(Res.drawable.product_img_2), "₹700"),
        ProductModel(painterResource(Res.drawable.product_img_3), "₹900"),
        ProductModel(painterResource(Res.drawable.product_img_4), "₹1200"),
    )
    @Composable
    fun ProductItem(productModelss: ProductModel) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(0.8f), // Adjust aspect ratio as needed
            shape = RoundedCornerShape(8.dp),
            color = Color.White,
            shadowElevation = 4.dp
        ) {
            Column(
                modifier = Modifier.padding(8.dp)
            ) {
                // Image
                Image(
                    painter = productModelss.image, // Use the image from the product model
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    contentScale = ContentScale.Crop
                )

                // Price Text
                Text(
                    text = productModelss.price,
                    modifier = Modifier.padding(top = 8.dp),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            }
        }
    }

    // State to track the selected chip
    var selectedCategory by remember { mutableStateOf(coffeeCategories[0]) }

    ConstraintLayout(modifier = Modifier) {
        val (backgroundImage, backgroundShape, searchBar, locationText, currentLocationText, icon, banner, category, product, filterButton, startButton) = createRefs()
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
            contentScale = ContentScale.Crop)

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
            textAlign = TextAlign.Center)

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
            tint = Color.White)
        val gradient = Brush.linearGradient(
            colors = listOf(Color(0xFF2A2A2A), Color(0x00A2A2A2)), // Define your gradient colors
            start = Offset(0f, 0f), // Start point (top-left)
            end = Offset.Infinite // End point (bottom-right)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
                .padding(start = 24.dp, end = 24.dp)
                .constrainAs(searchBar) {
                    top.linkTo(currentLocationText.bottom, 24.dp)
                }) {
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .background(gradient, shape = RoundedCornerShape(12.dp))
                    .weight(1f)
                    .fillMaxSize()
            ) {
                Icon(
                    painter = painterResource(Res.drawable.search),
                    contentDescription = "Search",
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(10.dp),
                    tint = Color.Gray
                )
                // Search Text at the start
                Text(
                    color = Color(0xff757575),
                    text = "Search a Tag or Description",
                    modifier = Modifier
                        .weight(1f) // Takes up remaining space
                        .fillMaxHeight()
                        .wrapContentHeight(Alignment.CenterVertically), // Centers text vertically
                    textAlign = TextAlign.Start
                )
            }
            Spacer(modifier = Modifier.width(40.dp))
            IconButton(
                onClick = {},
                modifier = Modifier
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

        Image(
            painter = painterResource(Res.drawable.banner_img_1),
            contentDescription = "Banner Image",
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .constrainAs(banner) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(backgroundShape.bottom)
                    bottom.linkTo(backgroundShape.bottom)
                }
                .clip(RoundedCornerShape(30.dp)),
            contentScale = ContentScale.Fit)

        LazyRow(modifier = Modifier
            .constrainAs(category) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(banner.bottom, 24.dp)
            }
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
            .selectableGroup(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            items(coffeeCategories) { category ->
                FilterChip(
                    selected = (category == selectedCategory),
                    onClick = { selectedCategory = category },
                    label = { Text(text = category) },
                    modifier = Modifier.padding(4.dp),
                    enabled = true,
                    colors = FilterChipDefaults.filterChipColors(
                        containerColor = Color(0x4DEDEDED),
                        selectedContainerColor = Color(0xFFC67C4E)
                    ),
                    border = FilterChipDefaults.filterChipBorder(
                        borderColor = Color.Transparent,
                        enabled = true,
                        selected = true,
                        selectedBorderColor = Color.Transparent,
                        disabledBorderColor = Color.Transparent,
                        disabledSelectedBorderColor = Color.Transparent,
                        borderWidth = 0.dp,
                        selectedBorderWidth = 0.dp,
                    )
                )
            }
        }

        // LazyVerticalGrid for products
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .constrainAs(product) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(category.bottom, margin = 24.dp)
                    bottom.linkTo(parent.bottom)
                    width = Dimension.fillToConstraints
                }
                .padding(horizontal = 24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(productModelss) { product ->
                ProductItem(product)
            }
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun TestPreview() {
    HomeScreen()
}