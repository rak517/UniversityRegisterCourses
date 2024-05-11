package controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {

    public static void main(String[] args) throws IOException {
        String filePath = "/Users/rak/Documents/IntelliJ/UniversityRegisterCourses/src/db.properties";
        Properties properties = new Properties();
        properties.load(new FileReader(filePath));
        System.out.println(properties.getProperty("url"));
        System.out.println(properties.getProperty("user"));
        System.out.println(properties.getProperty("password"));
    }
}
