package com.soundapp.feature_profile.presenter

import com.abecerra.base.presentation.BasePresenterImpl
import com.soundapp.feature_profile.R
import com.soundapp.feature_profile.model.ProfileItem
import com.soundapp.feature_profile.router.ProfileDialogRouter
import com.soundapp.feature_profile.view.ProfileDialogView
import com.soundapp.session.authentication.domain.interactor.SessionInteractor

class ProfileDialogPresenterImpl(
    private val router: ProfileDialogRouter,
    private val interactor: SessionInteractor
) : BasePresenterImpl<ProfileDialogView>(), ProfileDialogPresenter {

    override fun getAdapter(): ProfileDialogAdapter {
        val adapter = ProfileDialogAdapter(router)
        adapter.setItems(
            arrayListOf(
                ProfileItem(GITHUB_ID, "View code on Github", R.drawable.ic_code),
                ProfileItem(FEEDBACK_ID, "Send feedback", R.drawable.ic_feedback)
            )
        )
        return adapter
    }

    override fun onLogoutClicked() {
        interactor.logout()
        router.logout()
    }

    companion object {
        const val GITHUB_ID = 0
        const val FEEDBACK_ID = 1

        const val GITHUB_URL = "http://www.github.com/albertbecervas"
        const val EMAIL = "albertbecerrahervas@gmail.com"
    }
}