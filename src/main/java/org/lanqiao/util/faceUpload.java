package org.lanqiao.util;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;


public class faceUpload {
    public String upload(HttpServletRequest request, MultipartFile file) throws Exception {
        //如果文件不为空，写入上传路径
        if (!file.isEmpty()) {
            //上传文件路径
            String serverPath = System.getProperty("user.dir")+"/src/main/resources/static/images/shop";
            //上传文件名
            System.out.println(serverPath);
            String filename = file.getOriginalFilename();
            filename = new SimpleDateFormat("yyyy-MM-dd").format(System.currentTimeMillis()) + filename;
            File serverFile = new File(serverPath, filename);
            //判断路径是否存在，如果不存在就创建一个
            if (!serverFile.getParentFile().exists()) {
                serverFile.getParentFile().mkdirs();
            }
            //将上传文件保存到项目工作目录当中
            file.transferTo(new File(serverPath + File.separator + filename));

            return filename;
        }
        return null;
    }
}