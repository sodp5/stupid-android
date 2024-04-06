package com.stupid.stupidandroid.ui.screen.mypage

import androidx.lifecycle.ViewModel
import com.stupid.stupidandroid.ui.design.component.Badge
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyPageViewModel @Inject constructor(

) : ViewModel() {
    val userProfile = UserProfile(
        imageUrl = "https://www.tongguitar.co.kr/data//1505/2040710745_72155459_dddddd.jpg",
        name = "김민지님"
        )

    val badge = Badge.Fire
}

data class UserProfile(
    val imageUrl : String,
    val name : String
)