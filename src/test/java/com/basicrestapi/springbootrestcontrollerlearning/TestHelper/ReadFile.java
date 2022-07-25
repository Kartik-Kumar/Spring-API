package com.basicrestapi.springbootrestcontrollerlearning.TestHelper;

import org.springframework.stereotype.Component;

import javax.imageio.IIOException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class ReadFile {

    public static String readFile(String fileName) {
        try {
            return Files.readAllLines(Paths.get("src/test/resources" + fileName))
                    .stream()
                    .reduce(String::concat)
                    .orElse("");
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
