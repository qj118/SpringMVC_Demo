package org.demon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
/**
 * 将request域中的 msg 写入 session 中
 */
@SessionAttributes({"msg"})
public class SessionAttributeController {

    private final String SUCCESS = "success";

    @RequestMapping("/testPut")
    public String testPut(Model model){
        /**
         * 将 msg 写入 request 域中
         */
        model.addAttribute("msg", "这是一条重要信息");
        System.out.println("存入 msg " + model.getAttribute("msg"));
        return SUCCESS;
    }

    @RequestMapping("/testGet")
    public String testGet(ModelMap modelMap){
        System.out.println("获取 msg " + modelMap.get("msg"));
        return SUCCESS;
    }

    @RequestMapping("/testClean")
    public String testClean(SessionStatus sessionStatus){
        // 结束 session，无法在获取 msg
        sessionStatus.setComplete();
        System.out.println("结束会话");
        return SUCCESS;
    }
}
