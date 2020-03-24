package com.soundapp.feature_profile.presenter

import com.abecerra.base.presentation.BasePresenter
import com.soundapp.feature_profile.view.ProfileDialogView

interface ProfileDialogPresenter: BasePresenter<ProfileDialogView> {

    fun getAdapter(): ProfileDialogAdapter

    fun onLogoutClicked()
}