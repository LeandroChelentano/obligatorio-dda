package com.obligatorio.dda.entity;

import java.time.LocalDateTime;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table (name = "planes")
public class PlanViaje extends Base {
	
	@Column (length = 50)
	private String Destino;
	
	@Column (name="Fecha")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime Fecha;
	
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

	public LocalDateTime getFecha() {
		return this.Fecha;
	}

	public void setFecha(LocalDateTime Fecha) {
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

	public PlanViaje(String Destino, LocalDateTime Fecha, String Modalidad, int Precio) {
		this.Destino = Destino;
		this.Fecha = Fecha;
		this.Modalidad = Modalidad;
		this.Precio = Precio;
	}
}
