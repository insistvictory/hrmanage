package com.xux.ssm.handler;

import com.xux.ssm.entity.Resume;
import com.xux.ssm.service.AdminService;
import com.xux.ssm.service.ApplicationService;
import javafx.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
     * 查看投递者详细信息
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("searchDelivererDetail")
    public String searchEmployeeDetailByResumeId(Integer id,Model model) {
        Resume resume=adminService.searchDelivererDetailByDid(id);
        model.addAttribute("resume",resume);
        return "admin/applydetail";
    }

    /**
     * 查看所有应聘消息
     * @param session
     * @return
     */
    @RequestMapping("lookApplications")
    public String lookApplications(HttpSession session){
        List<Application> applications=applicationService.findAllApplications();
        session.setAttribute("applications",applications);
        return "admin/application";
    }
    @RequestMapping("sendInterview")
    public String sendInterview(){

        return null;
    }
}
