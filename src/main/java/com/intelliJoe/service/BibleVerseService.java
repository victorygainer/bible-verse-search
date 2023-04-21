package com.intelliJoe.service;

import com.intelliJoe.web.dto.BibleVerseDto;
import com.intelliJoe.entity.BibleVerse;
import com.intelliJoe.entity.BibleVerseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BibleVerseService {
    private final BibleVerseRepository bibleVerseRepository;

    public BibleVerseService(BibleVerseRepository bibleVerseRepository) {
        this.bibleVerseRepository = bibleVerseRepository;
    }

    public List<BibleVerseDto> findAll() {
        List<BibleVerse> bibleVerses = bibleVerseRepository.findAll();
        return bibleVerses.stream()
                .map(BibleVerseDto::new)
                .collect(Collectors.toList());
    }

    public BibleVerseDto findByIdx(Long idx) {
        Optional<BibleVerse> bibleVerse = bibleVerseRepository.findById(idx);
        return bibleVerse.map(BibleVerseDto::new).orElse(null);
    }

}
