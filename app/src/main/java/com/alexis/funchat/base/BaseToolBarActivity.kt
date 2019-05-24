package com.alexis.funchat.base

import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.ViewStub
import android.view.Window

import com.alexis.funchat.R
import com.alexis.funchat.util.Validator
import com.google.android.material.floatingactionbutton.FloatingActionButton

import androidx.annotation.DrawableRes
import androidx.annotation.LayoutRes
import androidx.annotation.RequiresApi
import androidx.annotation.StringRes
import androidx.appcompat.app.ActionBar
import androidx.appcompat.widget.Toolbar
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.DrawableCompat

/**
 * Class description:
 *
 * @author Alexis
 * @date 2019/5/16  8:26
 */
abstract class BaseToolBarActivity : BaseActivity() {


    private var mContentView: ViewStub? = null
    protected lateinit var mToolbar: Toolbar
    private var mFloatingActionButton: FloatingActionButton? = null

    @RequiresApi(api = Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val window = window
        window.statusBarColor = getColor(R.color.colorPrimaryDark)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        super.setContentView(R.layout.activity_toolbar)

        initView()
    }

    private fun initView() {
        mContentView = findViewById(R.id.toolbar_content_layout)

        mToolbar = findViewById(R.id.toolbar)
        setSupportActionBar(mToolbar)
        //Toolbar 初始化 获取toolbar的方式是getSupportActionBar()
        //有些操作通过ActionBar来设置也是一样的，注意要在setSupportActionBar(toolbar);之后，不然就报错了
        val drawable = mToolbar.navigationIcon
        if (drawable != null) {
            DrawableCompat.setTint(drawable, ResourcesCompat.getColor(resources, android.R.color.white, null))
        }

        mToolbar.setNavigationOnClickListener { v -> onBackPressed() }

        mFloatingActionButton = findViewById(R.id.toolbar_floating_action_button)
        mFloatingActionButton!!.setOnClickListener { v -> onFloatingClick() }

    }


    fun showNavigationIcon(isShow: Boolean) {
        val bar = supportActionBar
        if (Validator.isNotNull(bar)) {
            bar!!.setDisplayHomeAsUpEnabled(isShow)
            bar.setHomeButtonEnabled(isShow)
        }
    }

    fun setNavigationIcon(@DrawableRes resId: Int) {
        mToolbar.setNavigationIcon(resId)
    }

    fun setFloatingIcon(drawable: Drawable) {
        mFloatingActionButton!!.setImageDrawable(drawable)
    }

    fun showFloatingButton(isShow: Boolean) {
        mFloatingActionButton!!.visibility = if (isShow) View.VISIBLE else View.GONE
    }

    fun onFloatingClick() {

    }

    override fun setContentView(@LayoutRes layoutResID: Int) {
        mContentView!!.layoutResource = layoutResID
        mContentView!!.inflate()
    }

    override fun setContentView(view: View) {

    }

    override fun setContentView(view: View, params: ViewGroup.LayoutParams) {

    }

    override fun setTitle(@StringRes stringRes: Int) {
        val actionBar = supportActionBar
        actionBar?.setTitle(stringRes)
    }

    fun setTitle(title: String) {
        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.title = title
        }
    }

}
