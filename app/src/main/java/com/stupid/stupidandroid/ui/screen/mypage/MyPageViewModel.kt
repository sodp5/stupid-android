package com.stupid.stupidandroid.ui.screen.mypage

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stupid.stupidandroid.R
import com.stupid.stupidandroid.data.model.RemoteMyPage
import com.stupid.stupidandroid.ui.design.component.Badge
import com.stupid.stupidandroid.usecase.GetMyPageInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyPageViewModel @Inject constructor(
    private val getMyPageInfoUseCase: GetMyPageInfoUseCase
) : ViewModel() {
    private val _myPage = MutableStateFlow(RemoteMyPage())
    val myPage: StateFlow<RemoteMyPage> = _myPage.asStateFlow()

    private val _badge = MutableStateFlow<Badge>(Badge.Turtle)
    val badge : StateFlow<Badge> = _badge.asStateFlow()

    init {
        getMyPageInfo(1)
    }

    private val _selectedTab = MutableStateFlow(MyPageTab.Posted)
    val selectedTab: StateFlow<MyPageTab> = _selectedTab.asStateFlow()

    fun getMyPageInfo(memberId: Long) {
        viewModelScope.launch {
            getMyPageInfoUseCase(
                memberId = memberId
            ).catch {
                // TODO
            }.collect {
                _myPage.emit(it)
            }
        }
    }

    fun changeSelectedTab(tab: MyPageTab) {
        viewModelScope.launch {
            _selectedTab.emit(tab)
        }
    }

    fun refreshBadge(){
        viewModelScope.launch {
            _badge.emit(badge.value.getNextRandomBadge())
        }
    }
}

data class UserProfile(
    val imageUrl: String,
    val name: String
)

enum class MyPageTab(@StringRes val id: Int) {
    Posted(id = R.string.mypage_tab_post), Voted(id = R.string.mypage_tab_vote)
}

enum class VoteStatus(
    @StringRes val id: Int,
    val containerColor: Color,
    val contentColor: Color
) {
    Bought(
        R.string.mypage_vote_status_bought,
        Color(0xFFFF3385),
        Color(0xFFFFFFFF)
    ),
    NotBought(
        R.string.mypage_vote_status_not_bought,
        Color(0xFF13C55A),
        Color(0xFFFFFFFF)
    ),
    Voted(
        R.string.mypage_vote_status_voted,
        Color(0xFF242424),
        Color(0xFFFFFFFF)
    ),
    Voting(
        R.string.mypage_vote_status_voting,
        Color(0xFFFFFFFF),
        Color(0xFF242424)
    )
}