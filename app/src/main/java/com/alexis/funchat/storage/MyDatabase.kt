package com.alexis.funchat.storage

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.alexis.funchat.storage.dao.UserDao
import com.alexis.funchat.storage.entity.UserEntity

/**
 * Class description:
 *
 * @author Alexis
 * @date 2019/5/23  8:17
 */
@Database(entities = [UserEntity::class],version = 1,exportSchema = false)
abstract class MyDatabase constructor(context:Context): RoomDatabase() {

    abstract fun getUserDao():UserDao

    companion object {
        @Volatile private var INSTANCE: MyDatabase? = null
        fun getInstance(context: Context): MyDatabase =
                INSTANCE ?: synchronized(this) {
                    INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
                }

        private fun buildDatabase(context: Context) =
                Room.databaseBuilder(context.applicationContext,
                        MyDatabase::class.java, "funChat.db")
                        .allowMainThreadQueries()
                        .build()
    }
}
