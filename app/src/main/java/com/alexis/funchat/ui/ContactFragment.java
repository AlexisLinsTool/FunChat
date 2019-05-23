package com.alexis.funchat.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alexis.funchat.R;
import com.alexis.funchat.base.BaseFragment;
import com.alexis.funchat.util.JumpConfig;
import com.alibaba.android.arouter.facade.annotation.Route;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


/**
 * Class description:
 *
 * @author Alexis
 * @date 2019/5/14  10:26
 */
@Route(path = JumpConfig.URI_FRAGMENT_CONTACT)
public class ContactFragment extends BaseFragment {
    private View mView;

    ConstraintLayout fContactNewFriendGroup;
    ConstraintLayout fContactFriendsGroup;
    ConstraintLayout fContactTagsGroup;
    RecyclerView fContactRec;

    public static ContactFragment getInstance(){
        return new ContactFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRouter.inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_contact, container, false);
        initRecyclerView();
        return mView;
    }

    private void initRecyclerView(){
            fContactRec = mView.findViewById(R.id.f_contact_rec);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mView.getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        fContactRec.setLayoutManager(layoutManager);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
