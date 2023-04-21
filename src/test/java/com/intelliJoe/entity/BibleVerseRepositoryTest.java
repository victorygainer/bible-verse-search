package com.intelliJoe.entity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class BibleVerseRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BibleVerseRepository repository;

    @Test
    public void testFindByIdx() {
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
        entityManager.persist(verse);
        entityManager.flush();

        // when
        BibleVerse found = repository.findById(verse.getIdx()).orElse(null);

        // then
        assertThat(found.getSentence())
                .isEqualTo(verse.getSentence());
    }
}