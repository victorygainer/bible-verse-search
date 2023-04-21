package com.intelliJoe.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "bible_verse")
public class BibleVerse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(name = "cate")
    private Integer cate;

    @Column(name = "book")
    private Integer book;

    @Column(name = "chapter")
    private Integer chapter;

    @Column(name = "paragraph")
    private Integer paragraph;

    @Column(name = "sentence", columnDefinition = "TEXT")
    private String sentence;

    @Column(name = "testament")
    private String testament;

    @Column(name = "long_label")
    private String longLabel;

    @Column(name = "short_label")
    private String shortLabel;

    // 생성자, getter, setter, toString 등 필요한 메소드 구현
}
