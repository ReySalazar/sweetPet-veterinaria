package com.reysl.sweetPetveterinaria.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Mascota implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4787817150281311389L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long id;
	
	@Column
	@NotBlank
	private String tipo;
	
	@Column
	@NotBlank
	private String nombre;
	
	@Column
	@NotBlank
	@Size(min=3, message = "Debe ingresar como mínimo 3 caracteres")
	private String duenio;
	
	@Column
	@NotBlank
	@Size(min=8, message = "Debe ingresar como mínimo 8 números")
	private String contacto;

	public Mascota() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDuenio() {
		return duenio;
	}

	public void setDuenio(String duenio) {
		this.duenio = duenio;
	}

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(contacto, duenio, id, nombre, tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mascota other = (Mascota) obj;
		return Objects.equals(contacto, other.contacto) && Objects.equals(duenio, other.duenio)
				&& Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(tipo, other.tipo);
	}

	@Override
	public String toString() {
		return "Mascota [id=" + id + ", tipo=" + tipo + ", nombre=" + nombre + ", dueño=" + duenio + ", contacto="
				+ contacto + "]";
	}

}
