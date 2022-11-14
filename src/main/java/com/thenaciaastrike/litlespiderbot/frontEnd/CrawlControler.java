package com.thenaciaastrike.litlespiderbot.frontEnd;

import com.thenaciaastrike.litlespiderbot.DataStores.CrawlEntity;
import com.thenaciaastrike.litlespiderbot.DataStores.CrawlRepository;
import com.thenaciaastrike.litlespiderbot.backEnd.Yoinker;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Controller
public class CrawlControler {
    @Autowired
    private static CrawlRepository repository;


    @RequestMapping(value = "/allcrawls", method = RequestMethod.GET)
    public ResponseEntity<List<CrawlEntity>> getAllCrawls(@RequestParam(required = false) String url) {
        try {
            List<CrawlEntity> crawls = new ArrayList<CrawlEntity>();
            System.out.println("chekc here" + repository);
            if (crawls.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else
                return (ResponseEntity<List<CrawlEntity>>) repository.findAll();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }

    }

    @RequestMapping(value = "/crawl",method = RequestMethod.GET)
    public String crawl() {
        return "crawl";
    }
    @RequestMapping(value = "/crawl", method = RequestMethod.POST)
    public ResponseEntity newCrawl(String seed, String url, int breath, int depth,HttpServletResponse response ) throws IOException {
        System.out.println("seed: " + seed + " urls: " + url + " breath: " + breath + " depth: " + depth);
        Yoinker yoinker = new Yoinker();
        if (yoinker.validateUrl(url)) {
            ArrayList<String> urlsList = new ArrayList<>();
            ArrayList<String> seeddata = new ArrayList<String>();
            ArrayList<Integer> seedHitCount = new ArrayList<Integer>();
            ArrayList<String> sortedData = new ArrayList<String>();
            String[] urls = yoinker.getLinks(url);
            for (int i = 0; i < urls.length; i++) {
                urlsList.add(urls[i]);
            }
            deepCrawl(urlsList,depth);
            for (int i = 0; i < breath; i++) {
                seeddata.add(urlsList.get(i));
                seedHitCount.add(yoinker.getData(urlsList.get(i), seed));
            }
            dataSorter(seedHitCount,seed,seeddata);

            response.setContentType("text/csv");
            response.setHeader("Content-Disposition", "attachment; file=\"seeddata.csv\"");
            try (CSVPrinter printer = new CSVPrinter(response.getWriter(), CSVFormat.DEFAULT.withHeader("seed", "hits", "url"))) {
                for (int i = 0; i < seeddata.size(); i++) {
                    printer.printRecord(seed, seedHitCount.get(i), seeddata.get(i));
                }
                for (int i = 0; i < sortedData.size(); i++) {
                    printer.printRecord(sortedData.get(i));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                for (int i = 0; i < seeddata.size(); i++) {
                    CrawlEntity _crawl = repository
                            .save(new CrawlEntity(seed, seeddata.get(i), seedHitCount.get(i).toString()));
                }
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(null);
            }
        }
        return ResponseEntity.ok().body(null);
    }

    public ArrayList deepCrawl(ArrayList<String> b, int depth) throws IOException {
        Yoinker yoinker = new Yoinker();
        int iterator = 0;
        while (iterator != depth) {
            String[] urls2 = yoinker.getLinks(b.get(iterator));
            for (int i = 0; i < urls2.length; i++) {
                if (b.contains(urls2[i]))
                    continue;
                else
                    b.add(urls2[i]);
            }
            iterator++;
        }
        return b;
    }

    public ArrayList dataSorter(ArrayList<Integer>seedHitCount,String seed,ArrayList<String>seeddata){
        ArrayList<String> sortedData = new ArrayList<String>();
        for (int i = 0; i < seeddata.size(); i++) {
            sortedData.add(seedHitCount.get(i)+","+seed+","+seeddata.get(i));
        }
        Collections.sort(sortedData, Collections.reverseOrder());
        return sortedData;
    }

}