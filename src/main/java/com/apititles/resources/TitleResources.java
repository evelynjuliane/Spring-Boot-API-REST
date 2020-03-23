package com.apititles.resources;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	//GET
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Title>> Get() {
		List<Title> titles = services.list();
		return ResponseEntity.status(HttpStatus.OK).body(titles);
	}
	//GET (ID)
	
	@RequestMapping(value = "/{code}",method = RequestMethod.GET)
	public ResponseEntity<Optional<Title>> GET (@PathVariable("code") Long code){
		
		return ResponseEntity.status(HttpStatus.OK).body(services.search(code));
		
	}
 

	//POST
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> POST(@Valid @RequestBody Title title) {
		services.save(title);
		return null;
	}
	//DELETE
	@RequestMapping(value = "/{code}" ,method = RequestMethod.DELETE)
	public ResponseEntity<Void> DELETE (@PathVariable("code") Long code) {
			
		this.services.delete(code);
		
		return ResponseEntity.noContent().build();
		
	}
	//PUT
	@RequestMapping(value = "/{code}" ,method = RequestMethod.PUT)
	public ResponseEntity<Void> PUT (@RequestBody Title title, @PathVariable("code") Long code) {
		title.setCode(code);
		
		
		services.update(title);
		return ResponseEntity.noContent().build();
		
	}
}
