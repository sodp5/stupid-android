package com.stupid.stupidandroid.ui.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.stupid.stupidandroid.ui.design.component.SwipableCard

@Composable
fun HomeScreen(
    onShowEventScreen : (Choice) -> Unit,
    modifier : Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val list by viewModel.list.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.event.collect {
            onShowEventScreen(it)
        }
    }

    HomeScreen(
        modifier = modifier.fillMaxSize(),
        cardList = list,
        onSwipeLeft = {
            viewModel.buyItem(it)
        },
        onSwipeRight = {
            viewModel.stopIt(it)
        }
    )
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    cardList : List<ItemModel>,
    onSwipeLeft : (ItemModel) -> Unit,
    onSwipeRight : (ItemModel) -> Unit
){
    Column(
        modifier = modifier
    ) {
        LazyColumn(
            modifier = modifier
        ) {
            items(cardList, key = {
                it.id
            }){
                SwipableCard(
                    onSwipeLeft = {
                        onSwipeLeft(it)
                    },
                    onSwipeRight = {
                        onSwipeRight(it)
                    }
                ) {
                    ItemCard(it)
                }
            }
        }
    }

}