package com.bonicitas.controller;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.controlsfx.control.ListSelectionView;

import com.bonicitas.driving.DataBase;
import com.bonicitas.permanent.GlobalData;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableColumn.CellDataFeatures;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Callback;


public class FXMLCotrollerCPanel implements Initializable, GlobalData{
	
    @FXML
    private JFXTreeTableView<ModeloTableMedico> treeTableMedico;

    @FXML
    private TreeTableColumn<ModeloTableMedico, String> fechaColTableMedico;

    @FXML
    private TreeTableColumn<ModeloTableMedico, String> horaColTableMedico;

    @FXML
    private TreeTableColumn<ModeloTableMedico, String> pacienteColTableMedico;

    @FXML
    private TreeTableColumn<ModeloTableMedico, String> especialidadColTableMedico;

    @FXML
    private TreeTableColumn<ModeloTableMedico, String> estatusColTableMedico;

	
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
    public ArrayList<Integer> arrayEspecialidad = new ArrayList<Integer>(); //Cuenta cuantas especialidades fueron seleccionadas
    ArrayList<JFXCheckBox> Especialidad = new ArrayList<>();
    ObservableList<ModeloTableMedico> listTableMedico;
    
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
        	
        	db.showTableCitasMedico(idtPueblerino);
    		
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
    
    

    @FXML
    void onActionSaveEspecialidad(ActionEvent event) {
    	/*
    	JFXCheckBox[] n= new JFXCheckBox[3];
    	n[0] = cbe1;
    	n[1] = cbe2;
    	n[2] = cbe3;
    	
    	n[1].setSelected(true);

    	
    	*/
    	checkEspecialidad();
    	
    	System.out.println("ID : "+db.getIdUsuario());
    	System.out.println(arrayEspecialidad.size());

    	db.insetEspecialidadMedico(idtPueblerino, arrayEspecialidad.size(), arrayEspecialidad);
    	

    	
    }
    
    //Checkbox Datos Clinicos
    
    public void checkEspecialidad() {
    	
    	
    	if(cbe1.isSelected()) {
    		//System.out.println("1");
    		arrayEspecialidad.add(1);
    	}
    	
    	if(cbe2.isSelected()) {
    		//System.out.println("2");
    		arrayEspecialidad.add(2);
    	}
    	
    	if(cbe3.isSelected()) {
    		//System.out.println("3");
    		arrayEspecialidad.add(3);
    	}
    	
    	if(cbe4.isSelected()) {
    		//System.out.println("4");
    		arrayEspecialidad.add(4);
    	}
    	
    	if(cbe5.isSelected()) {
    		//System.out.println("5");
    		arrayEspecialidad.add(5);
    	}
    	
    	if(cbe6.isSelected()) {
    		//System.out.println("6");
    		arrayEspecialidad.add(6);
    	}
    	
    	if(cbe7.isSelected()) {
    		//System.out.println("7");
    		arrayEspecialidad.add(7);
    	}
    	
    	if(cbe8.isSelected()) {
    		//System.out.println("8");
    		arrayEspecialidad.add(8);
    	}
    	
    	if(cbe9.isSelected()) {
    		//System.out.println("9");
    		arrayEspecialidad.add(9);
    	}
    	
    	if(cbe10.isSelected()) {
    		//System.out.println("10");
    		arrayEspecialidad.add(10);
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
			
			
			
			//CheckBOX
			//db.countEspecialidadMedico(db.getIdUsuario());
			
			System.out.println(idtPueblerino);
			for (Integer integer : db.countEspecialidadMedico(idtPueblerino)) {
				System.out.println("c  ----> "+integer);
			}
			
	    	JFXCheckBox[] cb= new JFXCheckBox[10];
	    	cb[0] = cbe1;
	    	cb[1] = cbe2;
	    	cb[2] = cbe3;
	    	cb[3] = cbe4;
	    	cb[4] = cbe5;
	    	cb[5] = cbe6;
	    	cb[6] = cbe7;
	    	cb[7] = cbe8;
	    	cb[8] = cbe9;
	    	cb[9] = cbe10;
	    	
	    	for (Integer integer : db.countEspecialidadMedico(idtPueblerino)) {
				System.out.println("c  ----> "+integer);
				cb[integer-1].setSelected(true);
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
    	
    	//cbe2.setSelected(true);
    	
    	
    	
    	radioHombre.setToggleGroup(groupSex);
    	radioMujer.setToggleGroup(groupSex);
    	
    	
    	/*
    	 
    	     @FXML
    private TreeTableColumn<ModeloTableMedico, String> fechaColTableMedico;

    @FXML
    private TreeTableColumn<ModeloTableMedico, String> horaColTableMedico;

    @FXML
    private TreeTableColumn<ModeloTableMedico, String> pacienteColTableMedico;

    @FXML
    private TreeTableColumn<ModeloTableMedico, String> especialidadColTableMedico;

    @FXML
    private TreeTableColumn<ModeloTableMedico, String> estatusColTableMedico;
    	 * 
    	 */
    	
    	
    	fechaColTableMedico.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<ModeloTableMedico,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<ModeloTableMedico, String> param) {
				// TODO Auto-generated method stub
				return param.getValue().getValue().FECHA;
			}
		});
    	
    	horaColTableMedico.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<ModeloTableMedico,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<ModeloTableMedico, String> param) {
				// TODO Auto-generated method stub
				return param.getValue().getValue().HORA;
			}
		});
    	
    	pacienteColTableMedico.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<ModeloTableMedico,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<ModeloTableMedico, String> param) {
				// TODO Auto-generated method stub
				return param.getValue().getValue().PACIENTE;
			}
		});
    	
    	
    	especialidadColTableMedico.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<ModeloTableMedico,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<ModeloTableMedico, String> param) {
				// TODO Auto-generated method stub
				return param.getValue().getValue().ESPECIALIDAD;
			}
		});
    	
    	estatusColTableMedico.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<ModeloTableMedico,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<ModeloTableMedico, String> param) {
				// TODO Auto-generated method stub
				return param.getValue().getValue().ESTATUS;
			}
		});
    	
    	
    	listTableMedico = FXCollections.observableArrayList();
    	TreeItem<ModeloTableMedico> root = new RecursiveTreeItem<ModeloTableMedico>(listTableMedico, RecursiveTreeObject ::getChildren);
    	treeTableMedico.setRoot(root);
    	treeTableMedico.setShowRoot(false);
    	
    	
    	listTableMedico.addAll(new ModeloTableMedico("sss", "qqqq", "qqqqqq", "dd", "984654"));
    	listTableMedico.addAll(new ModeloTableMedico("Cristian", "qqqq", "qqqqqq", "dd", "984654"));
    	
	}

}
