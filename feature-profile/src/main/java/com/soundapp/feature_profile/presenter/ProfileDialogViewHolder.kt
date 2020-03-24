package com.soundapp.feature_profile.presenter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.soundapp.feature_profile.model.ProfileItem
import com.soundapp.feature_profile.router.ProfileDialogRouter
import kotlinx.android.synthetic.main.fragment_profile_dialog_item.view.*

class ProfileDialogViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(item: ProfileItem, router: ProfileDialogRouter) {
        itemView.tv_title.text = item.itemName
        itemView.iv_icon.setImageDrawable(itemView.context.getDrawable(item.icon))

        itemView.setOnClickListener {
            when (item.id) {
                ProfileDialogPresenterImpl.GITHUB_ID -> router.openGithubUrl(
                    ProfileDialogPresenterImpl.GITHUB_URL
                )
                ProfileDialogPresenterImpl.FEEDBACK_ID -> router.sendFeedbackIntent(
                    ProfileDialogPresenterImpl.EMAIL
                )
            }
        }
    }

    fun bindLastItem(item: ProfileItem, router: ProfileDialogRouter) {
        bind(item, router)
        itemView.divider.visibility = View.GONE
    }
}