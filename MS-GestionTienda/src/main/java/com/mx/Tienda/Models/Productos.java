package com.mx.Tienda.Models;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class Productos {

	private Long idProducto;
	private String nombre;
	private String descripcion;
	private Double precio;
	private int stock;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date fechaCreacion;
	private int tiendaId;

}