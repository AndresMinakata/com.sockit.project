package com.sockit.project.service;

import java.util.List;
import java.util.Optional;
import com.sockit.project.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
private final UsuarioRepository usuarioRepository;
@Autowired
public UsuarioService(UsuarioRepository usuarioRepository) {
	super();
	this.usuarioRepository = usuarioRepository;
}//Constructor

public List<Usuario> getUsuarios() {
	return usuarioRepository.findAll();
}//getAllUsuarios

public Usuario getUsuario(Long Id) {
	return usuarioRepository.findById(Id).orElseThrow(
			()-> new IllegalArgumentException("El usuario con el id"+ Id +"No existe")
			);
}//getUsuarioById

public Usuario deleteUsuario(Long Id) {
	Usuario tmpUser = null;
	if (usuarioRepository.existsById(Id)){
		tmpUser = usuarioRepository.findById(Id).get();
		usuarioRepository.deleteById(Id);
	}//if
	return tmpUser;
}//deleteUsuario

public Usuario addUsuario(Usuario usuario) {
	Usuario tmpUser = null;
	Optional<Usuario> userByEmail = usuarioRepository.findByEmail(usuario.getEmail());
	
	if (userByEmail.isPresent()) {
		throw new IllegalArgumentException("El email: ["+usuario.getEmail()+"] ya esta registrado");
	} else {
		usuarioRepository.save(usuario);	
		tmpUser = usuario;
	}//if & else
	return tmpUser;
}//addUsuario

public Usuario updateUsuario(Long Id, String email, String password) {
	Usuario tmpUser = null;
	if (usuarioRepository.existsById(Id)){
		tmpUser = usuarioRepository.findById(Id).get();
		if(email!=null) tmpUser.setEmail(email);
		if(password!=null) tmpUser.setPassword(password);
		usuarioRepository.save(tmpUser);
	} else {
		System.out.println("El usuario con el id"+ Id +"No existe");
	}//if
	return tmpUser;
}//UpdateUsuario

//public Usuario LoginUsuario(Usuario usuario) {
//	Usuario tmpUser = null;
//	Optional<Usuario> userByEmail = usuarioRepository.findByEmail(usuario.getEmail());
//	Optional<Usuario> userByPassword = usuarioRepository.findByPassword(usuario.getPassword());
//	
//	if (!userByEmail.isPresent() || !userByPassword.isPresent()) {
//		throw new IllegalArgumentException("Error - Usuario incorrecto");
//	} else {
//		usuarioRepository.save(usuario);	
//		tmpUser = usuario;
//	}//if & else
//	return tmpUser;
//}//LoginUsuario


}//class usuarioService
