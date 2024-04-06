package com.stupid.stupidandroid.ui.screen.login

import android.content.Context
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.ImageDecoderDecoder
import com.kakao.sdk.user.UserApiClient
import com.stupid.stupidandroid.R
import com.stupid.stupidandroid.ui.design.component.BubbleComment
import com.stupid.stupidandroid.ui.design.icon.IconPack
import com.stupid.stupidandroid.ui.design.icon.iconpack.IcKakao
import com.stupid.stupidandroid.ui.theme.Typography

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel = hiltViewModel()
) {
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        viewModel.loginSuccessEvent.collect {
            onLoginSuccess()
        }
    }

    LoginScreen(
        modifier = modifier.fillMaxSize(),
        context = context,
        onClickLogin = {
            UserApiClient.instance.loginWithKakaoTalk(context) { token, error ->
                if (error != null) {
                    Log.e("Login", "로그인 실패", error)
                } else if (token != null) {
                    Log.i("Login", "로그인 성공 ${token.accessToken}")
                    viewModel.registerKakaoToken(
                        token.accessToken
                    )
                }
            }
        }
    )
}

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    context: Context,
    onClickLogin: () -> Unit
) {
    Box(
        modifier = modifier
    ) {
        Column {
            Text(
                modifier = Modifier
                    .padding(vertical = 14.dp, horizontal = 24.dp),
                text = stringResource(id = R.string.login_title),
                style = Typography.SmallMedium20,
                color = Color(0xFF242424)
            )
            BubbleComment(
                modifier = Modifier.padding(horizontal = 24.dp),
                comment = "귀여운 고양이 이어폰 거치대ㅠㅠ 살까 말까?",
            )

            AnimatedGif(
                modifier = Modifier
                    .padding(horizontal = 56.dp)
                    .fillMaxWidth()
                    .aspectRatio(1f),
                context = context,
                gifUrl = "https://images.typeform.com/images/sCQ5hTGN5LEn"
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomStart),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_post_ask_left),
                    contentDescription = null,
                )

                Image(
                    painter = painterResource(id = R.drawable.img_post_ask_right),
                    contentDescription = null,
                )
            }

            KakaoLoginButton(
                modifier = Modifier
                    .padding(bottom = 82.dp),
                onClickLogin = onClickLogin
            )
        }
    }
}

@Composable
fun KakaoLoginButton(
    modifier: Modifier = Modifier,
    onClickLogin: () -> Unit
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .height(54.dp)
            .padding(horizontal = 24.dp),
        shape = RoundedCornerShape(6.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFFEE500),
            contentColor = Color(0xFF000000)
        ),
        onClick = onClickLogin
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = IconPack.IcKakao,
                contentDescription = null
            )
            Text(
                modifier = Modifier.padding(start = 14.dp),
                text = stringResource(id = R.string.kakao_login_button),
                style = Typography.XSmallSemiBold16
            )
        }
    }
}

@Composable
fun AnimatedGif(
    context: Context,
    gifUrl: String,
    modifier: Modifier = Modifier
) {
    val imageLoader = ImageLoader.Builder(context)
        .components {
            add(ImageDecoderDecoder.Factory())
        }
        .build()

    val painter = rememberAsyncImagePainter(
        model = gifUrl,
        imageLoader = imageLoader,
    )

    Image(
        modifier = modifier,
        painter = painter, contentDescription = null
    )
}
