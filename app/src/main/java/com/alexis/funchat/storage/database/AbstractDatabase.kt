package com.alexis.funchat.storage.database

import android.content.Context

import com.alexis.funchat.storage.database.dao.UserDao
import com.alexis.funchat.storage.database.entity.UserEntity

import androidx.room.Room
import androidx.room.RoomDatabase
import com.alexis.funchat.app.MyApplication


/**
 * Class description:
 *
 * @author Alexis
 * @date 2019/5/26  9:05
 */
@androidx.room.Database(entities = arrayOf(UserEntity::class), version = 1, exportSchema = false)
abstract class AbstractDatabase : RoomDatabase() {

    /**
     * fdsf
     * @return
     */
    abstract val userDao: UserDao

    companion object {


        @Volatile private var INSTANCE: AbstractDatabase? = null

        fun getInstance(): AbstractDatabase =
                INSTANCE ?: synchronized(this) {
                    INSTANCE?: initializa(MyApplication.getContext()).also { INSTANCE = it }
                }

        private fun initializa(context: Context) =
                Room.databaseBuilder(context.applicationContext,
                        AbstractDatabase::class.java, "Sample.db")
                        .build()
//        var wait = true
//        lateinit var instance: AbstractDatabase
//        private val S_LOCK = Any()
//
//        fun initializa(context: Context) {
//            if (wait) {
//                synchronized(S_LOCK) {
//                    if (wait) {
//                        instance = Room.databaseBuilder(context, AbstractDatabase::class.java, "BaseData.db")
//                                .allowMainThreadQueries()
//                                .build()
//                        wait = false
//                    }
//                }
//            }
//        }
    }
}
