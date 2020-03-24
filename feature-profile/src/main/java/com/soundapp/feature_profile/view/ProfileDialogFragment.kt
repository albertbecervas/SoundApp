package com.soundapp.feature_profile.view

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.abecerra.base.presentation.BaseBottomSheetDialogFragment
import com.soundapp.feature_profile.R
import com.soundapp.feature_profile.presenter.ProfileDialogPresenter
import kotlinx.android.synthetic.main.fragment_profile_dialog.*

class ProfileDialogFragment :
    BaseBottomSheetDialogFragment<ProfileDialogPresenter>(R.layout.fragment_profile_dialog),
    ProfileDialogView {

    override fun getTheme(): Int = R.style.BottomSheetDialogTheme

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter?.setView(this)
        initViews()
    }

    private fun initViews() {
        list.layoutManager = LinearLayoutManager(context)
        list.adapter = presenter?.getAdapter()
        cl_logout.setOnClickListener { presenter?.onLogoutClicked() }
    }
}
