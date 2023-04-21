package com.intelliJoe.web;

import com.intelliJoe.service.BibleVerseService;
import com.intelliJoe.web.dto.BibleVerseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bibleVerses")
public class BibleVerseController {
    private final BibleVerseService bibleVerseService;

    public BibleVerseController(BibleVerseService bibleVerseService) {
        this.bibleVerseService = bibleVerseService;
    }

    @GetMapping
    public List<BibleVerseDto> findAll() {
        return bibleVerseService.findAll();
    }

    @GetMapping("/{idx}")
    public BibleVerseDto findByIdx(@PathVariable Long idx) {
        return bibleVerseService.findByIdx(idx);
    }
}

