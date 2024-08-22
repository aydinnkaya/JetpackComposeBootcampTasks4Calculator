package com.aydinkaya.jetpackcomposebootcamptasks4calculator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CalculatorApp() {
    var displayText by remember { mutableStateOf("") }
    var result by remember { mutableStateOf(0.0) }

    val gradientBackground = Brush.linearGradient(
        colors = listOf(Color(0xFF8E2DE2), Color(0xFF4A00E0))
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradientBackground)
            .padding(16.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = displayText,
                fontSize = 32.sp,
                color = Color.White,
                modifier = Modifier.fillMaxWidth().padding(32.dp)
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    NumberButton("1") { displayText += "1" }
                    NumberButton("2") { displayText += "2" }
                    NumberButton("3") { displayText += "3" }
                    OperationButton("+") { displayText += "+" }
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    NumberButton("4") { displayText += "4" }
                    NumberButton("5") { displayText += "5" }
                    NumberButton("6") { displayText += "6" }
                    OperationButton("-") { displayText += "-" }
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    NumberButton("7") { displayText += "7" }
                    NumberButton("8") { displayText += "8" }
                    NumberButton("9") { displayText += "9" }
                    OperationButton("*") { displayText += "*" }
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    NumberButton("0") { displayText += "0" }
                    OperationButton("/") { displayText += "/" }
                    OperationButton("=") {
                        result = evaluateExpression(displayText)
                        displayText = result.toString()
                    }
                    Button(
                        onClick = { displayText = "" },
                        colors = ButtonDefaults.buttonColors(Color.Red),
                        modifier = Modifier.size(80.dp)
                    ) {
                        Text("", color = Color.White)
                    }
                }
            }
        }
    }
}