package com.xux.ssm.handler;

import com.alibaba.fastjson.JSONArray;
import com.xux.ssm.entity.*;
import com.xux.ssm.service.*;
import com.xux.ssm.util.MyUtil;
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
import java.util.ArrayList;
import java.util.Calendar;
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
    @Autowired
    private RewardPublishService rewardPublishService;
    @Autowired
    private ResumeService resumeService;
    @Autowired
    private UserService userService;
    @Autowired
    private InterviewService interviewService;
    @Autowired
    private EmployeeService employeeService;

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
        interview.setReadStatus("未查看");
        interview.setHire("未录用");
        adminService.addInterview(interview);
        return "redirect:lookApplications";
    }

    /**
     * 中转站
     * @return
     */
    @RequestMapping("middle")
    public String middle(){
        return "admin/admin";
    }

    /**
     * 查看所有部门
     * @param model
     * @return
     */
    @RequestMapping("lookDepts")
    public String lookDepts(Model model){
        List<Dept> depts= adminService.lookDepts();
        model.addAttribute("depts",depts);
        return "admin/dept";
    }

    /**
     * 删除部门
     * @param name
     * @return
     */
    @RequestMapping("deleteDeptByName")
    @ResponseBody
    public String deleteDeptByName(String name){
        System.out.println(name);
        List<Employee> employees=deptService.searchEmployeeByDeptName(name);
        System.out.println(employees);
        if (employees.size()==0){
            deptService.deleteDeptByName(name);
            return "ok";
        }else {
            return "no";
        }
    }

    /**
     * 查看面试邀请
     * @param applyId
     * @return
     */
    @RequestMapping("findInterviewByApplyId")
    @ResponseBody
    public String findInterviewByApplyId(Integer applyId){

        Interview interview=interviewService.findInterviewByApplyId(applyId);

        if (interview!=null){
            return "ok";
        }
        return "no";
    }

    /**
     * 删除应聘消息
     * @param id
     * @return
     */
    @RequestMapping("deleteApplicationById")
    @ResponseBody
    public String deleteApplicationById(Integer id){
        Interview interview=interviewService.findInterviewByApplyId(id);
        if (interview==null) {
            applicationService.deleteApplicationById(id);
            return "ok";
        }else {
            return "no";
        }
    }

    /**
     * 查询对应部门下的职位
     * @param deptName
     * @param model
     * @return
     */
    @RequestMapping("findJobsByDeptName")
    public String findJobsByDeptName(String deptName,Model model){
        Dept dept=deptService.findDeptByName(deptName);
        List<Job> jobs=adminService.findJobsByDeptId(dept.getId());
        model.addAttribute("jobs",jobs);
        model.addAttribute("deptId",dept.getId());
        return "admin/job";
    }

    /**
     * 删除职位
     * @param name
     * @return
     */
    @RequestMapping("deleteJobByName")
    @ResponseBody
    public String deleteJobByName(String name){
        List<Employee> employees=deptService.searchEmployeeByJobName(name);
        System.out.println(employees);
        if (employees.size()==0){
            adminService.deleteJobByName(name);
            return "ok";
        }else {
            return "no";
        }
    }
    @RequestMapping("lookJobDetail")
    public String lookJobDetail(Integer id,Model model){
        Job job=jobService.findJobById(id);
        model.addAttribute("job",job);
        return "admin/jobDetail";
    }

    /**
     * 修改职位
     * @param id
     * @param name
     * @return
     */
    @RequestMapping("updateJob")
    public String updateJob(Integer id,String name){
        jobService.updateJobByIdAndName(id,name);
        return "redirect:lookDepts";
    }

    /**
     * 添加职位中转站
     * @param model
     * @param deptId
     * @return
     */
    @RequestMapping("addJobMiddle")
    public String addJobMiddle(Model model,Integer deptId){
        model.addAttribute("deptId",deptId);
        return "admin/addjob";
    }

    /**
     * 添加职位
     * @param name
     * @param job
     * @return
     */
    @RequestMapping("findJobByName")
    @ResponseBody
    public String increaseJob(String name,Job job){
        Job job1=jobService.findJobByName(name);
        System.out.println(job);
        if (job1==null){
            job.setCreateTime(new Date());
            System.out.println(job);
            jobService.addJob(job);
            return "ok";
        }else{
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

    /**
     * 添加部门
     * @param name
     * @param dept
     * @return
     */
    @RequestMapping("findDeptByName")
    @ResponseBody
    public String findDeptByName(String name,Dept dept){
        Dept dept1=deptService.findDeptByName(name);
        if (dept1==null){
            dept.setCreateTime(new Date());
            deptService.addDept(dept);
            return "ok";
        }else{
            return "no";
        }
    }
    @RequestMapping("editDept")
    public String editDept(String name,Integer id){
        adminService.updateDeptByNameAndId(name,id);
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
     * 开除员工
     * @param id
     * @return
     */
    @RequestMapping("fireEmployee")
    @ResponseBody
    public String fireEmployeeById(Integer id){
        Employee employee = adminService.findEmployeeById(id);
        employee.setNowStatus("离职");
        adminService.updateEmployee(employee);
        return "ok";
    }

    /**
     * 人事调动页面跳转
     * @return
     */
    @RequestMapping("transferOfPersonnel")
    public String transferOfPersonnel(Integer id,Model model){
        Employee employee=adminService.findEmployeeById(id);
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

    /**
     * 查看培训
     * @param model
     * @return
     */
    @RequestMapping("trainManage")
    public String trainManage(Model model){
        List<Train> trains=adminService.findAllTrains();
        model.addAttribute("trains",trains);
        return "admin/train";
    }

    /**
     * 查看培训细节
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("lookTrainDetail")
    public String lookTrainDetail(Integer id,Model model){
        Train train=adminService.findTrainDetailById(id);
        List<Dept> depts=adminService.lookDepts();
        model.addAttribute("train",train);
        model.addAttribute("depts",depts);
        return "admin/trainDetail";
    }
    @RequestMapping("addTrainMiddle")
    public String addTrainMiddle(Model model){
        List<Dept> depts=adminService.lookDepts();
        model.addAttribute("depts",depts);
        return "admin/addTrain";
    }
    @RequestMapping("addTrain")
    public String addTrain(Train train){
        adminService.addTrain(train);
        return "redirect:trainManage";
    }
    @RequestMapping("updateTrain")
    public String updateTrain(Train train){
        adminService.updateTrain(train);
        return "redirect:trainManage";
    }
    @RequestMapping("deleteTrainById")
    @ResponseBody
    public String deleteTrainById(Integer id){
        adminService.deleteTrainById(id);
        return "ok";
    }

    /**
     * 奖惩
     * @param rewardPublish
     * @return
     */
    @RequestMapping("reward")
    @ResponseBody
    public String addReward(RewardPublish rewardPublish){
        System.out.println(rewardPublish);
        rewardPublishService.addRewardPublish(rewardPublish);
        return "yes";
    }
    @RequestMapping("lookInterviews")
    public String lookInterviews(String string,Model model){
        string="已查看";
        List<Interview> interviews=adminService.findAllInterviewsByReadStatus(string);
        model.addAttribute("interviews",interviews);
        return "admin/interviews";

    }
    @RequestMapping("searchDetail")
    public String searchDetail(Integer aid,Integer iid,Model model){
        Application application=applicationService.findApplicationById(aid);
        application.setInterviewStatus("已面试");
        applicationService.updateApplication(application);
        Resume resume=resumeService.findResumeById(application.getResumeId());
        model.addAttribute("resume",resume);
        model.addAttribute("iid",iid);
        return "admin/interviewDetail";
    }


    /**
     * 录用
     * @param employee
     * @param iid
     * @param model
     * @return
     */
    @RequestMapping("hireUser")
    public String hireUser(Employee employee,Integer iid,Model model){
        System.out.println(iid);
        Interview interview=interviewService.findInterviewById(iid);
        interview.setHire("录用");
        interviewService.modifyInterview(interview);
        userService.updateType(2,employee.getUid());
        employee.setEntryTime(new Date());
        employee.setNowStatus("在职");
        adminService.addEmployee(employee);
        return "redirect:lookInterviews";
    }
    @RequestMapping("findChecks")
    public String lookMyChecks(Integer id,Model model){
        model.addAttribute("eid",id);
        return "admin/personCheck";
    }

    /**
     * 查看员工考勤
     * @param time
     * @param eid
     * @return
     */
    @RequestMapping(value = "lookPersonalCheckByTime" ,produces = {"text/html;charset=utf-8"})
    @ResponseBody
    public String lookCheckByTime(String time,Integer eid){
        String[] arr=time.split("-");
        int i=Integer.parseInt(arr[0]);
        int k=Integer.parseInt(arr[1]);
        List<Check> checks=employeeService.findChecksByYearAndMonthAndEid(i,k,eid);
        String jsonChecks= JSONArray.toJSONString(checks);
        return jsonChecks;
    }

    /**
     *查看奖惩
     * @param time
     * @return
     */
    @RequestMapping(value = "lookRewardAndPublishByTime" ,produces = {"text/html;charset=utf-8"})
    @ResponseBody
    public String lookRewardAndPublishByTime(String time){
        String[] arr=time.split("-");
        int i=Integer.parseInt(arr[0]);
        int k=Integer.parseInt(arr[1]);
        List<RewardPublish> rewardPublishes=adminService.findAllRewardAndPublish();
        List<RewardPublish> list=new ArrayList<RewardPublish>();
        for (RewardPublish r:rewardPublishes) {
            String[] str=MyUtil.transferTime(r.getRpTime());
            int num=Integer.parseInt(str[0]);
            int num1=Integer.parseInt(str[1]);
            if (num==i&&num1==k){
                list.add(r);
            }
        }
        String jsonReward= JSONArray.toJSONString(list);
        return jsonReward;
    }

    /**
     * 发工资
     * @param eid
     * @param salary
     * @return
     */
    @RequestMapping("deliverSalary")
    @ResponseBody
    public String deliverSalary(Integer eid,Salary salary){
        Calendar calendar= Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH)+1;
        int date = calendar.get(Calendar.DATE);
        salary.setYear(year);
        salary.setMonth(month);
        int count=0;//打卡次数间接算基本工资
        Double reward=0.0;//奖惩金额
        //此处判断一下是否已经过工资了
        Salary salary1=adminService.findPersonSalaryByEidAndTime(year,month,eid);
        if (salary1!=null){
            return "re";//已经发过了
        }
        if (date<25){//看是否到发工资日，是否可以发工资
            return "no";
        }else {
            if(month-1>0){//不是一月份
                List<Check>checkList=adminService.findPersonChecksByTime(year,month,eid);//当月25号之前的打卡
                for (Check c:checkList) {
                    if (c.getDay()<25){
                        count++;
                    }
                }
                List<Check> checkList1=adminService.findPersonChecksByTime(year,month-1,eid);
                // 上个月25后以后的打卡
                for (Check c:checkList1) {
                    if (c.getDay()>=25){
                        count++;
                    }
                }
                salary.setBaseSalary(count*100.0);//基本工资已得
                //开始算奖惩工资
                List<RewardPublish> rewardPublishes=adminService.findAllRewardAndPublishByEid(eid);
                for (RewardPublish r:rewardPublishes) {
                    String[] str=MyUtil.transferTime(r.getRpTime());
                    int num=Integer.parseInt(str[0]);
                    int num1=Integer.parseInt(str[1]);
                    int num2=Integer.parseInt(str[2]);
                    if (num==year&&num1==month&&num2<25){//当月25号之前的奖惩
                        reward+=r.getMoney();
                    }
                    if(num==year&&num1==(month-1)&&num2>=25){//上个月25号以后的奖惩
                        reward+=r.getMoney();
                    }
                }
                salary.setRewardSalary(reward);//奖惩工资获得
                //开始算上个月的异议工资
                String str="同意";
                ArgSalary argSalary=adminService.findArgSalaryByEidAndTimeAndAgreeStatus(eid,year,month-1,str);
                if (argSalary==null){
                    salary.setArgSalary(0.0);
                }else{
                    salary.setArgSalary(argSalary.getAsalry());//异议工资获得
                }
                salary.setSociety(-200.0);//社保固定-200
                // （其实这里可以更具其他所得的钱是否足200来决定是否给交社保，目前我暂定无论怎样都交社保）
                Double sum=salary.getArgSalary()+salary.getBaseSalary()+salary.getRewardSalary()+salary.getSociety();
                salary.setSumSalary(sum);
                adminService.addSalary(salary);
                return "ok";
            }else{//本月是一月份
                List<Check>checkList=adminService.findPersonChecksByTime(year,month,eid);//当月25号之前的打卡
                for (Check c:checkList) {
                    if (c.getDay()<25){
                        count++;
                    }
                }
                List<Check> checkList1=adminService.findPersonChecksByTime(year-1,12,eid);
                // 上个月25后以后的打卡
                for (Check c:checkList1) {
                    if (c.getDay()>=25){
                        count++;
                    }
                }
                salary.setBaseSalary(count*100.0);//基本工资已得
                //开始算奖惩工资
                List<RewardPublish> rewardPublishes=adminService.findAllRewardAndPublishByEid(eid);
                //考虑null？？
                for (RewardPublish r:rewardPublishes) {
                    String[] str=MyUtil.transferTime(r.getRpTime());
                    int num=Integer.parseInt(str[0]);
                    int num1=Integer.parseInt(str[1]);
                    int num2=Integer.parseInt(str[2]);
                    if (num==year&&num1==month&&num2<25){//当月25号之前的奖惩
                        reward+=r.getMoney();
                    }
                    if(num==year-1&&num1==12&&num2>=25){//上个月25号以后的奖惩
                        reward+=r.getMoney();
                    }
                }
                salary.setRewardSalary(reward);//奖惩工资获得
                //开始算上个月的异议工资
                String str="同意";
                ArgSalary argSalary=adminService.findArgSalaryByEidAndTimeAndAgreeStatus(eid,year-1,12,str);
                if (argSalary==null){
                    salary.setArgSalary(0.0);
                }else{
                    salary.setArgSalary(argSalary.getAsalry());//异议工资获得
                }
                salary.setSociety(-200.0);//社保固定-200
                // （其实这里可以更具其他所得的钱是否足200来决定是否给交社保，目前我暂定无论怎样都交社保）
                Double sum=salary.getArgSalary()+salary.getBaseSalary()+salary.getRewardSalary()+salary.getSociety();
                salary.setSumSalary(sum);
                adminService.addSalary(salary);
                return "ok";
            }
        }
    }
    @RequestMapping("lookAllSalaryMid")
    public String lookAllSalaryMid(){
        return "admin/salary";
    }

    /**
     * 薪水查看
     * @param time
     * @return
     */
    @RequestMapping(value = "lookSalaryByTime",produces = {"text/html;charset=utf-8"})
    @ResponseBody
    public String lookSalaryByTime(String time){
        String[] arr=time.split("-");
        int i=Integer.parseInt(arr[0]);
        int k=Integer.parseInt(arr[1]);
        List<Salary> salaries=adminService.findSalariesByTime(i,k);
        String jsonSalaries= JSONArray.toJSONString(salaries);
        return jsonSalaries;
    }
    @RequestMapping("searchRelatedInterview")
    @ResponseBody
    public String searchRelatedInterview(Integer iid){
        Interview interview= interviewService.findInterviewById(iid);
        String string=interview.getHire();
        if ("录用".equals(string)){
            return "ok";
        }else {
            return "no";
        }
    }
    @RequestMapping("lookAllArguments")
    public String lookAllArguments(Model model){
        List<Argument> arguments=adminService.findAllArguments();
        model.addAttribute("arguments",arguments);
        return "admin/argument";
    }
    @RequestMapping("serachSalary")
    public String serachSalary(Integer id ,Model model){
        Salary salary=adminService.findSalaryById(id);
        model.addAttribute("salary",salary);
        System.out.println(salary);
        return "admin/uniqueSalary";
    }
    @RequestMapping("addArgSalary")
    @ResponseBody
    public String addArgSalary(ArgSalary argSalary,Integer sid){
        Salary salary=adminService.findSalaryById(sid);
        ArgSalary argSalary1=adminService.findArgSalaryByEidAndTimeAndAgreeStatus(salary.getEid(),salary.getYear(),salary.getMonth(),"同意");
        if (argSalary1!=null){
            return "no";
        }else {
            argSalary.setAgreeStatus("同意");
            argSalary.setEid(salary.getEid());
            argSalary.setMonth(salary.getMonth());
            argSalary.setYear(salary.getYear());
            adminService.addArgSalary(argSalary);
            return "ok";

        }
    }
    /**
     * 时间格式处理
     * @param binder
     * @param request
     */
    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request){
        DateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class,new CustomDateEditor(dateFormat,true));
    }

}
