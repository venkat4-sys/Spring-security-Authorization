package com.ft.rest;

import com.ft.entity.UserInfo;
import com.ft.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MsgRestController {

    @Autowired
    private UserService userService;

    @GetMapping("/msg")
    public String getMessage(){
        return "Hello World";
    }

    @GetMapping("/getAllMsgs")
    public List<String> getAllMessages(){

        List<String> msgs=new ArrayList<>();
        msgs.add("Hello world");
        msgs.add("Good Morning");
        return msgs;
    }

    @PostMapping("/user")
    public String saveUser(@RequestBody  UserInfo userInfo){
        String msg = userService.saveUser(userInfo);
        return msg;
    }
}
