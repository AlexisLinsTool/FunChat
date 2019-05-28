package com.alexis.funchat.storage.dao;

import com.alexis.funchat.storage.entity.UserEntity;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

/**
 * Class description:
 *
 * @author Alexis
 * @date 2019/5/26  9:15
 */
@Dao
public interface UserDao {
    /**
     * 添加一个用户（联系人）
     * @param userEntity 添加的联系人
     */
    @Insert
    void addOne(UserEntity userEntity);

    /**
     * 通过用户账号密码获取一个用户信息
     * @param account 用户账户
     * @param password 用户密码
     * @return UserEntity
     */
    @Query("SELECT * FROM USER WHERE account =:account AND password =:password LIMIT 1")
    UserEntity findOneByAccountAndPassword(String account, String password);

    /**
     * 获取所有用户（联系人）
     * @return List<UserEntity>
    </UserEntity> */
    @Query("SELECT * FROM USER")
    List<UserEntity> listAll();

    /**
     * 删除一个用户（联系人）
     * @param entity  删除的用户（联系人）
     */
    @Delete
    void deleteOne(UserEntity entity);

}
