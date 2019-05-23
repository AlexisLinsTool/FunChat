package com.alexis.funchat.ui;

import androidx.annotation.NonNull;
import androidx.collection.SparseArrayCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;

import com.alexis.funchat.R;
import com.alexis.funchat.base.BaseActivity;
import com.alexis.funchat.util.JumpConfig;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.google.android.material.bottomnavigation.BottomNavigationView;

@Route(path = JumpConfig.URI_ACTIVITY_MAIN)
public class MainActivity extends BaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private SparseArrayCompat<Fragment> mFragmentHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            super.onCreate(savedInstanceState);
        }
        setContentView(R.layout.activity_main);
        mRouter.inject(this);
        initView();
    }

    /**
     * 初始化组件
     */
    private void initView() {
//        showNavigationIcon(false);
        mFragmentHolder = new SparseArrayCompat<>();

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(this);
        selectFragment(navView.getSelectedItemId());
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        selectFragment(item.getItemId());
        return true;
    }

    /**
     * 显示对应的Fragment
     *
     * @param id 点击BottomNavigationView对应Item的id
     */
    private void selectFragment(int id) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment fragment = getFragment(id);
        transaction.replace(R.id.home_frag, fragment, String.valueOf(id));
        transaction.commitAllowingStateLoss();
    }

    /**
     * 获取Fragment
     *
     * @param id 点击BottomNavigationView对应Item的id
     * @return 返回与id对应的Fragment
     */
    private Fragment getFragment(int id) {
        Fragment fragment = mFragmentHolder.get(id);
        if (fragment == null) {
            fragment = createFragment(id);
            mFragmentHolder.put(id, fragment);
        }
        return fragment;

    }

    /**
     * 创建Fragment
     *
     * @param id 点击BottomNavigationView对应Item的id
     * @return 返回与id对应的Fragment
     */
    private Fragment createFragment(int id) {
        switch (id) {
            case R.id.navigation_message:
                return NewsFragment.getInstance();
            case R.id.navigation_contact:
                return ContactFragment.getInstance();
            case R.id.navigation_user:
            default:
                return MineFragment.getInstance();
        }
    }
}
