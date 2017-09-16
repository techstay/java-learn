package yitian.study.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

public class RepeatedTestDemo {
    @BeforeEach
    void beforeEach(RepetitionInfo info) {
        System.out.printf("%d - %d\n"
                , info.getCurrentRepetition()
                , info.getTotalRepetitions());
    }

    @RepeatedTest(10)
    void testRepeated10Times() {

    }
}
