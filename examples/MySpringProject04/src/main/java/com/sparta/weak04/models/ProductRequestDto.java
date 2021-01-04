package com.sparta.weak04.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

//@Getter
//@Setter
//@RequiredArgsConstructor
//public class ProductRequestDto {
//    private final String title;
//    private final String image;
//    private final String link;
//    private final int lprice;
//}
@Getter
public class ProductRequestDto {
    private String title;
    private String link;
    private String image;
    private int lprice;
}