package cn.wmyskxz.springboot.Controller;


import cn.wmyskxz.springboot.Service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



//@Controller
@RequestMapping("/testfunction")
public class Upload_Folder_Controller {


    @Autowired
    UploadService uploadService;


    @RequestMapping("/upload_folder")
    @ResponseBody
    public Object upload_folder_controller(@RequestParam("file") List<MultipartFile> files) throws IOException {
        System.out.println("********");
        for (MultipartFile file : files) {

            int last_name = file.getOriginalFilename().lastIndexOf("/") + 1;
            String pic_path = file.getOriginalFilename().substring(last_name);              //文件名(图片)
            int folder_name = file.getOriginalFilename().indexOf("/");
            String folder_path = file.getOriginalFilename().substring(0,folder_name);       //文件夹名

            uploadService.mkDirectory("G:/test/"+folder_path);

            file.transferTo(new File("G:/test/"+ folder_path + "/" + pic_path));  //存图片

//            System.out.println(file.getOriginalFilename());                         //test
        }
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "success");
        return map;
    }
}
