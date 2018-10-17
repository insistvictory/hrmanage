package com.xux.ssm.handler;

import com.alibaba.fastjson.JSONArray;
import com.xux.ssm.entity.*;
import com.xux.ssm.service.*;
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
    @Autowired
    private RecruitmentInfoService recruitmentInfoService;
    /**
     ��¼��֤ͨ���û������������User
     * @param name
     * @param password
     * @param session
     * @return
     */
    @RequestMapping("findUserByNameAndPassword")
    public String findUserByNameAndPassword(String name, String password, HttpSession session){
        User user=userService.findUserByNameAndPassword(name,password);
        if (user!=null){
            session.setAttribute("user",user);
            return "user/show";
        }else {
            return "redirect:/login.jsp";
        }
    }

    /**
     * �����������ӣ��޸ģ�
     * @param resume
     * @return
     */
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

    /**
     * ���ݲ������ֲ��Ҹò������е�ְλ
     * @param dName
     * @return
     */
    @RequestMapping( value = "findRelatedJobs" ,produces = {"text/html;charset=utf-8"})
    @ResponseBody
    public String findRelatedJobs(String dName){
        Dept dept=deptService.findDeptByName(dName);
        List<Job> jobs= jobService.findJobsByDeptId(dept.getId());
        String jsonJobs= JSONArray.toJSONString(jobs);
        System.out.println(jsonJobs);
        return jsonJobs;
    }

    /**
     * ע������û�
     * @param user
     * @return
     */
    @RequestMapping("addUser")
    public String addUser(User user){
        userService.addUser(user);
        return "redirect:/login.jsp";
    }

    /**
     * ��֤�û���
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
     * ��֤����
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
     * �޸�����
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
     * �鿴���������أ�
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
            return "card";
        }else {
            return "show";
        }
    }

    /**
     * �鿴��Ƹ��Ϣ
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("lookAtRecruitInfo")
    public String lookAtRecruitInfo(Integer id,Model model,HttpSession session){
        List<RecruitmentInfo> recruitInfos=recruitmentInfoService.findAllRecruitInfos();
        Resume resume=resumeService.findResumeByUid(id);
        model.addAttribute("recruitInfos",recruitInfos);
        session.setAttribute("resume",resume);
        return "user/recruit";
    }

    /**
     * �鿴����ְλ����Ƹ��Ϣ
     * @param id
     * @return
     */
    @RequestMapping("findRecruitInfo")
    public String findRecruitInfo(Integer id,Model model){
        RecruitmentInfo recruitInfo=recruitmentInfoService.findRecruitInfoById(id);
        model.addAttribute(recruitInfo);
        return "user/recruitinfo";
    }

    @RequestMapping("deliver")
    public String deliver(){
        return null;
        //ToDo
    }
}
