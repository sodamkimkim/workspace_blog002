package com.example.jpa_basic_crud.dto;

import com.example.jpa_basic_crud.model.Board;

import lombok.Data;

@Data
public class BoardSaveRequestDto {
	private String title;
	private String content;

	// 한 단계 추가.
	// 이 dto를 entity로 바꿔주는 메서드
	public static Board toEntity(BoardSaveRequestDto dto) {
		Board boardEntity = Board.builder()
				.title(dto.getTitle())
				.content(dto.getContent())
				.build();
		return boardEntity;
	}
	
}
