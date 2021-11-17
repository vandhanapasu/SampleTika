package com.example.tikaapp.controller;
import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import org.apache.tika.Tika;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class filetype {
    @RequestMapping(value ="/")
    public static void main(String[] args) throws IOException {
        System.out.println("Hello, World!");
        String path = "/Users/vandhu/Documents/java_programs/filefolder";
        File dir = new File(path);
        File[] files = dir.listFiles();
		Tika tika = new Tika();
        // Fetching all the files
        for (File file : files) {
            if(file.isFile()) {
                BufferedReader inputStream = null;
                String line;
                try {
                    inputStream = new BufferedReader(new FileReader(file));
                    while ((line = inputStream.readLine()) != null) {
                        System.out.println("Contents of this file: \n"+line);
						String filetype = tika.detect(file);
						System.out.println("Type of this file: \n"+filetype);
                    }
                }catch(IOException e) {
                	System.out.println(e);
                }
                finally {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                }
            }
        }
    }
}
