package com.alexis.funchat.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.alexis.funchat.R
import androidx.core.util.Preconditions
import androidx.recyclerview.widget.RecyclerView

/**
 * Class description:
 *
 * @author Alexis
 * @date 2019/5/16  9:01
 */
abstract class BaseRecyclerViewFragment<T> : BaseFragment() {

    var recyclerView: RecyclerView? = null
        private set
    var adapter: BaseRecyclerAdapter<T>? = null
        set(adapter) {
            field = adapter
            Preconditions.checkNotNull(adapter)
            recyclerView!!.adapter = this.adapter
        }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.common_refresh_recycler_view, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = view.findViewById(R.id.recycler_view)
        onRecyclerViewCreated(recyclerView)
    }

    /**
     * 创建RecyclerView
     * @param view 要创建1的view
     */
    protected abstract fun onRecyclerViewCreated(view: RecyclerView?)

    protected fun setItemAnimator(animator: RecyclerView.ItemAnimator?) {
        recyclerView!!.itemAnimator = animator
    }

    protected fun setLayoutManager(layout: RecyclerView.LayoutManager?) {
        recyclerView!!.layoutManager = layout
    }

    protected fun addItemDecoration(decor: RecyclerView.ItemDecoration) {
        recyclerView!!.addItemDecoration(decor)
    }
}
