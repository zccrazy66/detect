package cn.wmyskxz.springboot.Service;


import com.alibaba.fastjson.JSON;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


@Service
public class FlaskServiceImpl implements FlaskService {
    @Override
    public Map<String, Object> call_flask() {
            RestTemplate restTemplate = new RestTemplate();
            String str = restTemplate.getForObject("http://127.0.0.1:5000/", String.class);
            System.out.println(str);
            Map<String, Object> map = new HashMap<>();
            map.put("msg",str );
            System.out.println("in service... msg is " +map);
            return map;
        }

    @Override
    public Map<String,String> post_flask(Map param) {

        Map<String, String> map2controller = new LinkedHashMap<String, String>();
//        param.put("1111", "hello");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "application/json; charset=UTF-8");
        HttpEntity<Map<String, String>> requestEntity = new HttpEntity<Map<String, String>>(param, httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> resp = restTemplate.exchange("http://127.0.0.1:5000/",
                                                            HttpMethod.POST,
                                                            requestEntity,
                                                            String.class);

        String body = resp.getBody();
        Map rlt_map = JSON.parseObject(body);
        System.out.println("rlt_map is "+ rlt_map);
//        System.out.println("body is " + body.toString());
        map2controller.put("msg_from_flask", body);

        return rlt_map;
    }

}
