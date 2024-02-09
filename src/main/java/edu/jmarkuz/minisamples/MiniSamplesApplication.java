package edu.jmarkuz.minisamples;

import edu.jmarkuz.minisamples.util.JdbcTemplateDataLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Arrays;

@EnableTransactionManagement
@SpringBootApplication
public class MiniSamplesApplication implements CommandLineRunner {

    @Autowired
    JdbcTemplateDataLoader dataLoader;

    public static void main(String[] args) {
        SpringApplication.run(MiniSamplesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        final String INIT_DB_APPLICATION_PARAMETER = "init_db";

        if (Arrays.stream(args).anyMatch(INIT_DB_APPLICATION_PARAMETER::equalsIgnoreCase)) {
            var filePath = "src/main/resources/db/db-initialisation.sql";
            dataLoader.executeSqlFile(filePath);
        }
    }
}
