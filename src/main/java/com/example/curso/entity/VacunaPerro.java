package com.example.curso.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="vacunas_perro")
public class VacunaPerro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	@Column(name="id_perro")
	private Long perro;

	@Column(name="id_vacuna")
	private Long vacuna;

	@Column(name="fecha_vacuna")
	private Date fechaVacuna;

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

	public Long getPerro() {
		return perro;
	}

	public Long getVacuna() {
		return vacuna;
	}

	public void setVacuna(Long vacuna) {
		this.vacuna = vacuna;
	}

	public void setPerro(Long perro) {
		this.perro = perro;
	}

	public Date getFechaVacuna() {
		return fechaVacuna;
	}

	public void setFechaVacuna(Date fechaVacuna) {
		this.fechaVacuna = fechaVacuna;
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
