package com.intelliJoe.web;

import com.intelliJoe.service.BibleVerseService;
import com.intelliJoe.web.dto.BibleVerseResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BibleVerseApiController {

    private final BibleVerseService bibleVerseService;

    @PostMapping("/api/v1/bibleVerse/searchBySentence")
    public List<BibleVerseResponseDto> searchBySentence(@RequestBody String keyword) {
        System.out.println(keyword);
        return bibleVerseService.searchBySentence(keyword);
    }
}
