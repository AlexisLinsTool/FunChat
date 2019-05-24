package com.alexis.funchat.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast

import com.alexis.funchat.R
import com.alexis.funchat.app.MyApplication
import com.alexis.funchat.base.BaseActivity
import com.alexis.funchat.storage.entity.UserEntity
import com.alexis.funchat.util.JumpConfig
import com.alibaba.android.arouter.facade.annotation.Route
import kotlinx.android.synthetic.main.activity_login_layout.*


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
        mRouter.inject(this::class.java)
    }


    override fun onRestart() {
        super.onRestart()
        if (MyApplication.userAccount.isEmpty())
            return
        login_account.setText(MyApplication.userAccount)
    }

    private fun jump2main() {
        val account: String = login_account.text.toString()
        val password: String = login_password.text.toString()
        if (account.isEmpty()) {
            Toast.makeText(this.applicationContext, "账号为空", Toast.LENGTH_SHORT).show()
            return
        } else if (password.isEmpty()) {
            Toast.makeText(this.applicationContext, "密码为空", Toast.LENGTH_SHORT).show()
            return
        }
        val userEntity: UserEntity? = mDatabase.getUserDao().findOneByAccountAndPassword(account, password)
        if (userEntity == null) {
            Toast.makeText(this.applicationContext, "账号或密码错误", Toast.LENGTH_SHORT).show()
            return
        }
        navigation(JumpConfig.URI_ACTIVITY_MAIN)
    }

    fun jump2Register() {
        navigation(JumpConfig.URT_ACTIVITY_REGISTER)
    }

    override fun onClick(v: View) {
        val id = v.id
        when (id) {
            R.id.login_positive -> jump2main()
            R.id.login_2_register -> jump2Register()
        }
    }

    companion object {
        private val TAG = LoginActivity::class.java.simpleName
    }
}
