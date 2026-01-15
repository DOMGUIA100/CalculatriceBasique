package com.example.calculatricebasique.ui.components

// Ce fichier est dans le dossier components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Composable principal de l’interface de la calculatrice.
 *
 * @param expression L’expression à afficher sur l’écran.
 * @param onButtonClick Fonction callback appelée quand un bouton est cliqué.
 */
@Composable
fun CalculatorUI(
    expression: String,
    onButtonClick: (String) -> Unit
) {
    // Définition des lignes de boutons
    val buttonRows = listOf(
        listOf("(", ")", "DEL", "C"),
        listOf("7", "8", "9", "÷"),
        listOf("4", "5", "6", "×"),
        listOf("1", "2", "3", "−"),
        listOf("0", ".", "=", "+")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp, top = 70.dp, bottom = 60.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Écran d’affichage
        Text(
            text = expression,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            fontSize = 32.sp,
            textAlign = TextAlign.End
        )

        // Colonnes de boutons
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp) // espace entre les lignes de boutons
        ) {
            buttonRows.forEach { row ->
                RowButtons(row, onButtonClick)
            }
        }
    }
}

/**
 * Ligne de boutons réutilisable.
 *
 * @param labels Liste des labels des boutons
 * @param onClick Callback quand un bouton est cliqué
 */
@Composable
fun RowButtons(
    labels: List<String>,
    onClick: (String) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        labels.forEach { label ->
            Button(
                onClick = { onClick(label) },
                modifier = Modifier
                    .weight(1f)
                    .height(60.dp)
            ) {
                Text(text = label, fontSize = 15.sp)
            }
        }
    }
}
