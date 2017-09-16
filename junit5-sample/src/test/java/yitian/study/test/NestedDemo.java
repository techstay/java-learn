package yitian.study.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("外层测试")
public class NestedDemo {
    @Test
    void testOuter() {
    }

    @Nested
    @DisplayName("内层测试")
    class InnerTestDemo {
        @Test
        void testInner() {
        }
    }
}
