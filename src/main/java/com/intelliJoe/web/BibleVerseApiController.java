package com.intelliJoe.web;

import com.intelliJoe.service.BibleVerseService;
import com.intelliJoe.web.dto.BibleVerseResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BibleVerseApiController {

    private final BibleVerseService bibleVerseService;

    @GetMapping("/api/v1/bibleVerse/{keyword}")
    public List<BibleVerseResponseDto> searchBySentence(@PathVariable String keyword) {
        return bibleVerseService.searchBySentence(keyword);
    }
}
