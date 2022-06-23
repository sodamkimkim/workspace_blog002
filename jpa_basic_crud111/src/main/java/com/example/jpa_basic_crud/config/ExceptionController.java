package com.example.jpa_basic_crud.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class ExceptionController {
	
	@ExceptionHandler(value = Exception.class)
	public String 모든오류(Exception e) {
		System.out.println("모든 오류 메서드 실행()!!!");
		return e.getMessage();
	}
}
