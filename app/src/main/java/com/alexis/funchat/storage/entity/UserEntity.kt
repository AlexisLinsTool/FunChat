package com.alexis.funchat.storage.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Class description:
 *
 * @author Alexis
 * @date 2019/5/23  8:25
 */
@Entity(tableName = "user")
class UserEntity {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
    @ColumnInfo
    var account: String = ""
    @ColumnInfo
    var password: String = ""
    @ColumnInfo
    var name: String = "游客"
    @ColumnInfo
    var note: String = name
}
