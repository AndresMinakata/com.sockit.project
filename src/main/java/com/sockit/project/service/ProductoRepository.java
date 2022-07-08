package com.sockit.project.service;

import java.util.Optional;
import com.sockit.project.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
	@Query("SELECT p FROM Producto p WHERE p.nombre =?1") //busca el campo nombre de la tabla y checa si es igual al campo 1(nombre)
	Optional <Producto> findByNombre(String nombre);
	
}//interface ProductoRepository
