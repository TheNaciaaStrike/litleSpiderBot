package com.thenaciaastrike.litlespiderbot.DataStores;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrawlEntityTest {

    @Test
    void getCrawlId() {
        CrawlEntity crawlEntity = new CrawlEntity("test","test","50");
        crawlEntity.setCrawlId(1L);
        assertEquals(1L, crawlEntity.getCrawlId());
    }

    @Test
    void setCrawlId() {
        CrawlEntity crawlEntity = new CrawlEntity("test","test","50");
        crawlEntity.setCrawlId(1L);
        assertEquals(1L, crawlEntity.getCrawlId());
    }

    @Test
    void getSeed() {
        CrawlEntity crawlEntity = new CrawlEntity("test","test","50");
        crawlEntity.setSeed("test");
        assertEquals("test", crawlEntity.getSeed());
    }

    @Test
    void setSeed() {
        CrawlEntity crawlEntity = new CrawlEntity("test","test","50");
        crawlEntity.setSeed("test");
        assertEquals("test", crawlEntity.getSeed());
    }

    @Test
    void getCrawlUrl() {
        CrawlEntity crawlEntity = new CrawlEntity("test","test","50");
        crawlEntity.setCrawlUrl("test");
        assertEquals("test", crawlEntity.getCrawlUrl());
    }

    @Test
    void setCrawlUrl() {
        CrawlEntity crawlEntity = new CrawlEntity("test","test","50");
        crawlEntity.setCrawlUrl("test");
        assertEquals("test", crawlEntity.getCrawlUrl());
    }

    @Test
    void getCrawlHits() {
        CrawlEntity crawlEntity = new CrawlEntity("test","test","50");
        crawlEntity.setCrawlHits("50");
        assertEquals("50", crawlEntity.getCrawlHits());
    }

    @Test
    void setCrawlHits() {
        CrawlEntity crawlEntity = new CrawlEntity("test","test","50");
        crawlEntity.setCrawlHits("50");
        assertEquals("50", crawlEntity.getCrawlHits());
    }

}