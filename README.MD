# Crlawer Bot
- Version: 0.5.0
- Java Version: 11+
- Author: TheNaciaaStrike
- License: MIT
- Description: A simple web crawler bot for Java Using Spring Boot and Hibernate
- Current Test coverage: 54.0% (All tests are in the test folder) (Acording to SonarQube)
- Databse: Postgres 12
---
# Current Features
- [x] Crawl a website
- [ ] Save the crawled data in a database
- [X] get CSV file from crawled data
- [X] can crawl multiple websites

---
# How to use

- Clone the project
- - Windows: 
- - - clone the project
- - - run the start.bat file
- - - In browser goto 127.0.0.1:8080/crawl
- - - If it fails you might need to use a different java version (like java 17)
- - Linux:
- - - clone the project
- - - run the start.sh file
- - - In browser goto 127.0.0.1:8080/crawl
- - - - If it fails you might need to use start2.sh file

- - Mac:
- - - clone the project
- - - \shurg/ (I don't have a mac to test it)

- - -
# API
- - GET /crawl - a basic crawl caller
- - POST /crawl - unleashed the crawler
- - - Body request:
- - - - seed: the seed to crawl
- - - - url: the starter url of the crawl
- - - - breath: the breath of the crawl
- - - - deapth: the deapth of the crawl
- - GET /allcrawls - shows all the crawls in database (not implemented yet)
- - GET /test - a test page
---
# Packages and Classes
## frontend

- Test - a controller for a test page
- CrawlController - a controller for the crawl page and API
- - public ArrayList dataSorter (seedHitCount, seed, seeddata) a simple function to sort seed data form highest to lowest
- - public ArrayList deepCrawl (urls, death) a function to crawl through websites
## DataStores
- CrawlEntity - a class for the crawl entity keeps all the data and save it to database (not fully implemented yet)
- CrawlRepository - a repository for the crawl entity (not fully implemented yet)
- CrawlService - a service for the crawl entity (not fully implemented yet)
## backend
- Yoinker - a set of functions to make crawling simpler
- - public String getHTML(String urlToRead) a function to get the html of a website
- - public String[] getLinks(String html) a function to get all the links from a website
- - public String getTitle(String html) a function to get the title of a website
- - public static boolean validateURL(String url) a function to see if URL is actually valid
- - public int getData(String url, String seed) a function to get the data from a website based on a certain seed

## Built With

            spring framework
            postgresql
            commons-validator
            jacoco-maven-plugin
            jsoup
            apache  commons-csv 1.8
