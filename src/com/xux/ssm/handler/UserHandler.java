package com.xux.ssm.handler;

import com.xux.ssm.entity.Resume;
import com.xux.ssm.entity.User;
import com.xux.ssm.service.ResumeService;
import com.xux.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



/**
 * Created by Administrator on 2018/10/12.
 */
@RequestMapping("user")
@Controller
public class UserHandler {
    @Autowired
    private UserService userService;
    @Autowired
    private ResumeService resumeService;
    @RequestMapping("findUserByNameAndPassword")
    public String findUserByNameAndPassword(String name, String password, Model model){
        User user=userService.findUserByNameAndPassword(name,password);
        if (user!=null){
            model.addAttribute("user",user);
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
    @RequestMapping("lookResume")
    public String lookResume(String flag,Integer id,Model model){
        Resume resume=resumeService.findResumeByUid();
        if ("a".equals(flag)){
            model.addAttribute(resume);
            return "card";
        }else {
            return "show";
        }
    }
}
