package com.springcloud.provider_one.service;

import com.springcloud.provider_one.model.User;

import java.util.List;

public interface UserService {

    /**
     * 新增用户
     */
    public void createUser(User user);
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
