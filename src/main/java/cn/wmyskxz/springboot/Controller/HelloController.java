package cn.wmyskxz.springboot.Controller;

import cn.wmyskxz.springboot.DAO.EmployeeMapper;
import cn.wmyskxz.springboot.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


//跳转页面
@Controller
public class HelloController {

    @Autowired
    EmployeeMapper employeeMapper;


    @RequestMapping("/test")
    public String test() {
//        System.out.println("it is a test project");
        return "test";
    }

    @RequestMapping("/electric")
    public String electric() {
        return "electric";
    }

    @RequestMapping("/hotmelt")
    public String hot() {
        return "hotmelt";
    }

    @RequestMapping("/picture")
    public String pic() {
        return "picture";
    }

    @RequestMapping("/worklog")
    public String worklog() {
        return "worklog";
    }

    @RequestMapping("/person")
    public String per(Model model) {
        List<Employee> emps = employeeMapper.getAll();
       // System.out.println(emps);
        model.addAttribute("emps",emps);
        return "person";
    }



    @GetMapping("/test9")
    @ResponseBody
    public Object test9(){
        return "test";
    }



    @RequestMapping("/notRole")
    public String notRole(){
        return "notRole";
    }


    @RequestMapping("/login")
    public String test2() {
       // model.addAttribute("zc","");
        return "login";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }


    @GetMapping("/test999")
    @ResponseBody
    public Object testShiro() {
        System.out.println("into test...");
        return "test";
    }



}




