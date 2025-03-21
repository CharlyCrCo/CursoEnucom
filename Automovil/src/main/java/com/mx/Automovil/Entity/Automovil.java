package com.mx.Automovil.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Automovil {

	/*
	 * ID_AUTO NUMBER MARCA NVARCHAR2(100 CHAR) SUB_MARCA NVARCHAR2(100 CHAR) MODELO
	 * NUMBER COLOR NVARCHAR2(100 CHAR) PRECIO NUMBER VERSION NVARCHAR2(100 CHAR)
	 */
	@Id
	private Long idAuto;
	private String marca;
	private String subMarca;
	private int modelo;
	private String color;
	private double precio;
	private String version;

}
