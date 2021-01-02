package com.sparta.weak03.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@RequiredArgsConstructor
public class MemoRequestDto {
    private final String username;
    private final String contents;
}
