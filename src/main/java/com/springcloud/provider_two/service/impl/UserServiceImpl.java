package com.springcloud.provider_two.service.impl;

import com.springcloud.provider_two.dao.UserDao;
import com.springcloud.provider_two.model.User;
import com.springcloud.provider_two.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void createUser(User user) {
        userDao.createUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public List<User> findAllUser() {
        List<User> users = userDao.findAllUser();
        return users;
    }

    @Override
    public void deleteUser(Integer id) {
        userDao.deleteUser(id);
    }
}
