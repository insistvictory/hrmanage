package com.xux.ssm.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Administrator on 2018/10/18.
 */
@RequestMapping("employee")
@Controller
public class EmployeeHandler {
    @RequestMapping("working")
    public String working(){
        Date date=new Date();
        Calendar calendar=Calendar.getInstance();

    return null;
    }
}
