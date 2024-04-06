package com.stupid.stupidandroid.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stupid.stupidandroid.data.model.RemotePost
import com.stupid.stupidandroid.ui.screen.home.state.HomeUiState
import com.stupid.stupidandroid.usecase.GetPostListUseCase
import com.stupid.stupidandroid.usecase.VoteUseCase
import com.stupid.stupidandroid.util.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPostListUseCase: GetPostListUseCase,
    private val voteUseCase: VoteUseCase,
) : ViewModel() {
    private val catchingViewModelScope = viewModelScope + CoroutineExceptionHandler { coroutineContext, throwable ->
        _showErrorToast.tryEmit(Event(Unit))
    }

    private val _homeUiState = MutableStateFlow(HomeUiState())
    val homeUiState: StateFlow<HomeUiState> = _homeUiState.asStateFlow()

    private val _event = MutableSharedFlow<Choice>()
    val event: SharedFlow<Choice> = _event.asSharedFlow()

    private val _showErrorToast = MutableSharedFlow<Event<Unit>>(extraBufferCapacity = 1)
    val showErrorToast: SharedFlow<Event<Unit>> = _showErrorToast.asSharedFlow()

    init {
        loadPostList()
    }

    fun loadPostList() {
        catchingViewModelScope.launch {
            _homeUiState.emit(
                homeUiState.value.copy(
                    isLoading = true
                )
            )
            getPostListUseCase(
                lastId = homeUiState.value.postList.lastOrNull()?.id ?: -1,
                memberId = 1001
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

    fun onVoteCard(isBuyIt: Boolean) {
        catchingViewModelScope.launch {
            val item = homeUiState.value.postList.first()

            launch {
                voteUseCase(item.id.toLong(), isBuyIt)
            }

            _event.emit(
                if (isBuyIt) Choice.BuyIt(item) else Choice.Stupid(item = item)
            )
            delay(500)
            _homeUiState.update { state ->
                state.copy(postList = homeUiState.value.postList.filterNot { it.id == item.id })
            }
        }
    }

    fun swipePostCard(item: RemotePost, isBuyIt: Boolean) {


        viewModelScope.launch {
            launch {
                voteUseCase(item.id.toLong(), isBuyIt)
            }

            _event.emit(
                if (isBuyIt) Choice.BuyIt(item) else Choice.Stupid(item = item)
            )
            delay(500)
            _homeUiState.update { state ->
                state.copy(postList = homeUiState.value.postList.filterNot { it.id == item.id })
            }
        }
    }

}

sealed class Choice {
    data class BuyIt(val item: RemotePost) : Choice()
    data class Stupid(val item: RemotePost) : Choice()
}
