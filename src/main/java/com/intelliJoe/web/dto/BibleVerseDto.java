package com.intelliJoe.web.dto;

import com.intelliJoe.entity.BibleVerse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BibleVerseDto {
    private int idx;
    private Integer cate;
    private Integer book;
    private Integer chapter;
    private Integer paragraph;
    private String sentence;
    private String testament;
    private String longLabel;
    private String shortLabel;

    public BibleVerseDto() {}

    public BibleVerseDto(BibleVerse bibleVerse) {
        this.idx = bibleVerse.getIdx();
        this.cate = bibleVerse.getCate();
        this.book = bibleVerse.getBook();
        this.chapter = bibleVerse.getChapter();
        this.paragraph = bibleVerse.getParagraph();
        this.sentence = bibleVerse.getSentence();
        this.testament = bibleVerse.getTestament();
        this.longLabel = bibleVerse.getLongLabel();
        this.shortLabel = bibleVerse.getShortLabel();
    }

    public BibleVerse toBibleVerse() {
        BibleVerse bibleVerse = new BibleVerse();
        bibleVerse.setIdx(this.idx);
        bibleVerse.setCate(this.cate);
        bibleVerse.setBook(this.book);
        bibleVerse.setChapter(this.chapter);
        bibleVerse.setParagraph(this.paragraph);
        bibleVerse.setSentence(this.sentence);
        bibleVerse.setTestament(this.testament);
        bibleVerse.setLongLabel(this.longLabel);
        bibleVerse.setShortLabel(this.shortLabel);
        return bibleVerse;
    }
}

