package com.sparta.weak03.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface MemoRepository extends JpaRepository<Memo, Long> {
    List<Memo> findAllByModifiedAtBetween(LocalDateTime start, LocalDateTime end);
    //List<Memo> findAllByOrderByModifiedAtDesc();
    //List<Memo> findAll By OrderBy ModifiedAt Desc();
}
