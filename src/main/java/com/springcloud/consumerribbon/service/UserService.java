package com.springcloud.consumerribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springcloud.consumerribbon.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name){
        return restTemplate.getForObject("http://PROVIDER-USER/user/hi?name="+name,String.class);
    }

    @HystrixCommand(fallbackMethod = "userListError")
    public List<User> userList(){
        return restTemplate.getForObject("http://PROVIDER-USER/user/userList",List.class);
    }

    @HystrixCommand(fallbackMethod = "userAddError")
    public String addUser(User user){
        return restTemplate.postForObject("http://PROVIDER-USER/user/add",user,String.class);
    }

    @HystrixCommand(fallbackMethod ="updateUserError")
    public String updateUser(User user){
        return restTemplate.postForObject("http://PROVIDER-USER/user/update",user,String.class);
    }

    @HystrixCommand(fallbackMethod ="deleteUserError")
    public String deleteUser(String id){
        return restTemplate.postForObject("http://PROVIDER-USER/user/delete/"+id,null,String.class);
    }

    public String hiError(String name) {
        return "服务器开了小差，请休息一会再试！";
    }

    public List<User> userListError() {
        return null;
    }

    public String userAddError(User user){return "服务器开了小差，请休息一会再试！";}

    public String updateUserError(User user){return "服务器开了小差，请休息一会再试！";}

    public String deleteUserError(String id){return "服务器开了小差，请休息一会再试！";}
}
