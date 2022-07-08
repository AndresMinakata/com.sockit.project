package com.sockit.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {
	@Id
	@GeneratedValue (strategy =GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	    private Long id;
    @Column(name="email", nullable = false)
		private String email;
		private String password;
		

		public Usuario(Long id, String email, String password) {
			super();
			this.id = id;
			this.email = email;
			this.password = password;
		
		}//constructor
		
		public Usuario() {
		}//Usuario
		
		public Long getId() {
			return id;
		}//getId

		public String getEmail() {
			return email;
		}//getEmail	

		public void setEmail(String email) {
			this.email = email;
		}//setEmail

		public String getPassword() {
			return password;
		}//getPassword

		public void setPassword(String password) {
			this.password = password;
		}//setPassword

		@Override
		public String toString() {
			return "Usuario [id=" + id + ", email=" + email + ", password=" + password + "]";
		}//toString

	
	
	}//Usuario


