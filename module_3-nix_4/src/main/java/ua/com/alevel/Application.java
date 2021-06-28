package ua.com.alevel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.controller.JDBCController;
import ua.com.alevel.controller.JPAMController;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Application {
    private final static Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {

        Map<String, String> properties = new HashMap<>();
        properties.put("login", args[0]);//Login to BD
        properties.put("pass", args[1]);// Password BD
        properties.put("email", args[2]);// Email, search in script.sql
        properties.put("variant", args[3]);// "1" - JPA, "2" - JDBC

        if (properties.get("variant").equals("1")) {
            Configuration configuration = new Configuration().configure()
                    .setProperty("hibernate.connection.username", properties.get("login"))
                    .setProperty("hibernate.connection.password", properties.get("pass"));

            try (SessionFactory sessionFactory = configuration.buildSessionFactory();
                 Session session = sessionFactory.openSession()) {

                JPAMController firstVariant = new JPAMController(session, properties.get("email"));
                try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
                    firstVariant.JPARun(bufferedReader);
                } catch (Exception e) {
                    logger.error(e.getMessage());
                    System.out.println(e.getMessage());
                }
            } catch (Exception e) {
                logger.error(e.getMessage());
                System.out.println(e.getMessage());
            }
        } else if (properties.get("variant").equals("2")) {
            String fileName = "operations.csv";
            Properties props = loadProperties();
            String url = props.getProperty("url");
            try (Connection connection = DriverManager.getConnection(url, properties.get("login"), properties.get("pass"));
                 BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
                JDBCController secondVariant = new JDBCController(connection, properties.get("email"), fileName);
                secondVariant.JDBCRun(bufferedReader);
            } catch (Exception e) {
                logger.error(e.getMessage());
                System.out.println(e.getMessage());
            }
        } else {
            logger.info("Incorrect variant of task");
            System.exit(0);
        }

    }

    private static Properties loadProperties() {
        Properties props = new Properties();
        try (InputStream input = Application.class.getResourceAsStream("/jdbc.properties")) {
            props.load(input);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        return props;
    }
}
