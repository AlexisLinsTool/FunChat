package com.alexis.funchat.storage.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Class description:
 *
 * @author Alexis
 * @date 2019/5/26  9:18
 */
@Entity(tableName = "user")
public class UserEntity {
    @PrimaryKey(autoGenerate = true)
    Long id;
    @ColumnInfo
    String account;
    @ColumnInfo
    String password;
    @ColumnInfo
    String name = "游客";
    @ColumnInfo
    String note;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
