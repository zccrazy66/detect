package cn.wmyskxz.springboot.Service;


import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.Base64.Encoder;

@Service
public class UtilServiceImpl implements UtilService {

    @Override
    public String change_pic_to_base64(String path) {
        InputStream in = null;
        byte [] data = null;
        try {
            in = new FileInputStream(path);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        Encoder encoder = Base64.getEncoder();

        return encoder.encodeToString(data);
    }
}
