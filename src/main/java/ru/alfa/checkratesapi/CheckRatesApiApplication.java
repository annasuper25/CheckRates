package ru.alfa.checkratesapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import ru.alfa.checkratesapi.configuration.CheckRatesProperties;

@EnableFeignClients
@SpringBootApplication
@EnableConfigurationProperties({CheckRatesProperties.class})
public class CheckRatesApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CheckRatesApiApplication.class, args);
    }

}
