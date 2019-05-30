package com.alexis.funchat.adapter

import com.alexis.funchat.R
import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.view.ViewGroup
import androidx.collection.SparseArrayCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.PagerAdapter
import com.alexis.funchat.ui.home.fragment.NewsFragment
import androidx.fragment.app.FragmentPagerAdapter
import com.alexis.funchat.ui.home.fragment.ContactFragment
import com.alexis.funchat.ui.home.fragment.MineFragment


/**
 *  Class description:
 *
 *  @author Alexis
 *  @date   2019/5/29  20:23
 */

class fragPagerAdapter(fragmentMana: FragmentManager, private var fragHolder:SparseArrayCompat<Fragment> = SparseArrayCompat(3)) : FragmentPagerAdapter(fragmentMana) {

    fun addFrag(id:Int, frag:Fragment){
        if (fragHolder.containsKey(id)){
            return
        }else{
            fragHolder.put(id,frag)
        }

    }

    override fun getItem(position: Int): Fragment {
        return when(position){
            1->fragHolder.get(R.id.navigation_contact)?:ContactFragment()
            2->fragHolder.get(R.id.navigation_user)?:MineFragment()
            else->fragHolder.get(R.id.navigation_message)?:NewsFragment()
        }
    }

    override fun getCount(): Int {
        return fragHolder.size()
    }

}