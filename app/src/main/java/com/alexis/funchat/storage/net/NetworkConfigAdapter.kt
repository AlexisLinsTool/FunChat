package com.alexis.funchat.storage.net

import retrofit2.Retrofit


/**
 *  Class description:
 *
 *  @author Alexis
 *  @date   2019/5/30  8:24
 */

interface NetworkConfigAdapter {
    fun configure(builder:Retrofit.Builder)
}