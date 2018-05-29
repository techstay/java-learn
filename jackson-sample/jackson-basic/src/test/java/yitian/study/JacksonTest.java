package yitian.study;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import yitian.study.entity.Friend;

import java.io.IOException;

public class JacksonTest {
    private static XmlMapper xmlMapper;
    private static ObjectMapper jsonMapper;

    @BeforeAll
    static void setUp() {
        xmlMapper = new XmlMapper();
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
        xmlMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        xmlMapper.findAndRegisterModules();

        jsonMapper = new ObjectMapper();
        jsonMapper.findAndRegisterModules();
        jsonMapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        jsonMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    @Test
    static void testJson() throws IOException {
        Friend f1 = new Friend("yitian", 25);
        String text = jsonMapper.writeValueAsString(f1);
        Friend f2 = jsonMapper.readValue(text, Friend.class);
        Assertions.assertEquals(f1, f2, "Friends should be the same");

    }

    @Test
    static void testXml() {

    }

    @AfterAll
    static void tearDown() {

    }
}
