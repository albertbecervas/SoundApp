package com.abecerra.components.bottomnavigation

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import com.abecerra.components.R
import com.abecerra.components.bottomnavigation.viewModel.NavigationItem
import com.abecerra.components.bottomnavigation.viewModel.NavigationItemMapper
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation
import kotlinx.android.synthetic.main.view_bottom_navigation.view.*

class BottomNavigationComponent : LinearLayout {

    private var listener: BottomNavigationListener? = null

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context, attrs, defStyleAttr
    ) {
        init()
    }

    fun setBottomNavigationListener(listener: BottomNavigationListener) {
        this.listener = listener
    }

    fun setItems(items: List<NavigationItem>) {
        ah_bottom_nav.addItems(NavigationItemMapper.mapToAhBottomNavigationItems(items))
        ah_bottom_nav.titleState = AHBottomNavigation.TitleState.ALWAYS_SHOW
    }

    private fun init() {
        inflate(context, R.layout.view_bottom_navigation, this)
        ah_bottom_nav.defaultBackgroundColor = ContextCompat.getColor(context, R.color.colorPrimary)
        ah_bottom_nav.accentColor = ContextCompat.getColor(context, R.color.colorAccent)
        ah_bottom_nav.inactiveColor = ContextCompat.getColor(context, R.color.white)
        ah_bottom_nav.setOnTabSelectedListener { position, wasSelected ->
            if (!wasSelected) listener?.onItemSelected(position)
            true
        }
    }
}