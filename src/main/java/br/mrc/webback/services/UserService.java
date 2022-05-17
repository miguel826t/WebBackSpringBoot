package br.mrc.webback.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.mrc.webback.entities.User;
import br.mrc.webback.repositories.IUserRepository;

//Registra que essa classe é um servico
@Service
public class UserService {
	
	@Autowired
	private IUserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
	
}
