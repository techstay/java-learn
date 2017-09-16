package yitian.study.test;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("taggedTest")
public class TagDemo {
    @Test
    @Tag("taggedTest1")
    void testWithTag1() {

    }

    @Test
    @Tag("taggedTest2")
    void testWithTag2() {

    }
}
