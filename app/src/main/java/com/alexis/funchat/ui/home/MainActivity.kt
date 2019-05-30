package com.alexis.funchat.ui.home

import androidx.collection.SparseArrayCompat
import androidx.fragment.app.Fragment

import android.os.Build
import android.os.Bundle
import android.view.MenuItem

import com.alexis.funchat.R
import com.alexis.funchat.base.BaseActivity
import com.alexis.funchat.ui.home.fragment.ContactFragment
import com.alexis.funchat.ui.home.fragment.MineFragment
import com.alexis.funchat.ui.home.fragment.NewsFragment
import com.alexis.funchat.util.JumpConfig
import com.alexis.funchat.util.LogUtil
import com.alibaba.android.arouter.facade.annotation.Route
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import androidx.viewpager.widget.ViewPager
import com.alexis.funchat.base.BaseFragment





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
        LogUtil.d(TAG,"onCreate")
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
        mFragmentHolder = SparseArrayCompat()
        main_nav.setOnNavigationItemSelectedListener(this)

        selectFragment(main_nav.selectedItemId)

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
        transaction.replace(R.id.main_frag, fragment, id.toString())
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
            else -> MineFragment.instance
        }
    }

    companion object{
        val TAG:String = MainActivity::class.java.simpleName
    }
}
