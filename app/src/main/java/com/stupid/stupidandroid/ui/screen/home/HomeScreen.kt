package com.stupid.stupidandroid.ui.screen.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.stupid.stupidandroid.ui.design.component.SwipableCard
import com.stupid.stupidandroid.ui.design.icon.IconPack
import com.stupid.stupidandroid.ui.design.icon.iconpack.IcBuy
import com.stupid.stupidandroid.ui.design.icon.iconpack.IcStop

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    onShowEventScreen : (Choice) -> Unit,
    modifier : Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val list by viewModel.list.collectAsStateWithLifecycle()
    val listState = rememberLazyListState()

    val snappingLayout = remember(listState) { SnapLayoutInfoProvider(listState) }
    val snapFlingBehavior = rememberSnapFlingBehavior(snappingLayout)

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
                Box(
                  modifier = Modifier.fillMaxWidth()
                ){
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
                    Icon(
                        modifier = Modifier.align(Alignment.CenterStart),
                        imageVector = IconPack.IcBuy, contentDescription = null
                    )

                    Icon(
                        modifier = Modifier.align(Alignment.CenterEnd),
                        imageVector = IconPack.IcStop, contentDescription = null
                    )
                }

            }
        }
    }

}