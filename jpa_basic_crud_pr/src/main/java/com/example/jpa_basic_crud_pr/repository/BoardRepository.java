package com.example.jpa_basic_crud_pr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpa_basic_crud_pr.model.Board;

public interface BoardRepository extends JpaRepository<Board, Integer>{

}
