package com.thenaciaastrike.litlespiderbot.frontEnd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TestTest {

    @Test
    @DisplayName("Open crawl page")
    void crawl() {
        //test crawl page
        com.thenaciaastrike.litlespiderbot.frontEnd.Test app = new com.thenaciaastrike.litlespiderbot.frontEnd.Test();
        String expected = "test";
        String actual = app.test();
        assertEquals(expected, actual);
    }
}