import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DevelopmentConnectionFactory extends ConnectionFactory {
    public DevelopmentConnectionFactory(Properties config) { super(config); }

    @Override
    public Connection createConnection() throws SQLException, ClassNotFoundException {
        String driver = config.getProperty("jdbc.driver", "org.mariadb.jdbc.Driver");
        Class.forName(driver);
        String url = config.getProperty("development.url");
        String user = config.getProperty("development.user");
        String pass = config.getProperty("development.password");
        return DriverManager.getConnection(url, user, pass);
    }
}
