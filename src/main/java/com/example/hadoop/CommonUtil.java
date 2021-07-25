package com.example.hadoop;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class CommonUtil {
    public static void inputStreamToFile(InputStream ins, File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static public File MultipartFileToFile(MultipartFile file)
    {
        File f = null;
        try {

            if (file.equals("") || file.getSize() <= 0) {
                file = null;
            } else {
                InputStream ins = file.getInputStream();
                f = new File(file.getOriginalFilename());
                inputStreamToFile(ins, f);
            }
            return f;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return f;
        }
    }
}