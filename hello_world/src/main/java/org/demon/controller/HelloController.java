package org.demon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {

    /**
     * params 指定必要的请求参数，也可指定请求参数的值
     * header 指定必须包含的请求头
     * method 指定响应的请求方式
     * @return
     */
    @RequestMapping(value = "/hello", method = RequestMethod.GET,params = {"username=demon"}, headers = {"Accept"})
    public String sayHello(){
        System.out.println("Hello SpringMVC");
        return "success";
    }
}
