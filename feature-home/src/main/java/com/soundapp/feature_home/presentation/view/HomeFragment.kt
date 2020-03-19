package com.soundapp.feature_home.presentation.view

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abecerra.base.presentation.BasePresenterFragment
import com.soundapp.feature_home.R
import com.soundapp.feature_home.presentation.presenter.HomePresenter
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.view_item_loading.*

class HomeFragment : BasePresenterFragment<HomePresenter>(R.layout.fragment_home), HomeView {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter?.setView(this)

        rv_rock.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        rv_rock.adapter = presenter?.getRockAdapter()
    }

    override fun onResume() {
        super.onResume()
        presenter?.getInitialSongs()
    }

    override fun showLoading() {
        loading.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        loading.visibility = View.GONE
    }
}
