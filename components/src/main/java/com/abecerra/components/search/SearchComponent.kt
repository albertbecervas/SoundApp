package com.abecerra.components.search

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
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
        View.inflate(this.context, R.layout.view_search, this)
        tv_cancel.setOnClickListener {
            val imm: InputMethodManager? =
                context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
            imm?.hideSoftInputFromWindow(windowToken, 0)
            et_search.setText("")
        }
        et_search.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                searchComponentOutput?.onSearch(et_search.text.toString())
            }
            true
        }
        et_search.addTextChangedListener(onTextChanged = { text, _, _, _ ->
            if (text.toString().isBlank()) {
                searchComponentOutput?.emptySearch()
                cl_cancel.visibility = View.GONE
            } else {
                cl_cancel.visibility = View.VISIBLE
            }
        })
    }

    fun bindSearchOutput(searchComponentOutput: SearchComponentOutput) {
        this.searchComponentOutput = searchComponentOutput
    }
}