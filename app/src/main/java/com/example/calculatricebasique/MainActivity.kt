package com.example.calculatricebasique

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.example.calculatricebasique.Logic2.CalculatriceInteraction
import com.example.calculatricebasique.ui.components.CalculatriceUI
import com.example.calculatricebasique.ui.theme.CalculatriceBasiqueTheme

/* MainActivity qui lance l'application */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            CalculatriceBasiqueTheme {
                // Instance du ScreenManager (LOGIQUE)
                val screenManager = remember { CalculatriceInteraction() }

                // UI
                Calculatrice(screenManager)
            }
        }
    }
}

/*Lien entre UI et logique */
@Composable
fun Calculatrice(screenManager: CalculatriceInteraction) {
    CalculatriceUI(
        expression = screenManager.expression,
        onButtonClick = { symbol ->
            screenManager.onButtonClick(symbol)
        }
    )
}



/* Preview */
@Preview(showBackground = true)
@Composable
fun CalculatricePreview() {
    CalculatriceBasiqueTheme {
        val previewManager = CalculatriceInteraction()
        Calculatrice(screenManager = previewManager)
    }
}
