package com.stupid.stupidandroid.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stupid.stupidandroid.data.model.RemotePost
import com.stupid.stupidandroid.ui.screen.home.state.HomeUiState
import com.stupid.stupidandroid.usecase.GetPostListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPostListUseCase: GetPostListUseCase
) : ViewModel() {

    private val _homeUiState = MutableStateFlow(HomeUiState())
    val homeUiState: StateFlow<HomeUiState> = _homeUiState.asStateFlow()

    private val _event = MutableSharedFlow<Choice>()
    val event: SharedFlow<Choice> = _event.asSharedFlow()

    init {
        loadPostList()
    }

    fun loadPostList() {
        viewModelScope.launch {
            _homeUiState.emit(
                homeUiState.value.copy(
                    isLoading = true
                )
            )
            getPostListUseCase(
                lastId = homeUiState.value.postList.lastOrNull()?.id ?: -1,
                memberId = 1
            ).catch {
                //TODO
            }.collect { result ->
                _homeUiState.emit(
                    homeUiState.value.copy(
                        isLoading = false,
                        isEnded = result.isEmpty(),
                        postList = if (result.isEmpty()) homeUiState.value.postList
                        else (homeUiState.value.postList + result)

                    )
                )
            }
        }
    }


    fun swipePostCard(item: RemotePost, isBuyIt: Boolean) {
        viewModelScope.launch {
            _event.emit(
                if (isBuyIt)
                    Choice.BuyIt(item) else Choice.Stupid(item = item)
            )
            delay(1000)
            _homeUiState.emit(
                _homeUiState.value.copy(
                    postList = homeUiState.value.postList.filterNot { it.id == item.id })
            )
        }
    }

}

sealed class Choice {
    data class BuyIt(val item: RemotePost) : Choice()
    data class Stupid(val item: RemotePost) : Choice()
}

val dummy = listOf(
    ItemModel(
        id = 1,
        imageUrl = "https://gd.image-gmkt.com/%ea%b7%80%ec%97%ac%ec%9a%b4-%ea%b3%a0%ec%96%91%ec%9d%b4%ec%97%90%ec%96%b4%ed%8c%9f%ea%b1%b0%ec%b9%98%eb%8c%80-%eb%b2%84%ec%a6%88-%ed%99%80%eb%8d%94-%ec%9d%b4%ec%96%b4%ed%8f%b0-%ea%b1%b8%ec%9d%b4-%ec%84%a0%eb%ac%bc/li/875/828/1891828875.g_350-w-et-pj_g.jpg",
        mainComment = "테스트",
        subCommentList = listOf("테스트 코멘트1, 테스트 코멘트2")
    ),
    ItemModel(
        id = 2,
        imageUrl = "https://qi-o.qoo10cdn.com/goods_image_big/9/0/4/5/8475369045_l.jpg",
        mainComment = "테스트",
        subCommentList = listOf("테스트 코멘트1, 테스트 코멘트2")
    ),
    ItemModel(
        id = 3,
        imageUrl = "https://cdn.011st.com/11dims/resize/600x600/quality/75/11src/product/3704442929/B.jpg?300000000",
        mainComment = "테스트",
        subCommentList = listOf("테스트 코멘트1, 테스트 코멘트2")
    ),
    ItemModel(
        id = 4,
        imageUrl = "https://image.babosarang.co.kr/product/detail/DD2/2108021831179642/_401.jpg",
        mainComment = "테스트",
        subCommentList = listOf("테스트 코멘트1, 테스트 코멘트2")
    )
)