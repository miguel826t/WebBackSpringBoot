package br.mrc.webback.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.hibernate.annotations.IdGeneratorType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


//Marcação para o spring mapear essa entidade
@Entity
@Table(name = "tb_user")
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long usId;
	
	private String usName;
	private String usEmail;
	private String usFone;
	private String usPass;
	
	//Mapeamento do muitos pedidos
	@OneToMany(mappedBy = "client")
	@JsonIgnore
	private List<Order> orders = new ArrayList<Order>();
	
	public User() {}

	public User(Long usId, String usName, String usEmail, String usFone, String usPass) {
		super();
		this.usId = usId;
		this.usName = usName;
		this.usEmail = usEmail;
		this.usFone = usFone;
		this.usPass = usPass;
	}

	
	//Orders ,HastCode ID------------------
	public List<Order> getOrders() {
		return orders;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(usId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(usId, other.usId);
	}

	//Gets and Sets-----------------------------------
	public Long getUsId() {
		return usId;
	}
	
	public void setUsId(Long usId) {
		this.usId = usId;
	}

	public String getUsName() {
		return usName;
	}

	public void setUsName(String usName) {
		this.usName = usName;
	}

	public String getUsEmail() {
		return usEmail;
	}

	public void setUsEmail(String usEmail) {
		this.usEmail = usEmail;
	}

	public String getUsFone() {
		return usFone;
	}

	public void setUsFone(String usFone) {
		this.usFone = usFone;
	}

	public String getUsPass() {
		return usPass;
	}

	public void setUsPass(String usPass) {
		this.usPass = usPass;
	}

}
