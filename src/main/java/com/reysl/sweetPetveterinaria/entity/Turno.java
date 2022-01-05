package com.reysl.sweetPetveterinaria.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Turno implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6491480068797639525L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long id;
	
	@Column
	@NotBlank
	private String mascotaCliente;
	
	@Column
	@NotBlank
	private String fecha;
	
	@Column
	@NotBlank
	private String horaInicio;
	
	@Column
	@NotBlank
	private String horaFinal;
	
	@Column
	@NotBlank
	private String especialidad;
	
	@Column
	@NotBlank
	private String veterinario;

	public Turno() {
		super();
	}

	public Turno(Long id) {
		super();
		this.id = id;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(String horaFinal) {
		this.horaFinal = horaFinal;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getVeterinario() {
		return veterinario;
	}

	public void setVeterinario(String veterinario) {
		this.veterinario = veterinario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(especialidad, fecha, horaFinal, horaInicio, id, veterinario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Turno other = (Turno) obj;
		return Objects.equals(especialidad, other.especialidad) && Objects.equals(fecha, other.fecha)
				&& Objects.equals(horaFinal, other.horaFinal) && Objects.equals(horaInicio, other.horaInicio)
				&& Objects.equals(id, other.id) && Objects.equals(veterinario, other.veterinario);
	}

	@Override
	public String toString() {
		return "Turno [id=" + id + ", fecha=" + fecha + ", horaInicio=" + horaInicio + ", horaFinal=" + horaFinal
				+ ", especialidad=" + especialidad + ", veterinario=" + veterinario + "]";
	}

}
