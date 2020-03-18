package com.soundapp.feature_home.presentation.view

import android.os.Bundle
import android.view.View
import com.abecerra.base.presentation.BasePresenterFragment
import com.soundapp.feature_home.R
import com.soundapp.feature_home.presentation.presenter.HomePresenter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BasePresenterFragment<HomePresenter>(R.layout.fragment_home), HomeView {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter?.setView(this)

        tv.setOnClickListener {
            presenter?.getInitialSongs()
        }
    }
}
