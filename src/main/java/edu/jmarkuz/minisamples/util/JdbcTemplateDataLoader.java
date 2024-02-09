package edu.jmarkuz.minisamples.util;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Slf4j
@Service
@RequiredArgsConstructor
public class JdbcTemplateDataLoader {

    private final JdbcTemplate jdbcTemplate;

    public void executeSqlFile(@NonNull final String filePath) {
        try {
            var sqlScript = new String(Files.readAllBytes(Paths.get(filePath)));

            jdbcTemplate.execute(sqlScript);

            log.info("DB initialisation completed successfully");
        } catch (IOException e) {
            log.error("Error while doing DB data initialisation " + e.getMessage());
        }
    }
}
