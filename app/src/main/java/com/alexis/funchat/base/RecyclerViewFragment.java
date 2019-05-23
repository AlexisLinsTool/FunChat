package com.alexis.funchat.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alexis.funchat.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Class description:
 *
 * @author Alexis
 * @date 2019/5/16  9:01
 */
public abstract class RecyclerViewFragment<T> extends BaseFragment {

    private RecyclerView mRecyclerView;
    private RecyclerAdapter<T> mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.common_refresh_recycler_view, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mRecyclerView = view.findViewById(R.id.recycler_view);
        onRecyclerViewCreated(mRecyclerView);
    }

    protected abstract void onRecyclerViewCreated(RecyclerView view);

    public RecyclerView getRecyclerView() {
        return mRecyclerView;
    }

    public void setAdapter(RecyclerAdapter<T> adapter) {
        mAdapter = adapter;
        Preconditions.checkNotNull(adapter);
        mRecyclerView.setAdapter(mAdapter);
    }

    public RecyclerAdapter<T> getAdapter() {
        return mAdapter;
    }

    protected void setItemAnimator(@Nullable RecyclerView.ItemAnimator animator) {
        mRecyclerView.setItemAnimator(animator);
    }

    protected void setLayoutManager(@Nullable RecyclerView.LayoutManager layout) {
        mRecyclerView.setLayoutManager(layout);
    }

    protected void addItemDecoration(@NonNull RecyclerView.ItemDecoration decor) {
        mRecyclerView.addItemDecoration(decor);
    }
}
