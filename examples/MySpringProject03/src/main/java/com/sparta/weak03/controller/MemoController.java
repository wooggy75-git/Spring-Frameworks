package com.sparta.weak03.controller;

import com.sparta.weak03.domain.Memo;
import com.sparta.weak03.domain.MemoRepository;
import com.sparta.weak03.domain.MemoRequestDto;
import com.sparta.weak03.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemoController {
    private final MemoRepository memoRepository;
    private final MemoService memoService;

    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDto memoRequestDto) {
        Memo memo = new Memo(memoRequestDto);
        return memoRepository.save(memo);
    }

    @GetMapping("/api/memos")

    public List<Memo> readMemo() {
        LocalDateTime startDatetime = LocalDateTime.now().minusDays(1);
        LocalDateTime endDatetime = LocalDateTime.now();

        //System.out.println(startDatetime);
        //System.out.println(endDatetime);
        return memoRepository.findAllByModifiedAtBetween(startDatetime, endDatetime);
        //return memoRepository.findAllByOrderByModifiedAtDesc();
    }

    @DeleteMapping("/api/memos/{id}")
    public Long deleteMemo(@PathVariable Long id) {
        memoRepository.deleteById(id);
        return id;
    }

    @PutMapping("/api/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto memoRequestDto) {
        memoService.update(id, memoRequestDto);
        return id;
    }
}
