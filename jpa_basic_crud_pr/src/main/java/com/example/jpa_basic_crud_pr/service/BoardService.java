package com.example.jpa_basic_crud_pr.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jpa_basic_crud_pr.dto.BoardSaveRequestDto;
import com.example.jpa_basic_crud_pr.model.Board;
import com.example.jpa_basic_crud_pr.repository.BoardRepository;

@Service
public class BoardService {
	@Autowired // 의존주입. 생성과 동시에 초기화
	private BoardRepository boardRepository;
	
//	//@Autowired는 밑과 같다.
//	public BoardService (BoardRepository boardRepository) {
//		this.boardRepository=boardRepository;
//	}
	
	@Transactional
	public void 글쓰기(BoardSaveRequestDto dto) {
		Board boardEntity = BoardSaveRequestDto.toEntity(dto);
		boardRepository.save(boardEntity);
	}
	
}
