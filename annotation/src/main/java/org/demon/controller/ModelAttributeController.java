package org.demon.controller;

import org.demon.dao.BookDao;
import org.demon.domain.Book;
import org.demon.utils.MybatisUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.Map;

@Controller
public class ModelAttributeController {

    private BookDao bookDao;

    public ModelAttributeController() throws IOException {
        bookDao = MybatisUtil.getSession().getMapper(BookDao.class);
    }

    /**
     * 在执行该控制器方法之前，book的值是数据库查出来的数据
     * 执行该方法后，用前端表单数据更新 book
     */
    @RequestMapping(value = "/testModelAttribute", method = RequestMethod.POST)
    public String testModelAttribute(Book book){
        System.out.println("ModelAttribute 方法有返回值");
        System.out.println(book);
        return "success";
    }

    /**
     * 带返回值的方法：
     *      1. 在表单得到 bId后，去数据查询数据；
     *      2. 将数据封装后返回。
     */
    @ModelAttribute
    public Book getBook(int bId){
        Book book = bookDao.findById(bId);
        return book;
    }

    /**
     * 由于前置方法没有返回值，需要去方法的 map 中取出想要的数据。
     * 注解的参数就是指定的是 map 的 key 值。
     */
    @RequestMapping(value = "/testModelAttribute2", method = RequestMethod.POST)
    public String testModelAttribute2(@ModelAttribute("book2") Book book)
    {
        System.out.println("ModelAttribute 方法无返回值");
        System.out.println(book);
        return "success";
    }

    /**
     * 如果方法没有返回值，则必须在参数中加入 Map，以便后续方法使用 key 值将查询出来的数据取出
     */
    @ModelAttribute
    public void getBook2(int bId, Map<String, Book> map){
        // 模拟数据库查询
        Book book = bookDao.findById(bId);
        map.put("book2", book);
    }
}
