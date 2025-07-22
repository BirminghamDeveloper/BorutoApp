package com.hashinology.presentation.common

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.paging.LoadState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.paging.compose.LazyPagingItems
import androidx.wear.compose.material.ContentAlpha
import com.hashinology.borutoapp.R
import com.hashinology.borutoapp.ui.theme.DarkGray
import com.hashinology.borutoapp.ui.theme.LightGray
import com.hashinology.borutoapp.ui.theme.NETWORK_ERROR_ICON_HEIGHT
import com.hashinology.borutoapp.ui.theme.SMALL_PADDING
import com.hashinology.domain.model.Hero
import kotlinx.coroutines.launch
import java.net.ConnectException
import java.net.SocketTimeoutException

@Composable
fun EmptyScreen(
    error: LoadState.Error? = null,
    heroes: LazyPagingItems<Hero>? = null
) {
    var message by remember {
        mutableStateOf("Find your Favorite Hero")
    }

    var icon by remember {
        mutableStateOf(R.drawable.search_document)
    }

    if (error != null){
        message = parseErrorMEssage(error = error)
        icon = R.drawable.ic_network_error
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

    EmptyContent(
        alphaAnim = alphaAnimate,
        icon = icon,
        message = message,
        heroes = heroes,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmptyContent(
    alphaAnim: Float,
    icon: Int,
    message: String,
    heroes: LazyPagingItems<Hero>? = null
) {
    val scope = rememberCoroutineScope()
    val refreshState = rememberPullToRefreshState()
    var isRefreshing by remember { mutableStateOf(false) }

    PullToRefreshBox(
        state = refreshState,
        isRefreshing = isRefreshing,
        onRefresh = {
            isRefreshing = true
            heroes?.refresh()
            isRefreshing = false
            scope.launch {
                refreshState.animateToHidden()
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    modifier = Modifier
                        .size(NETWORK_ERROR_ICON_HEIGHT)
                        .alpha(alpha = alphaAnim),
                    painter = painterResource(id = icon),
                    contentDescription = stringResource(R.string.network_error_icon),
                    tint = if (isSystemInDarkTheme()) LightGray else DarkGray
                )
                Text(
                    modifier = Modifier
                        .padding(top = SMALL_PADDING)
                        .alpha(alpha = alphaAnim),
                    text = message,
                    color = if (isSystemInDarkTheme()) LightGray else DarkGray,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Medium,
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize
                )
            }
        }
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
        alphaAnim = ContentAlpha.disabled,
        icon = R.drawable.ic_network_error,
        "Internet Unavailable"
    )
}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun EmptyScreenDarkPreview() {
    EmptyContent(
        alphaAnim = ContentAlpha.disabled,
        icon = R.drawable.ic_network_error,
        "Internet Unavailable"
    )
}