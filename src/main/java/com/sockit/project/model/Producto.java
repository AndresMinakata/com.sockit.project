package com.sockit.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="producto")
public class Producto {
	@Id
	@GeneratedValue (strategy =GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	    private Long id;
	    @Column(name="nombre", nullable = false)
		private String nombre;
		private String descripcion;
		@Column(name="url_imagen")
		private String URL_imagen;
		private double precio;
		

		public Producto(Long id, String nombre, String descripcion, String uRL_imagen, double precio) {
			super();
			this.id = id;
			this.nombre = nombre;
			this.descripcion = descripcion;
			this.URL_imagen = uRL_imagen;
			this.precio = precio;
		
		}//constructor
		
		public Producto() {
		}//Producto
		
		public Long getId() {
			return id;
		}//getId
		public String getNombre() {
			return nombre;
		}//getNombre
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}//setNombre
		public String getDescripcion() {
			return descripcion;
		}//getDescripcion
		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}//setDescripcion
		public String getURL_imagen() {
			return URL_imagen;
		}//getURL_imagen
		public void setURL_imagen(String uRL_imagen) {
			URL_imagen = uRL_imagen;
		}//setURL_imagen
		public double getPrecio() {
			return precio;
		}//getPrecio
		public void setPrecio(double precio) {
			this.precio = precio;
		}//setPrecio

		@Override
		public String toString() {
			return "Producto [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", URL_imagen="
					+ URL_imagen + ", precio=" + precio + "]";
		}
	
	}//Producto


