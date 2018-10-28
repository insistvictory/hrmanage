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
        System.out.println(apid);
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
    public String interviewAdd(Interview interview){
        interview.setReadStatus("δ�鿴");
        interview.setHire("δ¼��");
        adminService.addInterview(interview);
        return "redirect:lookApplications";
    }

    /**
     * ��תվ
     * @return
     */
    @RequestMapping("middle")
    public String middle(){
        return "admin/admin";
    }

    /**
     * �鿴���в���
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
     * ɾ������
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
     * �鿴��������
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
     * ɾ��ӦƸ��Ϣ
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
     * ��ѯ��Ӧ�����µ�ְλ
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
     * ɾ��ְλ
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
     * �޸�ְλ
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
     * ���ְλ��תվ
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
     * ���ְλ
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
     * ��Ӳ���
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
     * ����Ա��
     * @param id
     * @return
     */
    @RequestMapping("fireEmployee")
    @ResponseBody
    public String fireEmployeeById(Integer id){
        Employee employee = adminService.findEmployeeById(id);
        employee.setNowStatus("��ְ");
        adminService.updateEmployee(employee);
        return "ok";
    }

    /**
     * ���µ���ҳ����ת
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
     * ���µ���
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
     * �鿴��ѵ
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
     * �鿴��ѵϸ��
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
     * ����
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
        string="�Ѳ鿴";
        List<Interview> interviews=adminService.findAllInterviewsByReadStatus(string);
        model.addAttribute("interviews",interviews);
        return "admin/interviews";

    }
    @RequestMapping("searchDetail")
    public String searchDetail(Integer aid,Integer iid,Model model){
        Application application=applicationService.findApplicationById(aid);
        application.setInterviewStatus("������");
        applicationService.updateApplication(application);
        Resume resume=resumeService.findResumeById(application.getResumeId());
        model.addAttribute("resume",resume);
        model.addAttribute("iid",iid);
        return "admin/interviewDetail";
    }


    /**
     * ¼��
     * @param employee
     * @param iid
     * @param model
     * @return
     */
    @RequestMapping("hireUser")
    public String hireUser(Employee employee,Integer iid,Model model){
        System.out.println(iid);
        Interview interview=interviewService.findInterviewById(iid);
        interview.setHire("¼��");
        interviewService.modifyInterview(interview);
        userService.updateType(2,employee.getUid());
        employee.setEntryTime(new Date());
        employee.setNowStatus("��ְ");
        adminService.addEmployee(employee);
        return "redirect:lookInterviews";
    }
    @RequestMapping("findChecks")
    public String lookMyChecks(Integer id,Model model){
        model.addAttribute("eid",id);
        return "admin/personCheck";
    }

    /**
     * �鿴Ա������
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
     *�鿴����
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
     * ������
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
        int count=0;//�򿨴���������������
        Double reward=0.0;//���ͽ��
        //�˴��ж�һ���Ƿ��Ѿ���������
        Salary salary1=adminService.findPersonSalaryByEidAndTime(year,month,eid);
        if (salary1!=null){
            return "re";//�Ѿ�������
        }
        if (date<25){//���Ƿ񵽷������գ��Ƿ���Է�����
            return "no";
        }else {
            if(month-1>0){//����һ�·�
                List<Check>checkList=adminService.findPersonChecksByTime(year,month,eid);//����25��֮ǰ�Ĵ�
                for (Check c:checkList) {
                    if (c.getDay()<25){
                        count++;
                    }
                }
                List<Check> checkList1=adminService.findPersonChecksByTime(year,month-1,eid);
                // �ϸ���25���Ժ�Ĵ�
                for (Check c:checkList1) {
                    if (c.getDay()>=25){
                        count++;
                    }
                }
                salary.setBaseSalary(count*100.0);//���������ѵ�
                //��ʼ�㽱�͹���
                List<RewardPublish> rewardPublishes=adminService.findAllRewardAndPublishByEid(eid);
                for (RewardPublish r:rewardPublishes) {
                    String[] str=MyUtil.transferTime(r.getRpTime());
                    int num=Integer.parseInt(str[0]);
                    int num1=Integer.parseInt(str[1]);
                    int num2=Integer.parseInt(str[2]);
                    if (num==year&&num1==month&&num2<25){//����25��֮ǰ�Ľ���
                        reward+=r.getMoney();
                    }
                    if(num==year&&num1==(month-1)&&num2>=25){//�ϸ���25���Ժ�Ľ���
                        reward+=r.getMoney();
                    }
                }
                salary.setRewardSalary(reward);//���͹��ʻ��
                //��ʼ���ϸ��µ����鹤��
                String str="ͬ��";
                ArgSalary argSalary=adminService.findArgSalaryByEidAndTimeAndAgreeStatus(eid,year,month-1,str);
                if (argSalary==null){
                    salary.setArgSalary(0.0);
                }else{
                    salary.setArgSalary(argSalary.getAsalry());//���鹤�ʻ��
                }
                salary.setSociety(-200.0);//�籣�̶�-200
                // ����ʵ������Ը����������õ�Ǯ�Ƿ���200�������Ƿ�����籣��Ŀǰ���ݶ��������������籣��
                Double sum=salary.getArgSalary()+salary.getBaseSalary()+salary.getRewardSalary()+salary.getSociety();
                salary.setSumSalary(sum);
                adminService.addSalary(salary);
                return "ok";
            }else{//������һ�·�
                List<Check>checkList=adminService.findPersonChecksByTime(year,month,eid);//����25��֮ǰ�Ĵ�
                for (Check c:checkList) {
                    if (c.getDay()<25){
                        count++;
                    }
                }
                List<Check> checkList1=adminService.findPersonChecksByTime(year-1,12,eid);
                // �ϸ���25���Ժ�Ĵ�
                for (Check c:checkList1) {
                    if (c.getDay()>=25){
                        count++;
                    }
                }
                salary.setBaseSalary(count*100.0);//���������ѵ�
                //��ʼ�㽱�͹���
                List<RewardPublish> rewardPublishes=adminService.findAllRewardAndPublishByEid(eid);
                //����null����
                for (RewardPublish r:rewardPublishes) {
                    String[] str=MyUtil.transferTime(r.getRpTime());
                    int num=Integer.parseInt(str[0]);
                    int num1=Integer.parseInt(str[1]);
                    int num2=Integer.parseInt(str[2]);
                    if (num==year&&num1==month&&num2<25){//����25��֮ǰ�Ľ���
                        reward+=r.getMoney();
                    }
                    if(num==year-1&&num1==12&&num2>=25){//�ϸ���25���Ժ�Ľ���
                        reward+=r.getMoney();
                    }
                }
                salary.setRewardSalary(reward);//���͹��ʻ��
                //��ʼ���ϸ��µ����鹤��
                String str="ͬ��";
                ArgSalary argSalary=adminService.findArgSalaryByEidAndTimeAndAgreeStatus(eid,year-1,12,str);
                if (argSalary==null){
                    salary.setArgSalary(0.0);
                }else{
                    salary.setArgSalary(argSalary.getAsalry());//���鹤�ʻ��
                }
                salary.setSociety(-200.0);//�籣�̶�-200
                // ����ʵ������Ը����������õ�Ǯ�Ƿ���200�������Ƿ�����籣��Ŀǰ���ݶ��������������籣��
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
     * нˮ�鿴
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
        if ("¼��".equals(string)){
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
        ArgSalary argSalary1=adminService.findArgSalaryByEidAndTimeAndAgreeStatus(salary.getEid(),salary.getYear(),salary.getMonth(),"ͬ��");
        if (argSalary1!=null){
            return "no";
        }else {
            argSalary.setAgreeStatus("ͬ��");
            argSalary.setEid(salary.getEid());
            argSalary.setMonth(salary.getMonth());
            argSalary.setYear(salary.getYear());
            adminService.addArgSalary(argSalary);
            return "ok";

        }
    }
    /**
     * ʱ���ʽ����
     * @param binder
     * @param request
     */
    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request){
        DateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class,new CustomDateEditor(dateFormat,true));
    }

}
