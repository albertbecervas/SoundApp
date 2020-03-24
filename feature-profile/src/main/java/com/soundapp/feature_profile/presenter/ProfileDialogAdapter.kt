package com.soundapp.feature_profile.presenter

import android.view.ViewGroup
import com.abecerra.base.presentation.BaseAdapter
import com.abecerra.base.utils.inflate
import com.soundapp.feature_profile.R
import com.soundapp.feature_profile.model.ProfileItem
import com.soundapp.feature_profile.router.ProfileDialogRouter

class ProfileDialogAdapter(private val router: ProfileDialogRouter) :
    BaseAdapter<ProfileDialogViewHolder, ProfileItem>() {

    override fun onBindViewHolder(holder: ProfileDialogViewHolder, item: ProfileItem, pos: Int) {
        if (isLastItem(pos)) holder.bindLastItem(item, router)
        else holder.bind(item, router)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileDialogViewHolder {
        return ProfileDialogViewHolder(parent.inflate(R.layout.fragment_profile_dialog_item))
    }
}