import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public abstract class ConnectionFactory {
    protected final Properties config;

    public ConnectionFactory(Properties config) {
        this.config = config;
    }

    // método factory
    public abstract Connection createConnection() throws SQLException, ClassNotFoundException;
}