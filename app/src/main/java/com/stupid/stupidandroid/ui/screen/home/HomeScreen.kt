package com.stupid.stupidandroid.ui.screen.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.stupid.stupidandroid.ui.design.component.SwipableCard

@Composable
fun HomeScreen(
    modifier : Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
    var list by remember {
        mutableStateOf(listOf(1,2,3,4,5))
    }

    HomeScreen(
        modifier = modifier.fillMaxSize(),
        cardList = list,
        onSwipeCard = {
            if(list.isNotEmpty()) list = list.drop(1)
        }
    )
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    cardList : List<Int>,
    onSwipeCard : () -> Unit
){
    //test
    Box(modifier = modifier) {
        if(cardList.isNotEmpty()){
            SwipableCard(
                onSwipeLeft = onSwipeCard,
                onSwipeRight = onSwipeCard
            ) {
                Card(
                    modifier = Modifier.fillMaxSize().padding(vertical = 40.dp, horizontal = 20.dp)
                ) {
                    Text(
                        cardList.first().toString()
                    )
                }
            }
        }else {
            Text("카드가 더 이상 없습니다.")
        }
    }
}