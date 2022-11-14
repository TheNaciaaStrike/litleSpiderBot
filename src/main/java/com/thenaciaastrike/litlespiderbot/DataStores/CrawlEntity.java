package com.thenaciaastrike.litlespiderbot.DataStores;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "crawl", schema = "public", catalog = "clawer")
public class CrawlEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "crawl_ID", nullable = false)
    private long crawlId;
    @Basic
    @Column(name = "seed", nullable = false, length = 255)
    private String seed;
    @Basic
    @Column(name = "crawl_URL", nullable = false, length = 255)
    private String crawlUrl;
    @Basic
    @Column(name = "crawl_hits", nullable = false, length = 255)
    private String crawlHits;
    @Basic
    @Column(name = "crawl_date", nullable = false)
    private Date crawlDate;

    public CrawlEntity(String seed, String crawlUrl, String crawlHits) {
        this.seed = seed;
        this.crawlUrl = crawlUrl;
        this.crawlHits = crawlHits;
    }

    public long getCrawlId() {
        return crawlId;
    }

    public void setCrawlId(long crawlId) {
        this.crawlId = crawlId;
    }

    public String getSeed() {
        return seed;
    }

    public void setSeed(String seed) {
        this.seed = seed;
    }

    public String getCrawlUrl() {
        return crawlUrl;
    }

    public void setCrawlUrl(String crawlUrl) {
        this.crawlUrl = crawlUrl;
    }

    public String getCrawlHits() {
        return crawlHits;
    }

    public void setCrawlHits(String crawlHits) {
        this.crawlHits = crawlHits;
    }

    public Date getCrawlDate() {
        return crawlDate;
    }

    public void setCrawlDate(Date crawlDate) {
        this.crawlDate = crawlDate;
    }
}
