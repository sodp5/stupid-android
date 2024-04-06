package com.stupid.stupidandroid.ui.screen.login

import android.content.Context
import android.os.Build.VERSION.SDK_INT
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import com.kakao.sdk.user.UserApiClient
import com.stupid.stupidandroid.R
import com.stupid.stupidandroid.ui.design.icon.IconPack
import com.stupid.stupidandroid.ui.design.icon.iconpack.IcKakao
import com.stupid.stupidandroid.ui.theme.Typography

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel = hiltViewModel()
) {
    val context = LocalContext.current

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
    Column(
        modifier = modifier
    ) {
        Text(
            modifier = Modifier
                .padding(vertical = 14.dp, horizontal = 24.dp),
            text = stringResource(id = R.string.app_name),
            style = Typography.SmallMedium20,
            color = Color(0xFF242424)
        )
        BoxWithConstraints(
            modifier = Modifier.fillMaxWidth().weight(1f)
        ){
            AnimatedGif(
                modifier = Modifier
                    .padding(horizontal = 30.dp)
                    .align(Alignment.Center)
                    .then(
                        if(maxWidth > maxHeight) Modifier.fillMaxHeight()
                        else Modifier.fillMaxWidth()
                    ).aspectRatio(1f),
                context = context,
                gifUrl = "https://images.typeform.com/images/sCQ5hTGN5LEn"
            )
        }


        KakaoLoginButton(
            modifier = Modifier
                .padding(bottom = 82.dp),
            onClickLogin = onClickLogin
        )
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
            if (SDK_INT >= 28) {
                add(ImageDecoderDecoder.Factory())
            } else {
                add(GifDecoder.Factory())
            }
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