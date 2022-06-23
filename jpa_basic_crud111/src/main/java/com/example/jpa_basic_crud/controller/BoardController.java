package com.example.jpa_basic_crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.jpa_basic_crud.dto.BoardSaveRequestDto;
import com.example.jpa_basic_crud.model.Board;
import com.example.jpa_basic_crud.service.BoardService;

@Controller
public class BoardController {

	@Autowired // 의존주입
	private BoardService boardService;

	// http://http://localhost:9090/list?page=1
	@GetMapping({ "", "/", "list" })
	// Pageable data domain들고와야함
	public String list(@PageableDefault(size = 3, sort = "id", direction = Direction.DESC) Pageable pageable,
			Model model) {
		// 서비스 객체에 접근해서 목록 가져와야 한다.
		Page<Board> boards = boardService.글목록보기(pageable);
		System.out.println(boards.toString());
		model.addAttribute("boards", boards);
		return "list"; // list.jsp파일을 만들거다.
	}

	// http://localhost:9090/listPage
	// http://localhost:9090/listPage?page=0
	// http://localhost:9090/listPage?page=1
	// http://localhost:9090/listPage?page=2
	// ..등
	@GetMapping("/listPage")
	@ResponseBody
	// Pageable data domain들고와야함
	public Page<Board> listPage(@PageableDefault(size = 1, sort = "id", direction = Direction.DESC) Pageable pageable,
			Model model) {
		// 서비스 객체에 접근해서 목록 가져와야 한다.
		Page<Board> boards = boardService.글목록보기(pageable);
		System.out.println(boards.toString());
		model.addAttribute("boards", boards);
		return boards;
	}

	@GetMapping("/save_form")
	public String saveForm() {

		return "saveForm";
	}

	@PostMapping("/save")
	@ResponseBody
	public String save(@RequestBody BoardSaveRequestDto dto) { // title, content 넘어온다.
		// 서비스 객체로 가서 DB저장 요청 해야 함
		System.out.println("save함수에서 받은 dto입니다 : "+dto);
		boardService.글쓰기(dto);
		return "ok";
	}

	@GetMapping("/board/{id}")
	public String detail(@PathVariable int id, Model model) {
		// 서비스에 가서 데이터 가져오기
		model.addAttribute("board", boardService.글상세보기(id));
		return "detail";
	}

	@GetMapping("/updateForm/{id}")
	public String updateForm(@PathVariable int id, Model model) {
		Board board = boardService.글상세보기(id);
		model.addAttribute("board", board); // key값 "board"
		return "updateForm";
	}
	// 글 수정하는 주소 설계
	// 스프링의 기본 파싱전략은 key=value
	// 근데 우리는 Json으로 받음. 키벨류로 변환하려고 @RequestBody써야함. 애초에 키밸류로 받는다고 하면 매개변수에 String
	// title, String content들어감

	@PutMapping("/board/{id}")
	@ResponseBody // @Controller 쓸 때, 데이터를 리턴하고 싶으면 이것도 적어줘야 한다.
	public String updateBoard(@PathVariable int id, @RequestBody BoardSaveRequestDto dto) { // 메시지 컨버터가 자동으로 파싱해서 오브젝트로
																							// 만들어 준다.
		boardService.글수정하기(id, dto);
		return "ok";
	}

	@DeleteMapping("/board/{id}")
	@ResponseBody
	public boolean deleteBoard(@PathVariable int id) {
		return boardService.글삭제하기(id) == 1 ? true : false;
	}

}
