package com.soundapp.session.login.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.soundapp.session.signup.presenter.SignUpPresenter
import com.soundapp.session.signup.view.SignUpFragment

class LoginFragmentFactory(private val presenter: SignUpPresenter) : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        val fragment = SignUpFragment()
        fragment.injectPresenter(presenter)
        return fragment
    }
}