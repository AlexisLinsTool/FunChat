package com.alexis.funchat.base;

import android.view.View;

import com.alexis.funchat.util.Validator;

import androidx.annotation.IdRes;
import androidx.collection.SparseArrayCompat;

/**
 * Class description:
 *
 * @author Alexis
 * @date 2019/5/16  8:54
 */
public class ViewHolder {
    private static final String TAG = ViewHolder.class.getSimpleName();
    private SparseArrayCompat<View> mHolder;
    private View mItemView;

    public ViewHolder() {
        this(null);
    }

    public ViewHolder(View itemView) {
        this.mItemView = itemView;
        mHolder = new SparseArrayCompat<>();
    }

    @SuppressWarnings("unchecked")
    public <T extends View> T get(@IdRes int resId) {
        View view = mHolder.get(resId);
        if (Validator.isNull(view)) {
            view = mItemView.findViewById(resId);
            mHolder.put(resId, view);
        }
        return (T) view;
    }

    public View getItemView() {
        return mItemView;
    }

    public void setItemView(View itemView) {
        this.mItemView = itemView;
    }

    public void clear() {
        mItemView = null;
        mHolder.clear();
    }
}
