package com.reysl.sweetPetveterinaria.entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;



@Entity
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4951332898804008674L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native") //Valor automático generado y el nativo, es para que use autoincremento de mysql 
	@GenericGenerator(name = "native", strategy = "native")
	private Long id;
	
	@Column
	@NotBlank
	@Size(min=3, message = "Debe ingresar como mínimo 3 caracteres")
	private String nombre;
	
	@Column
	@NotBlank
	@Size(min=3, message = "Debe ingresar como mínimo 3 caracteres")
	private String apellido;
	
	@Column
	@NotBlank
	@Size(min=4, message = "Debe ingresar como mínimo 4 caracteres")
	private String usuario;
	
	@Column
	@NotBlank
	private String email;
	
	@Column
	private String especialidad;
	
	@Column
	@NotBlank
	private String password;
	
	@Transient
	@NotBlank
	private String confirmarPassword;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "usuario_roles",
			joinColumns = @JoinColumn(name = "usuario_id"),
			inverseJoinColumns = @JoinColumn(name = "rol_id")) //busca cual es el Id del objeto rol y lo asigna como clave foranea
	private Set<Rol> rolSet;  // Crea, una colección de roles(sin valores repetidos)
	
	public Usuario() {
		super();
	}

	public Usuario(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
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

	public String getConfirmarPassword() {
		return confirmarPassword;
	}

	public void setConfirmarPassword(String confirmarPassword) {
		this.confirmarPassword = confirmarPassword;
	}

	public Set<Rol> getRol() {
		return rolSet;
	}

	public void setRoleSet(Set<Rol> rolSet) {
		this.rolSet = rolSet;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellido, confirmarPassword, email, id, nombre, password, rolSet, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(apellido, other.apellido) && Objects.equals(confirmarPassword, other.confirmarPassword)
				&& Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(password, other.password)
				&& Objects.equals(rolSet, other.rolSet) && Objects.equals(usuario, other.usuario);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", usuario=" + usuario + ", email="
				+ email + ", password=" + password + ", confirmarPassword=" + confirmarPassword + ", roleSet=" + rolSet
				+ "]";
	}
	
}
