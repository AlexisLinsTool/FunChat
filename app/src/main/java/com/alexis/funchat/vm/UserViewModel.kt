package com.alexis.funchat.vm

import android.util.Log
import androidx.lifecycle.ViewModel
import com.alexis.funchat.storage.database.entity.UserEntity
import androidx.lifecycle.MutableLiveData




/**
 *  Class description:
 *
 *  @author Alexis
 *  @date   2019/5/30  20:14
 */
class UserViewModel :ViewModel(){

    private val TAG = UserViewModel::class.simpleName

    private var mUsernameLiveData: MutableLiveData<UserEntity> = MutableLiveData()

    init {
        mUsernameLiveData.value = null
        Log.e(TAG, "new")
    }

    fun getUsernameLiveData(): MutableLiveData<UserEntity> {
        return mUsernameLiveData
    }
}