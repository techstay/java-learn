package yitian.study.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:beans.xml")
@ActiveProfiles("quartz")
public class QuartzServiceTest {
    @Test
    public void testQuartzTasks() throws InterruptedException {
        TimeUnit.SECONDS.sleep(10);
    }
}
