package com.alexis.funchat.base

import android.os.Bundle

import com.alibaba.android.arouter.launcher.ARouter
import androidx.fragment.app.Fragment


/**
 * Class description:
 *
 * @author Alexis
 * @date 2019/5/14  10:26
 */
abstract class BaseFragment : Fragment() {
    protected lateinit var mRouter: ARouter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mRouter = ARouter.getInstance()

    }

    fun navigation(path: String) {
        mRouter.build(path).navigation()
    }
}
