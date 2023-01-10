package br.com.fiap.abctechapi.component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.stereotype.Component;

@Component
public class VersionComponent {

    private final String name;
    private final String version;

    public VersionComponent() throws IOException {
        Properties properties = new Properties();

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("application.yml");
        properties.load(inputStream);
        
        this.name = properties.getProperty("build.name");
        this.version = properties.getProperty("build.version");
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public String getNameVersion() {
        return getName() + " - " + getVersion();
    }
}
