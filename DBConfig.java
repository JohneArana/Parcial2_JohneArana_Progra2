import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DBConfig {
    public static Properties load(String path) throws IOException {
        Properties props = new Properties();
        try (InputStream in = new FileInputStream(path)) {
            props.load(in);
        }
        return props;
    }
}
