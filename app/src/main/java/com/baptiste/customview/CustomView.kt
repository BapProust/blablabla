package com.baptiste.customview

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.text.Editable
import android.util.AttributeSet
import android.view.*
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.squareup.picasso.Picasso
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL
import kotlin.random.Random

class CustomView : View {

    val mutableList = mutableListOf<MagicCircle>()

    //constructeurs secondaires
    constructor(context: Context) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
    }

    //fonction native onDraw
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        for (mCircle in mutableList) {
            mCircle.move()
            canvas?.drawCircle(mCircle.cx, mCircle.cy, mCircle.rad, mCircle.mPaint)
            invalidate()
        }
    }

    //fonction native onLayout
    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bot: Int) {
        super.onLayout(changed, left, top, right, bot)
        mCircle = MagicCircle(width, height, 50F, 50F)
        mutableList.add(mCircle)
    }

    fun addButton() {
        mutableList.add(
            MagicCircle(
                width,
                height,
                Random.nextInt(1, 200).toFloat(),
                Random.nextInt(1, 200).toFloat()
            )
        )
    }

    fun lessButton() {
        if (mutableList.size != 1) {
            mutableList.removeFirst()
        }
    }
}