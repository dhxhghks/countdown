package net.metainfo.countdown

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import net.metainfo.countdown.ui.theme.CountdownTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = MainViewModel()

        setContent {
            CountdownTheme {

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        val uiState = viewModel.uiState.collectAsState()
                        Row {
                            Button(
                                onClick = {
                                    viewModel.setTimer(1, 10)
                                    viewModel.start()
                                }
                            ) {
                                "Coundown"
                            }
                        }
                        Row {
                            var remain = uiState.value
                            val min = remain / 60000
                            val tmp = remain % 60000
                            val sec = tmp / 1000
                            Text(text = "${min} : ${sec}")
                        }
                    }

                }
            }
        }
    }
}
