package org.demon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController {

    private final String SUCCESS = "success";

    @RequestMapping("/throwException")
    public String throwException() throws Exception {
        try{
            int temp = 10/0;
        }catch(Exception e){
            e.printStackTrace();
            //throw new MyException("Controller 抛出异常！");
            throw new Exception("这是一个异常");
        }

        return SUCCESS;
    }
}
