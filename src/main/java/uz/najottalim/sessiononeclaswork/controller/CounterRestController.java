package uz.najottalim.sessiononeclaswork.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import uz.najottalim.sessiononeclaswork.entity.Counter;
import uz.najottalim.sessiononeclaswork.repository.CounterRepository;

@RestController
public class CounterRestController {

    private final CounterRepository counterRepository;

    public CounterRestController(CounterRepository counterRepository) {
        this.counterRepository = counterRepository;
    }


    @GetMapping
    public Counter getDAta1(@RequestHeader("Cookie") String s) {
        Counter counter = getCounter(s);
        counter.increment();
        counterRepository.save(counter);
        return counter;
    }

    @GetMapping("/count")
    public Counter getData(@RequestHeader("Cookie") String s) {
        return getCounter(s);
    }

    private Counter getCounter(String s) {
        s = s.split(";")[0];
        Counter counter = counterRepository.findBySession(s).orElse(new Counter(s));
                return counter;
    }
}
