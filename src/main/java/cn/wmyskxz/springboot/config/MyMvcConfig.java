package cn.wmyskxz.springboot.config;



import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;



@Configuration
public class MyMvcConfig implements WebMvcConfigurer {



//    对外暴露地址
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/img_res/**").addResourceLocations("file:/home/xx15203/web/picture/");
        registry.addResourceHandler("/img_aft/**").addResourceLocations("file:/home/xx15203/web/return_picture");

    }

}



