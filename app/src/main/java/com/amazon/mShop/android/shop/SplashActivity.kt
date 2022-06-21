package com.amazon.mShop.android.shop

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.animation.doOnEnd

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val colipcarim = findViewById<ImageView>(R.id.iv_app_bg)
        val tvcomlipcarimipcar = findViewById<TextView>(R.id.tv_app_name)

        val lipcarimarimator =
            ObjectAnimator.ofFloat(colipcarim, View.ALPHA, 1F, 0.4F).apply {
                duration = 1200
            }

        val tvAcolipcarimrtor =
            ObjectAnimator.ofFloat(tvcomlipcarimipcar, View.ALPHA, 0F, 1F).apply {
                duration = 1200
            }

        AnimatorSet().apply {
            play(lipcarimarimator).with(tvAcolipcarimrtor)
            doOnEnd {
                navilipcarimvity()
            }
            start()
        }
    }

    private fun navilipcarimvity() {
        Intent(this, MainActivity::class.java).run {
            startActivity(this)
            finish()
        }
    }
}