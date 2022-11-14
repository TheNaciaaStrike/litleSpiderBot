package com.thenaciaastrike.litlespiderbot.DataStores;

import java.util.List;

public interface CrawlService {
    public void saveCrawl(CrawlEntity crawlEntity);

    List<CrawlEntity> findAll();
}
