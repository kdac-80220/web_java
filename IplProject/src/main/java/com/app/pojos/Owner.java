package com.app.pojos;

import javax.persistence.*;

@Entity
@Table(name="OwnerInfo")
public class Owner {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ownerId;
	@Column(name="first_name",length=30)
	private String firstName;
	@Column(name="last_name",length=30)
	private String lastName;
	@Column(unique = true,length=50)
	private String email;
	
	
	
	public Owner(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Owner() {
		// TODO Auto-generated constructor stub
	}
	
	public Integer getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Owner [ownerId=" + ownerId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ "]";
	}
	
	
	
}
