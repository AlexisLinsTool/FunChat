package com.alexis.funchat.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.alexis.funchat.util.CollectionsUtils
import com.alexis.funchat.util.Validator

import androidx.annotation.IntRange
import androidx.annotation.LayoutRes
import androidx.core.util.Preconditions
import androidx.recyclerview.widget.RecyclerView


/**
 * Class description:
 *
 * @author Alexis
 * @date 2019/5/16  8:56
 */
abstract class BaseRecyclerAdapter<T>
/**
 * the constructor of this class.
 *
 * @param items the data source.
 */
(
        /**
         * data source of the adapter.
         */
        private var mItems: MutableList<T>?) : RecyclerView.Adapter<RecyclerViewHolder>() {

    /**
     * return the data source of the adapter.
     *
     * @return the data source of the adapter.
     */
    /**
     * set the data source to the adapter.
     *
     * @param items new data source to set.
     */
    var items: MutableList<T>?
        get() = this.mItems
        set(items) {
            this.mItems = items
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(getLayoutByViewType(viewType), parent, false)
        return RecyclerViewHolder(view)
    }

    /**
     * return the layout's id by the given view type.
     *
     * @param viewType The view type of the new View.
     * @return the layout's id of the special view type.
     */
    @LayoutRes
    protected abstract fun getLayoutByViewType(viewType: Int): Int

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        onBindViewHolder(holder, position, getItem(position))
    }

    /**
     * extend method of [.onBindViewHolder].
     *
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     * item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     * @param item     the  item of the special position within the adapter's data set.
     */
    protected abstract fun onBindViewHolder(holder: RecyclerViewHolder, position: Int, item: T?)

    /**
     * return the item of the special position within the adapter's data set.
     *
     * @param position position to get.
     * @return the  item of the special position within the adapter's data set.
     */
    fun getItem(position: Int): T? {
        return CollectionsUtils.get(mItems!!, position)
    }

    override fun getItemCount(): Int {
        return CollectionsUtils.sizeOf(mItems)
    }

    /**
     * inserts all of the elements in the specified collection into this
     * list at the specified position (optional operation)
     *
     * @param items         items to be insert into this list.
     * @param positionStart position at which to insert the first element from the
     * specified items.
     * @param isRepeatable  if true, the data in the list can be repeatable.
     */
    @JvmOverloads
    fun inserts(items: List<T>, @IntRange(from = 0) positionStart: Int, isRepeatable: Boolean = false) {
        Preconditions.checkNotNull<List<T>>(mItems, "You must set items before invoke this method!")
        if (Validator.isEmpty(items)) {
            return
        }
        if (!isRepeatable && this.mItems!!.containsAll(items)) {
            return
        }
        this.mItems!!.addAll(positionStart, items)
        notifyItemRangeInserted(positionStart, items.size)
    }

    @JvmOverloads
    fun insert(t: T, @IntRange(from = 0) position: Int, isRepeatable: Boolean = false) {
        Preconditions.checkNotNull<List<T>>(mItems, "You must set items before invoke this method!")
        if (!isRepeatable && this.mItems!!.contains(t)) {
            return
        }
        mItems!!.add(position, t)
        notifyItemInserted(position)
    }

    fun appends(list: List<T>, isRepeatable: Boolean) {
        Preconditions.checkNotNull<List<T>>(mItems, "You must set items before invoke this method!")
        if (Validator.isEmpty(list)) {
            return
        }
        if (!isRepeatable && this.mItems!!.containsAll(list)) {
            return
        }
        val startIndex = mItems!!.size
        this.mItems!!.addAll(list)
        notifyItemRangeInserted(startIndex, list.size)
    }

    fun appends(list: List<T>) {
        this.appends(list, false)
    }

    fun append(t: T, isRepeatable: Boolean) {
        Preconditions.checkNotNull<List<T>>(mItems, "You must set items before invoke this method!")
        if (!isRepeatable && this.mItems!!.contains(t)) {
            return
        }
        val startIndex = mItems!!.size
        mItems!!.add(t)
        notifyItemInserted(startIndex)
    }

    fun append(t: T) {
        this.append(t, false)
    }

    fun updates(list: List<T>, @IntRange(from = 0) positionStart: Int) {
        Preconditions.checkNotNull<List<T>>(mItems, "You must set items before invoke this method!")
        val size = CollectionsUtils.sizeOf(list)
        for (i in 0 until size) {
            mItems!![positionStart + i] = list[i]
        }
        notifyItemRangeChanged(positionStart, size)
    }

    fun update(t: T, @IntRange(from = 0) position: Int) {
        Preconditions.checkNotNull<List<T>>(mItems, "You must set items before invoke this method!")
        mItems!![position] = t
        notifyItemChanged(position)
    }

    fun removes(@IntRange(from = 0) positionStart: Int, itemCount: Int) {
        Preconditions.checkNotNull<List<T>>(mItems, "You must set items before invoke this method!")
        var positionEnd = positionStart + itemCount - 1
        while (positionEnd >= positionStart) {
            mItems!!.removeAt(positionEnd)
            positionEnd--
        }
        notifyItemRangeRemoved(positionStart, itemCount)
    }

    fun removes() {
        Preconditions.checkNotNull<List<T>>(mItems, "You must set items before invoke this method!")
        val itemCount = mItems!!.size
        mItems!!.clear()
        notifyItemRangeRemoved(0, itemCount - 1)
    }

    fun remove(@IntRange(from = 0) position: Int) {
        Preconditions.checkNotNull<List<T>>(mItems, "You must set items before invoke this method!")
        mItems!!.removeAt(position)
        notifyItemRemoved(position)
    }

    fun replaces(items: MutableList<T>) {
        this.mItems = items
        notifyDataSetChanged()
    }

    companion object {
        private val TAG = "BaseRecyclerAdapter"
    }
}
/**
 * inserts all of the elements in the specified collection into this
 * list at the specified position (optional operation)
 *
 * @param items         items to be insert into this list.
 * @param positionStart position at which to insert the first element from the
 * specified items.
 */
