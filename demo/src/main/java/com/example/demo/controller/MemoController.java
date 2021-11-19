package com.example.demo.controller;
import com.example.demo.domain.Memo;
import com.example.demo.dto.MemoRequestDto;
import com.example.demo.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor // 꼭 필요한 요소(final) 자동 생성
@RestController // JSON 으로 응답하기 위한 RestController 라는 의미
public class MemoController {
    private final MemoService memoService;
    // 신규 메모 생성


    @PostMapping("/memos")
    public Memo setMemo(@RequestBody MemoRequestDto memoRequestDto) {
       return memoService.setMemo(memoRequestDto);
    }


    @GetMapping("/memo/{id}")
    public Memo getMemo(@PathVariable Long id){ return memoService.getMemo(id);}


}
