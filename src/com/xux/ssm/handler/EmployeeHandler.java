package com.xux.ssm.handler;

import com.alibaba.fastjson.JSONArray;
import com.xux.ssm.entity.*;
import com.xux.ssm.service.EmployeeService;
import com.xux.ssm.service.RewardPublishService;
import com.xux.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/10/18.
 */
@RequestMapping("employee")
@Controller
public class EmployeeHandler {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private UserService userService;
    @Autowired
    private RewardPublishService rewardPublishService;

    /**
     * 上班打卡
     * @param uid
     * @param rewardPublish
     * @param check
     * @return
     */
    @RequestMapping("working")
    @ResponseBody
    public String working(Integer uid,RewardPublish rewardPublish,Check check){
        Employee employee=employeeService.findEmployeeByUid(uid);
        System.out.println(employee.getId());
        Integer eid=employee.getId();
        Calendar calendar= Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH)+1;
        int date = calendar.get(Calendar.DATE);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        check.setEid(eid);
        check.setYear(year);
        check.setMonth(month);
        check.setDay(date);
        check.setBeginTime(year + "-" + month + "-" + date + " " + hour + ":" + minute + ":" + second);
        if (hour >= 12) {
            check.setWorkStatus("旷工");
            rewardPublish.setCause("旷工");
            rewardPublish.setEid(eid);
            rewardPublish.setMoney(-100.0);
            rewardPublish.setRpTime(new Date());
            employeeService.addRewardPublish(rewardPublish);
            employeeService.addCheck(check);
        } else if (hour >= 9) {
            check.setWorkStatus("迟到");
            rewardPublish.setCause("迟到");
            rewardPublish.setEid(eid);
            rewardPublish.setMoney(-25.0);
            rewardPublish.setRpTime(new Date());
            employeeService.addRewardPublish(rewardPublish);
            employeeService.addCheck(check);
        } else {
            check.setWorkStatus("正常");
        }
        return "ok";
    }

    /**
     * 下班打卡
     * @param uid
     * @param rewardPublish
     * @return
     */
    @RequestMapping("worked")
    @ResponseBody
    private String worked(Integer uid, RewardPublish rewardPublish) {
        System.out.println(uid+"youmeiyou");
        Employee employee=employeeService.findEmployeeByUid(uid);
        System.out.println(employee);
        System.out.println(employee.getId());
        Integer eid=employee.getId();
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH)+1;
        int date = calendar.get(Calendar.DATE);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        Check check=employeeService.findCheckByTimeAndUid(year,month,date,eid);
        check.setEndTime(year + "-" + month + "-" + date + " " + hour + ":" + minute + ":" + second);
        if (hour < 14) {//旷工
            if(check.getWorkStatus().equals("迟到")){
                check.setWorkStatus("旷工");
                rewardPublish.setCause("旷工");
                rewardPublish.setEid(eid);
                rewardPublish.setMoney(-75.0);
                rewardPublish.setRpTime(new Date());
                employeeService.addRewardPublish(rewardPublish);
                employeeService.updateCheck(check);
            }else if (check.getWorkStatus().equals("正常")){
                check.setWorkStatus("旷工");
                rewardPublish.setCause("旷工");
                rewardPublish.setEid(eid);
                rewardPublish.setMoney(-100.0);
                rewardPublish.setRpTime(new Date());
                employeeService.addRewardPublish(rewardPublish);
                employeeService.updateCheck(check);
            }else {
                employeeService.updateCheck(check);
            }
        } else if (hour>=14&&hour<17) {//早退
            if(check.getWorkStatus().equals("迟到")) {
                check.setWorkStatus("早退");
                check.setWorkStatus("早退");
                rewardPublish.setCause("早退");
                rewardPublish.setEid(eid);
                rewardPublish.setMoney(-25.0);
                rewardPublish.setRpTime(new Date());
                employeeService.addRewardPublish(rewardPublish);
                employeeService.updateCheck(check);
            }else if (check.getWorkStatus().equals("正常")){
                check.setWorkStatus("早退");
                check.setWorkStatus("早退");
                rewardPublish.setCause("早退");
                rewardPublish.setEid(eid);
                rewardPublish.setMoney(-25.0);
                rewardPublish.setRpTime(new Date());
                employeeService.addRewardPublish(rewardPublish);
                employeeService.updateCheck(check);
            }else {
                employeeService.updateCheck(check);
            }
        } else if (hour >= 17 && hour < 19) {
            employeeService.updateCheck(check);
        } else {
            if (check.getWorkStatus().equals("迟到")) {
                check.setWorkStatus("迟到，加班");
                rewardPublish.setCause("迟到，加班");
                rewardPublish.setEid(eid);
                rewardPublish.setMoney(20.0 * (hour - 19));
                rewardPublish.setRpTime(new Date());
                employeeService.addRewardPublish(rewardPublish);
               employeeService.updateCheck(check);
            }else if (check.getWorkStatus().equals("旷工")){
                check.setWorkStatus("旷工，加班");
                rewardPublish.setCause("旷工，加班");
                rewardPublish.setEid(eid);
                rewardPublish.setMoney(20.0 * (hour - 19));
                rewardPublish.setRpTime(new Date());
                employeeService.addRewardPublish(rewardPublish);
                employeeService.updateCheck(check);
            }else {
                check.setWorkStatus("正常，加班");
                rewardPublish.setCause("正常，加班");
                rewardPublish.setEid(eid);
                rewardPublish.setMoney(20.0 * (hour - 19));
                rewardPublish.setRpTime(new Date());
                employeeService.addRewardPublish(rewardPublish);
                employeeService.updateCheck(check);
            }
        }
        return "ok";
    }

    /**
     * 刷新打卡按钮
     * @param uid
     * @return
     */
    @RequestMapping("checkAbility")
    @ResponseBody
    public String checkAbility(Integer uid){
        Employee employee=employeeService.findEmployeeByUid(uid);
        Integer eid=employee.getId();
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH)+1;
        int date = calendar.get(Calendar.DATE);
        Check check=employeeService.findCheckByTimeAndUid(year,month,date,eid);
        System.out.println("验证"+check);
        if (check==null){
            return "ok";
        }
        return "no";
    }
    @RequestMapping("lookMessage")
    public String lookMessage(Integer id,Model model){
        Employee employee=employeeService.findEmployeeByUid(id);
        model.addAttribute("employee",employee);
        return "employee/employeeifo";
    }
    @RequestMapping("middle")
    public String middle(){
        return "employee/employee";
    }
    @RequestMapping("updateEmployee")
    public String updateEmployee(Employee employee){
        employeeService.modifyEmployee(employee);
        return "redirect:middle";
    }
    @RequestMapping("lookDepts")
    public String lookDepts(Model model){
        List<Dept> depts= employeeService.lookDepts();
        model.addAttribute("depts",depts);
        return "employee/dept";
    }
    @RequestMapping("findJobsByDeptName")
    public String findJobsByDeptName(String deptName,Model model){
        Dept dept=employeeService.findDeptByName(deptName);
        List<Job> jobs=employeeService.findJobsByDeptId(dept.getId());
        model.addAttribute("jobs",jobs);
        //model.addAttribute("deptName",deptName);//域问题
        return "employee/job";
    }
    @RequestMapping("revisePassword")
    public String revisePassword(Integer id,Model model){
        model.addAttribute("id",id);
        return "employee/revisepassword";
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
        return "employee/employee";

    }
    @RequestMapping("backTurn")
    public String backTurn(){
        return "employee/employee";
    }
    @RequestMapping("lookReward")
    public String lookReward(Integer id,Model model){
        Employee employee=employeeService.findEmployeeByUid(id);
        List<RewardPublish> rewardPublishes=rewardPublishService.findRewardPublishByEid(employee.getId());
        model.addAttribute("rewardPublishes",rewardPublishes);
        return "employee/reward";
    }
    @RequestMapping("findRelatedEmployee")
    public  String findRelatedEmployee(String jName,Model model){
        List<Employee> employees=employeeService.findEmployeeByJobName(jName);
        model.addAttribute("employees",employees);
        return "employee/relatedEmployee";

    }
    @RequestMapping(value = "lookDeptTrain" ,produces = {"text/html;charset=utf-8"})
    @ResponseBody
    public String lookDeptTrain(Integer uid){
        Employee employee=employeeService.findEmployeeByUid(uid);
        List<Train> trains=employeeService.findTrainsByDeptName(employee.getDept());
        String jsonTrains= JSONArray.toJSONString(trains);
        System.out.println(jsonTrains);
        return jsonTrains;
    }
    @RequestMapping("lookMyChecks")
    public String lookMyChecks(Integer id,Model model){
        Employee employee=employeeService.findEmployeeByUid(id);
        Integer eid=employee.getId();
        model.addAttribute("eid",eid);
        return "employee/myCheck";
    }
    @RequestMapping(value = "lookCheckByTime" ,produces = {"text/html;charset=utf-8"})
    @ResponseBody
    public String lookCheckByTime(String time,Integer eid){
        String[] arr=time.split("-");
        int i=Integer.parseInt(arr[0]);
        int k=Integer.parseInt(arr[1]);
        List<Check> checks=employeeService.findChecksByYearAndMonthAndEid(i,k,eid);
        String jsonChecks= JSONArray.toJSONString(checks);
        return jsonChecks;
    }
    @RequestMapping("lookMySalary")
    public String lookMySalary(Integer id,Model model){
        Employee employee=employeeService.findEmployeeByUid(id);
        Integer eid=employee.getId();
        model.addAttribute("eid",eid);
        //return "employee/mySalary";
        return "employee/mySalary1";

    }
    /*@RequestMapping(value = "lookSalaryByTime",produces = {"text/html;charset=utf-8"})
    @ResponseBody
    public String lookSalaryByTime(String time,Integer eid){
        String[] arr=time.split("-");
        int year=Integer.parseInt(arr[0]);
        int month=Integer.parseInt(arr[1]);
        Salary salary=employeeService.findSalariesByTime(year,month,eid);
        String jsonSalary= JSONArray.toJSONString(salary);
        System.out.println(jsonSalary+"lalalalaalal");
        return jsonSalary;
    }*/
    @RequestMapping("lookSalaryByTime")
    public String lookSalaryByTime(String time,Integer eid,Model model){
        String[] arr=time.split("-");
        int year=Integer.parseInt(arr[0]);
        int month=Integer.parseInt(arr[1]);
        Salary salary=employeeService.findSalariesByTime(year,month,eid);
        model.addAttribute("salary",salary);
        return "employee/personSalary";
    }
    @RequestMapping("AddArgument")
    public String AddArgument(Argument argument){
        System.out.println(argument);
        employeeService.addArgument(argument);
        return "redirect:backTurn";

    }
    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request){
        DateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        binder.registerCustomEditor(Date.class,new CustomDateEditor(dateFormat,true));
    }
}
