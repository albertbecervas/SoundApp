package com.abecerra.components.text

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.abecerra.components.R
import kotlinx.android.synthetic.main.view_text_underlined.view.*

class TextViewUnderlined : LinearLayout {

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context, attrs, defStyle
    ) {
        init(attrs)
    }

    private fun init() {
        inflate(context, R.layout.view_text_underlined, this)
    }

    private fun init(attrs: AttributeSet) {
        inflate(context, R.layout.view_text_underlined, this)
        val a = context.obtainStyledAttributes(
            attrs, intArrayOf(R.styleable.TextViewUnderlined_android_text)
        )
        tv.text = a.getText(0)
        a.recycle()
    }

    fun setText(text: String) {
        tv.text = text
    }
}