package com.example.curso.entity;


import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name="razas")
public class Raza implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	@Column(name="nombre_raza")
	private String nombreRaza ;

	@Column(name="descripcion")
	private String descripcion;

	@Column(name="origen")
	private String origen;

	@Column(name="expectativa_vida")
	private String expectativaVida;

	@Column(name="comidas_contradictorias")
	private String comidasContradictorias;

	@Column(name="photo")
	private String photo;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreRaza() {
		return nombreRaza;
	}

	public void setNombreRaza(String nombreRaza) {
		this.nombreRaza = nombreRaza;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getExpectativaVida() {
		return expectativaVida;
	}

	public void setExpectativaVida(String expectativaVida) {
		this.expectativaVida = expectativaVida;
	}

	public String getComidasContradictorias() {
		return comidasContradictorias;
	}

	public void setComidasContradictorias(String comidasContradictorias) {
		this.comidasContradictorias = comidasContradictorias;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
}
