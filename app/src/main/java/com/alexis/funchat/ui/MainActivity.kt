package com.alexis.funchat.ui

import androidx.collection.SparseArrayCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

import android.os.Build
import android.os.Bundle
import android.view.MenuItem

import com.alexis.funchat.R
import com.alexis.funchat.base.BaseActivity
import com.alexis.funchat.util.JumpConfig
import com.alibaba.android.arouter.facade.annotation.Route
import com.google.android.material.bottomnavigation.BottomNavigationView

/**
 * Class description:
 *
 * @author Alexis
 * @date   2019/5/20 10:00
 */
@Route(path = JumpConfig.URI_ACTIVITY_MAIN)
class MainActivity : BaseActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private var mFragmentHolder: SparseArrayCompat<Fragment>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            super.onCreate(savedInstanceState)
        }
        setContentView(R.layout.activity_main)
        mRouter.inject(this)
        initView()
    }

    /**
     * 初始化组件
     */
    private fun initView() {
        //        showNavigationIcon(false);
        mFragmentHolder = SparseArrayCompat()

        val navView = findViewById<BottomNavigationView>(R.id.nav_view)
        navView.setOnNavigationItemSelectedListener(this)
        selectFragment(navView.selectedItemId)
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        selectFragment(item.itemId)
        return true
    }

    /**
     * 显示对应的Fragment
     *
     * @param id 点击BottomNavigationView对应Item的id
     */
    private fun selectFragment(id: Int) {
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        val fragment = getFragment(id)
        transaction.replace(R.id.home_frag, fragment, id.toString())
        transaction.commitAllowingStateLoss()
    }

    /**
     * 获取Fragment
     *
     * @param id 点击BottomNavigationView对应Item的id
     * @return 返回与id对应的Fragment
     */
    private fun getFragment(id: Int): Fragment {
        var fragment = mFragmentHolder!!.get(id)
        if (fragment == null) {
            fragment = createFragment(id)
            mFragmentHolder!!.put(id, fragment)
        }
        return fragment

    }

    /**
     * 创建Fragment
     *
     * @param id 点击BottomNavigationView对应Item的id
     * @return 返回与id对应的Fragment
     */
    private fun createFragment(id: Int): Fragment {
        return when (id) {
            R.id.navigation_message -> NewsFragment.instance
            R.id.navigation_contact -> ContactFragment.instance
            R.id.navigation_user -> MineFragment.instance
            else -> MineFragment.instance
        }
    }
}
