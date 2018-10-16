package com.xux.ssm.handler;

import com.xux.ssm.entity.Resume;
import com.xux.ssm.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Administrator on 2018/10/14.
 */
@RequestMapping("admin")
@Controller
public class AdminHandler {
    @Autowired
    private AdminService adminService;
    @RequestMapping("searchDelivererDetailByDid")
    public String searchEmployeeDetailByEdid(Integer did,Model model) {
        Resume resume=adminService.searchDelivererDetailByDid(did);
        model.addAttribute("resume",resume);
        return "admin/eee";
    }
}
