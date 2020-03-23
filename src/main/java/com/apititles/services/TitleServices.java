package com.apititles.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.apititles.main.Title;
import com.apititles.repository.TitleRepository;
import com.apititles.services.exception.TitleNotFoundException;

@Service
public class TitleServices {
	
	@Autowired
	private TitleRepository repository;
	
	
	public List<Title> list() {
		return repository.findAll();
	}
	
	public Optional<Title> search(Long code) {
		 Optional<Title> title  = repository.findById(code);
		
		 if(title.isEmpty() ){			
			throw new TitleNotFoundException("O Título não foi encontrado!");
		}
		return title;
	}
	
	public Title save(Title title) {

		if (title.getCode() != null) {

			Title titles = repository.findById(title.getCode()).orElse(null);

			if (titles != null) {

				throw new TitleNotFoundException("O título já existe!");
			}

		}

		return repository.save(title);
	}

	public void delete(Long code) {

		try {
			this.repository.deleteById(code);
		} catch (EmptyResultDataAccessException e) {

			throw new TitleNotFoundException("O Titulo não pode ser encontrado .");
		}

	}  
	public void update(Title title) {
		checkExist(title);
		repository.save(title);

	}
	
	private void checkExist(Title title) {

		search(title.getCode());

	}
}   