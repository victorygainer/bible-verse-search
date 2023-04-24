package com.intelliJoe.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BibleVerseRepository extends JpaRepository<BibleVerse, Long> {

    List<BibleVerse> findBySentenceContaining(String keyword);
}
