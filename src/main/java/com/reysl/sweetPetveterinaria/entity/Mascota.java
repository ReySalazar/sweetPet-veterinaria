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
	private String nombreMascota;
	
	@Column
	@NotBlank
	@Size(min=3, message = "Debe ingresar como mínimo 3 caracteres")
	private String nombreDueño;
	
	@Column
	@NotBlank
	@Size(min=8, message = "Debe ingresar como mínimo 8 números")
	private String numeroContacto;

	public Mascota() {
		super();
	}
	
	

	public Mascota(Long id) {
		super();
		this.id = id;
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

	public String getNombreMascota() {
		return nombreMascota;
	}

	public void setNombreMascota(String nombreMascota) {
		this.nombreMascota = nombreMascota;
	}

	public String getNombreDueño() {
		return nombreDueño;
	}

	public void setNombreDueño(String nombreDueño) {
		this.nombreDueño = nombreDueño;
	}

	public String getNumeroContacto() {
		return numeroContacto;
	}

	public void setNumeroContacto(String numeroContacto) {
		this.numeroContacto = numeroContacto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nombreDueño, nombreMascota, numeroContacto, tipo);
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
		return Objects.equals(id, other.id) && Objects.equals(nombreDueño, other.nombreDueño)
				&& Objects.equals(nombreMascota, other.nombreMascota)
				&& Objects.equals(numeroContacto, other.numeroContacto) && Objects.equals(tipo, other.tipo);
	}

	@Override
	public String toString() {
		return "Mascota [id=" + id + ", tipo=" + tipo + ", nombreMascota=" + nombreMascota + ", nombreDueño="
				+ nombreDueño + ", numeroContacto=" + numeroContacto + "]";
	}

}
