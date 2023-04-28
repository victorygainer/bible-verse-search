package com.intelliJoe.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.intelliJoe.entity.BibleVerse;

public class BibleVerseResponseDto {
//    @JsonProperty("verse_id")
//    private int idx;

    @JsonProperty("cate")
    private Integer cate;

    @JsonProperty("book")
    private Integer book;

    @JsonProperty("chapter")
    private Integer chapter;

    @JsonProperty("paragraph")
    private Integer paragraph;

    @JsonProperty("sentence")
    private String sentence;

    @JsonProperty("testament")
    private String testament;
    @JsonProperty("longLabel")
    private String longLabel;
    @JsonProperty("shortLabel")
    private String shortLabel;

    public BibleVerseResponseDto(BibleVerse entity) {
//        this.idx = entity.getIdx();
        this.cate = entity.getCate();
        this.book = entity.getBook();
        this.chapter = entity.getChapter();
        this.paragraph = entity.getParagraph();
        this.sentence = entity.getSentence();
        this.testament = entity.getTestament();
        this.longLabel = entity.getLongLabel();
        this.shortLabel = entity.getShortLabel();
    }
}
