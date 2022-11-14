package com.thenaciaastrike.litlespiderbot;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class LitleSpiderBotApplicationTests {

    @Autowired
    private com.thenaciaastrike.litlespiderbot.frontEnd.Test Test;

    @Test
    @DisplayName("Hello world test")
    void testContext() {
        LitleSpiderBotApplication app = new LitleSpiderBotApplication();
        String expected = "Hello!";
        String actual = app.hello();
        assertEquals(expected, actual);
    }

}
