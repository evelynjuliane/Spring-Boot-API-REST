package com.apititles.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apititles.main.Title;
import com.apititles.services.TitleServices;

@RestController
@RequestMapping("/titles")
public class TitleResources {
	
	@Autowired
	private TitleServices services;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Title>> Get() {
		List<Title> titles = services.list();
		return ResponseEntity.status(HttpStatus.OK).body(titles);
	}
}
