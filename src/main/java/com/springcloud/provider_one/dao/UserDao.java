package com.springcloud.provider_one.dao;

import com.springcloud.provider_one.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {

    /**
     * 新增用户
     */
    void createUser(User user);
    /**
     * 修改用户
     */
    void updateUser(User user);
    /**
     * 查找用户
     */
    List<User> findAllUser();
    /**
     * 删除用户
     */
    void deleteUser(Integer id);
}
