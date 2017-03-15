package yitian.study.service;

import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.atomic.AtomicInteger;

public class SimpleService implements IService {
    private AtomicInteger integer = new AtomicInteger();

    @Scheduled(fixedDelay = 1000)
    @Override
    public void doService() {

        System.out.println("This is a simple service:" + integer.incrementAndGet());
    }
}
