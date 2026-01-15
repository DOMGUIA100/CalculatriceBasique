package com.example.calculatricebasique.logic1

import net.objecthunter.exp4j.ExpressionBuilder


/**
 * Objet qui gère uniquement le calcul mathématique de l'expression.
 */
object CalculatorOperations {

    /**
     * Calcule le résultat d'une expression mathématique passée sous forme de String.
     * Exemple : "3+5×2"
     *
     * @param expression L'expression à calculer
     * @return Résultat formaté en String ou "Erreur" si invalide
     */
    fun calculate(expression: String): String {
        return try {
            // Remplacer les symboles Compose par ceux reconnus par exp4j
            val expr = expression
                .replace("×", "*")
                .replace("÷", "/")
                .replace("−", "-")

            val result = ExpressionBuilder(expr).build().evaluate()

            // Formater le résultat : entier sans .0, décimal sinon
            if (result % 1.0 == 0.0) result.toLong().toString() else result.toString()
        } catch (e: Exception) {
            "Erreur"
        }
    }
}