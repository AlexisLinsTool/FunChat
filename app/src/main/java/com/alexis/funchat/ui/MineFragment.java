package com.alexis.funchat.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alexis.funchat.R;
import com.alexis.funchat.base.BaseFragment;
import com.alexis.funchat.util.JumpConfig;
import com.alibaba.android.arouter.facade.annotation.Route;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


/**
 * Class description:
 *
 * @author Alexis
 * @date 2019/5/20  14:22
 */
@Route(path = JumpConfig.URI_FRAGMENT_MINE)
public class MineFragment extends BaseFragment {

    public static MineFragment getInstance(){
        return new MineFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRouter.inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_mine,container,false);
        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
