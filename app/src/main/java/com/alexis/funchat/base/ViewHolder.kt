package com.alexis.funchat.base

import android.view.View

import com.alexis.funchat.util.Validator

import androidx.annotation.IdRes
import androidx.collection.SparseArrayCompat

/**
 * Class description:
 *
 * @author Alexis
 * @date 2019/5/16  8:54
 */
@Suppress("UNCHECKED_CAST")
class ViewHolder @JvmOverloads constructor(var itemView: View? = null) {
    private val mHolder: SparseArrayCompat<View>

    init {
        mHolder = SparseArrayCompat()
    }

    operator fun <T : View> get(@IdRes resId: Int): T {
        var view = mHolder.get(resId)
        if (Validator.isNull(view)) {
            view = itemView!!.findViewById(resId)
            mHolder.put(resId, view)
        }
        return view as T
    }

    fun clear() {
        itemView = null
        mHolder.clear()
    }

    companion object {
        private val TAG = ViewHolder::class.java.simpleName
    }
}
