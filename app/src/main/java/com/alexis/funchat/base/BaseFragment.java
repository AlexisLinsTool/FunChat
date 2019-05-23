package com.alexis.funchat.base;

import android.os.Bundle;

import com.alibaba.android.arouter.launcher.ARouter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


/**
 * Class description:
 *
 * @author Alexis
 * @date 2019/5/14  10:26
 */
public abstract class BaseFragment extends Fragment {
    protected ARouter mRouter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRouter = ARouter.getInstance();

    }

    public void navigation(String path){
        mRouter.build(path).navigation();
    }
}
