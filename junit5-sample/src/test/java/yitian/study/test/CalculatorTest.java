package yitian.study.test;


import org.junit.jupiter.api.*;
import yitian.study.Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("good calculator test")
public class CalculatorTest {
    static Calculator calculator;

    @BeforeAll
    static void init() {
        calculator = new Calculator();
    }

    @Test
    void testPlus() {
        assertEquals(9, calculator.plus(4, 5));
    }

    @Test
    @Disabled("This will fail")
    void testFail() {
        assertEquals(-2, calculator.minus(2, 4));
    }
}
