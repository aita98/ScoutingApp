package com.scoutapp.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.unit.dp
import kotlin.math.cos
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.DrawScope
import kotlin.math.PI
import kotlin.math.sin

data class RadarData(
    val labels: List<String>,
    val values: List<Float> // 0 to 100
)

@Composable
fun RadarChart(
    data: RadarData,
    modifier: Modifier = Modifier.size(300.dp),
    color: Color = MaterialTheme.colorScheme.primary
) {
    val labels = data.labels
    val values = data.values
    val numSides = labels.size
    val angleStep = (2 * PI / numSides).toFloat()

    Canvas(modifier = modifier) {
        val center = Offset(size.width / 2, size.height / 2)
        val radius = size.minDimension / 2.5f

        // Draw background web (5 levels)
        for (i in 1..5) {
            val currentRadius = radius * (i / 5f)
            drawRadarPolygon(center, currentRadius, numSides, angleStep, Color.Gray.copy(alpha = 0.3f), Stroke(1.dp.toPx()))
        }

        // Draw axes
        for (i in 0 until numSides) {
            val angle = i * angleStep - (PI / 2).toFloat()
            val endPoint = Offset(
                center.x + radius * cos(angle),
                center.y + radius * sin(angle)
            )
            drawLine(
                color = Color.Gray.copy(alpha = 0.5f),
                start = center,
                end = endPoint,
                strokeWidth = 1.dp.toPx()
            )
        }

        // Draw data area
        val valuePath = Path().apply {
            for (i in 0 until numSides) {
                val angle = i * angleStep - (PI / 2).toFloat()
                val normalizedValue = values[i] / 100f
                val point = Offset(
                    center.x + radius * normalizedValue * cos(angle),
                    center.y + radius * normalizedValue * sin(angle)
                )
                if (i == 0) moveTo(point.x, point.y) else lineTo(point.x, point.y)
            }
            close()
        }
        drawPath(path = valuePath, color = color.copy(alpha = 0.4f))
        drawPath(path = valuePath, color = color, style = Stroke(2.dp.toPx()))

        // Draw labels (using native canvas for simplicity with text)
        labels.forEachIndexed { i, label ->
            val angle = i * angleStep - (PI / 2).toFloat()
            val labelPoint = Offset(
                center.x + (radius + 20.dp.toPx()) * cos(angle),
                center.y + (radius + 20.dp.toPx()) * sin(angle)
            )
            
            drawContext.canvas.nativeCanvas.drawText(
                label,
                labelPoint.x,
                labelPoint.y,
                android.graphics.Paint().apply {
                    this.color = android.graphics.Color.WHITE
                    this.textSize = 32f
                    this.textAlign = android.graphics.Paint.Align.CENTER
                }
            )
        }
    }
}

private fun DrawScope.drawRadarPolygon(
    center: Offset,
    radius: Float,
    sides: Int,
    angleStep: Float,
    color: Color,
    style: Stroke
) {
    val path = Path().apply {
        for (i in 0 until sides) {
            val angle = i * angleStep - (PI / 2).toFloat()
            val point = Offset(
                center.x + radius * cos(angle),
                center.y + radius * sin(angle)
            )
            if (i == 0) moveTo(point.x, point.y) else lineTo(point.x, point.y)
        }
        close()
    }
    drawPath(path = path, color = color, style = style)
}
