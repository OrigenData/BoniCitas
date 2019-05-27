package com.bonicitas.permanent;

public interface GlobalData {
	
	//Data Base
	String URL="jdbc:postgresql://192.168.1.20:5432/bonicitas";
	String DBUSER="escobedo";
	String DBPASSWD="@escobedo";
	
	//Gui FXML
	String guiLogin = "sceneLogin.fxml";
	String guiRegisterPatient = "register.fxml";
	String guiCPanel = "controlPanel.fxml";
	int Medico = 1;
	int Paciente =2;
	
}




