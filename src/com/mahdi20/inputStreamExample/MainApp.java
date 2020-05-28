package com.mahdi20.inputStreamExample;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class MainApp {

    static List<InputStream> list = new ArrayList<>();

    public static void main(String[] args) {


        for (int i = 0; i < 100; i++) {

            String str = "mahdi_" + i;
            InputStream in = new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8));
            list.add(in);
            System.out.println("added: " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        System.out.println("list size is: " + list.size());


        for (InputStream inputStream : list) {

            byte[] byteArray = new byte[1024];
            try {
                inputStream.read(byteArray);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String s = new String(byteArray);
            System.out.println("Content is: " + s);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


    }
}
