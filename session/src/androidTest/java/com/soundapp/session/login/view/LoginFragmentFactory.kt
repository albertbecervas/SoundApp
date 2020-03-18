package com.soundapp.session.login.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.soundapp.session.authentication.domain.interactor.SessionInteractor
import com.soundapp.session.login.presenter.LoginPresenter
import com.soundapp.session.login.presenter.LoginPresenterImpl
import com.soundapp.session.login.router.LoginRouter
import org.mockito.Mockito

class LoginFragmentFactory(private val presenter: LoginPresenter) : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        val fragment = LoginFragment()
        fragment.injectPresenter(presenter)
        return fragment
    }
}