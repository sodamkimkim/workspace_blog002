package com.example.jpa_basic_crud.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity // User 클래스가 자동으로 mysql에 테이블을 생성한다.
public class User {
	
	@Id // db로 따지면 primary key로 설정된다.
	@GeneratedValue(strategy=GenerationType.IDENTITY) // 프로젝트에 연결된 DB의 넘버링 전략을 따라가겠다.
	private int id;
	
	@Column(nullable = false, length = 30, unique = true)
	private String username;
	
	@Column(nullable = false, length=100)
	private String password;
	
	@Column(nullable = false, length = 50)
	private String email;
	
	@Enumerated(EnumType.STRING) // 데이터베이스에서는 스트링으로 알아들음
	private RoleType role; // 지금은 String 이지만 Enum타입 사용 권장 : admin
	
	@CreationTimestamp
	private Timestamp createDate;
}
