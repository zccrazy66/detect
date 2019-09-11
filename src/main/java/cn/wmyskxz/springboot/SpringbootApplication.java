package cn.wmyskxz.springboot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

//
//    @Bean
//    public MultipartConfigElement multipartConfigElement() {         //设置文件上传大小
//        MultipartConfigFactory factory = new MultipartConfigFactory();
//        factory.setMaxFileSize("30MB");
//        factory.setMaxRequestSize("30MB");
//        return factory.createMultipartConfig();
//
//    }

}



