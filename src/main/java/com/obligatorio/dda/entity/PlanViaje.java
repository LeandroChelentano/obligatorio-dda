package com.obligatorio.dda.entity;

import javax.persistence.*;

import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table (name = "planes")
public class PlanViaje extends Base {
	@Column (length = 50)
	private String Destino;
	
	@Column (name="Fecha")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate Fecha;
	
	@Column (nullable = false, length = 20)
	private String Modalidad;
	
	@Column (nullable = false)
	private int Precio;
	
	//#region Getters-Setters
	public String getDestino() {
		return this.Destino;
	}

	public void setDestino(String Destino) {
		this.Destino = Destino;
	}

	public String getModalidad() {
		return this.Modalidad;
	}

	public void setModalidad(String Modalidad) {
		this.Modalidad = Modalidad;
	}

	public LocalDate getFecha() {
		return this.Fecha;
	}

	public void setFecha(LocalDate Fecha) {
		this.Fecha = Fecha;
	}

	public int getPrecio() {
		return this.Precio;
	}

	public void setPrecio(int Precio) {
		this.Precio = Precio;
	}
	//#endregion

	public PlanViaje() {}

	public PlanViaje(String Destino, LocalDate Fecha, String Modalidad, int Precio) {
		this.Destino = Destino;
		this.Fecha = Fecha;
		this.Modalidad = Modalidad;
		this.Precio = Precio;
	}
}
