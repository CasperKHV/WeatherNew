package khv.casper.weathernew.ui.screen.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.ComposeView

internal class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(
            ComposeView(this).apply {
                setContent {
                    MaterialTheme {
                        Box(
                            contentAlignment = Alignment.Center,
                        ) {
                            Text(
                                text = "Hello world",
                                style = MaterialTheme.typography.titleMedium,
                            )
                        }
                    }
                }
            }
        )
    }
}