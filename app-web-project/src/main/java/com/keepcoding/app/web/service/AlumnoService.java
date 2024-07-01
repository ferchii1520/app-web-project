package com.keepcoding.app.web.service;

import java.util.List;

import com.keepcoding.app.web.entity.Alumno;

public interface AlumnoService {
	
	public List<Alumno> listarAlumnos();
	public Alumno guardarAlumno(Alumno alumno);
	public Alumno obtenerAlumno(Long id);
	public Alumno actualizarAlumno(Alumno alumno);
	public void eliminarAlumno(Long id);

}
