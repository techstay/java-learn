package yitian.study.test;

import org.junit.jupiter.api.*;


public class JUnit5Test {
    @BeforeAll
    static void beforeAll() {
        System.out.println("Before All");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After All");
    }

    @BeforeEach
    void before() {
        System.out.println("Before");
    }

    @AfterEach
    void after() {
        System.out.println("After");
    }

    @Test
    void test1() {
        System.out.println("Test 1");
    }

    @Test
    void test2() {
        System.out.println("Test 2");
    }
}
