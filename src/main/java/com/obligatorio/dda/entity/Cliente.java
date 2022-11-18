package com.obligatorio.dda.entity;

import java.util.*;
import javax.persistence.*;

@Entity
@Table (name = "clientes")
public class Cliente extends Base {

	@Column (nullable = false, length = 50)
	private String Nombre;
	
	@Column (nullable = false, length = 50)
	private String Apellido;

	@Column (nullable = false, length = 30, unique = true)
	private String Email;

	@Column (nullable = false, unique = true)
	private int CI;
	
	@Column (columnDefinition = "default(False)")
	private boolean isPremium;

	@ManyToMany(cascade = CascadeType.REFRESH)
	private List<PlanViaje> PlanesComprados = new ArrayList<PlanViaje>(); 
	
	//#region Getters-Setters
	public String getNombre() {
		return this.Nombre;
	}

	public void setNombre(String nombre) {
		this.Nombre = nombre;
	}

	public String getApellido() {
		return this.Apellido;
	}

	public void setApellido(String apellido) {
		this.Apellido = apellido;
	}

	public String getEmail() {
		return this.Email;
	}

	public void setEmail(String email) {
		this.Email = email;
	}

	public boolean isPremium() {
		return this.isPremium;
	}

	public void setIsPremium(boolean isPremium) {
		this.isPremium = isPremium;
	}
	//#endregion

	public Cliente() { }

	public Cliente(String Nombre, String Apellido, String Email, boolean isPremium) {
		this.Nombre = Nombre;
		this.Apellido = Apellido;
		this.Email = Email;
		this.isPremium = isPremium;
	}
}
