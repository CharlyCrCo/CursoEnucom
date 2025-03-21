package com.mx.Clientes.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "CLIENTES")
@Data
public class Clientes {

	@Id
	private Long idCliente;
	private String nombre;
	private String direccion;
	private Long contacto;
	private int tiendaId;

}


	/*
	CREATE TABLE CLIENTES(
		ID_CLIENTE NUMBER,
		NOMBRE NVARCHAR2(100),
		DIRECCION NVARCHAR2(100),
		CONTATO NUMBER,
		TIENDA_ID NUMBER,
		CONSTRAINT ID_CLIENTE_PK PRIMARY KEY (ID_CLIENTE)
	);
 	*/