package org.demon.controller;

import org.demon.domain.Account;
import org.demon.domain.Child;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Controller
public class ParamsController {

    @RequestMapping("/testSimple")
    public String testSimple(String username, String password){
        System.out.println("用户名：" + username);
        System.out.println("密码： " + password);
        return "success";
    }

    @RequestMapping("/saveAccount")
    public String saveAccount(Account account){
        System.out.println(account);
        return "success";
    }

    @RequestMapping("/saveChild")
    public String saveChild(Child child){
        System.out.println(child);
        return "success";
    }

    @RequestMapping("/getAPI")
    public String getAPI(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        System.out.println(session);
        System.out.println(response);
        return "success";
    }
}
