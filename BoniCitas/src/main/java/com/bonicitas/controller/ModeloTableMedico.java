package com.bonicitas.controller;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ModeloTableMedico extends RecursiveTreeObject<ModeloTableMedico>{
	
	StringProperty FECHA, HORA, PACIENTE, ESPECIALIDAD, ESTATUS;
	
	
	public ModeloTableMedico(String fecha, String hora, String paciente, String especialidad, String estatus) {
		
		this.FECHA = new SimpleStringProperty(fecha);
		this.HORA = new SimpleStringProperty(hora);
		this.PACIENTE = new SimpleStringProperty(paciente);
		this.ESPECIALIDAD = new SimpleStringProperty(especialidad);
		this.ESTATUS = new SimpleStringProperty(estatus);
		 
	}


	public StringProperty getFECHA() {
		return FECHA;
	}


	public void setFECHA(StringProperty fECHA) {
		FECHA = fECHA;
	}


	public StringProperty getHORA() {
		return HORA;
	}


	public void setHORA(StringProperty hORA) {
		HORA = hORA;
	}


	public StringProperty getPACIENTE() {
		return PACIENTE;
	}


	public void setPACIENTE(StringProperty pACIENTE) {
		PACIENTE = pACIENTE;
	}


	public StringProperty getESPECIALIDAD() {
		return ESPECIALIDAD;
	}


	public void setESPECIALIDAD(StringProperty eSPECIALIDAD) {
		ESPECIALIDAD = eSPECIALIDAD;
	}


	public StringProperty getESTATUS() {
		return ESTATUS;
	}


	public void setESTATUS(StringProperty eSTATUS) {
		ESTATUS = eSTATUS;
	}
	
	
	
	
	
}