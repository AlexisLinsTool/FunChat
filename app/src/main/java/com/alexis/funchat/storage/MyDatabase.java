package com.alexis.funchat.storage;

import android.content.Context;

import com.alexis.funchat.storage.dao.UserDao;
import com.alexis.funchat.storage.entity.UserEntity;

import androidx.room.Room;
import androidx.room.RoomDatabase;


/**
 * Class description:
 *
 * @author Alexis
 * @date 2019/5/26  9:05
 */
@androidx.room.Database(entities = {UserEntity.class},version = 1, exportSchema = false)
public abstract class MyDatabase extends RoomDatabase {
    private static MyDatabase sInstance;
    private static final Object S_LOCK = new Object();

    public static MyDatabase getInstance(){
        return sInstance;
    }

    public static void initializa(Context context){
        if (sInstance == null){
            synchronized (S_LOCK){
                if (sInstance == null){
                    sInstance = Room.databaseBuilder(context,MyDatabase.class,"BaseData.db")
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
    }

    public abstract UserDao getUserDao();
}
