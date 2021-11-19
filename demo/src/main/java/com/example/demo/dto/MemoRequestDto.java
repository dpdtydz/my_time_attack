package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemoRequestDto {
    private String content;
    private String title;

    public MemoRequestDto(String title, String content){
        this.title=title;
        this.content=content;
    }
}
