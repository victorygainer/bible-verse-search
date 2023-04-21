package com.intelliJoe.entity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@Transactional
class BibleVerseRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BibleVerseRepository repository;

    @Test
    public void testFindByIdx() {
        // given
        BibleVerse verse = new BibleVerse();
        verse.setIdx(1);
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
        BibleVerse found = repository.findById((long) verse.getIdx()).orElse(null);

        // then
        assertThat(found.getSentence())
                .isEqualTo(verse.getSentence());
    }
}
