package com.alexis.funchat.storage.dao

import com.alexis.funchat.storage.entity.UserEntity
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.alexis.funchat.ui.ContactFragment

/**
 * Class description:
 *
 * @author Alexis
 * @date 2019/5/23  21:59
 */
@Dao
interface UserDao {
    /**
     * 添加一个用户（联系人）
     * @param entity 添加的联系人
     */
    @Insert
    fun addOne(entity: UserEntity)

    /**
     * 通过用户账号密码获取一个用户信息
     * @param account 用户账户
     * @param password 用户密码
     * @return UserEntity
     */
    @Query("SELECT * FROM USER WHERE account =:account AND password =:password LIMIT 1")
    fun findOneByAccountAndPassword(account: String, password: String): UserEntity?

    /**
     * 获取所有用户（联系人）
     * @return List<UserEntity>
    </UserEntity> */
    @Query("SELECT * FROM USER")
    fun listAll(): List<UserEntity>

    /**
     * 删除一个用户（联系人）
     * @param entity  删除的用户（联系人）
     */
    @Delete
    fun deleteOne(entity: UserEntity)

    companion object {

        val instance: UserDao
            get() = UserDao.instance
    }
}
