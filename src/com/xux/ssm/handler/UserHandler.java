package com.xux.ssm.handler;

import com.xux.ssm.entity.User;
import com.xux.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.PublicKey;

/**
 * Created by Administrator on 2018/10/12.
 */
@RequestMapping("user")
@Controller
public class UserHandler {
    @Autowired
    private UserService userService;
    @RequestMapping("findUserByNameAndPassword")
    public String findUserByNameAndPassword(String name,String password){
        Boolean flag=userService.findUserByNameAndPassword(name,password);
        if (flag){
            return "show";
        }else {
            return "redirect:/login.jsp";
        }
    }
    @RequestMapping("addUser")
    public String addUser(User user){
        userService.addUser(user);
        return "redirect:/login.jsp";
    }
}
