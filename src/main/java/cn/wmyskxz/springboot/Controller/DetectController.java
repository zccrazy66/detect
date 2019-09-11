package cn.wmyskxz.springboot.Controller;


import cn.wmyskxz.springboot.Service.FlaskService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static com.alibaba.fastjson.JSON.parseObject;
import static com.alibaba.fastjson.JSON.toJSON;

@Controller
public class DetectController {

    @Autowired
    FlaskService flaskService;

    @RequestMapping("/detect_get")
    @ResponseBody
    public Object detect(){
        return flaskService.call_flask();
    }

    @PostMapping("/detect_post")
    @ResponseBody
    public Object detect_post(@RequestBody JSONObject params){
        String UPLOADED_FLODER = "/home/xx15203/web/picture/";
        String url = params.getString("url");
        int threshold_L = params.getIntValue("threshold_L");
        System.out.println("threshold_L is that" + threshold_L);

        int reative = url.lastIndexOf("/") + 1;
        String url_post = UPLOADED_FLODER + url.substring(reative);
//        System.out.println("post_url =" + url_post);
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("filepath", url_post);
        map.put("threshold_L", threshold_L);
        //String str = JSON.toJSONString(map);
        Map rlt = flaskService.post_flask(map);
//        System.out.println("rlt from service is " + rlt);
//      System.out.println(map.get("rlt_path"));
        return rlt;
    }





}
