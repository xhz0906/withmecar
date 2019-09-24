package com.qf.j1904.utils;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

public class SaveImg {
    public static String saveImg(MultipartFile uploadfile, HttpServletRequest request){
        String filepath = "";
        String path = ("D:\\Gitlocalresponsity\\withmecar\\withmecar\\withmecar_qt\\src\\main\\resources\\static\\img/upload");
        File uploadRoot = new File(path);
        if (!uploadRoot.exists()){
            uploadRoot.mkdir();
        }
        try {
            InputStream inputStream = uploadfile.getInputStream();
            byte[] b = new byte[inputStream.available()];
            inputStream.read(b,0,b.length);
            inputStream.close();
            OutputStream outputStream = new FileOutputStream(uploadRoot+"/"+uploadfile.getOriginalFilename());
            outputStream.write(b,0,b.length);
            outputStream.flush();
            outputStream.close();
            filepath = uploadRoot+"/"+uploadfile.getOriginalFilename();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filepath;
    }
}
