package br.mrc.webback.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.mrc.webback.entities.Category;
import br.mrc.webback.repositories.ICategoryRepository;

//Registra que essa classe é um servico
@Service
public class CategoryService {
	
	@Autowired
	private ICategoryRepository repository;
	
	public List<Category> findAll(){
		return repository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}
	
}
