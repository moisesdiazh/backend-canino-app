package com.example.curso.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="afiliaciones")
public class Afiliacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	@Column(name="id_usuario")
	private Long usuario;

	@Column(name="tipo_afiliacion")
	private String tipoAfiliacion;

	@Column(name="is_active")
	private Boolean isActive;

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

	public String getTipoAfiliacion() {
		return tipoAfiliacion;
	}

	public void setTipoAfiliacion(String tipoAfiliacion) {
		this.tipoAfiliacion = tipoAfiliacion;
	}

	public Boolean getActive() {
		return isActive;
	}

	public void setActive(Boolean active) {
		isActive = active;
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
