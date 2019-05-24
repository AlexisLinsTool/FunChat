package com.alexis.funchat.base

import android.view.View

import androidx.annotation.IdRes
import androidx.recyclerview.widget.RecyclerView


/**
 * Class description:
 *
 * @author Alexis
 * @date 2019/5/16  8:54
 */
class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val mViewHolder: ViewHolder = ViewHolder(itemView)

    operator fun <T : View> get(@IdRes resId: Int): T {
        return mViewHolder.get(resId)
    }
}
