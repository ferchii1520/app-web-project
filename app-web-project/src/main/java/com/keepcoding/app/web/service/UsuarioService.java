package com.keepcoding.app.web.service;

import org.springframework.stereotype.Service;

import com.keepcoding.app.web.entity.Usuario;

@Service
public interface UsuarioService {

	public Usuario guardarUsuario(Usuario usuario);
	public Usuario obtenerUsuarioPorUsername(String username);
	
}
