package com.example.curso.model;

import com.example.curso.entity.User;

import java.util.Date;

public class UserObject {

	private Long id;

	private Long comuna;

	private Long afiliacion;

	private String nombre;
	private String apellido;
	private String rut;
	private String email;
	private String password;
	private Integer telefono;
	private String direccion;
	private String role;

	private Date createdAt;

	private Date updatedAt;

	public UserObject(User user) {

		this.id = user.getId();
		this.comuna = user.getComuna();
		this.afiliacion = user.getAfiliacion();
		this.nombre = user.getNombre();
		this.apellido = user.getApellido();
		this.rut = user.getRut();
		this.email = user.getEmail();
		this.telefono = user.getTelefono();
		this.direccion = user.getDireccion();
		this.role = user.getRole();
		this.createdAt = user.getCreatedAt();
		this.updatedAt = user.getUpdatedAt();

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getComuna() {
		return comuna;
	}

	public void setComuna(Long comuna) {
		this.comuna = comuna;
	}

	public Long getAfiliacion() {
		return afiliacion;
	}

	public void setAfiliacion(Long afiliacion) {
		this.afiliacion = afiliacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
}
