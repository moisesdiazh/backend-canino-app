package com.example.curso.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="servicios")
public class Servicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	@Column(name="id_comuna")
	private Long comuna;

	@Column(name="id_afiliacion")
	private Long afiliacion;

	@Column(name="nombre_servicio")
	private String nombreServicio;

	@Column(name="telefono")
	private Integer telefono;

	@Column(name="email")
	private String email;

	@Column(name="direccion")
	private String direccion;

	@Column(name="fecha_solicitud")
	@Temporal(TemporalType.DATE)
	private Date fechaSolicitud;

	@Column(name="estado")
	private String estado;

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

	public String getNombreServicio() {
		return nombreServicio;
	}

	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(Date fecha_solicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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
