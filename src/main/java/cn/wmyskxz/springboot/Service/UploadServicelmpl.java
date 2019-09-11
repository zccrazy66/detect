package cn.wmyskxz.springboot.Service;


import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class UploadServicelmpl implements UploadService {
    @Override
    public boolean mkDirectory(String path) {
        File file = null;
        try{
            file = new File(path);
            if (!file.exists()){
                return file.mkdirs();
            }else {
                return false;
            }
        }catch (Exception e){}
        finally {
            file = null;
        }
        return false;
    }
}
