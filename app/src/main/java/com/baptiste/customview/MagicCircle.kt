package com.baptiste.customview

import android.graphics.*
import kotlin.random.Random

lateinit var mCircle: MagicCircle

data class MagicCircle(val maxX: Int, val maxY: Int, var cx: Float, var cy: Float) {

    fun randomValues(min: Int, max: Int): Float {
        val value = Random.nextInt(min, max).toFloat()
        return value
    }

    var rad = randomValues(1, 250)
    var dx = randomValues(-50, 50)
    var dy = randomValues(-50, 50)

    var mPaint = Paint()

    init {
        mPaint.color = Color.argb(
            Random.nextInt(0, 255),
            Random.nextInt(0, 255),
            Random.nextInt(0, 255),
            Random.nextInt(0, 255)
        )
    }

    fun move() {

        when {
            cx.toInt() !in 0..maxX -> dx = -dx
            cy.toInt() !in 0..maxY -> dy = -dy
        }
        cx += dx
        cy += dy
    }
}





