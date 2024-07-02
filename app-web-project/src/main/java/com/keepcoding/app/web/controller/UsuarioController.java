package com.keepcoding.app.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.keepcoding.app.web.entity.Usuario;
import com.keepcoding.app.web.service.UsuarioService;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;

    @GetMapping({"/", "/login"})
    public String loginForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("usuario") Usuario usuario, Model model) {
        Usuario user = usuarioService.obtenerUsuarioPorUsername(usuario.getUsername());
        if (user != null && user.getPassword().equals(usuario.getPassword())) {
            return "redirect:/alumnos";
        } else {
            model.addAttribute("error", "Username or password is incorrect");
            return "login";
        }
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "Register"; // Asegúrate de que este nombre coincida con el archivo de la plantilla
    }


    @PostMapping("/register")
    public String register(@ModelAttribute("usuario") Usuario usuario) {
        usuario.setActivo(true);
        usuarioService.guardarUsuario(usuario);
        return "redirect:/login";
    }


}
