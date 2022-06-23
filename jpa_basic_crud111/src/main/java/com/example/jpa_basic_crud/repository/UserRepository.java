package com.example.jpa_basic_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpa_basic_crud.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	// spring JPA네이밍 전략
	// prepare statement
	// SELECT * FROM user WHERE username = ?1 AND password = ?2;
	User findByUsernameAndPassword(String username, String password); //user테이블에 대해서 위의 쿼리 자동으로 만들어줌.
	
	// 두번째 방법 - native query사용
//	@Query(value = "SELECT * FROM user WHERE username = ?1 AND password = ?2;")
//	User login();
}
