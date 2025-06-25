package com.hashinology.presentation.common

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.paging.LoadState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.wear.compose.material.ContentAlpha
import com.hashinology.borutoapp.R
import com.hashinology.borutoapp.ui.theme.DarkGray
import com.hashinology.borutoapp.ui.theme.LightGray
import com.hashinology.borutoapp.ui.theme.NETWORK_ERROR_ICON_HEIGHT
import com.hashinology.borutoapp.ui.theme.SMALL_PADDING
import java.net.ConnectException
import java.net.SocketTimeoutException

@Composable
fun EmptyScreen(error: LoadState.Error) {
    val message by remember {
        mutableStateOf(parseErrorMEssage(error = error))
    }

    val icon by remember {
        mutableStateOf(R.drawable.ic_network_error)
    }

    var startAnimation by remember{
        mutableStateOf(false)
    }
    val alphaAnimate by animateFloatAsState(
        targetValue = if (startAnimation) /*ContentAlpha.disabled*/ 0.38f else 0f,
        animationSpec = tween(
            durationMillis = 1000
        )
    )

    LaunchedEffect(key1 = true) {
        startAnimation = true
    }

    EmptyContent(alphaAnimate = alphaAnimate, icon = icon, message = message)
}

@Composable
fun EmptyContent(alphaAnimate: Float, icon: Int, message: String) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            modifier = Modifier
                .size(NETWORK_ERROR_ICON_HEIGHT)
                .alpha(alpha = alphaAnimate),
            painter = painterResource(icon),
            contentDescription = stringResource(R.string.network_error_icon),
            tint = if (isSystemInDarkTheme()) LightGray else DarkGray
        )
        Text(
            modifier = Modifier
                .padding(top = SMALL_PADDING)
                .alpha(alpha = alphaAnimate),
            text = message,
            color = if (isSystemInDarkTheme()) LightGray else DarkGray,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Medium,
            fontSize = MaterialTheme.typography.labelMedium.fontSize
        )
    }
}

fun parseErrorMEssage(error: LoadState.Error): String {
    return when(error.error) {
        is SocketTimeoutException -> {
            "Server Unavailable"
        }

        is ConnectException -> {
            "Internet Unavailable"
        }

        else -> {
            "Unknown Error"
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun EmptyScreenPreview() {
//    EmptyScreen(error = LoadState.Error(SocketTimeoutException()))
    EmptyContent(
        alphaAnimate = ContentAlpha.disabled,
        icon = R.drawable.ic_network_error,
        "Internet Unavailable"
    )
}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun EmptyScreenDarkPreview() {
    EmptyContent(
        alphaAnimate = ContentAlpha.disabled,
        icon = R.drawable.ic_network_error,
        "Internet Unavailable"
    )
}