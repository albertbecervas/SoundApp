package com.abecerra.soundapp.navigation.navigator

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import java.lang.ref.WeakReference

class NavigatorImpl(private val context: WeakReference<Context?>?) : Navigator {

    private var lastFragment: WeakReference<Fragment>? = null

    override fun startActivity(clazz: Class<*>) {
        context?.get()?.let {
            it.startActivity(Intent(it, clazz))
        }
    }

    override fun startActivity(clazz: Class<*>, extras: Bundle) {
        context?.get()?.let {
            val intent = Intent(it, clazz)
            intent.putExtras(extras)
            it.startActivity(intent)
        }
    }

    override fun startActivityFinishingCurrent(clazz: Class<*>) {
        (context?.get() as? AppCompatActivity)?.let {
            it.startActivity(Intent(it, clazz))
            it.finish()
        }
    }

    override fun startActivityForResult(intent: Intent, resultCode: Int, fragment: Fragment) {
        fragment.startActivityForResult(intent, resultCode)
    }

    override fun replaceFragment(fragment: Fragment, layout: Int) {
        when (context?.get()) {
            is AppCompatActivity -> {
                if (fragment.isAdded) {
                    val t =
                        (context.get() as AppCompatActivity).supportFragmentManager.beginTransaction()
                    lastFragment?.get()?.let {
                        t.hide(it)
                        t.show(fragment)
                    }?:run {
                        t.replace(layout, fragment)
                    }
                    t.commit()
                } else {
                    (context.get() as AppCompatActivity).supportFragmentManager.beginTransaction()
                        .add(layout, fragment)
                        .commit()
                }
                lastFragment = WeakReference(fragment)
            }
        }
    }
}