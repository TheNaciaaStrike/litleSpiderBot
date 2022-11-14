package com.thenaciaastrike.litlespiderbot.backEnd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.io.IOException;
import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class YoinkerTest {

    @LocalServerPort
    private int port;
    //Mock Spring boot
    @Autowired
    private com.thenaciaastrike.litlespiderbot.frontEnd.Test Test;


    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("URL validation")
    void validateUrl() throws MalformedURLException {
        Yoinker app = new Yoinker();
        String Validurl = "https://www.google.com";
        String Invalidurl = "https://www.google.com/ asdikhjafijsidogp";
        boolean result = app.validateUrl(Validurl);
        boolean result2 = app.validateUrl(Invalidurl);
        assertTrue(result);
        assertFalse(result2);
    }

    @Test
    @DisplayName("Get HTML code")
    void getHtml() throws IOException {
        Yoinker app = new Yoinker();
        String url = "http://127.0.0.1:"+port+"/test";
        String expected = "<!doctype html>\n" +
                "<html lang=\"en\">\n" +
                " <head> \n" +
                "  <meta charset=\"UTF-8\"> \n" +
                "  <title>Title</title> \n" +
                " </head> \n" +
                " <body>\n" +
                "   Hello! \n" +
                "  <a href=\"/crawl\">Crawl</a> \n" +
                "  <a href=\"/test\">Test</a> \n" +
                "  <a href=\"/\">Home</a>  \n" +
                " </body>\n" +
                "</html>";
        String actual = app.getHtml(url);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Get title")
    void getTitle() throws IOException{
        Yoinker app = new Yoinker();
        String url = "http://127.0.0.1:"+port+"/test";
        String expected = "Title";
        String actual = app.getTitle(url);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Get links form a page")
    void getLinks() throws IOException{
        Yoinker app = new Yoinker();
        String url = "http://127.0.0.1:"+port+"/test";
        String[] expected = {"http://127.0.0.1:"+port+"/crawl","http://127.0.0.1:"+port+"/test","http://127.0.0.1:"+port+"/"};
        String[] actual = app.getLinks(url);
        assertArrayEquals(expected, actual);
    }
    @Test
    @DisplayName("Get data from a page using a seed")
    void getData() throws IOException {
        Yoinker app = new Yoinker();
        String url = "http://127.0.0.1:" + port + "/test";
        int expected = 1;
        int actual = app.getData(url, "Hello");
        assertEquals(expected, actual);
    }
}