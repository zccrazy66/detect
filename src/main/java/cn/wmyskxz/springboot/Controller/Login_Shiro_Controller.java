package cn.wmyskxz.springboot.Controller;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static org.springframework.boot.Banner.Mode.LOG;

@Controller
public class Login_Shiro_Controller {

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,@RequestParam("password") String password, Model model) {
        //获取Subject
        Subject subject = SecurityUtils.getSubject();
        //封装数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
            return "index";
        } catch (UnknownAccountException e) {
            model.addAttribute("msg", "请输入密码");
            return "login";
        } catch (IncorrectCredentialsException e) {
            model.addAttribute("msg", "密码错误！");
            return "login";
        }
    }

    @RequestMapping(value = "/logout")
    @ResponseBody
    public String logout(){

        Subject subject1 = SecurityUtils.getSubject();

     // 执行注销
        if (subject1.isAuthenticated()) {
        subject1.logout();
      }
    return "您已登出";
    }


    }





