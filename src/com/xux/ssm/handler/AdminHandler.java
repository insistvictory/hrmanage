package com.xux.ssm.handler;

import com.xux.ssm.entity.*;
import com.xux.ssm.service.AdminService;
import com.xux.ssm.service.ApplicationService;
import com.xux.ssm.service.DeptService;
import com.xux.ssm.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    @Autowired
    private DeptService deptService;
    @Autowired
    private JobService jobService;

    /**
     * 查看投递者详细信息
     * @param id
     * @param session
     * @return
     */
    @RequestMapping("searchDelivererDetail")
    public String searchEmployeeDetailByResumeId(Integer id,Integer apid,HttpSession session) {
        Resume resume=adminService.searchDelivererDetailByDid(id);
        Application application=applicationService.findApplicationById(apid);
        application.setResumeStatus("已查看");
        System.out.println(application);
        System.out.println(apid);
        applicationService.updateApplication(application);
        session.setAttribute("resume",resume);
        session.setAttribute("apid",apid);
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

    /**
     * 添加面试邀请
     * @return
     */
    @RequestMapping("interviewAdd")
    public String interviewAdd(Interview interview){
        System.out.println("来！！！");
        System.out.println(interview);
        interview.setHire("未录用");
        adminService.addInterview(interview);
        System.out.println(interview+"22222");
        return "redirect:lookApplications";
    }
    //TODO
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
    @ResponseBody
    public String deleteDeptByName(String name){
        List<Employee> employees=deptService.searchEmployeeByDeptName(name);
        System.out.println(employees);
        if (employees==null){
            return "ok";
        }else {
            return "no";
        }
    }
    @RequestMapping("deleteApplicationById")
    @ResponseBody
    public String deleteApplicationById(Integer id){
        applicationService.deleteApplicationById(id);
        return "ok";
    }
    @RequestMapping("findJobsByDeptName")
    public String findJobsByDeptName(String deptName,Model model){
        Dept dept=deptService.findDeptByName(deptName);
        List<Job> jobs=adminService.findJobsByDeptId(dept.getId());
        model.addAttribute("jobs",jobs);
        model.addAttribute("deptId",dept.getId());
        return "admin/job";
    }
    @RequestMapping("deleteJobByName")
    @ResponseBody
    public String deleteJobByName(String name){
        List<Employee> employees=deptService.searchEmployeeByJobName(name);
        System.out.println(employees);
        if (employees==null){
            return "ok";
        }else {
            return "no";
        }
    }
    @RequestMapping("deptMiddle")
    public String deptMiddle(String flag,String deptName,Model model){
        if ("add".equals(flag)){
            return "admin/addept";
        }else {
            Dept dept=deptService.findDeptByName(deptName);
            model.addAttribute("dept",dept);
            return "admin/editdept";
        }
    }
    @RequestMapping("findDeptByName")
    @ResponseBody
    public String findDeptByName(String name){
        Dept dept=deptService.findDeptByName(name);
        if (dept==null){
            dept.setCreateTime(new Date());
            deptService.addDept(dept);
            return "ok";
        }else{
            return "no";
        }
    }
    @RequestMapping("editDept")
    public String editDept(Dept dept){
        deptService.editDept(dept);
        return "forward:lookDepts";
    }
    @RequestMapping("lookAllEmployees")
    public String lookAllEmployees(Model model){
        List<Employee> employees=adminService.findAllEmployees();
        model.addAttribute("employees",employees);
        return "admin/emp";
    }
    @RequestMapping("searchEmployeeById")
    public String searchEmployeeById(Integer id,Model model){
       Employee employee = adminService.findEmployeeById(id);
       model.addAttribute("employee",employee);
       return "admin/empdetail";
    }

    /**
     * 人事调动页面跳转
     * @return
     */
    @RequestMapping("transferOfPersonnel")
    public String transferOfPersonnel(Integer id,Model model){
        Employee employee=adminService.findEmployeeById(id);
        System.out.println(employee+"#######");
        List<Dept> depts=deptService.findAllDepts();
        List<Job> jobs=jobService.findAllJobs();
        model.addAttribute("employee",employee);
        model.addAttribute("depts",depts);
        model.addAttribute("jobs",jobs);
        return "admin/transfer";
    }

    /**
     * 人事调度
     * @param id
     * @param dept
     * @param job
     * @return
     */
    @RequestMapping("transfer")
    @ResponseBody
    public String transfer(Integer id,String dept,String job){
        adminService.updateEmployeeById(id,dept,job);
        return "yes";
    }
    @RequestMapping("trainManage")
    public String trainManage(){
        return null;
        //TODO
    }



    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request){
        DateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class,new CustomDateEditor(dateFormat,true));
    }
}
