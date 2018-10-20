package com.xux.ssm.handler;

import com.alibaba.fastjson.JSONArray;
import com.xux.ssm.entity.*;
import com.xux.ssm.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpSession;
import java.util.Date;
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
    @Autowired
    private RecruitmentInfoService recruitmentInfoService;
    @Autowired
    private ApplicationService applicationService;
    @Autowired
    private InterviewService interviewService;
    /**
     登录验证通过用户名和密码查找User
     * @param name
     * @param password
     * @param session
     * @return
     */
    @RequestMapping("findUserByNameAndPassword")
    public String findUserByNameAndPassword(String name, String password, HttpSession session){
        User user=userService.findUserByNameAndPassword(name,password);
        if (user!=null){
            if (user.getType()==4){
                session.setAttribute("user",user);
                Resume resume=resumeService.queryResumeByUid(user.getId());
                if(resume!=null){
                    Application application=applicationService.queryApplicationByResumeId(resume.getId());
                    if (application!=null){
                        Interview interview=interviewService.findInterviewByApplyId(application.getId());
                        session.setAttribute("interview",interview);
                        session.setAttribute("application",application);
                        System.out.println(interview);
                    }
                }
                return "user/show";
            }else if(user.getType()==1){
                return "admin/admin";
            }else {
                return null;
            }
        }else {
            return "redirect:/login.jsp";
        }
    }

    /**
     * 保存简历（添加，修改）
     * @param resume
     * @return
     */
    @RequestMapping("saveResume")
    public String saveResume(Resume resume){
        Resume rsme=resumeService.findResumeByUid(resume.getUid());
        if (rsme==null){
            resumeService.saveResume(resume);
            return "user/show";
        }else {
            resumeService.updateResume(resume);
            return "user/show";
        }
    }

    /**
     * 根据部门名字查找该部门所有的职位
     * @param dName
     * @return
     */
    @RequestMapping( value = "findRelatedJobs" ,produces = {"text/html;charset=utf-8"})
    @ResponseBody
    public String findRelatedJobs(String dName){
        Dept dept=deptService.findDeptByName(dName);
        List<Job> jobs= jobService.findJobsByDeptId(dept.getId());
        String jsonJobs= JSONArray.toJSONString(jobs);
        return jsonJobs;
    }

    /**
     * 注册添加用户
     * @param user
     * @return
     */
    @RequestMapping("addUser")
    public String addUser(User user){
        userService.addUser(user);
        return "redirect:/login.jsp";
    }

    /**
     * 验证用户名
     * @param name
     * @return
     */
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

    /**
     * 验证密码
     * @param password
     * @return
     */
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

    /**
     * 修改密码
     * @param id
     * @param newPassword
     * @return
     */
    @RequestMapping("updatePassword")
    public String updatePassword(Integer id,String newPassword){
        userService.updatePassword(id,newPassword);
        return "user/show";

    }

    /**
     * 查看简历（返回）
     * @param flag
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("lookResume")
    public String lookResume(String flag,Integer id,Model model){
        Resume resume=resumeService.findResumeByUid(id);
        List<Dept> depts=deptService.findAllDepts();
        List<Job> jobs=jobService.findAllJobs();
        if ("a".equals(flag)){
            model.addAttribute("resume",resume);
            model.addAttribute("depts",depts);
            model.addAttribute("jobs",jobs);
            return "user/card";
        }else {
            return "user/show";
        }
    }

    /**
     * 查看招聘信息
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("lookAtRecruitInfo")
    public String lookAtRecruitInfo(Integer id,Model model,HttpSession session){
        List<RecruitmentInfo> recruitInfos=recruitmentInfoService.findAllRecruitInfos();
        Resume resume=resumeService.findResumeByUid(id);
        System.out.println(resume);
        model.addAttribute("recruitInfos",recruitInfos);
        session.setAttribute("resume",resume);
        return "user/recruit";
    }

    /**
     * 查看具体职位的招聘信息
     * @param id
     * @return
     */
    @RequestMapping("findRecruitInfo")
    public String findRecruitInfo(Integer id,Model model){
        RecruitmentInfo recruitInfo=recruitmentInfoService.findRecruitInfoById(id);
        model.addAttribute("recruitInfo",recruitInfo);
        return "user/recruitinfo";
    }

    @RequestMapping("deliver")
    @ResponseBody
    public String deliver(Application application){
        System.out.println(application.getResumeId());
        Application app=userService.findApplyByResumeId(application.getResumeId());
        if (app!=null){
            return "no";
        }else {
            application.setApplyTime(new Date());
            application.setResumeStatus("未查看");
            application.setInterviewStatus("未面试");
            applicationService.addApplication(application);
            return "yes";
        }
    }
}
