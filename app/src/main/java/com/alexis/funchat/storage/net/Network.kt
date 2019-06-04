package com.alexis.funchat.storage.net

import android.provider.CalendarContract
import retrofit2.Retrofit


/**
 *  Class description:
 *
 *  @author Alexis
 *  @date   2019/5/30  8:18
 */

public class Network(var adapter:NetworkConfigAdapter?){

    lateinit var mRetrofit: Retrofit

    init {
        val builder:Retrofit.Builder = Retrofit.Builder()
        adapter?.configure(builder)
        mRetrofit = builder.build()
    }

    fun<T> getService(service:Class<T>):T{
        return mRetrofit.create(service)
    }

    companion object{

        @Volatile private var INSTANCE: Network? = null

        fun getInstance(): Network =
                INSTANCE ?: synchronized(Network::class) {
                    INSTANCE?: Network(NetworkConfiguration())
                }

    }
}