package br.mrc.webback.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import br.mrc.webback.entities.Category;
import br.mrc.webback.entities.Order;
import br.mrc.webback.entities.Product;
import br.mrc.webback.entities.User;
import br.mrc.webback.entities.enums.OrderStatus;
import br.mrc.webback.repositories.ICategoryRepository;
import br.mrc.webback.repositories.IOrderRepository;
import br.mrc.webback.repositories.IProductRepository;
import br.mrc.webback.repositories.IUserRepository;

@Configuration     //Anotation para spring saber que é uma classe de config
@Profile("test")   //Profile - Nome igual está setado no application.properties
@Component
public class TestConfig implements CommandLineRunner{
	
	// Esta anotacao faz o spring fazer a injeção de dependencia automatica
	@Autowired 
	private IUserRepository userRepository;
	
	@Autowired
	private IOrderRepository orderRepository;
	
	@Autowired
	private ICategoryRepository categoryRepository;
	
	@Autowired
	private IProductRepository productRepository;

	//Metodo herdado do CommandLineRunner
	//Executa tudo dentro dele quando a aplicação é rodada
	@Override
	public void run(String... args) throws Exception {
		
		User us1 = new User("1","M da casa C","Mrc@gmail.com","9988224458","123456");
		User us2 = new User("2","R da casa Silva","RS@gmail.com","358486","65448");
		userRepository.saveAll(Arrays.asList(us1,us2));		
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"),OrderStatus.CANCELED, us1); 
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"),OrderStatus.DELIVERED, us2); 
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"),OrderStatus.PAID, us1); 
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));		
		
		Category cat1 = new Category(null, "Electronics"); 
		Category cat2 = new Category(null, "Books"); 
		Category cat3 = new Category(null, "Computers"); 
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));	
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, ""); 
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, ""); 
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, ""); 
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, ""); 
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat1);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p2.getCategories().add(cat2);
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
	}
	
	
}
