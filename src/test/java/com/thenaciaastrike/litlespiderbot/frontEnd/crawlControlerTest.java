package com.thenaciaastrike.litlespiderbot.frontEnd;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.io.IOException;
import java.util.ArrayList;


import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CrawlControlerTest {

    @LocalServerPort
    private int port;

    @Test
    @DisplayName("Open crawl page")
    void crawl() {
        //test crawl page
        CrawlControler app = new CrawlControler();
        String expected = "crawl";
        String actual = app.crawl();
        assertEquals(expected, actual);
    }

    @Test
    void deepCrawl() throws IOException {
        CrawlControler app = new CrawlControler();
        ArrayList<String> Validurl = new ArrayList<>();
        Validurl.add("http://127.0.0.1:"+port+"/test");
        ArrayList<String> result = new ArrayList<>();
        result = app.deepCrawl(Validurl,3);
        assertNotNull(result);
    }

    @Test
    void dataSorter() {
        ArrayList<Integer> seedHitCount= new ArrayList<Integer>();
        String seed= "test";
        ArrayList<String>seeddata= new ArrayList<>();
        seeddata.add("test");
        seeddata.add("test2");
        seedHitCount.add(1);
        seedHitCount.add(2);
        CrawlControler app = new CrawlControler();
        ArrayList<String> expected = new ArrayList<>();
        expected.add("2,test,test2");
        expected.add("1,test,test");
        ArrayList<String> actual = app.dataSorter(seedHitCount,seed,seeddata);
        assertEquals(expected, actual);
    }
}