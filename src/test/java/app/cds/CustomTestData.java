package app.cds;

import lombok.Getter;
import lombok.Setter;

import java.util.Properties;

@Getter
@Setter
public class CustomTestData {

    public final String url;
    public final String browser;
    public final String username;
    public final String password;

    public CustomTestData(Properties properties) {
        url = properties.getProperty("web.url");
        browser = properties.getProperty("browser");
        username = properties.getProperty("username");
        password = properties.getProperty("password");
    }
}