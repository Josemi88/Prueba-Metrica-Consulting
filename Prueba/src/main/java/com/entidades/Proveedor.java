package com.entidades;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="proveedores")
public class Proveedor implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	
	
	private String nombre;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="Fecha_De_Alta")
	private Date fechaAlta;

	@Column(name="Id_Cliente")
	private int idCliente;

	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public Date getFechaAlta() {
		return fechaAlta;
	}



	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}



	public int getIdCliente() {
		return idCliente;
	}



	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public Proveedor(int id, String nombre, Date fechaAlta, int idCliente) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fechaAlta = fechaAlta;
		this.idCliente = idCliente;
	}



	public Proveedor() {
		// TODO Auto-generated constructor stub
	}


}
