package com.example.calculatricebasique

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.example.calculatricebasique.Logic2.CalculatorScreenManager
import com.example.calculatricebasique.ui.components.CalculatorUI
import com.example.calculatricebasique.ui.theme.CalculatriceBasiqueTheme

/**
 * MainActivity qui lance l'application.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            CalculatriceBasiqueTheme {
                // Instance du ScreenManager (LOGIQUE)
                val screenManager = remember { CalculatorScreenManager() }

                // UI
                CalculatorScreen(screenManager)
            }
        }
    }
}

/**
 * Lien entre UI et logique
 */
@Composable
fun CalculatorScreen(screenManager: CalculatorScreenManager) {
    CalculatorUI(
        expression = screenManager.expression,
        onButtonClick = { symbol ->
            screenManager.onButtonClick(symbol)
        }
    )
}

/* 🔍 Preview */
@Preview(showBackground = true)
@Composable
fun CalculatorScreenPreview() {
    CalculatriceBasiqueTheme {
        val previewManager = CalculatorScreenManager()
        CalculatorScreen(screenManager = previewManager)
    }
}
