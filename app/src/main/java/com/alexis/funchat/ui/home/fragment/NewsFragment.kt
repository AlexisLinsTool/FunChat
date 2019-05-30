package com.alexis.funchat.ui.home.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.alexis.funchat.R
import com.alexis.funchat.base.BaseFragment
import com.alexis.funchat.util.JumpConfig
import com.alibaba.android.arouter.facade.annotation.Route


/**
 * Class description:
 *
 * @author Alexis
 * @date 2019/5/20  10:05
 */
@Route(path = JumpConfig.URI_FRAGMENT_NEWS)
class NewsFragment : BaseFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mRouter.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    companion object {

        val instance: NewsFragment
            get() = NewsFragment()
    }
}
