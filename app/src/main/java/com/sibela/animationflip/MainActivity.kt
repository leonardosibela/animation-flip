package com.sibela.animationflip

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.DecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import com.sibela.animationflip.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var isFront = true
    private var isAnimating = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            binding.buttonFlip.setOnClickListener {
                if (isAnimating) {
                    return@setOnClickListener
                }

                isAnimating = true

                val startAnim = ObjectAnimator.ofFloat(cardImage, "scaleX", 1f, 0f)
                val endAnim = ObjectAnimator.ofFloat(cardImage, "scaleX", 0f, 1f)
                startAnim.interpolator = DecelerateInterpolator()
                endAnim.interpolator = AccelerateDecelerateInterpolator()
                startAnim.addListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: Animator) {
                        super.onAnimationEnd(animation)
                        if (isFront) {
                            cardImage.setImageResource(R.drawable.card_back)
                            isFront = false
                        } else {
                            cardImage.setImageResource(R.drawable.card_front)
                            isFront = true
                        }
                        endAnim.start()
                    }
                })

                endAnim.addListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: Animator) {
                        super.onAnimationEnd(animation)
                        isAnimating = false
                    }
                })

                startAnim.start()
            }
        }
    }
}