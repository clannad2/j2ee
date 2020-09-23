package com.cebbank.liuxiaoming.file;

import java.io.File;
import java.io.FileOutputStream;

public class TestFileOutStream {
    public static void main(String[] args) {
        try{
            File file = new File("src//fileone.txt");
            if (!file.exists()){
                file.createNewFile();
            }

            FileOutputStream fos = new FileOutputStream(file,true);
            String s = "你好，今天是周末了";
            fos.write(s.getBytes());
            fos.close();


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
