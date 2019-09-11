package cn.wmyskxz.springboot.Service;


import org.springframework.stereotype.Service;

import java.util.Map;


public interface FlaskService {

     Map call_flask();
//     public post_flask(String);


     Map<String,String> post_flask(Map param);
}
