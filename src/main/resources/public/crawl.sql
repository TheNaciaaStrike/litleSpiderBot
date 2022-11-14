create table crawl
(
    "crawl_ID"  bigserial
        primary key,
    seed        varchar(255)              not null,
    "crawl_URL" varchar(255)              not null,
    crawl_hits  varchar(255)              not null,
    crawl_date  date default CURRENT_DATE not null
);

alter table crawl
    owner to clawer;

