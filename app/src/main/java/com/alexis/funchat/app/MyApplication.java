package com.alexis.funchat.app;

import android.app.Application;

import com.alexis.funchat.BuildConfig;
import com.alibaba.android.arouter.launcher.ARouter;


/**
 * Class description:
 *
 * @author Alexis
 * @date 2019/5/16  8:24
 */
public class MyApplication extends Application {

    private final static String TAG = MyApplication.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();


        if (BuildConfig.DEBUG) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        ARouter.getInstance().destroy();
    }
}

