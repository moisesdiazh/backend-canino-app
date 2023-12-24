package com.example.curso.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="users")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	@Column(name="id_comuna")
	private Long comuna;

	@Column(name="id_afiliado")
	private Long afiliacion;

	@Column(name="nombre")
	private String nombre;

	@Column(name="apellido")
	private String apellido;

	@Column(name="rut")
	private String rut;

	@Column(name="email", length = 60, unique = true)
	private String email;

	@Column(name="password")
	private String password;

	@Column(name="telefono")
	private Integer telefono;

	@Column(name="direccion")
	private String direccion;

	@Column(name="role")
	private String role;

	@Column(name="created_at")
	@Temporal(TemporalType.DATE)
	private Date createdAt;

	@Column(name="updated_at")
	@Temporal(TemporalType.DATE)
	private Date updatedAt;


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
