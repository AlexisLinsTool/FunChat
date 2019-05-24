package com.alexis.funchat.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.alexis.funchat.R
import androidx.recyclerview.widget.RecyclerView
import com.alexis.funchat.storage.entity.UserEntity


/**
 * Class description:
 *
 * @author Alexis
 * @date 2019/5/14  11:00
 */
class ContactRecAdapter constructor(listData:List<UserEntity>) : RecyclerView.Adapter<ContactRecAdapter.ViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_contact_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 0
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView = itemView.findViewById(R.id.list_contact_img)
        var textView: TextView = itemView.findViewById(R.id.list_contact_name)
    }

    companion object{
        val mList:List<UserEntity>? = null
    }
}
