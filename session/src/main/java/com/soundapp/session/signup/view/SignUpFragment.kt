package com.soundapp.session.signup.view


import android.os.Bundle
import android.view.View
import com.abecerra.base.presentation.BasePresenterFragment
import com.soundapp.session.R
import com.soundapp.session.signup.presenter.SignUpPresenter
import kotlinx.android.synthetic.main.fragment_login.bt_signup
import kotlinx.android.synthetic.main.fragment_login.et_password
import kotlinx.android.synthetic.main.fragment_login.et_username
import kotlinx.android.synthetic.main.fragment_sign_up.*

open class SignUpFragment : BasePresenterFragment<SignUpPresenter>(R.layout.fragment_sign_up),
    SignUpView {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter?.setView(this)

        initViews()
    }

    private fun initViews() {
        bt_signup.setOnClickListener {
            presenter?.onSignUpWithEmailClicked(
                et_username.text.toString(),
                et_password.text.toString()
            )
        }
        bt_goto_login.setOnClickListener {
            activity?.onBackPressed()
        }
    }

    override fun showErrorOnUsernameField(errorMessage: String) {
        et_username.error = errorMessage
    }

    override fun showErrorOnPasswordField(errorMessage: String) {
        et_password.error = errorMessage
    }
}
