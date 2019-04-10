package com.example.fernando.hellokotlin

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.RippleDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mtxt.setText("Ola kotlin...")
        mtxt.setOnClickListener(this.on())
        mtxt.setOnLongClickListener(firstLongClick())

        getSupportActionBar()?.hide();

        val anim : Animation = AnimationUtils.loadAnimation(this, R.anim.bounce)

        imageViewLogo.setOnClickListener {
            imageViewLogo.startAnimation(anim)
        }

        setRippleEffectOnButton(buttonAbrirConta)
        setRippleEffectOnButton(buttonDemonstracao)
        setRippleEffectOnButton(buttonLogin)

    }

    fun setRippleEffectOnButton(button : Button): Unit {
        val ripple : RippleDrawable  = RippleDrawable(ColorStateList.valueOf(Color.GRAY), button.background, null)
        button.background = ripple
    }

    fun off() : View.OnClickListener {
        return View.OnClickListener {
            mtxt.setText(":-<");
            mtxt.setOnClickListener(on());
        }
    }

    fun on() : View.OnClickListener {
        return View.OnClickListener {
            mtxt.setText(":->")
            mtxt.setOnClickListener(off())
        }
    }

    fun secondLongClick() : View.OnLongClickListener {
        return View.OnLongClickListener {
            mtxt.setBackgroundColor(Color.WHITE)
            mtxt.setTextColor(Color.BLACK)
            mtxt.setOnLongClickListener(firstLongClick())
            true
        }
    }


    fun firstLongClick() : View.OnLongClickListener {
        return View.OnLongClickListener {
            mtxt.setBackgroundColor(Color.BLACK)
            mtxt.setTextColor(Color.WHITE)
            mtxt.setOnLongClickListener(secondLongClick())
            true
        }
    }

}
