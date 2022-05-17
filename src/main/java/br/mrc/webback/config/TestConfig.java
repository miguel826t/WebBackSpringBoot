package br.mrc.webback.config;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import br.mrc.webback.entities.User;
import br.mrc.webback.repositories.IUserRepository;

@Configuration     //Anotation para spring saber que é uma classe de config
@Profile("test")   //Profile - Nome igual está setado no application.properties
@Component
public class TestConfig implements CommandLineRunner{
	
	// Esta anotacao faz o spring fazer a injeção de dependencia automatica
	@Autowired 
	private IUserRepository userRepository;

	//Metodo herdado do CommandLineRunner
	//Executa tudo dentro dele quando a aplicação é rodada
	@Override
	public void run(String... args) throws Exception {
		
		User us1 = new User("1","M da casa C","Mrc@gmail.com","9988224458","123456");
		User us2 = new User("2","R da casa Silva","RS@gmail.com","358486","65448");
		
		userRepository.saveAll(Arrays.asList(us1,us2));		
	}
	
	
}
