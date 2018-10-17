package com.xux.ssm.handler;

import com.xux.ssm.entity.*;
import com.xux.ssm.service.AdminService;
import com.xux.ssm.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2018/10/14.
 */
@RequestMapping("admin")
@Controller
public class AdminHandler {
    @Autowired
    private AdminService adminService;
    @Autowired
    private ApplicationService applicationService;

    /**
     * ����Ա��¼
     * @param name
     * @param password
     * @param session
     * @return
     */
    @RequestMapping("findAdminByNameAndPassword")
    public String findAdminByNameAndPassword(String name, String password, HttpSession session){
        Admin admin=adminService.findAdminByNameAndPassword(name,password);
        if (admin!=null){
            session.setAttribute("admin",admin);
            return "admin/admin";
        }else {
            return "redirect:/adminlogin.jsp";
        }
    }
    /**
     * �鿴Ͷ������ϸ��Ϣ
     * @param id
     * @param session
     * @return
     */
    @RequestMapping("searchDelivererDetail")
    public String searchEmployeeDetailByResumeId(Integer id,Integer apid,HttpSession session) {
        Resume resume=adminService.searchDelivererDetailByDid(id);
        Application application=applicationService.findApplicationById(apid);
        application.setResumeStatus("�Ѳ鿴");
        System.out.println(application);
        applicationService.updateApplication(application);
        session.setAttribute("resume",resume);
        session.setAttribute("apid",apid);
        return "admin/applydetail";
    }

    /**
     * �鿴����ӦƸ��Ϣ
     * @param session
     * @return
     */
    @RequestMapping("lookApplications")
    public String lookApplications(HttpSession session){
        List<Application> applications=applicationService.findAllApplications();
        session.setAttribute("applications",applications);
        return "admin/application";
    }

    /**
     * �����������
     * @return
     */
    @RequestMapping("interviewAdd")
    public String interviewAdd(Interview interview,String dept){
        System.out.println(interview);
        interview.setHire("δ¼��");

        adminService.addInterview(interview);
        return null;
    }
    @RequestMapping("middle")
    public String middle(){
        return "admin/admin";
    }
    @RequestMapping("lookDepts")
    public String lookDepts(Model model){
        List<Dept> depts= adminService.lookDepts();
        model.addAttribute("depts",depts);
        return "admin/dept";
    }
    @RequestMapping("deleteDeptByName")
    public String deleteDeptByName(){
        return null;
    //TODO
    }
    @RequestMapping("deleteApplicationById")
    @ResponseBody
    public String deleteApplicationById(Integer id){
        applicationService.deleteApplicationById(id);
        return "ok";
    }

}
