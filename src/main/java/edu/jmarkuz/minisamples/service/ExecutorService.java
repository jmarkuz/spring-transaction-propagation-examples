package edu.jmarkuz.minisamples.service;

import edu.jmarkuz.minisamples.service.example.Example;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExecutorService {

    @Value("${example.number:0}")
    private int exampleNumber;

    @Lazy
    private final Example example_0;
    @Lazy
    private final Example example_1;
    @Lazy
    private final Example example_2;
    @Lazy
    private final Example example_4;
    @Lazy
    private final Example example_5;
    @Lazy
    private final Example example_6;
    @Lazy
    private final Example example_7;

    @EventListener(ContextRefreshedEvent.class)
    public void execute() {
        switch (exampleNumber) {
            case 0 -> example_0.execute();
            case 1 -> example_1.execute();
            case 2 -> example_2.execute();
            case 4 -> example_4.execute();
            case 5 -> example_5.execute();
            case 6 -> example_6.execute();
            case 7 -> example_7.execute();
            default -> throw new IllegalStateException("Unexpected value: " + exampleNumber);
        }
    }

}
