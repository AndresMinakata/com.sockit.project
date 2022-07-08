package com.sockit.project.controller;
import com.sockit.project.service.UsuarioService;
import com.sockit.project.model.Usuario;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path="/api/users/register/")
public class UsuarioController {
private final UsuarioService usuarioService;

@Autowired
public UsuarioController(UsuarioService usuarioService) {
	super();
	this.usuarioService = usuarioService;
}//constructor

//CRUD
@GetMapping
public List<Usuario> getAllUsuarios(){
	return usuarioService.getUsuarios();
}//getAllUsers

@GetMapping(path= "{prodId}")
public Usuario getUsuario(@PathVariable("prodId") Long Id){
	return usuarioService.getUsuario(Id);
}//getUsersbyId

@DeleteMapping(path= "{prodId}")
public Usuario deleteUsuario(@PathVariable("prodId") Long Id){
	return usuarioService.deleteUsuario(Id);
}//DeleteUsersbyId

@PutMapping(path= "{prodId}")
public Usuario updateUsuario(@PathVariable("prodId") Long id, 
		@RequestParam (required = false)String email,
		@RequestParam (required = false)String password) {
	return usuarioService.updateUsuario(id, email, password);
}//UpdateUsers

@PostMapping
public Usuario addUsuario(@RequestBody Usuario usuario){
	return usuarioService.addUsuario(usuario);
}//PostUsers

}//class UsuarioController


