package yitian.study.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("测试类可以指定显示名称")
public class DisplayNameDemo {
    @Test
    @DisplayName("测试方法也可以指定显示名称")
    void testWithLongDisplayName() {

    }

    @Test
    @DisplayName("显示名称还可以包含表情😻")
    void testWithDisplayNameWithEmoji() {

    }
}
