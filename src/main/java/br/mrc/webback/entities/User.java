package br.mrc.webback.entities;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String usId;
	private String usName;
	private String usEmail;
	private String usFone;
	private String usPass;
	
	public User() {}

	public User(String usId, String usName, String usEmail, String usFone, String usPass) {
		super();
		this.usId = usId;
		this.usName = usName;
		this.usEmail = usEmail;
		this.usFone = usFone;
		this.usPass = usPass;
	}

	
	//HastCode ID------------------
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
	public String getUsId() {
		return usId;
	}
	
	public void setUsId(String usId) {
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
