package com.alexis.funchat.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast

import com.alexis.funchat.R
import com.alexis.funchat.app.MyApplication
import com.alexis.funchat.base.BaseActivity
import com.alexis.funchat.storage.MyDatabase
import com.alexis.funchat.storage.entity.UserEntity
import com.alexis.funchat.util.JumpConfig
import com.alexis.funchat.util.LogUtil
import com.alibaba.android.arouter.facade.annotation.Route
import kotlinx.android.synthetic.main.activity_register_layout.*


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
        MyDatabase.initializa(this)
        mDatabase = MyDatabase.getInstance()
        initView()
    }

    private fun initView() {

    }

    private fun jump2Login() {
        LogUtil.d(TAG,"jump2Login")
        val account:String = register_account.text.toString()
        val password:String = register_password.text.toString()
        val rePassword:String = register_re_password.text.toString()
        if (account.isEmpty()){
            Toast.makeText(this.applicationContext,getString(R.string.error_empty_account),Toast.LENGTH_SHORT).show()
            return
        }else if(password.isEmpty()||rePassword.isEmpty()){
            Toast.makeText(this.applicationContext,getString(R.string.error_empty_password),Toast.LENGTH_SHORT).show()
            return
        }else if(password!=rePassword){
            Toast.makeText(this.applicationContext,getString(R.string.error_repassword_not_macth_passwoord),Toast.LENGTH_SHORT).show()
            return
        }
        val mUserEntity: UserEntity = UserEntity()
        mUserEntity.account = account
        mUserEntity.password = password
        mDatabase.getUserDao().addOne(mUserEntity)
        MyApplication.userAccount = account
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
