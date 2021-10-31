package com.bogTech.stockviewer.ui

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.bogTech.stockviewer.R
import com.bogTech.stockviewer.model.Message
import com.bogTech.stockviewer.ui.theme.StockViewerTheme

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                setupMain()
            }
        }
    }

    @Composable
    private fun setupMain() {
        StockViewerTheme {
            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colors.background
            ) {
                LazyColumnPopulate()
            }
        }
    }

    @Composable
    private fun LazyColumnPopulate() {
        LazyColumn {
            items(200) {
                MessageCard(Message("Android", "Jetpack Compose"))
            }
        }
    }


    @Composable
    fun MessageCard(msg: Message) {
        Row(modifier = Modifier.padding(all = 8.dp)) {
            Image(
                painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "Random picture",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Column {
                Text(
                    text = "${msg.author}!",
                    color = MaterialTheme.colors.secondaryVariant,
                    style = MaterialTheme.typography.subtitle1
                )

                Spacer(modifier = Modifier.height(4.dp))

                Surface(shape = MaterialTheme.shapes.medium, elevation = 1.dp) {
                    Text(
                        text = "${msg.body}!",
                        modifier = Modifier.padding(4.dp),
                        style = MaterialTheme.typography.body2
                    )
                }
            }
        }
    }

    @Preview(
        name = "Light Mode",
        showBackground = true
    )
    @Preview(
        uiMode = Configuration.UI_MODE_NIGHT_YES,
        showBackground = true,
        name = "Dark Mode"
    )
    @Composable
    fun DefaultPreview() {
        StockViewerTheme {
            MessageCard(msg = Message("Colleague", "Jetpack Compose"))
        }
    }

    companion object {
        const val FRAGMENT_TAG = "MAIN_FRAGMENT"
    }
}