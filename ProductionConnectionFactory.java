import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ProductionConnectionFactory extends ConnectionFactory {
    public ProductionConnectionFactory(Properties config) {
        super(config);
    }

    @Override
    public Connection createConnection() throws SQLException, ClassNotFoundException {
        String driver = config.getProperty("jdbc.driver", "org.mariadb.jdbc.Driver");
        Class.forName(driver);
        String url = config.getProperty("production.url");
        String user = config.getProperty("production.user");
        String pass = config.getProperty("production.password");
        return DriverManager.getConnection(url, user, pass);
    }
}
