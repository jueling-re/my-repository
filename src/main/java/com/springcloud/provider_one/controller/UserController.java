package com.springcloud.provider_one.controller;

import com.springcloud.provider_one.model.User;
import com.springcloud.provider_one.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/userList")
    public List<User> findAllUser(){
        return userService.findAllUser();
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String addUser(@RequestBody User user){
        if(user!=null){
            userService.createUser(user);
            return "success";
        }else{
            return "error";
        }
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String update(@RequestBody User user){
        if(user!=null){
            userService.updateUser(user);
            return "success";
        }else{
            return "error";
        }
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.POST)
    public String delete(@PathVariable Integer id){
        try {
            userService.deleteUser(id);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }

    @Value("${server.port}")
    String port;
    @RequestMapping(value = "/hi")
    public String home(@RequestParam(value = "name",defaultValue = "zhangsan")String name){
        return "hi"+name+",i am from port:"+port;
    }
}
