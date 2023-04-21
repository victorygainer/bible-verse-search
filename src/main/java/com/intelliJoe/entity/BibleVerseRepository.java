package com.intelliJoe.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BibleVerseRepository extends JpaRepository<BibleVerse, Long> {
}
