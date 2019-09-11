package cn.wmyskxz.springboot.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

//上传图片
@Controller
public class UploadController {
    private static String UPLOADED_FLODER = "/home/xx15203/web/picture/";
    @PostMapping("/upload")
    @ResponseBody
    public Object singleFileUpload(@RequestParam("file") MultipartFile file) {
        System.out.println("ori name is " + file.getOriginalFilename());

        Map<String, Object> map = new HashMap<>();
        if (file.isEmpty()) {
            map.put("success", false);
            map.put("message", "failed");
        }
        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FLODER + file.getOriginalFilename());
//          System.out.println("path is " + path);
            Files.write(path, bytes);

        } catch (IOException e) {
            e.printStackTrace();
        }
        map.put("success", true);
        map.put("message", "upload ok...");
        map.put("fileName", file.getOriginalFilename());
        map.put("filepath", UPLOADED_FLODER+file.getOriginalFilename());
        return map;
    }
}
