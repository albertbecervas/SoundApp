package com.abecerra.base.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

open class BaseBottomSheetDialogFragment<PRESENTER : BasePresenter<*>>(private val layout: Int) :
    BottomSheetDialogFragment(), BaseView {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layout, container)
    }

    protected var presenter: PRESENTER? = null

    open fun injectPresenter(presenter: PRESENTER) {
        this.presenter = presenter
    }

    override fun showErrorMessage(error: String) {
        Toast.makeText(this.context, error, Toast.LENGTH_SHORT).show()
    }
}