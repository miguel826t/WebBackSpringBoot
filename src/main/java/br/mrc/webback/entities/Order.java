package br.mrc.webback.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long odId;
	
	//Formata o Json para Data UTC
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant odmoment;
	
	//Criando relação com o cliente
	//Um cliente pode ter varios pedidos
	//Como estamos na classe pedido então é MuitosParaUm
	@ManyToOne
	@JoinColumn(name = "client_id")
	private User client;
	
	public Order() {}

	public Order(Long odId, Instant odmoment, User client) {
		super();
		this.odId = odId;
		this.odmoment = odmoment;
		this.client = client;
	}

	
	//--HasCode and Equals do Id-----------------------------
	@Override
	public int hashCode() {
		return Objects.hash(odId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(odId, other.odId);
	}

	//Gets and Sets --------------
	public Long getOdId() {
		return odId;
	}

	public void setOdId(Long odId) {
		this.odId = odId;
	}

	public Instant getOdMoment() {
		return odmoment;
	}

	public void setOdMoment(Instant moment) {
		this.odmoment = moment;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}
	
	
}