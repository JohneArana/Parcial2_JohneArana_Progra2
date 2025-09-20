import java.sql.Connection;
import java.util.Properties;

public class App {
    public static void main(String[] args) {
        try {
            Properties props = DBConfig.load("db.properties");

            // obtener ambiente desde variable de entorno o args
            String envStr = System.getenv().getOrDefault("APP_ENV", "DEVELOPMENT");
            Environment env = Environment.valueOf(envStr.toUpperCase());

            ConnectionFactory factory = ConnectionFactoryProducer.getFactory(env, props);
            try (Connection conn = factory.createConnection()) {
                System.out.println("Conectado a: " + conn.getMetaData().getURL());
                // ejecutar queries...
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
