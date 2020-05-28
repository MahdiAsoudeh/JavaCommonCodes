package com.mahdi20.convertorExample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

public class Convertor {


    public static String filePathToBase64(String filePath) {

        String base64File = "";
        File file = new File(filePath);

        if (file.exists()) {
            try (FileInputStream imageInFile = new FileInputStream(file)) {
                byte fileData[] = new byte[(int) file.length()];
                imageInFile.read(fileData);
                base64File = Base64.getEncoder().encodeToString(fileData);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }


        return base64File;
    }


    public static String fileToBase64(File file) {

        if (file.exists()) {
            return Base64.getEncoder().encodeToString(fileToByteArray(file));
        }
        return null;

    }

    public static byte[] fileToByteArray(File file) {

        if (file.exists()) {
            try {
                byte[] fileContent = Files.readAllBytes(file.toPath());
                return fileContent;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
