package com.mx.Productos.Entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "PRODUCTOS")
@Data
public class Productos {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ID_PRODUCTO")
	@SequenceGenerator(name = "SEQ_ID_PRODUCTO", sequenceName = "S_ID_PRODUCTO", allocationSize = 1)
	private Long idProducto;
	private String nombre;
	private String descripcion;
	private Double precio;
	private int stock;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date fechaCreacion;
	private int tiendaId;

}

/*
 * 
 * CREATE TABLE PRODUCTOS( ID_PRODUCTO NUMBER, NOMBRE NVARCHAR2(100),
 * DESCRIPCION NVARCHAR2(150), PRECIO NUMBER(12, 2), STOCK NUMBER,
 * FECHA_CREACION DATE, CONSTRAINT ID_PRODUCTO_PK PRIMARY KEY (ID_PRODUCTO) );
 * 
 */