package yitian.study.test;


import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class AssertionDemo {
    @Test
    void testAssertion() {
        assertEquals(10, 10);
        assertTrue(true);
        assertEquals(100, 100, "两个数相等");
        assertAll("数字"
                , () -> assertEquals("name", "name")
                , () -> assertEquals(500, 500));
        assertThrows(InvalidParameterException.class
                , () -> {
                    throw new InvalidParameterException();
                }
        );
        int result = assertTimeout(Duration.ofSeconds(5)
                , () -> {
                    int i = 0, j = 0;
                    while (i <= 100) {
                        for (; j <= 100000; j++)
                            j++;
                        i++;
                    }
                    return i;
                });
        assertEquals(101, result);
    }
}
