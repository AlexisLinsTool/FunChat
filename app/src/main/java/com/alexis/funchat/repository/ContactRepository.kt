package com.alexis.funchat.repository

import com.alexis.funchat.storage.database.entity.ContactEntity
import com.alexis.funchat.storage.net.ContactService
import com.alexis.funchat.storage.net.Network
import io.reactivex.Flowable


/**
 *  Class description:
 *
 *  @author Alexis
 *  @date   2019/5/30  19:21
 */
class ContactRepository{
    private val TAG = ContactRepository::class.simpleName
    private var mContactService:ContactService = Network.getInstance().getService(ContactService::class.java)

    fun getContacts():Flowable<List<ContactEntity>>{
        return mContactService.getList()
    }
}