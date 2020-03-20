package com.soundapp.feature_home.presentation.view

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abecerra.base.presentation.BasePresenterFragment
import com.soundapp.feature_home.R
import com.soundapp.feature_home.presentation.presenter.HomePresenter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BasePresenterFragment<HomePresenter>(R.layout.fragment_home), HomeView {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter?.setView(this)

        rv_rock.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        rv_rock.adapter = presenter?.getRockAdapter()

        rv_jazz.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        rv_jazz.adapter = presenter?.getJazzAdapter()

        rv_pop.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        rv_pop.adapter = presenter?.getPopAdapter()
    }

    override fun onResume() {
        super.onResume()
        presenter?.getInitialSongs()
    }

    override fun showLoading() {
        rock_loading?.visibility = View.VISIBLE
        jazz_loading?.visibility = View.VISIBLE
        pop_loading?.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        rock_loading?.visibility = View.GONE
        jazz_loading?.visibility = View.GONE
        pop_loading?.visibility = View.GONE
    }
}
