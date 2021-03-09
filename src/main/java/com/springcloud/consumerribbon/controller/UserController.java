package com.springcloud.consumerribbon.controller;

import com.springcloud.consumerribbon.model.User;
import com.springcloud.consumerribbon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/hi")
    public String hi(@RequestParam String name){
        return userService.hiService(name);
    }

    @RequestMapping(value = "/userList")
    public List<User> userList(){
        return userService.userList();
    }

    @RequestMapping(value ="/addUser")
    public String addUser(@RequestParam Integer id,String username){
        User user =new User();
        user.setId(id);
        user.setName(username);
        return userService.addUser(user);
    }

    @RequestMapping(value ="/updateUser")
    public String updateUser(@RequestParam Integer id,String username){
        User user =new User();
        user.setId(id);
        user.setName(username);
        return userService.updateUser(user);

    }

    @RequestMapping(value ="/deleteUser")
    public String deleteUser(@RequestParam String id){
        return userService.deleteUser(id);
    }

}
