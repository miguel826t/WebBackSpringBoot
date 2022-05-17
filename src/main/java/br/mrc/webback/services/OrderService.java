package br.mrc.webback.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.mrc.webback.entities.Order;
import br.mrc.webback.repositories.IOrderRepository;

//Registra que essa classe é um servico
@Service
public class OrderService {
	
	@Autowired
	private IOrderRepository repository;
	
	public List<Order> findAll(){
		return repository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
	
}
