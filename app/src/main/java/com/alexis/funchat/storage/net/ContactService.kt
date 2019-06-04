package com.alexis.funchat.storage.net

import com.alexis.funchat.storage.database.entity.ContactEntity
import io.reactivex.Flowable
import retrofit2.http.GET


/**
 *  Class description:
 *
 *  @author Alexis
 *  @date   2019/5/30  9:29
 */
interface ContactService{

    @GET("contact")
    fun getList():Flowable<List<ContactEntity>>

}