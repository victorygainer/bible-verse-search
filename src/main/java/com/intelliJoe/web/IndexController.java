package com.intelliJoe.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intelliJoe.entity.BibleVerse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/bibleVerses/search/result")
    public String searchResult(@RequestParam("keyword") String keyword, @RequestParam("bibleVerses") String bibleVersesJson, Model model) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<BibleVerse> bibleVerses = objectMapper.readValue(bibleVersesJson, new TypeReference<List<BibleVerse>>(){});

        model.addAttribute("keyword", keyword);
        model.addAttribute("bibleVerses", bibleVerses);
        return "result";
    }
}
