package com.alexis.funchat.vm

import android.util.Log
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alexis.funchat.repository.ContactRepository
import com.alexis.funchat.storage.database.entity.ContactEntity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


/**
 *  Class description:
 *
 *  @author Alexis
 *  @date   2019/5/30  19:13
 */
class ContactViewModel : ViewModel() {
    private var TAG = ContactViewModel::class.simpleName
    private var mContactLiiveData: MutableLiveData<List<ContactEntity>> = MediatorLiveData<List<ContactEntity>>()
    private var mContactRepository: ContactRepository
    private var mDisposable: CompositeDisposable = CompositeDisposable()

    init {
        mContactLiiveData.value = null
        mContactRepository = ContactRepository()
        val disposable = mContactRepository
                .getContacts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {mContactLiiveData.value = it },
                        { throwable ->
                            Log.e(TAG, "获取联系人失败")
                            throwable.printStackTrace()
                        }
                )
        mDisposable.add(disposable)
        Log.e(TAG, "创建了实例")
    }

    override fun onCleared() {
        mDisposable.clear()
    }
}