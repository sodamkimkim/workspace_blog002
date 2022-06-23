package com.example.jpa_basic_crud.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.jpa_basic_crud.model.Board;


public interface BoardRepository extends JpaRepository<Board, Integer> {

	// 서브쿼리같은거 쓰고 싶을 때 네이티브 쿼리 씀
	@Query(value="SELECT * FROM board WHERE id = :id", nativeQuery = true)
	Optional<Board> mFindById(int id);
	
	
	@Modifying //수정, 삭제, 저장할 때 붙여야함.
	@Query(value = "DELETE FROM board WHERE id = :id", nativeQuery = true) // :id하면 Board에서 넘어오는 id가 셋팅된다.
	int mDeleteById(int id);
}
