package com.empresa.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "proveedor")
public class Proveedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProveedor;
	private String nombre;
	private String dni;
	private Date fechaRegistro;
	
	@ManyToOne//Para indicar la relacion 
	@JoinColumn(name = "idTipo")//la llave foranea
	private Tipo tipo;//todo el objeto
	
	
	@ManyToOne//Para indicar la relacion 
	@JoinColumn(name = "idPais")//la llave foranea
	private Pais pais;//todo el objeto
	
}