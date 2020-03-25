package com.soundapp.session.login.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.soundapp.session.login.presenter.LoginPresenter
import com.soundapp.session.signup.presenter.SignUpPresenter
import com.soundapp.session.signup.view.SignUpFragment

class LoginFragmentFactory(private val presenter: LoginPresenter) : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        val fragment = LoginFragment()
        fragment.injectPresenter(presenter)
        return fragment
    }
}