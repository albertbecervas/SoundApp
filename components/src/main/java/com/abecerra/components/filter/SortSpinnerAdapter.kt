package com.abecerra.components.filter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.abecerra.base.utils.inflate
import com.abecerra.components.R
import kotlinx.android.synthetic.main.item_sort_spinner.view.*

class SortSpinnerAdapter(
    context: Context,
    private val items: List<String>
) : ArrayAdapter<String>(context, R.layout.item_sort_spinner, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: parent.inflate(R.layout.item_sort_spinner)
        view.tv_sort_title.text = items[position]
        return view
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: parent.inflate(R.layout.item_sort_spinner)
        view.tv_sort_title.text = items[position]
        return view
    }
}