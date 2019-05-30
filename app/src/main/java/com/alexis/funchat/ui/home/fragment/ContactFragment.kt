package com.alexis.funchat.ui.home.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.alexis.funchat.R
import com.alexis.funchat.base.BaseFragment
import com.alexis.funchat.util.JumpConfig
import com.alibaba.android.arouter.facade.annotation.Route
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alexis.funchat.adapter.ContactRecAdapter
import kotlinx.android.synthetic.main.fragment_contact.*


/**
 * Class description:
 *
 * @author Alexis
 * @date 2019/5/14  10:26
 */
@Route(path = JumpConfig.URI_FRAGMENT_CONTACT)
class ContactFragment : BaseFragment() {
    private var mView: View? = null
    private lateinit var mAdapter:ContactRecAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mRouter.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mView = inflater.inflate(R.layout.fragment_contact, container, false)
        return mView
    }

    private fun initRecyclerView() {
        val layoutManager = LinearLayoutManager(mView!!.context)
        mAdapter = ContactRecAdapter(null)
        layoutManager.orientation = RecyclerView.VERTICAL
        f_contact_rec.layoutManager = layoutManager

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initRecyclerView()
    }

    companion object {

        val instance: ContactFragment
            get() = ContactFragment()
    }
}
