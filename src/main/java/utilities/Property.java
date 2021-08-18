package utilities;

import java.io.FileInputStream;
import java.io.IOException;

public class Property {

    public static java.util.Properties getProp() throws IOException {
        java.util.Properties props = new java.util.Properties();
        FileInputStream file = new FileInputStream(
                "./src/test/java/application.properties");
        props.load(file);
        return props;
    }
}