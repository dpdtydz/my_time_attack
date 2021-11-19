package com.example.demo.service;

import com.example.demo.Repository.MemoRepository;
import com.example.demo.domain.Memo;
import com.example.demo.dto.MemoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor // 꼭 필요한 요소(final) 자동 생성
@Service // 이 클래스가 서비스임을 알려줌
public class MemoService {
    private final MemoRepository memoRepository;

    public Memo setMemo(MemoRequestDto memoRequestDto) {
        Memo memo = new Memo();
        memo.setContent(memoRequestDto.getContent());
        memo.setTitle(memoRequestDto.getTitle());
        memoRepository.save(memo);
        return memo;
    }

    public Memo getMemo(Long id) {
        return memoRepository.findById(id).get();
    }

}