package com.example.jpa_basic_crud_pr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.jpa_basic_crud_pr.dto.BoardSaveRequestDto;
import com.example.jpa_basic_crud_pr.service.BoardService;

@Controller
public class BoardController {
	@Autowired // 의존주입
	private BoardService boardService;
	
	@PostMapping("/save")
	@ResponseBody
	public String save(@RequestBody BoardSaveRequestDto dto) {
		boardService.글쓰기(dto);
		return "ok";
	}
	
}
