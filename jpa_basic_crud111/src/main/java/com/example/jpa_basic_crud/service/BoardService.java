package com.example.jpa_basic_crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.jpa_basic_crud.dto.BoardSaveRequestDto;
import com.example.jpa_basic_crud.model.Board;
import com.example.jpa_basic_crud.repository.BoardRepository;

@Service
public class BoardService {

	@Autowired
	private BoardRepository boardRepository;

//		@Autowired이거는 밑과 같다.
//	public BoardService(BoardRepository boardRepository) {
//		this.boardRepository = boardRepository;
//	}
	
	
	@Transactional
	public void 글쓰기(BoardSaveRequestDto dto) {
		Board boardEntity = BoardSaveRequestDto.toEntity(dto);
		boardRepository.save(boardEntity);
	}
	
	@Transactional
	public Page<Board> 글목록보기(Pageable pageable) {
		return boardRepository.findAll(pageable);
	}
	
	@Transactional
	public Board 글상세보기(int id) {
		Board board = boardRepository.findById(id).orElseThrow(() -> {
			return new RuntimeException("해당글은 삭제되었습니다.");
			
		});
		// 더티체킹 (조회수 증가)
		board.setReadCount(board.getReadCount()+1);
		return board;
		
	}
	
	@Transactional
	public void 글수정하기(int id, BoardSaveRequestDto dto) {
		Board boardEntity = boardRepository.findById(id).orElseThrow(() -> {
			return new RuntimeException("해당 글은 존재하지 않습니다.");
		});
		
		boardEntity.setTitle(dto.getTitle());
		boardEntity.setContent(dto.getContent());
		
		// boardRepository.save(boardEntity);
		// 이렇게 하지 않고 트랜잭션 처리 --> 글수정하기()메서드가 종료되는 시점에 더티체킹 발생
	}
	
	@Transactional
	public int 글삭제하기(int id) {
//		boardRepository.deleteById(id);//delete from board where id=100; 해보면 무조건 성공나오기 때문에 return -1 or return 1이런거 구분해 줄 필요 없다.
	
		return boardRepository.mDeleteById(id);
	
	}
}
