package com.abecerra.components.filter

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.AdapterView
import android.widget.LinearLayout
import com.abecerra.components.R
import kotlinx.android.synthetic.main.view_sort_spinner.view.*

class SortComponent : LinearLayout {

    private var sortComponentOutput: SortComponentOutput? = null

    private var items: ArrayList<SortComponentViewModel> = arrayListOf()

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context, attrs, defStyle
    )

    init {
        View.inflate(context, R.layout.view_sort_spinner, this)
        spinner_sort?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener,
            AdapterView.OnItemClickListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {}

            override fun onItemSelected(
                parent: AdapterView<*>?, view: View?, position: Int, id: Long
            ) {
                sortComponentOutput?.onSortSelected(items[position].id)
            }

            override fun onItemClick(
                parent: AdapterView<*>?, view: View?, position: Int, id: Long
            ) {
            }
        }
    }

    fun setSortingOptions(
        items: List<SortComponentViewModel>, sortComponentOutput: SortComponentOutput
    ) {
        this.items.addAll(items)
        spinner_sort?.adapter =
            SortSpinnerAdapter(
                context,
                this.items.map { it.name }
            )
        this.sortComponentOutput = sortComponentOutput
    }
}