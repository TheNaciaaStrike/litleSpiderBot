package com.thenaciaastrike.litlespiderbot.backEnd;

import org.apache.commons.validator.routines.UrlValidator;
import org.jsoup.Jsoup;

import java.io.IOException;


public class Yoinker {
    //validate url
    public static boolean validateUrl(String url) {
        UrlValidator urlValidator = new UrlValidator();
        return urlValidator.isValid(url);
    }
    //get Html code of the page
    public String getHtml(String url) throws IOException {
        return Jsoup.connect(url).get().html();
    }

    //get the title of a page
    public String getTitle(String url) throws IOException {
        return Jsoup.connect(url).get().title();
    }

    //get the links of a page
    public String[] getLinks(String url) throws IOException{
        return Jsoup.connect(url).get().select("a[href]").eachAttr("abs:href").toArray(new String[0]);
    }
    //get count of terms based on seed in url
    public int getData(String url, String seed) throws IOException{
        //return count of seed in url
        return Jsoup.connect(url).get().text().repeat(1).split(seed).length-1;
    }

}
