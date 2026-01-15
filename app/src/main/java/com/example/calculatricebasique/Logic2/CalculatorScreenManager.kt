package com.example.calculatricebasique.Logic2



import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.calculatricebasique.logic1.CalculatorOperations

/**
 * Gère l'état de l'écran de la calculatrice et les interactions
 * avec les boutons DEL, C, opérateurs et chiffres.
 */
class CalculatorScreenManager {

    var expression by mutableStateOf("0")  // texte affiché à l'écran
        private set

    private var resetNext = false  // indique si le prochain bouton doit remplacer l'écran
    private val operators = listOf("+", "−", "×", "÷")

    /**
     * Appelé à chaque fois qu'un bouton est cliqué
     *
     * @param symbol Le symbole du bouton cliqué ("1", "+", "DEL", "=" etc.)
     */
    fun onButtonClick(symbol: String) {
        when (symbol) {
            "C" -> {
                expression = "0"
                resetNext = false
            }
            "DEL" -> {
                if (!resetNext) {
                    expression = if (expression.length > 1) expression.dropLast(1) else "0"
                }
            }
            "=" -> {
                expression = CalculatorOperations.calculate(expression)
                resetNext = true
            }
            in operators -> {
                if (resetNext) resetNext = false
                // Empêche opérateur au début ou après un autre opérateur
                if (expression.isEmpty() || operators.any { expression.last().toString() == it }) {
                    expression = "0$symbol"
                } else {
                    expression += symbol
                }
            }
            else -> {
                // chiffres et point
                if (resetNext) {
                    expression = symbol
                    resetNext = false
                } else {
                    expression = if (expression == "0" && symbol != ".") symbol else expression + symbol
                }
            }
        }
    }
}