package com.apititles.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apititles.main.Title;
import com.apititles.repository.TitleRepository;

@Service
public class TitleServices {
	
	@Autowired
	private TitleRepository repository;
	
	
	public List<Title> list() {
		return repository.findAll();
	}
}
