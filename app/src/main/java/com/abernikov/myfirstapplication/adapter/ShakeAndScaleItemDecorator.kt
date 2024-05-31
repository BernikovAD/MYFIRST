package com.abernikov.myfirstapplication.adapter

import android.graphics.Canvas
import android.view.MotionEvent
import android.view.View
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import android.view.animation.TranslateAnimation
import androidx.recyclerview.widget.RecyclerView

class ShakeAndScaleItemDecorator : RecyclerView.ItemDecoration() {
    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(c, parent, state)
        parent.addOnItemTouchListener(object : RecyclerView.OnItemTouchListener {
            override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
                val child = rv.findChildViewUnder(e.x, e.y)
                if (child != null && e.action == MotionEvent.ACTION_DOWN) {
                    performShakeAndScaleAnimation(child)
                }
                return false
            }

            override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {}
            override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {}
        })
    }

    private fun performShakeAndScaleAnimation(view: View) {
        val scaleAnimation = ScaleAnimation(
            1.0f, 4.1f, 1.0f, 4.1f,
            Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f
        ).apply {
            duration = 300
            fillAfter = true
        }
        val shakeAnimation = TranslateAnimation(
            0f, 40f, 0f, 0f
        ).apply {
            duration = 100
            repeatCount = 5
            repeatMode = Animation.REVERSE
        }
        view.startAnimation(scaleAnimation)
        view.startAnimation(shakeAnimation)
    }
}