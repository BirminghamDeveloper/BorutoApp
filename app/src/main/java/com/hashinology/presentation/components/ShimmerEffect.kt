package com.hashinology.presentation.components

import android.content.res.Configuration
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hashinology.borutoapp.ui.theme.ABOUT_PLACEHOLDER_HEIGHT
import com.hashinology.borutoapp.ui.theme.EXTRA_SMALL_PADDING
import com.hashinology.borutoapp.ui.theme.HERO_ITEM_HEIGHT
import com.hashinology.borutoapp.ui.theme.LARGE_PADDING
import com.hashinology.borutoapp.ui.theme.MEDIUM_PADDING
import com.hashinology.borutoapp.ui.theme.NAME_PLACEHOLDER_HEIGHT
import com.hashinology.borutoapp.ui.theme.RATING_PLACEHOLDER_HEIGHT
import com.hashinology.borutoapp.ui.theme.SMALL_PADDING
import com.hashinology.borutoapp.ui.theme.ShimmerDarkGray
import com.hashinology.borutoapp.ui.theme.ShimmerLightGray
import com.hashinology.borutoapp.ui.theme.ShimmerMediumGray

@Composable
fun ShimmerEffect() {

}

@Composable
fun ShimmerItem(alpha: Float) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(HERO_ITEM_HEIGHT),
        color = if (isSystemInDarkTheme())
            Color.Black else ShimmerLightGray,
        shape = RoundedCornerShape(size = LARGE_PADDING)
    ) {
        Column(
            modifier = Modifier
                .padding(all = MEDIUM_PADDING),
            verticalArrangement = Arrangement.Bottom
        ) {
            Surface(
                modifier = Modifier
                    .alpha(alpha = alpha)
                    .fillMaxWidth(0.5f)
                    .height(NAME_PLACEHOLDER_HEIGHT),
                color = if (isSystemInDarkTheme())
                    ShimmerDarkGray else ShimmerMediumGray,
                shape = RoundedCornerShape(size = SMALL_PADDING)
            ) {}
            Spacer(modifier = Modifier.padding(all = SMALL_PADDING))
            repeat(3) {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .alpha(alpha = alpha)
                        .height(ABOUT_PLACEHOLDER_HEIGHT),
                    color = if (isSystemInDarkTheme())
                        ShimmerDarkGray else ShimmerMediumGray,
                    shape = RoundedCornerShape(size = SMALL_PADDING)
                ) {}
                Spacer(modifier = Modifier.padding(all = EXTRA_SMALL_PADDING))
            }
            Row(modifier = Modifier.fillMaxWidth()) {
                repeat(5){
                    Surface(
                        modifier = Modifier
                            .alpha(alpha = alpha)
                            .size(RATING_PLACEHOLDER_HEIGHT),
                        color = if (isSystemInDarkTheme())
                            ShimmerDarkGray else ShimmerMediumGray,
                        shape = RoundedCornerShape(size = SMALL_PADDING)
                    ) {}
                    Spacer(modifier = Modifier.padding(all = SMALL_PADDING))
                }
            }
        }
    }
}

@Preview
@Composable
private fun ShimmerItemPreview() {
    ShimmerItem(0.5f)
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun ShimmerItemDarkPreview() {
    ShimmerItem(0.5f)
}