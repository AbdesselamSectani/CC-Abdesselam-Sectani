package sectani.equipesecurite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import sectani.equipesecurite.Configuration.RsaConfig;

@SpringBootApplication
@EnableConfigurationProperties(RsaConfig.class)
public class EquipeSecuriteApplication {

    public static void main(String[] args) {
        SpringApplication.run(EquipeSecuriteApplication.class, args);
    }

}
