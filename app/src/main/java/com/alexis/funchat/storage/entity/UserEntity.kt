package com.alexis.funchat.storage.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

/**
 * Class description:
 *
 * @author Alexis
 * @date 2019/5/26  9:18
 */
@Entity(tableName = "user")
data class UserEntity (
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String = UUID.randomUUID().toString(),
    @ColumnInfo(name = "account")
    var account: String = "",
    @ColumnInfo
    var password: String = "",
    @ColumnInfo
    var name:String = "游客",
    @ColumnInfo
    var note: String = ""
)