package com.example.curso.model;

import com.example.curso.entity.Perro;

import java.util.Date;

public class PerroObject {

	private Long id;
	private Long usuario;
	private Long raza;
	private String nombreCanino;
	private int edad;
	private String chip;
	private Date createdAt;
	private Date updatedAt;

	public PerroObject(Perro perro) {

		this.id = perro.getId();
		this.usuario = perro.getUsuario();
		this.raza = perro.getRaza();
		this.nombreCanino = perro.getNombreCanino();
		this.edad = perro.getEdad();
		this.chip = perro.getChip();
		this.createdAt = perro.getCreatedAt();
		this.updatedAt = perro.getUpdatedAt();

	}

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
