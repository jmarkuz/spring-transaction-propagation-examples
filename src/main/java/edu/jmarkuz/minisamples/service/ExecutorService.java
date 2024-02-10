package edu.jmarkuz.minisamples.service;

import edu.jmarkuz.minisamples.exception.FakeErrorException;
import edu.jmarkuz.minisamples.service.example.Example;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExecutorService {

    @Value("${example.number:0}")
    private int exampleNumber;

    private final Example example_0;
    private final Example example_1;
    private final Example example_2;
    private final Example example_4;
    private final Example example_5;
    private final Example example_6;

    @EventListener(ContextRefreshedEvent.class)
    public void execute() {
        switch (exampleNumber) {
            case 0 -> example_0.execute();

            case 1 -> {
                try {
                    this.example_1.execute();
                } catch (FakeErrorException e) {
                    this.example_1.showResults();
                }
            }

            case 2 -> example_2.execute();

            case 4 -> {
                example_4.execute();
                example_4.showResults();
            }

            case 5 -> {
                example_5.execute();
                example_5.showResults();
            }
            case 6 -> {
                example_6.execute();
            }
        }
    }

}
