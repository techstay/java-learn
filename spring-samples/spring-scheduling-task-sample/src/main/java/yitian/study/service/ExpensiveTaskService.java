package yitian.study.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;


public class ExpensiveTaskService implements IService {
    private AtomicInteger integer = new AtomicInteger();

    @Override
    @Scheduled(fixedDelay = 2000)
    @Async
    public void doService() {
        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("This is an expensive task:" + integer.incrementAndGet());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
