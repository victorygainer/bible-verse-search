package com.intelliJoe.service;

import com.intelliJoe.entity.BibleVerse;
import com.intelliJoe.entity.BibleVerseRepository;
import com.intelliJoe.web.dto.BibleVerseResponseDto;
import lombok.RequiredArgsConstructor;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BibleVerseService {
    private final BibleVerseRepository bibleVerseRepository;

    public List<BibleVerseResponseDto> searchBySentence(String json) {
        String keyword = "";
        try {
            JSONObject jsonObject = new JSONObject(json);
            keyword = jsonObject.getString("keyword");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        List<BibleVerse> bibleVerses = bibleVerseRepository.findBySentenceContaining(keyword);
        return bibleVerses.stream()
                .map(BibleVerseResponseDto::new)
                .collect(Collectors.toList());
    }
}


