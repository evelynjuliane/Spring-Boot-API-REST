package com.apititles.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apititles.main.Title;

public interface TitleRepository extends JpaRepository<Title, Long>{
	
	public List<Title> findBycodeContaining(String code);
	
}
