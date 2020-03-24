package com.abecerra.soundapp.navigation.navigator

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment

interface Navigator {

    fun startActivity(clazz: Class<*>)

    fun startActivity(clazz: Class<*>, extras: Bundle)

    fun startActivityFinishingCurrent(clazz: Class<*>)

    fun startActivityForResult(intent: Intent, resultCode: Int, fragment: Fragment)

    fun startActivityWithUpAnimation(clazz: Class<*>, extras: Bundle)

    fun replaceFragment(fragment: Fragment, layout: Int)

    fun share(text: String)
}