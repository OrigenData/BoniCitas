package com.bonicitas.permanent;

public interface GlobalData {
	
	//Data Base
	String URL="jdbc:postgresql://escobedo.urown.cloud:5432/bonicitas";
	//String URL="jdbc:postgresql://localhost:5432/bonicitas";
	String DBUSER="escobedo";
	String DBPASSWD="@escobedo";
	
	//Gui FXML
	String guiLogin = "sceneLogin.fxml";
	String guiRegisterPatient = "register.fxml";
	String guiCPanel = "controlPanel.fxml";
	int Medico = 1;
	int Paciente =2;
	
}




