package br.mrc.webback.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.mrc.webback.entities.Product;
import br.mrc.webback.repositories.IProductRepository;

//Registra que essa classe é um servico
@Service
public class ProductService {
	
	@Autowired
	private IProductRepository repository;
	
	public List<Product> findAll(){
		return repository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}
	
}
