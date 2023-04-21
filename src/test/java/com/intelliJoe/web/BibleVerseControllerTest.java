package com.intelliJoe.web;

import com.intelliJoe.entity.BibleVerse;
import com.intelliJoe.entity.BibleVerseRepository;
import com.intelliJoe.web.dto.BibleVerseDto;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BibleVerseControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private BibleVerseRepository repository;

    @Test
    public void testFindAll() {
        // given
        BibleVerse verse = new BibleVerse();
        verse.setCate(1);
        verse.setBook(1);
        verse.setChapter(1);
        verse.setParagraph(1);
        verse.setSentence("In the beginning God created the heavens and the earth.");
        verse.setTestament("Old");
        verse.setLongLabel("Genesis 1:1");
        verse.setShortLabel("Gen 1:1");
        repository.save(verse);

        // when
        ResponseEntity<List<BibleVerseDto>> response = restTemplate.exchange(
                "/bibleVerses",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<BibleVerseDto>>(){});

        // then
        System.out.println(response);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).hasSize(1);
        assertThat(response.getBody().get(0)).extracting("sentence").isEqualTo(verse.getSentence());
    }
}
