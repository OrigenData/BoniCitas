package com.bonicitas;


import com.bonicitas.controller.FXMLControllerRegister;
import com.bonicitas.controller.FXMLCotrollerCPanel;
import com.bonicitas.permanent.GlobalData;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class Main extends Application implements GlobalData{


	public Stage stage;
	
	public void start (Stage primaryStage) {
		
		this.stage = primaryStage;
		mainWindowLogin();
		
	}

	/**
	 * Ventana principal del programa es la de Login
	 */
	public void mainWindowLogin() {
		
		try {

			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource(guiLogin));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setResizable(false);
			//stage.initStyle(StageStyle.UNDECORATED);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	/**
	 * Ventana de Registro Paciente/Medico
	 * @param idTypeUser Es el tipo de usuario
	 */
	public void windowRegister(int idTypeUser) {
		try {
			
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(guiRegisterPatient));
			Parent root = (Parent)fxmlLoader.load();          
			FXMLControllerRegister controller = fxmlLoader.<FXMLControllerRegister>getController();
			//Medico = 1, Paciente = 2
			controller.idPueblerino=idTypeUser;
			Scene scene = new Scene(root); 
			Stage stageRegister = new Stage();
			stageRegister.setScene(scene);    
			stageRegister.setResizable(false);

			stageRegister.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	

	/**
	 * Ventana de Panel de Control Paciente/Medico
	 * @param args
	 */
	public void windowCPanel(int id, int idTypeUser, String nameUser, String surnameUser) {
		try {
			
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(guiCPanel));
			Parent root = (Parent)fxmlLoader.load();          
			FXMLCotrollerCPanel controller = fxmlLoader.<FXMLCotrollerCPanel>getController();
			//Medico = 1, Paciente = 2
			if (idTypeUser == Medico) {
				
				controller.idtPueblerino=id;
				controller.idTUser=idTypeUser;
				controller.nombreUsuario="Medico:\n"
						+ nameUser+" "+surnameUser;
				
				
			} else {
				
				controller.idtPueblerino=id;
				controller.idTUser=idTypeUser;
				controller.nombreUsuario="Paciente:\n"
						+ nameUser+" "+surnameUser;
				
			}
			
			
			Scene scene = new Scene(root); 
			Stage stageRegister = new Stage();
			stageRegister.setScene(scene);    
			//stageRegister.setResizable(false);
			stageRegister.setMaximized(true);

			stageRegister.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}



}
