package net.stevenking;

import lombok.extern.slf4j.Slf4j;
import net.stevenking.apartment.service.ApartmentService;
import net.stevenking.apartment.service.SeleniumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableJpaAuditing
@Slf4j
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Component
    public class CommandLineAppStartupRunner implements CommandLineRunner {
        @Autowired
        private SeleniumService seleniumService;

        @Override
        public void run(String...args) throws Exception {
            seleniumService.fetchNewPrice();
        }
    }
}
