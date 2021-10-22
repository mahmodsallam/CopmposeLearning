package com.example.copmposelearning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.copmposelearning.ui.theme.CopmposeLearningTheme
import com.example.copmposelearning.ui.theme.Message
import com.example.copmposelearning.ui.theme.SampleData

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            conversation(msgs = SampleData.conversationSample)
        }
    }
}

@Composable
fun MessageCard(msg: Message) {

    Row(modifier = Modifier.padding(8.dp)) {
        Image(
            painter = painterResource(R.drawable.ic_launcher_background),
            contentDescription = "Img",
            Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)


        )

        Spacer(modifier = Modifier.width(8.dp))

        var isExpanded by remember { mutableStateOf(false) }


        Column(modifier = Modifier.clickable { isExpanded != isExpanded }) {
            Text(text = "${msg.author}!")
            Text(text = "${msg.body}!" ,
            maxLines = if (isExpanded) Int.MAX_VALUE else 1 )

        }
    }




}

@Composable
fun conversation(msgs: List<Message>) {
    LazyColumn {
        items(msgs) { msg ->
            MessageCard(msg = msg)
        }
    }
}


@Composable
@Preview(showBackground = true)
fun DefaultPreview() {
    CopmposeLearningTheme {
        val msg = Message(author = "Mahmoud Sallam", body = "Winter is Here")
        conversation(msgs = SampleData.conversationSample)

    }
}

