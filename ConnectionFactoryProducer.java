import java.util.Properties;

public class ConnectionFactoryProducer {
    public static ConnectionFactory getFactory(Environment env, Properties config) {
        switch (env) {
            case PRODUCTION:  return new ProductionConnectionFactory(config);
            case DEVELOPMENT: return new DevelopmentConnectionFactory(config);
            case TESTING:     return new TestingConnectionFactory(config);
            default: throw new IllegalArgumentException("Environment not supported: " + env);
        }
    }
}
