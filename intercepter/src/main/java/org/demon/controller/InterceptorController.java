package org.demon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InterceptorController {

    private final String SUCCESS = "success";

    @RequestMapping("/testInterceptor")
    public String testInterceptor(){
        System.out.println("controller 方法执行 ...");
        return SUCCESS;
    }
}
