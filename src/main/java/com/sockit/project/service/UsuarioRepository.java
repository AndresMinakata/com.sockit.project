package com.sockit.project.service;

import java.util.Optional;
import com.sockit.project.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	@Query("SELECT u FROM Usuario u WHERE u.email =?1") //busca el campo nombre de la tabla y checa si es igual al campo 1(nombre)
	Optional <Usuario> findByEmail(String email);
	
//	@Query("SELECT p FROM Usuario p WHERE p.password =?1")
//	Optional<Usuario> findByPassword(String password);
	
}//interface ProductoRepository
