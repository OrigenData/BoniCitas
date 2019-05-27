package com.bonicitas.controller;

import com.bonicitas.driving.DataBase;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;

import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import javafx.fxml.Initializable;

public class FXMLControllerRegister implements Initializable{

    @FXML
    private Label labelTitle;
	
    @FXML
    private Pane pane1;

    @FXML
    private JFXTextField fieldNombre;

    @FXML
    private JFXTextField fieldApePaterno;

    @FXML
    private JFXTextField fieldApeMaterno;

    @FXML
    private Pane pane2;

    @FXML
    private JFXTextField fieldTelefono;

    @FXML
    private JFXTextField fieldUser;

    @FXML
    private JFXTextField fieldEmail;

    @FXML
    private JFXPasswordField fieldPassword;
    
    @FXML
    private AnchorPane alertPaneGuardado;
    
    @FXML
    private JFXButton onActionSiguiente;

    @FXML
    private JFXButton OnActionAtras;
    
    @FXML
    private Label labelErrorAnimatio;
    
    @FXML
    private JFXRadioButton radioHombre;

    @FXML
    private JFXRadioButton radioMujer;
    
    @FXML
    private JFXDatePicker dateFNacimiento;
    
    private String TitleRegister;
    
    public int idPueblerino;
    
    private ToggleGroup groupSex = new ToggleGroup();
    
    private DataBase db = new DataBase();
    
    
    /**
     * Metodo para saber el sexo
     * @return
     */
    public int selectSex () {
    	
    	int id=0;
    	
    	if (radioHombre.isSelected()) {
			
    		System.out.println(radioHombre.getText());
    		id=1;
		} else {
			System.out.println(radioMujer.getText());
			id=2;
		}
    	
		return id;
    	
    }
    
    /**
     * Metodos que devuelve la fecha de nacimiento por A-M-D
     * @return
     */
    public LocalDate birthDate(){
    	LocalDate localDate = dateFNacimiento.getValue();
    	System.out.println(localDate);
    	return localDate;
    }
    
    @FXML
    void onActionSiguiente(ActionEvent event) {
    	
    	
    	if(pane1.isVisible()) {
    		
    		pane1.setVisible(false);
    		pane2.setVisible(true);
    		OnActionAtras.setVisible(true);  		
    		onActionSiguiente.setText("Guardar");

    		
    	} else{
    		
    		/*
    		 * Se verificara en el boton de guardar si todos los campos fueron llenados o se dejo
    		 * alguno vasio, de estar vasio alguno saldra una alerta y si no se almacenaran en la
    		 * base de datos
    		 */
    		
    		if(onActionSiguiente.getText().equals("Guardar")) {
    			System.out.println("Dice lo mismo");
    			
    			if(fieldNombre.getText().isEmpty() || fieldApePaterno.getText().isEmpty() || fieldApeMaterno.getText().isEmpty()
    					|| fieldTelefono.getText().isEmpty() || fieldUser.getText().isEmpty() || fieldEmail.getText().isEmpty()
    					|| fieldPassword.getText().isEmpty()) {
    				
    				System.out.println("Esta vasio");
    				
    				//Error al guardar
    				showToast();
    				
    			} else {		
    				/*
    				System.out.println("Paciente: "+idPueblerino);
    				
    				System.out.println(
    						    	
    					    " "+fieldNombre.getText()
    					    +" "+fieldApePaterno.getText()
    					    +" "+fieldApeMaterno.getText()
    					    +" "+selectSex()
    					    +" "+birthDate()
    					    +" "+fieldTelefono.getText()
    					    +" "+fieldUser.getText()
    					    +" "+fieldEmail.getText()
    					    +" "+fieldPassword.getText()
    						
    						);
    		    	*/
    				db.insertUsuarioTableRegister(fieldNombre.getText(), fieldApePaterno.getText(), fieldApeMaterno.getText(), birthDate()
    						, selectSex(), fieldTelefono.getText(), fieldEmail.getText(), fieldUser.getText(), fieldPassword.getText(), idPueblerino);
    				
    				alertPaneGuardado.setVisible(true);
    			}
    		}
    	}

    }
    



    /**
     * Este metodo contiene el aviso de error si esque no se ingreso
     * algun campo o ninguno
     */
	private void showToast() {
		
		labelErrorAnimatio.setVisible(true);
		
		FadeTransition launch_error = new  FadeTransition(Duration.seconds(2),labelErrorAnimatio);
		launch_error.setToValue(1);
		launch_error.setFromValue(0);
		launch_error.play();
		
		new Timer().schedule(new TimerTask() {

			@Override
			public void run() {
				
				FadeTransition finish_error = new  FadeTransition(Duration.seconds(2),labelErrorAnimatio);
				finish_error.setToValue(0);
				finish_error.setFromValue(1);
				finish_error .play();
			}
			
		},4800);
		

	}


	@FXML
    void OnActionAtras(ActionEvent event) {

    	if(pane2.isVisible()) {
    		
    		pane2.setVisible(false);
    		pane1.setVisible(true);
    		OnActionAtras.setVisible(false);
    		onActionSiguiente.setText("Siguiente");
    		
    		
    	}

    }
	

	

	
	public FXMLControllerRegister() {
		

		Platform.runLater(() -> {

	    	String mensaje;

			/*
	    	 * 1 = Medico
	    	 * 2 = Paciente
	    	 */
	       	if(idPueblerino==1){

	       		mensaje = "Crea tu cuenta como Medico en BoniCitas";
	       		TitleRegister = mensaje;
	       		labelTitle.setText(TitleRegister);
	    	} else {

	    		mensaje = "Crea tu cuenta como Paciente en BoniCitas";
	    		TitleRegister = mensaje;
	    		labelTitle.setText(TitleRegister);
	    		
	    	}
	       
	    });
		

	
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		
		/*Valores por default*/
		//labelTitle.setText(TitleRegister+"dd");
		radioHombre.setToggleGroup(groupSex);
		radioMujer.setToggleGroup(groupSex);
		radioHombre.setSelected(true);
		LocalDate localDate = LocalDate.now();
		dateFNacimiento.setValue(localDate);
		
		//System.out.println(groupSex.getSelectedToggle().getUserData().toString());
    	
		radioHombre.getOnAction();
		radioHombre.isFocused();
    	
		
	}
	
	

}
