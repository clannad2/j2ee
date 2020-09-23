package com.cebbank.liuxiaoming.file;

import java.io.File;

/**
 *
 */
public class TestFile {
    public static void main(String[] args) {
        //绝对路径构建对象
        File file = new File("D:\\ceshi\\fileone.txt");
        //相对路径构建对象，起点是工程根目录
       // File file = new File("src\\fileone.txt");
//        System.out.println(file.isDirectory());
//        System.out.println(file.isFile());
//        if (file.isFile()){
//            //是否找到指定对象，找到则返回true
//            if (!file.exists()){
//                try {
//                    file.createNewFile();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
            System.out.println("文件的大小为："+file.length());
        System.out.println(file.getName());//获取文件名
        System.out.println(file.getPath());//相对路径
        System.out.println(file.getAbsoluteFile());//绝对路径
        System.out.println(file.getAbsolutePath());//绝对路径
        System.out.println(file.getParent());//文件存放的父目录
       // }
    }
}

