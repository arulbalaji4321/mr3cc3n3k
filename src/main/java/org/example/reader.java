package org.example;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class reader {

    public Properties reader() throws IOException {
        FileReader reader = new FileReader("src/test/java/Properties/project.properties");
        Properties p = new Properties();
        p.load(reader);
        return p;
    }

}