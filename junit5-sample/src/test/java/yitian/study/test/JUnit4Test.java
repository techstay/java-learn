package yitian.study.test;

import org.junit.*;

public class JUnit4Test {
    @BeforeClass
    public static void init() {
        System.out.println("Before Class");
    }

    @AfterClass
    public static void clean() {
        System.out.println("After class");
    }

    @Before
    public void before() {
        System.out.println("Before");
    }

    @After
    public void after() {
        System.out.println("After");
    }

    @Test
    public void test1() {
        System.out.println("Test 1");
    }

    @Test
    public void test2() {
        System.out.println("Test 2");
    }
}
