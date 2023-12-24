package com.example.curso.entity;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="perros")
public class Perro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	@Column(name="id_usuario")
	private Long usuario;

	@Column(name="id_raza")
	private Long raza;

	@Column(name="nombre_canino")
	private String nombreCanino;

	@Column(name="edad")
	private int edad;

	@Column(name="chip")
	private String chip;

	@Column(name="tamanno")
	private String tamanno;

	@Column(name="actividad")
	private String actividad;

	@Column(name="sexo")
	private String sexo;

	@Column(name="peso")
	private Float peso;

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

	public Long getUsuario() {
		return usuario;
	}

	public void setUsuario(Long usuario) {
		this.usuario = usuario;
	}

	public Long getRaza() {
		return raza;
	}

	public void setRaza(Long raza) {
		this.raza = raza;
	}

	public String getNombreCanino() {
		return nombreCanino;
	}

	public void setNombreCanino(String nombreCanino) {
		this.nombreCanino = nombreCanino;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getChip() {
		return chip;
	}

	public void setChip(String chip) {
		this.chip = chip;
	}

	public String getTamanno() {
		return tamanno;
	}

	public void setTamanno(String tamanno) {
		this.tamanno = tamanno;
	}

	public String getActividad() {
		return actividad;
	}

	public void setActividad(String actividad) {
		this.actividad = actividad;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Float getPeso() {
		return peso;
	}

	public void setPeso(Float peso) {
		this.peso = peso;
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
