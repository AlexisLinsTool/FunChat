package com.alexis.funchat.storage.net

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


/**
 *  Class description:
 *
 *  @author Alexis
 *  @date   2019/5/30  8:25
 */

class NetworkConfiguration :NetworkConfigAdapter{
    override fun configure(builder: Retrofit.Builder) {
        builder.baseUrl(BASE_URL)
        builder.addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
        builder.addConverterFactory(GsonConverterFactory.create())
    }

    companion object URL{
        val BASE_URL:String = "http:///10.29.5.175:8080/im/"
        val TAG: String? = NetworkConfiguration::class.simpleName
    }
}