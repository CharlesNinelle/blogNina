package be.intecbrussel.blogteam2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "be.intecbrussel.blogteam2.models")
@EnableJpaRepositories(basePackages = "be.intecbrussel.blogteam2.repository")
public class BlogTeam2Application {
    public static void main(String[] args) {
        SpringApplication.run(BlogTeam2Application.class, args);
    }
}
