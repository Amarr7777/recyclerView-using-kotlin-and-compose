package com.example.p9_recyclerview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.p9_recyclerview.ui.theme.P9recyclerViewTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            P9recyclerViewTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ItemList(itemsList)
                }
            }
        }
    }
}

data class Item(val id: Int, val name: String)

val itemsList = mutableStateListOf(
    Item(1, "Item 1"),
    Item(2, "Item 2"),
    Item(3, "Item 3"),
)

@Composable
fun ItemList(items: List<Item>) {
    LazyColumn(verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(0.dp,10.dp)) {
        items(items) { item ->
            ElevatedCard(
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp
                ),
                modifier = Modifier
                    .size(width = 340.dp, height = 100.dp)
                    .padding(5.dp, 10.dp)
            ) {
                Row (modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp, 0.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween){
                    Icon(imageVector = Icons.Default.Email, contentDescription = "message")
                Text(text = item.name, modifier = Modifier.padding(16.dp))
                }
            }
        }
    }
    Column(verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.End) {
    FloatingActionButton(onClick = {
        val newItem = Item(items.size + 1, "Item ${items.size + 1}")
        itemsList.add(newItem)
    },
        modifier = Modifier
            .padding(16.dp)
            .clip(CircleShape)) {
        Icon(imageVector = Icons.Default.Add, contentDescription = "add")
    }
    }

}




@Preview(showBackground = true)
@Composable
fun PreviewItemList() {
    ItemList(itemsList)
}



