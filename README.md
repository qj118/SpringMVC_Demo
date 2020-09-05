## 简介

SpringMVC 边学边敲 [教学视频](https://www.bilibili.com/video/BV1mE411X7yp?p=159)

## 模块

### hello-world

包含以下几个点：
1. SpringMVC 工程的创建；
2. @RequestMapping 参数的简单使用。

### params

包含以下几个点：
1. 请求参数的获取，包括：简单参数，实体类参数，集合类参数；
2. POST 请求中文乱码问题解决；
3. 自定义类型转换器的编码与配置；
4. Servlet 原生 API 获取。

### annotation

包含以下注解的使用：
- @RequestMapping
- @RequestParam
- @RequestBody
- @RequestBody
- @PathVariable
- @RequestHeader
- @CookieValue
- @ModelAttribute
- @SessionAttributes

### response

包含以下几个要点：
1. controller 可以方法以 String，void，ModelAndView 为返回值；
2. 转发与重定向关键字；
3. @ResponseBody 响应 json 数据；
4. ajax 异步请求的处理。

### fileupload

以以下三种方式实现文件上传：
1. 传统方式；
2. SpringMVC方式，即提供文件解析器；
3. 跨服务器上传文件。

### images-server

模拟跨服务器上传文件的另一个服务器上运行的空 module。

### exception

自定义异常处理器。

### interceptor

自定义 springmvc 拦截器。