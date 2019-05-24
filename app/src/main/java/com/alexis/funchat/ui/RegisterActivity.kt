package com.alexis.funchat.ui

import android.os.Bundle
import android.view.View
import android.widget.EditText

import com.alexis.funchat.R
import com.alexis.funchat.base.BaseActivity
import com.alexis.funchat.util.JumpConfig
import com.alibaba.android.arouter.facade.annotation.Route


/**
 * Class description:
 *
 * @author Alexis
 * @date 2019/5/23  20:39
 */
@Route(path = JumpConfig.URT_ACTIVITY_REGISTER)
class RegisterActivity : BaseActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_layout)
        mRouter.inject(this)
        initView()
    }

    private fun initView() {

    }

    private fun jump2Login() {
        // TODO: 2019/5/23 注册验证逻辑
        navigation(JumpConfig.URT_ACTIVITY_LOGIN)
    }

    override fun onClick(v: View) {

        when (v.id) {
            R.id.register_navigtive -> finish()
            R.id.register_positive -> jump2Login()
        }
    }

    companion object {
        val TAG:String = RegisterActivity::class.java.simpleName
    }
}
