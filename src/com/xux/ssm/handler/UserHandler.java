package com.xux.ssm.handler;

import com.alibaba.fastjson.JSONArray;
import com.xux.ssm.entity.Dept;
import com.xux.ssm.entity.Job;
import com.xux.ssm.entity.Resume;
import com.xux.ssm.entity.User;
import com.xux.ssm.service.DeptService;
import com.xux.ssm.service.JobService;
import com.xux.ssm.service.ResumeService;
import com.xux.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.print.SunPrinterJobService;

import javax.servlet.http.HttpSession;
import java.util.List;


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
    @Autowired
    private DeptService deptService;
    @Autowired
    private JobService jobService;
    @RequestMapping("findUserByNameAndPassword")
    public String findUserByNameAndPassword(String name, String password, HttpSession session){
        User user=userService.findUserByNameAndPassword(name,password);
        if (user!=null){
            session.setAttribute("user",user);
            return "show";
        }else {
            return "redirect:/login.jsp";
        }
    }
    @RequestMapping("saveResume")
    public String saveResume(Resume resume){
        Resume rsme=resumeService.findResumeByUid(resume.getUid());
        if (rsme==null){
            resumeService.saveResume(resume);
            return "show";
        }else {
            resumeService.updateResume(resume);
            return "show";
        }

    }
    @RequestMapping( value = "findRelatedJobs" ,produces = {"text/html;charset=utf-8"})
    @ResponseBody
    public String findRelatedJobs(String dName){
        Dept dept=deptService.findDeptByName(dName);
        List<Job> jobs= jobService.findJobsByDeptId(dept.getId());
        String jsonJobs= JSONArray.toJSONString(jobs);
        System.out.println(jsonJobs);
        return jsonJobs;
    }

    @RequestMapping("addUser")
    public String addUser(User user){
        userService.addUser(user);
        return "redirect:/login.jsp";
    }
    @RequestMapping("validateName")
    @ResponseBody
    public String validateName(String name){
        User user=userService.validate(name);
        String msg="";
        if (user==null){
            msg="ok";
        }else {
            msg="no";
        }
        return msg;
    }
    @RequestMapping("validatePassword")
    @ResponseBody
    public String validatePassword(String password){
        User user=userService.validatePassword(password);
        String msg="";
        if (user==null){
            msg="error";
        }
        return msg;
    }
    @RequestMapping("updatePassword")
    public String updatePassword(Integer id,String newPassword){
        userService.updatePassword(id,newPassword);
        return "show";

    }

    @RequestMapping("lookResume")
    public String lookResume(String flag,Integer id,Model model){
        Resume resume=resumeService.findResumeByUid(id);
        List<Dept> depts=deptService.findAllDepts();
        List<Job> jobs=jobService.findAllJobs();
        if ("a".equals(flag)){
            model.addAttribute("resume",resume);
            model.addAttribute("depts",depts);
            model.addAttribute("jobs",jobs);
            return "card";
        }else {
            return "show";
        }
    }
}
