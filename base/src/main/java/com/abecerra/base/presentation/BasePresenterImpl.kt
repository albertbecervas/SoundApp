package com.abecerra.base.presentation

import java.lang.ref.WeakReference

abstract class BasePresenterImpl<VIEW: BaseView> : BasePresenter<VIEW> {

    protected var view: WeakReference<VIEW>? = null

    override fun setView(view: VIEW) {
        this.view = WeakReference(view)
    }

    protected fun getView(): VIEW? {
        return view?.get()
    }

    protected fun showError(errorMessage: String) {
        getView()?.showErrorMessage(errorMessage)
    }
}