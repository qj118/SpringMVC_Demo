package org.demon.controller;

import org.demon.domain.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class ResponseController {

    private final String SUCCESS = "success";

    @RequestMapping("/getBook")
    public String testReturnString(Model model){
        Book book = new Book();
        // 模拟数据库查询
        book.setBookId(1);
        book.setBookName("大漠谣");
        book.setBookAuthor("桐华");
        // 将查询出来的数据放入 request 域中
        model.addAttribute("book", book);
        return SUCCESS;
    }

    /**
     * 当返回值是 void 时，视图解析器会自动去寻找以请求为文件名的 jsp 文件。
     * 如果本意不是编写新页面，则有以下三种方式：
     * 1. 请求转发
     * 2. 重定向
     * 3. 直接写回页面
     *
     */
    @RequestMapping("/testVoid")
    public void testReturnVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 请求转发：直接转发到要跳转的页面
        // request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request, response);
        // 重定向：发送别的请求跳转页面，或者指定 WEB-INF 文件夹外部的文件
        // response.sendRedirect("getBook");
        // response.sendRedirect("redirect.jsp");
        // 直接将响应结果写入页面
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println("控制器方法返回值类型为 Void");
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testReturnMV(){
        ModelAndView mv = new ModelAndView();

        Book book = new Book();
        book.setBookId(2);
        book.setBookName("思维是平的");
        book.setBookAuthor("Nick·Chater");

        mv.addObject("book", book);
        mv.setViewName("success");

        return mv;
    }

    @RequestMapping("/testForward")
    public String testForward(){
        System.out.println("请求转发 ...");
        return "forward:/WEB-INF/pages/success.jsp";
    }

    @RequestMapping("/testRedirect")
    public String testRedirect(){
        System.out.println("重定向 ...");
        return "redirect:/redirect.jsp";
    }

    @RequestMapping(value = "/testJson", method = RequestMethod.POST)
    public @ResponseBody Book testResponseJson(@RequestBody Book book){
        System.out.println(book);
        // 模拟数据库查询
        Book b = new Book();
        b.setBookId(4);
        b.setBookAuthor("吴军");
        b.setBookName("数学之美");
        return b;
    }
}
