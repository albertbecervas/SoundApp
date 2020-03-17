package com.abecerra.soundapp.di.module.data

import android.content.Context
import com.abecerra.soundapp.AppApplication
import com.abecerra.soundapp.R
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import dagger.Module
import dagger.Provides

@Module
class GoogleAuthModule {

    @Provides
    fun provideGoogleSignInOptions(): GoogleSignInOptions {
        return GoogleSignInOptions.Builder(
            GoogleSignInOptions.DEFAULT_SIGN_IN
        ).requestIdToken(AppApplication.getInstance().getString(R.string.default_web_client_id))
            .requestEmail().build()
    }

    @Provides
    fun provideSignInClient(
        context: Context,
        googleSignInOptions: GoogleSignInOptions
    ): GoogleSignInClient {
        return GoogleSignIn.getClient(context, googleSignInOptions)
    }
}