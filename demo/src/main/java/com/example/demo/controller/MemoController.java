package com.example.demo.controller;
import com.example.demo.Repository.MemoRepository;
import com.example.demo.domain.Memo;
import com.example.demo.dto.MemoRequestDto;
import com.example.demo.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor // 꼭 필요한 요소(final) 자동 생성
@RestController // JSON 으로 응답하기 위한 RestController 라는 의미
public class MemoController {
    private final MemoService memoService;
    private final MemoRepository memoRepository;
    // 신규 메모 생성

    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDto requestDto) {
        Memo memo = new Memo(requestDto);
        return memoRepository.save(memo); // 값 저장
    }
}
