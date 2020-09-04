package org.demon.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
public class UploadFileController {

    private final String SUCCESS = "success";

    @RequestMapping(value = "/fileuploadTraditional", method = RequestMethod.POST)
    public String uploadTraditional(HttpServletRequest request) throws Exception {
        System.out.println("文件上传 ...");

        // 上传位置，路径为项目部署的位置的路径
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        File file = new File(path);
        if(!file.exists()){
            file.mkdirs();
        }

        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);

        // 解析 request
        List<FileItem> items = upload.parseRequest(request);
        for (FileItem item : items) {
            // 当前 item 对象是否是上传文件项
            if(item.isFormField()){
                // 普通表单项，不做任何处理
            }else{
                // 获取文件名
                String filename = item.getName();
                // 生成唯一值
                String uuid = UUID.randomUUID().toString().replace("-", "");
                filename = uuid + "_" + filename;
                // 完成文件上传
                item.write(new File(path, filename));
                // 删除临时文件
                item.delete();
            }
        }

        return SUCCESS;
    }

    // upload 对象从配置文件中的文件解析其中直接拿到，参数名要与form表单中文件表单项的 name 保持一致
    @RequestMapping("/fileupload")
    public String fileUpload(HttpServletRequest request, MultipartFile upload) throws IOException {
        System.out.println("springmvc 文件上传 ...");

        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        File file = new File(path);
        if(!file.exists()){
            file.mkdirs();
        }

        // 获取文件名
        String filename = upload.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + "_" + filename;
        // 上传文件
        upload.transferTo(new File(path, filename));

        return SUCCESS;
    }

    @RequestMapping("/fileupload2Server")
    public String fileUploadToServer(MultipartFile upload) throws IOException {
        System.out.println("跨服务器文件上传 ...");

        // 上传的服务器路径
        String path = "http://localhost:9090/images_server_war/uploads/";

        // 获取文件名
        String filename = upload.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + "_" + filename;

        // 创建客户端对象
        Client client = Client.create();
        // 连接上传服务器
        WebResource webResource = client.resource(path + filename);
        webResource.put(upload.getBytes());

        return SUCCESS;
    }
}
