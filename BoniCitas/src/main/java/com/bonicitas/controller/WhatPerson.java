package com.bonicitas.controller;

import java.sql.Date;

public class WhatPerson {
	/*
	"IdUsuario", "Nombres", "APaterno", "AMaterno", "Fecha_Nac", "IdGeneroFK", 
	"Calle", "NoExt", "Colonia", "CodigPostal", "Telefono", "Correo", "Usuario",
	"Contraseña", "IdTUsuarioFK", "IdTSangreFK")
*/
	
	private int IdUsuario;
	private String Nombres;
	private String APaterno;
	private String AMaterno;
	private Date Fecha_Nac;
	private int IdGeneroFK;
	private String Calle;
	private int NoExt;
	private String Colonia;
	private int CodigPostal;
	private String Telefono;
	private String Correo;
	private int IdTUsuarioFK;
	private int IdTSangreFK;
	private String user;
	private String password;
	
	
	public String getNombres() {
		return Nombres;
	}
	public void setNombres(String nombres) {
		Nombres = nombres;
	}
	public String getAPaterno() {
		return APaterno;
	}
	public void setAPaterno(String aPaterno) {
		APaterno = aPaterno;
	}
	public String getAMaterno() {
		return AMaterno;
	}
	public void setAMaterno(String aMaterno) {
		AMaterno = aMaterno;
	}
	public Date getFecha_Nac() {
		return Fecha_Nac;
	}
	public void setFecha_Nac(Date fecha_Nac) {
		Fecha_Nac = fecha_Nac;
	}
	public int getIdGeneroFK() {
		return IdGeneroFK;
	}
	public void setIdGeneroFK(int idGeneroFK) {
		IdGeneroFK = idGeneroFK;
	}
	public String getCalle() {
		return Calle;
	}
	public void setCalle(String calle) {
		Calle = calle;
	}
	public int getNoExt() {
		return NoExt;
	}
	public void setNoExt(int noExt) {
		NoExt = noExt;
	}
	public String getColonia() {
		return Colonia;
	}
	public void setColonia(String colonia) {
		Colonia = colonia;
	}
	public int getCodigPostal() {
		return CodigPostal;
	}
	public void setCodigPostal(int codigPostal) {
		CodigPostal = codigPostal;
	}
	public String getTelefono() {
		return Telefono;
	}
	public void setTelefono(String telefono) {
		Telefono = telefono;
	}
	public String getCorreo() {
		return Correo;
	}
	public void setCorreo(String correo) {
		Correo = correo;
	}
	public int getIdTUsuarioFK() {
		return IdTUsuarioFK;
	}
	public void setIdTUsuarioFK(int idTUsuarioFK) {
		IdTUsuarioFK = idTUsuarioFK;
	}
	public int getIdTSangreFK() {
		return IdTSangreFK;
	}
	public void setIdTSangreFK(int idTSangreFK) {
		IdTSangreFK = idTSangreFK;
	}
	public int getIdUsuario() {
		return IdUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		IdUsuario = idUsuario;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


}
