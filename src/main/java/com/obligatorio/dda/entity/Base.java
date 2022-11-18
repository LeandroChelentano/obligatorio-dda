package com.obligatorio.dda.entity;

import java.io.Serializable;

import javax.persistence.*;

@MappedSuperclass
public class Base implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	//#region Getters-Setters
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}
	//#endregion
}
