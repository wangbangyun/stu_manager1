package com.qf.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.entity.Class;
import com.qf.entity.Student;
import com.qf.seivice.IClassService;
import com.qf.seivice.IStuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.List;

@Controller
@RequestMapping("/stu")
public class StuController {
    @Reference
    private IClassService classService;
    @Reference
    private IStuService stuService;
    @RequestMapping("/toadd")
    public String addStu(Model model){
        List<Class> classList = classService.queryAllClass();
        model.addAttribute("clist",classList);
        return "stuinsert";
    }
    @RequestMapping("/insert")
    public String insertStu(Student student){
        int result = stuService.inserStu(student);
        if (result>0){
            return "success";
        }
        return "error";
    }
    @RequestMapping("/query")
    public  String queryStu(Model model){
        List<Student> stulist = stuService.queryAllStu();
        System.out.println(stulist.get(0).getName()+"---------");
        model.addAttribute("stulist",stulist);
        return "slist";
    }
}
