package by.kulevets.demociproj;

import jakarta.annotation.PreDestroy;
import org.fluentd.logger.FluentLogger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
@EnableRedisRepositories
@EnableJpaRepositories
public class DemoCiProjApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoCiProjApplication.class, args);
    }


}
