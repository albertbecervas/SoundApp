package com.abecerra.components.search

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import androidx.core.widget.addTextChangedListener
import com.abecerra.components.R
import kotlinx.android.synthetic.main.view_search.view.*

class SearchComponent : LinearLayout {

    private var searchComponentOutput: SearchComponentOutput? = null

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context, attrs, defStyle
    )

    init {
        View.inflate(
            this.context,
            R.layout.view_search, this
        )
        tv_cancel.setOnClickListener {
            this.visibility = View.GONE
        }
        et_search.addTextChangedListener(onTextChanged = { text, _, _, count ->
            if (text.toString().isNotEmpty() && count > 3) {
                searchComponentOutput?.onSearch(text.toString())
                cl_cancel.visibility = View.VISIBLE
            } else {
                searchComponentOutput?.emptySearch()
                cl_cancel.visibility = View.GONE
            }
        })
    }

    fun bindSearchOutput(searchComponentOutput: SearchComponentOutput) {
        this.searchComponentOutput = searchComponentOutput
    }
}