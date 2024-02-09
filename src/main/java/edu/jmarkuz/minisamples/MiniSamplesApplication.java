package edu.jmarkuz.minisamples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class MiniSamplesApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiniSamplesApplication.class, args);
    }

}
