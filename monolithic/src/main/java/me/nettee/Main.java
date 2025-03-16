package me.nettee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {
        "me.nettee.common",
        "me.nettee.core",
        "me.nettee.services.board",
        "me.nettee.monolithic"
})
@EntityScan(basePackages = {
        "me.nettee.core.entity",
        "me.nettee.services.board.entity"
})
@EnableJpaRepositories(basePackages = {
        "me.nettee.core.repository"
})
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
