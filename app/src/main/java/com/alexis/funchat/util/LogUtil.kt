package com.alexis.funchat.util

import android.util.Log
import androidx.annotation.NonNull


/**
 *  Class description:
 *
 *  @author Alexis
 *  @date   2019/5/24  15:44
 */
class LogUtil {

    companion object {
        private val TAG: String = LogUtil::class.java.simpleName
        private const val END:Boolean = false

        fun d(@NonNull message:String){
            if (END){
                return
            }
            Log.d(TAG,message)
        }

        fun d(@NonNull message: String, @NonNull vararg messages:String?){
            if (END){
                return
            }
            val sb = StringBuffer(message)
            for (item in messages){
                sb.append(item)
            }
            Log.d(TAG,sb.toString())

        }
    }
}