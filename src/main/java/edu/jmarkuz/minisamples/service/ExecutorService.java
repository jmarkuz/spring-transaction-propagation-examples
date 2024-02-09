package edu.jmarkuz.minisamples.service;

import edu.jmarkuz.minisamples.service.example.Example;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExecutorService {

    private final Example example_1;

    @EventListener(ContextRefreshedEvent.class)
    public void execute() {
        example_1.execute();
    }

}
