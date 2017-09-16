package yitian.study.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class DependencyInjectionDemo {
    @Test
    @DisplayName("依赖注入")
    @Tag("test")
    void testDisplayName(TestInfo testInfo) {
        assertEquals("依赖注入", testInfo.getDisplayName());
        assertEquals(Collections.singleton("test"), testInfo.getTags());
    }
}
