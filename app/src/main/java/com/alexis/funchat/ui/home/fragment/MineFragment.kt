package com.alexis.funchat.ui.home.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

import com.alexis.funchat.R
import com.alexis.funchat.base.BaseFragment
import com.alexis.funchat.util.JumpConfig
import com.alibaba.android.arouter.facade.annotation.Route


/**
 * Class description:
 *
 * @author Alexis
 * @date 2019/5/20  14:22
 */
@Route(path = JumpConfig.URI_FRAGMENT_MINE)
class MineFragment : BaseFragment(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mRouter.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_mine, container, false)
        val mine_user_icon:ImageView = v.findViewById(R.id.mine_user_icon)
        mine_user_icon.setOnClickListener{navigation(JumpConfig.URT_ACTIVITY_LOGIN)}
        return v
    }

    override fun onClick(v: View) {
        val id = v.id
        when (id) {
            R.id.mine_user_icon -> navigation(JumpConfig.URT_ACTIVITY_LOGIN)
        }
    }

    companion object {
        private val TAG = MineFragment::class.java.simpleName

        val instance: MineFragment
            get() = MineFragment()
    }
}
