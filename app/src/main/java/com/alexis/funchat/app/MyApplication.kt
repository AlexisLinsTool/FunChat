package com.alexis.funchat.app

import android.app.Application

import com.alexis.funchat.BuildConfig
import com.alibaba.android.arouter.launcher.ARouter


/**
 * Class description:
 *
 * @author Alexis
 * @date 2019/5/16  8:24
 */
class MyApplication : Application() {


    override fun onCreate() {
        super.onCreate()


        if (BuildConfig.DEBUG) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)
    }

    override fun onTerminate() {
        super.onTerminate()
        ARouter.getInstance().destroy()
    }

    companion object{
        private val TAG = MyApplication::class.java.simpleName
    }

    object obj{
        val userName:String = ""
    }
}

