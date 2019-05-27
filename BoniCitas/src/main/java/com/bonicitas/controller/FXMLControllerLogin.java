package com.bonicitas.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import com.bonicitas.Main;
import com.bonicitas.permanent.GlobalData;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import com.bonicitas.driving.DataBase;

public class FXMLControllerLogin extends WhatPerson implements Initializable, GlobalData{


    @FXML
    private Pane paneLogin1, paneLogin2, paneLogin3, paneLogin4;
    

    @FXML
    private JFXTextField fieldLoginUser;

    @FXML
    private JFXPasswordField fieldLoginPassword;
    
    
    @FXML
    private JFXButton OnActionLoginEntrar;

    @FXML
    private JFXButton OnActionLoginRegistrate;
    
    @FXML
    private Pane paneLoad;
    

    @FXML
    private JFXButton buttonEntrar;
    

    @FXML
    void OnActionLoginEntrar(ActionEvent event) {
    	
    	DataBase db = new DataBase();
    	String user = fieldLoginUser.getText();
    	String password = fieldLoginPassword.getText();
    	//WhatPerson wp = new DataBase();
    	
    	

    	
    	if (user.equals("boni_medico") && password.equals("123")) {
    		
			System.out.println("Se registra como medico");
			new Main().windowRegister(Medico);
			
		} else if(db.login(user, password)) {
			
			String string = db.getNombres();
			String[] parts = string.split(" ");
			String name = parts[0]; 
			
			System.out.println("Entra como paciente");
			System.out.println(name);
			
			
			new Main().windowCPanel(db.getIdUsuario(),db.getIdTUsuarioFK(),name,db.getAPaterno()); //Panel medico

			Stage stage = (Stage)buttonEntrar.getScene().getWindow();
			stage.close();
						
		} else if(user.equals("admin") && password.equals("admin")){
			
			System.out.println("Entra como admin");
			
		} else {
			System.out.println("Usuario no encontrado");
		}

    }

    @FXML
    void OnActionLoginRegistrate(ActionEvent event) {
    	
    	System.out.println("Registrate");
    	new Main().windowRegister(Paciente);

    }


   

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		new AnimationLogin(paneLogin1, paneLogin2, paneLogin3, paneLogin4);
	
	}

}
