package com.alexis.funchat.base

import android.os.Bundle

import com.alibaba.android.arouter.launcher.ARouter
import androidx.appcompat.app.AppCompatActivity


/**
 * Class description:
 *
 * @author Alexis
 * @date 2019/5/16  8:16
 */
abstract class BaseActivity : AppCompatActivity() {
    protected lateinit var mRouter: ARouter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mRouter = ARouter.getInstance()
    }

    fun navigation(path: String) {
        mRouter.build(path).navigation()
    }
}
