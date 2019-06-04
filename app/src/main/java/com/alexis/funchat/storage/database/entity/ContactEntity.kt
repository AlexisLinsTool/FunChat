package com.alexis.funchat.storage.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


/**
 *  Class description:
 *
 *  @author Alexis
 *  @date   2019/5/30  9:33
 */
data class ContactEntity (
        //名字
        var name:String,
        //头像路径
        var avatar:String
)