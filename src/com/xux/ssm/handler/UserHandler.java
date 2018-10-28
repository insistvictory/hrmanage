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
                session.setAttribute("user2",user);
                return "employee/employee";
            }
        }else {
            return "redirect:/login.jsp";
        }
    }

    /**
     * ��תվ
     * @return
     */
    @RequestMapping("backTurn")
    public String backTurn(){
        return "user/show";
    }

    /**
     * �������������ȡ״̬
     * @param readStatus
     * @param id
     * @return
     */
    @RequestMapping("modifyInterview")
    @ResponseBody
    public String modifyInterview(String readStatus,Integer id){
        interviewService.modifyInterviewReadStatus(readStatus,id);
        return "ok";
    }
    /**
     * �����������ӣ��޸ģ�
     * @param resume
     * @return
     */
    @RequestMapping("saveResume")
    public String saveResume(Resume resume){
        Resume rsme=resumeService.findResumeByUid(resume.getUid());
        System.out.println(rsme);
        System.out.println(resume);
        if (rsme==null){
            resumeService.saveResume(resume);
            return "user/show";
        }else {
            resumeService.updateResume(resume);
            return "user/show";
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
        return jsonJobs;
    }

    /**
     * ע������û�
     * @param user
     * @return
     */
    @RequestMapping("addUser")
    public String addUser(User user){
        user.setType(4);
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
    public String validatePassword(String password,Integer id){
        User user=userService.validatePassword(password,id);
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
            return "user/card";
        }else {
            return "user/show";
        }
    }

    /**
     * �鿴��Ƹ��Ϣ
     * @param model
     * @return
     */
    @RequestMapping("lookAtRecruitInfo")
    public String lookAtRecruitInfo(Model model){
        List<RecruitmentInfo> recruitInfos=recruitmentInfoService.findAllRecruitInfos();
        model.addAttribute("recruitInfos",recruitInfos);
        System.out.println(recruitInfos+"@@@@");
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
        model.addAttribute("recruitInfo",recruitInfo);
        return "user/recruitinfo";
    }

    /**
     * Ͷ�ݼ���
     * @param application
     * @return
     */
    @RequestMapping("deliver")
    @ResponseBody
    public String deliver(Application application){
        System.out.println(application.getResumeId());
        Application app=userService.findApplyByResumeId(application.getResumeId());
        if (app!=null){
            return "no";
        }else {
            application.setApplyTime(new Date());
            application.setResumeStatus("δ�鿴");
            application.setInterviewStatus("δ����");
            applicationService.addApplication(application);
            return "yes";
        }
    }
}
