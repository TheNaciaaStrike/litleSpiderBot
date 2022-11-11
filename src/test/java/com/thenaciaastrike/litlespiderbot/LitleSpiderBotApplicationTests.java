package com.thenaciaastrike.litlespiderbot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class LitleSpiderBotApplicationTests {

    //@Test
    //void contextLoads() {
    //}
    @Test
    public void testHello() {
        LitleSpiderBotApplication app = new LitleSpiderBotApplication();
        String result = app.hello();
        assertEquals("Hello!", result);
    }

}
