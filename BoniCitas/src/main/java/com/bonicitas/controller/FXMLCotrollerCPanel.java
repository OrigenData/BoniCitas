package com.bonicitas.controller;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ResourceBundle;

import org.controlsfx.control.ListSelectionView;

import com.bonicitas.driving.DataBase;
import com.bonicitas.permanent.GlobalData;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;


public class FXMLCotrollerCPanel implements Initializable, GlobalData{
	
    @FXML
    private JFXTextField txtUserCuenta;

    @FXML
    private JFXTextField txtEmailCuenta;

    @FXML
    private JFXTextField txtPasswordCuenta;


    @FXML
    private JFXTextField txtNombre;

    @FXML
    private JFXTextField txtApellidoPaterno;

    @FXML
    private JFXTextField txtApellidoMaterno;

    @FXML
    private JFXDatePicker dateFechaN;

    @FXML
    private JFXRadioButton radioHombre;

    @FXML
    private JFXRadioButton radioMujer;

    @FXML
    private JFXTextField txtCP;

    @FXML
    private JFXTextField txtColonia;

    @FXML
    private JFXTextField txtCalle;

    @FXML
    private JFXTextField txtNumExt;

    @FXML
    private JFXTextField txtTelefono;
	
    @FXML
    private Label fieldTitleView;

    @FXML
    private AnchorPane panePerfilGenerico;

    @FXML
    private Pane panePerfil;

    @FXML
    private AnchorPane paneCitasPaciente;

    @FXML
    private AnchorPane paneCitasMedico;

    @FXML
    private AnchorPane paneDatosClinicos;

    @FXML
    private Pane panePerfil1;

    @FXML
    private AnchorPane paneEspecialidad;

    @FXML
    private Pane panePerfil11;

    @FXML
    private AnchorPane paneCuenta;

    @FXML
    private Pane panePerfil2;

    @FXML
    private Label fieldShowName;
    
    
    @FXML
    private JFXCheckBox cbe1;

    @FXML
    private JFXCheckBox cbe2;

    @FXML
    private JFXCheckBox cbe3;

    @FXML
    private JFXCheckBox cbe4;

    @FXML
    private JFXCheckBox cbe5;

    @FXML
    private JFXCheckBox cbe6;

    @FXML
    private JFXCheckBox cbe7;

    @FXML
    private JFXCheckBox cbe8;

    @FXML
    private JFXCheckBox cbe9;

    @FXML
    private JFXCheckBox cbe10;


    
    @FXML
    private JFXButton bttnEspecialidad;
    
    private ToggleGroup groupSex = new ToggleGroup();
    
    public int idtPueblerino;
    public int idTUser;
    public String nombreUsuario;
    public String TITLE_GENERIC;
    
    //Manejo de la Base de datos 
    DataBase db = new DataBase();
    

    @FXML
    void onActionCitas(ActionEvent event) {
    	
    	fieldTitleView.setText("CITAS");
    	panePerfilGenerico.setVisible(false);
    	paneCitasPaciente.setVisible(true);
    	paneDatosClinicos.setVisible(false);
    	
    	if(idTUser==Medico){
    		
        	//Paneles genericos
        	panePerfilGenerico.setVisible(false);
        	paneCuenta.setVisible(false);
        	//Paciente
        	paneCitasPaciente.setVisible(false);
        	paneDatosClinicos.setVisible(false);
        	//Medico
        	paneCitasMedico.setVisible(true);
        	paneEspecialidad.setVisible(false);
    		
    	}else {
    		
        	//Paneles genericos
        	panePerfilGenerico.setVisible(false);
        	paneCuenta.setVisible(false);
        	//Paciente
        	paneCitasPaciente.setVisible(true);
        	paneDatosClinicos.setVisible(false);
        	//Medico
        	paneCitasMedico.setVisible(false);
        	paneEspecialidad.setVisible(false);
    		
    	}
    }

    @FXML
    void onActionCuenta(ActionEvent event) {
    	
    	fieldTitleView.setText("CUENTA");
    	//Paneles genericos
    	panePerfilGenerico.setVisible(false);
    	paneCuenta.setVisible(true);
    	//Paciente
    	paneCitasPaciente.setVisible(false);
    	paneDatosClinicos.setVisible(false);
    	//Medico
    	paneCitasMedico.setVisible(false);
    	paneEspecialidad.setVisible(false);
    	
    	
    	//Ver
    	db.showProfileUser(idtPueblerino);
    	txtEmailCuenta.setText(db.getCorreo());
    	txtUserCuenta.setText(db.getUser());
    	txtPasswordCuenta.setText(db.getPassword());
    	
    }

    @FXML
    void onActionDatosClinicos(ActionEvent event) {
    	
    	fieldTitleView.setText(TITLE_GENERIC);

    	if(idTUser==Medico){
    		
        	//Paneles genericos
        	panePerfilGenerico.setVisible(false);
        	paneCuenta.setVisible(false);
        	//Paciente
        	paneCitasPaciente.setVisible(false);
        	paneDatosClinicos.setVisible(false);
        	//Medico
        	paneCitasMedico.setVisible(false);
        	paneEspecialidad.setVisible(true);
        	

        	
    		
    	}else {
        	//Paneles genericos
        	panePerfilGenerico.setVisible(false);
        	paneCuenta.setVisible(false);
        	//Paciente
        	paneCitasPaciente.setVisible(false);
        	paneDatosClinicos.setVisible(true);
        	//Medico
        	paneCitasMedico.setVisible(false);
        	paneEspecialidad.setVisible(false);
    	}
    	
    }
    
    //Checkbox Datos Clinicos
    
    public void checkEventEspecialidad(ActionEvent event) {
    	
    	if(cbe1.isSelected()) {
    		System.out.println("1");
    	}
    	
    	if(cbe2.isSelected()) {
    		System.out.println("2");
    	}
    	
    	if(cbe3.isSelected()) {
    		System.out.println("3");
    	}
    	
    	if(cbe4.isSelected()) {
    		System.out.println("4");
    	}
    	
    	if(cbe5.isSelected()) {
    		System.out.println("5");
    	}
    	
    	if(cbe6.isSelected()) {
    		System.out.println("1");
    	}
    	
    	if(cbe7.isSelected()) {
    		System.out.println("1");
    	}
    	
    	if(cbe8.isSelected()) {
    		System.out.println("1");
    	}
    	
    	if(cbe9.isSelected()) {
    		System.out.println("1");
    	}
    	
    	if(cbe10.isSelected()) {
    		System.out.println("1");
    	}
    }
    
    
    
    
    
    
    
    
    

    @FXML
    void onActionPerfil(ActionEvent event) {
    	
    	fieldTitleView.setText("PERFIL");
    	//Paneles genericos
    	panePerfilGenerico.setVisible(true);
    	paneCuenta.setVisible(false);
    	//Paciente
    	paneCitasPaciente.setVisible(false);
    	paneDatosClinicos.setVisible(false);
    	//Medico
    	paneCitasMedico.setVisible(false);
    	paneEspecialidad.setVisible(false);
    	
    	//Mostrar datos
    	
    	db.showProfileUser(idtPueblerino);
    	txtNombre.setText(db.getNombres());
    	txtApellidoPaterno.setText(db.getAPaterno());
    	txtApellidoMaterno.setText(db.getAMaterno());
    	txtCalle.setText(db.getCalle());
    	txtColonia.setText(db.getColonia());
    	txtCP.setText(String.valueOf(db.getCodigPostal()));
    	txtNumExt.setText(String.valueOf(db.getNoExt()));
    	txtTelefono.setText(db.getTelefono());
    	dateFechaN.setValue(db.getFecha_Nac().toLocalDate());
    	
    	if (db.getIdGeneroFK()==1) {
    		
    		radioHombre.setSelected(true);
			
		}else {
			
			radioMujer.setSelected(true);
			
		}
    	
    }
    
    
    
    
    @FXML
    void onActionUpdateProfile(ActionEvent event) {
    	

    	
    	db.setNombres(txtNombre.getText());
    	db.setAPaterno(txtApellidoPaterno.getText());
    	db.setAMaterno(txtApellidoMaterno.getText());
    	db.setCalle(txtCalle.getText());
    	db.setColonia(txtColonia.getText());
    	db.setCodigPostal(Integer.valueOf(txtCP.getText()));
    	db.setNoExt(Integer.valueOf(txtNumExt.getText()));
    	db.setTelefono(txtTelefono.getText());
    	//Fecha y sexo
    	db.updateProfileUser(db);
    	

    }
    
    
    
    @FXML
    void onActionUpdateCuenta(ActionEvent event) {
    	
    	db.setCorreo(txtEmailCuenta.getText());
    	db.setUser(txtUserCuenta.getText());
    	db.setPassword(txtPasswordCuenta.getText());
    	db.updateProfileUser(db);
    	
    }
    
    
    @FXML
    void actionClose(ActionEvent event) {

    }
    
    
    public FXMLCotrollerCPanel(){
    	
		Platform.runLater(() -> {
			

			
			fieldShowName.setText(nombreUsuario);
			
			if (idTUser==Medico) {
				TITLE_GENERIC="ESPECIALIDAD";
				bttnEspecialidad.setText(TITLE_GENERIC);
				
			} else {
				TITLE_GENERIC="DATOS CLINICOS";
				bttnEspecialidad.setText(TITLE_GENERIC);
				
			}
			
	       
	    });
    	
    }
    

    @Override
	public void initialize(URL location, ResourceBundle resources) {
    	
    	//Paneles genericos
    	panePerfilGenerico.setVisible(false);
    	paneCuenta.setVisible(false);
    	//Paciente
    	paneCitasPaciente.setVisible(false);
    	paneDatosClinicos.setVisible(false);
    	//Medico
    	paneCitasMedico.setVisible(false);
    	paneEspecialidad.setVisible(false);
    	
    	
    	radioHombre.setToggleGroup(groupSex);
    	radioMujer.setToggleGroup(groupSex);
    	
	}

}
