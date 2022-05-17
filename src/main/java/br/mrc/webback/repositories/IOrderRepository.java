package br.mrc.webback.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.mrc.webback.entities.Order;

//Quando a interface herdade de JpaRepository já existe uma implementação generica para ser usada
@Repository
public interface IOrderRepository extends JpaRepository<Order, Long> {

	
	
}
