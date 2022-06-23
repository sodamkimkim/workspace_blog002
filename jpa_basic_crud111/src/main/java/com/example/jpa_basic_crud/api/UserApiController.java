package com.example.jpa_basic_crud.api;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpa_basic_crud.dto.ResponseDto;
import com.example.jpa_basic_crud.model.RoleType;
import com.example.jpa_basic_crud.model.User;
import com.example.jpa_basic_crud.service.UserService;

@RestController
public class UserApiController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private HttpSession session;

	// 회원가입할 때 사용
	@PostMapping("api/user/join")
	public ResponseDto<Integer> join(@RequestBody User user) {
		System.out.println("UserApiController에서 join함수 호출 됨.");
		user.setRole(RoleType.USER);
		int result = userService.joinUser(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), result);
	}
	
	// 로그인할 때 사용
	// ../blogcrud/api/user/login
	@PostMapping("/api/user/login")
	public ResponseDto<Integer> login(@RequestBody User user){
		System.out.println("UserApiController에서 login함수 호출 됨.");
		// 서비스한테 이 user가 데이터베이스에 있는지 확인해달라고 요청해야함.
		// principal은 접근 주체라는 의미로 사용.
		User principal = userService.login(user);
		//접근 주체가 정상적으로 username, password 확인! (세션이라는 거대한 메모리에 저장)
		if(principal != null) {
			session.setAttribute("principal", principal); // 세션에 값 저장할 때 "키", 밸류 형식으로 저장한다.
			System.out.println("세션 정보가 저장되었습니다.");
			return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);

		}else {
			return null;			
		}
		
	}
}
