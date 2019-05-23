package com.alexis.funchat.base;

import android.os.Bundle;

import com.alibaba.android.arouter.launcher.ARouter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


/**
 * Class description:
 *
 * @author Alexis
 * @date 2019/5/16  8:16
 */
public abstract class BaseActivity extends AppCompatActivity {
    protected ARouter mRouter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRouter = ARouter.getInstance();
    }

    public void navigation(String path){
        mRouter.build(path).navigation();
    }
}
