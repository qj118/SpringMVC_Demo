package org.demon.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        e.printStackTrace();
        MyException myException;
        /**
         * 抛出的是 MyException 则显示抛出的信息；
         *          如果不是，则抛出定制好的信息。
         */
        if(e instanceof MyException){
            myException = (MyException) e;
        }else{
            myException = new MyException("我抛出了一个异常，哈哈哈哈");
        }
        // 返回定制页面及定制信息
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", myException.getMessage());
        mv.setViewName("error");

        return mv;
    }
}
