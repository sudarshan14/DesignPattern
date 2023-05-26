import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.amlavati.tdd.ui.features.playlist.PlaylistViewModel

@Composable
fun FavouriteList(viewModel: PlaylistViewModel = viewModel()) {

    val list = viewModel.playList.observeAsState()

    LazyColumn(modifier = Modifier.testTag("favourite")) {
        list.value?.let {
            items(it) { item ->
                Text(text = "$item.")
            }
        }
    }
    var tabIndex by remember { mutableStateOf(0) } // 1.
    val tabTitles = listOf("Hello", "There", "World")
    Column { // 2.
        TabRow(selectedTabIndex = tabIndex) { // 3.
            tabTitles.forEachIndexed { index, title ->
                Tab(selected = tabIndex == index, // 4.
                    onClick = { tabIndex = index },
                    text = { Text(text = title) }) // 5.
            }
        }
        when (tabIndex) { // 6.
            0 -> {
                Column(
                    modifier = Modifier
                        .width(200.dp)
                        .background(Color.Gray),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(modifier = Modifier.width(140.dp), text = "Hello content,Hello content,Hello content")
                }

            }

            1 -> Text("There content")
            2 -> Text("World content")
        }
    }
}

//@OptIn(ExperimentalFoundationApi::class)
//@Composable
//fun tabsWithSwiping() {
//    var tabIndex by remember { mutableStateOf(0) }
//    val tabTitles = listOf("Hello", "There", "World")
//    val pagerState = rememberPagerState() // 2.
//    Column {
//        TabRow(selectedTabIndex = tabIndex,
//            indicator = { tabPositions -> // 3.
//                TabRowDefaults.Indicator(
//                    Modifier.(
//                        pagerState,
//                        tabPositions
//                    )
//                )
//            }) {
//            tabTitles.forEachIndexed { index, title ->
//                Tab(selected = tabIndex == index,
//                    onClick = { tabIndex = index },
//                    text = { Text(text = title) })
//            }
//        }
//        HorizontalPager( // 4.
//            pageCount = tabTitles.size,
//            state = pagerState,
//        ) { tabIndex ->
//            Text(
//                tabIndex.toString(),
//                modifier = Modifier
//                    .fillMaxSize()
//                    .background(Color.White)
//            )
//        }
//    }
//}