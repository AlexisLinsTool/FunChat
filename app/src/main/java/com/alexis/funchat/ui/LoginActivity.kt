package com.alexis.funchat.ui

import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView

import com.alexis.funchat.R
import com.alexis.funchat.base.BaseActivity
import com.alexis.funchat.util.JumpConfig
import com.alibaba.android.arouter.facade.annotation.Route


/**
 * Class description:
 *
 * @author Alexis
 * @date 2019/5/23  20:29
 */
@Route(path = JumpConfig.URT_ACTIVITY_LOGIN)
class LoginActivity : BaseActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_layout)
        mRouter.inject(this)
        initView()
    }

    private fun initView() {

    }

    private fun jump2main() {
        // TODO: 2019/5/23 验证逻辑
        navigation(JumpConfig.URI_ACTIVITY_MAIN)
    }

    private fun jump2Register() {
        navigation(JumpConfig.URT_ACTIVITY_REGISTER)
    }

    override fun onClick(v: View) {
        val id = v.id
        when (id) {
            R.id.login_check -> jump2main()
            R.id.login_2_register -> jump2Register()
        }
    }

    companion object {
        private val TAG = LoginActivity::class.java.simpleName
    }
}
