package com.cebbank.liuxiaoming.file;

import java.io.File;
import java.io.FileInputStream;

/**
 * 字节文件流
 */
public class TestFileStream {
    public static void main(String[] args) {
        try{
            File file = new File("src//fileone.txt");
            if (!file.exists()){
                file.createNewFile();
            }

            FileInputStream fis = new FileInputStream(file);
//            byte[] data = new byte[(int) file.length()];
            byte[] data = new byte[1024];
            String content = "";
            while (true){
                int read = fis.read(data, 0, (int) file.length());
                if (read == -1){
                    break;
                }
                content += new String(data);
            }


            System.out.println(content);
//            FileInputStream fis = new FileInputStream("src//fileone.txt");
//            while (true){
//                int read = fis.read();
//                if (read == -1){
//                    break;
//                }
//                char c = (char) read;
//                System.out.print(c);
//            }
            fis.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
