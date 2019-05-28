package com.bonicitas.controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import org.controlsfx.control.ListSelectionView;

import com.bonicitas.driving.DataBase;
import com.bonicitas.permanent.GlobalData;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableColumn.CellDataFeatures;
import javafx.scene.control.TreeTableColumn.CellEditEvent;
import javafx.scene.control.cell.ChoiceBoxTreeTableCell;
import javafx.scene.control.cell.ComboBoxTreeCell;
import javafx.scene.control.cell.ComboBoxTreeTableCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Callback;


public class FXMLCotrollerCPanel implements Initializable, GlobalData{
	

	   @FXML
	    private JFXTreeTableView<ModeloTableMedico> treeTablePaciente;

	    @FXML
	    private TreeTableColumn<ModeloTableMedico, String> fechaColTablePaciente;

	    @FXML
	    private TreeTableColumn<ModeloTableMedico, String> horaColTablePaciente;

	    @FXML
	    private TreeTableColumn<ModeloTableMedico, String> medicoColTablePaciente;

	    @FXML
	    private TreeTableColumn<ModeloTableMedico, String> especialidadColTablePaciente;

	    @FXML
	    private TreeTableColumn<ModeloTableMedico, String> estatusColTablePaciente;

	
	
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
    private JFXComboBox comboBoxEspecialidadCitaPaciente;

    @FXML
    private JFXComboBox comboBocMedicoCitasPaciente;

    @FXML
    private JFXDatePicker dataFechaCitasPaciente;

    @FXML
    private JFXTextField txtVerHoraCita;

    @FXML
    private JFXTextField txtVerMinutosCita;

    @FXML
    private JFXButton bttnTime9am;

    @FXML
    private JFXButton bttnTime12am;

    @FXML
    private JFXButton bttnTime3pm;

    @FXML
    private JFXButton bttnTime10am;

    @FXML
    private JFXButton bttnTime1pm;

    @FXML
    private JFXButton bttnTime4pm;

    @FXML
    private JFXButton bttnTime11am;

    @FXML
    private JFXButton bttnTime2pm;

    @FXML
    private JFXButton bttnTime5pm;

    @FXML
    private JFXButton bttnMinut00;
    
    @FXML
    private JFXButton bttnMinut30;

    @FXML
    private JFXComboBox comboGrupoSanguineo;
    
    
  
    @FXML
    void onActionFechaDeCita(ActionEvent event) {
    	
    	System.out.println("Es fecha");
    	LocalDate localDate = dataFechaCitasPaciente.getValue();
    	System.out.println(localDate);
    	//dataFechaCitasPaciente.get
    	fechaConsulta(localDate);
    	
    	

    	//for (ArrayList<> jfxCheckBox : fechaConsulta(localDate)) {
			
		

    }
    
    
    public ArrayList<String> fechaConsulta(LocalDate date) {
    	
    	ArrayList<String> horaMinutos = new ArrayList<String>();
    	
    	Connection DB =null;
    	ResultSet rs = null;
    	PreparedStatement pst = null;
    		
    		try {
    			DB = DriverManager.getConnection(URL, DBUSER, DBPASSWD);
    			
    			String query = "select\n" + 
    					"     \"Citas\".\"IdCita \",\n" + 
    					"	 \"Citas\".\"Hora\",\n" + 
    					"	 \"Citas\".\"Fecha\",\n" + 
    					"	 \"Citas\".\"IdUsuarioM FK\"\n" + 
    					"from \"Citas\"\n" + 
    					"where \"Fecha\" = ? ";
    			
    			pst= DB.prepareStatement(query);
    			
    			pst.setDate(1, Date.valueOf(date));
    			
    			rs = pst.executeQuery();
    			
    			while ( rs.next() ) { 
    				   // Read the next item
    				horaMinutos.add(rs.getTime(2).toString());
    				System.out.println(rs.getTime(2).toString());
    				
    			}
    			

    				
    			
    			DB.close();
    			
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	
    	
    	
    	
		return horaMinutos ;
    	
    	
    }
    


@FXML
void onActionbttnMinut00(ActionEvent event) {
	
	String minutos="00";
	txtVerMinutosCita.setText(minutos);
}

@FXML
void onActionbttnMinut30(ActionEvent event) {
	
	String minutos="30";
	txtVerMinutosCita.setText(minutos);
}

@FXML
void onActionbttnTime10am(ActionEvent event) {
	
	String hora="10";
	
	txtVerHoraCita.setText(hora);
	
}

@FXML
void onActionbttnTime11am(ActionEvent event) {
	
	String hora="11";

	txtVerHoraCita.setText(hora);
	
}

@FXML
void onActionbttnTime12am(ActionEvent event) {

	String hora="12";

	txtVerHoraCita.setText(hora);
}

@FXML
void onActionbttnTime1pm(ActionEvent event) {

	String hora="01";

	txtVerHoraCita.setText(hora);
}

@FXML
void onActionbttnTime2pm(ActionEvent event) {

	String hora="02";

	txtVerHoraCita.setText(hora);
}

@FXML
void onActionbttnTime3pm(ActionEvent event) {
	
	String hora="03";

	txtVerHoraCita.setText(hora);

}

@FXML
void onActionbttnTime4pm(ActionEvent event) {
	
	String hora="04";

	txtVerHoraCita.setText(hora);

}

@FXML
void onActionbttnTime5pm(ActionEvent event) {

	String hora="05";

	txtVerHoraCita.setText(hora);
}

@FXML
void onActionbttnTime9am(ActionEvent event) {
	
	String hora="09";

	txtVerHoraCita.setText(hora);

}

@FXML
void onActioncomboBocMedicoCitasPaciente(ActionEvent event) {
	
	//System.out.println((1+comboBoxEspecialidadCitaPaciente.getSelectionModel().getSelectedIndex())+" >>> "+comboBoxEspecialidadCitaPaciente.getSelectionModel().getSelectedItem());
	//selectMedicoBox(1+comboBoxEspecialidadCitaPaciente.getSelectionModel().getSelectedIndex());
	System.out.println("onActioncomboBocMedicoCitasPaciente");
	System.out.println(comboBocMedicoCitasPaciente.getSelectionModel().getSelectedItem());
	System.out.println((1+comboBocMedicoCitasPaciente.getSelectionModel().getSelectedIndex())+" >>> "+comboBocMedicoCitasPaciente.getSelectionModel().getSelectedItem());

}

    
    
    
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
    ObservableList<ModeloTableMedico> listTablePaciente;
    ModeloTableMedico mtm;
    
    //Manejo de la Base de datos 
    DataBase db = new DataBase();
    
    /*
     * 
     * Variables de Cita
     * 
     */
    
    int comboBOXEspecialidad;
    int comboBOXMedico;
    
    
    /***
     * Es la tabla de Citas del panel de control de Medico
     */
    @SuppressWarnings("unlikely-arg-type")
	public void tableViewMedicoMetodo(){
    	
    	listTableMedico = FXCollections.observableArrayList();
    	TreeItem<ModeloTableMedico> root = new RecursiveTreeItem<ModeloTableMedico>(listTableMedico, RecursiveTreeObject ::getChildren);
    	
    	
    	//TreeItem<ModeloTableMedico> per1 = new  TreeItem<>(new ModeloTableMedico("a","v","e","3","2"));
    	//TreeItem<ModeloTableMedico> per3 = new  TreeItem<>(new ModeloTableMedico("a","v","e","3","2"));
    	//TreeItem<ModeloTableMedico> per4 = new  TreeItem<>(new ModeloTableMedico("a","v","e","3","2"));
    	//TreeItem<ModeloTableMedico> root = new  TreeItem<>(new ModeloTableMedico("a","v","e","3","2"));
    	//root.getChildren().add(per1);
    	//root.getChildren().add(per1);
    	//root.getChildren().add(per3);
    	//root.getChildren().add(per4);
    	
    	fechaColTableMedico.setCellValueFactory(
    			(TreeTableColumn.CellDataFeatures<ModeloTableMedico, String> param) -> param.getValue().getValue().FECHA);
    	
    	horaColTableMedico.setCellValueFactory(
    			(TreeTableColumn.CellDataFeatures<ModeloTableMedico, String> param) -> param.getValue().getValue().HORA);
    	
    	
    	pacienteColTableMedico.setCellValueFactory(
    			(TreeTableColumn.CellDataFeatures<ModeloTableMedico, String> param) -> param.getValue().getValue().PACIENTE);
    	
    	
    	especialidadColTableMedico.setCellValueFactory(
    			(TreeTableColumn.CellDataFeatures<ModeloTableMedico, String> param) -> param.getValue().getValue().ESPECIALIDAD);
    	
    	estatusColTableMedico.setCellValueFactory(
    			(TreeTableColumn.CellDataFeatures<ModeloTableMedico, String> param) -> param.getValue().getValue().ESTATUS);
    	
    	
    	
    	ObservableList<String> listEstatus = FXCollections.observableArrayList();
    	/*
    	 * Estatus
    	 */
    	String Estatus[] = {"Cumplida", "Pendiente", "Cancelada"};
    	listEstatus.add(Estatus[0]);
    	listEstatus.add(Estatus[1]);
    	listEstatus.add(Estatus[2]);
    	
    	estatusColTableMedico.setCellFactory(ChoiceBoxTreeTableCell.forTreeTableColumn(listEstatus));
    	
    	
    	estatusColTableMedico.setOnEditCommit(new  EventHandler<TreeTableColumn.CellEditEvent<ModeloTableMedico,String>>() {
			
			@Override
			public void handle(CellEditEvent<ModeloTableMedico, String> event) {
				// TODO Auto-generated method stub
				TreeItem<ModeloTableMedico> cep = treeTableMedico.getTreeItem(event.getTreeTablePosition().getRow());
				cep.getValue().setESTATUS(event.getNewValue());
			}
		});
    
    	
    	treeTableMedico.setEditable(true);
    	treeTableMedico.setRoot(root);
    	treeTableMedico.setShowRoot(false);
    	
    	
    }
    
    
    
    
    
    
    
	public void showTableCitasMedico(int idtPueblerino) {
		// TODO Auto-generated method stub
		listTableMedico.clear();
		Connection DB =null;
		ResultSet rs = null;
		PreparedStatement pst = null;
		try {
			DB = DriverManager.getConnection(URL, DBUSER, DBPASSWD);
			
			String query = "Select\n" + 
					"   \"Citas\".\"Fecha\",\n" + 
					"   \"Citas\".\"Hora\",\n" + 
					"   \"Paciente\".\"Nombres\" As Paciente,\n" + 
					"   \"Especialidades\".\"DescEspecialidad\" As Especialidad,\n" + 
					"   \"Estatus\".\"DescEstatus\"\n" + 
					"   FROM \"Citas\"\n" + 
					"   left join \"Usuario\" on \"Citas\".\"IdUsuarioM FK\" = \"Usuario\".\"IdUsuario\"\n" + 
					"   left join \"Usuario\" as \"Paciente\" on \"Citas\".\"IdUsuarioPFK\" = \"Paciente\".\"IdUsuario\"\n" + 
					"   join \"Estatus\" on \"Citas\".\"IdEstatusFK\" = \"Estatus\".\"IdEstatus\"\n" + 
					"   left join \"Especialidades\" on \"Especialidades\".\"IdEspecialidad\" = \"Citas\".\"IdEspecialidad\"\n" + 
					"   WHERE \"Citas\".\"IdUsuarioM FK\" = ?";
			
			pst= DB.prepareStatement(query);
			
			pst.setInt(1, idtPueblerino);
			
			rs = pst.executeQuery();
			
			while    ( rs.next() ) {
				
				//listTableMedico.addAll(new mtm
				listTableMedico.addAll(new ModeloTableMedico(rs.getDate(1).toString(), 
						rs.getTime(2).toString(), rs.getString(3).toString(), rs.getString(4).toString(), rs.getString(5).toString()));
	        	
                
			}
		
			
			DB.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
    /***
     * Es la tabla de Citas del panel de control de paciente
     */
    @SuppressWarnings("unlikely-arg-type")
	public void tableViewPacienteMetodo(){
    	
    	listTablePaciente = FXCollections.observableArrayList();
    	TreeItem<ModeloTableMedico> root = new RecursiveTreeItem<ModeloTableMedico>(listTablePaciente, RecursiveTreeObject ::getChildren);
    	
    	
    	//TreeItem<ModeloTableMedico> per1 = new  TreeItem<>(new ModeloTableMedico("a","v","e","3","2"));
    	//TreeItem<ModeloTableMedico> per3 = new  TreeItem<>(new ModeloTableMedico("a","v","e","3","2"));
    	//TreeItem<ModeloTableMedico> per4 = new  TreeItem<>(new ModeloTableMedico("a","v","e","3","2"));
    	//TreeItem<ModeloTableMedico> root = new  TreeItem<>(new ModeloTableMedico("a","v","e","3","2"));
    	//root.getChildren().add(per1);
    	//root.getChildren().add(per1);
    	//root.getChildren().add(per3);
    	//root.getChildren().add(per4);
    	
    	fechaColTablePaciente.setCellValueFactory(
    			(TreeTableColumn.CellDataFeatures<ModeloTableMedico, String> param) -> param.getValue().getValue().FECHA);
    	
    	horaColTablePaciente.setCellValueFactory(
    			(TreeTableColumn.CellDataFeatures<ModeloTableMedico, String> param) -> param.getValue().getValue().HORA);
    	
    	
    	medicoColTablePaciente.setCellValueFactory(
    			(TreeTableColumn.CellDataFeatures<ModeloTableMedico, String> param) -> param.getValue().getValue().PACIENTE);
    	
    	
    	especialidadColTablePaciente.setCellValueFactory(
    			(TreeTableColumn.CellDataFeatures<ModeloTableMedico, String> param) -> param.getValue().getValue().ESPECIALIDAD);
    	
    	estatusColTablePaciente.setCellValueFactory(
    			(TreeTableColumn.CellDataFeatures<ModeloTableMedico, String> param) -> param.getValue().getValue().ESTATUS);
    	
    	
    	
    	ObservableList<String> listEstatus = FXCollections.observableArrayList();
    	/*
    	 * Estatus
    	 */
    	String Estatus[] = {"Cumplida", "Pendiente", "Cancelada"};
    	//listEstatus.add(Estatus[0]);
    	//listEstatus.add(Estatus[1]);
    	listEstatus.add(Estatus[2]);
    	
    	estatusColTablePaciente.setCellFactory(ChoiceBoxTreeTableCell.forTreeTableColumn(listEstatus));
    	
    	
    	estatusColTablePaciente.setOnEditCommit(new  EventHandler<TreeTableColumn.CellEditEvent<ModeloTableMedico,String>>() {
			
			@Override
			public void handle(CellEditEvent<ModeloTableMedico, String> event) {
				// TODO Auto-generated method stub
				TreeItem<ModeloTableMedico> cep = treeTablePaciente.getTreeItem(event.getTreeTablePosition().getRow());
				cep.getValue().setESTATUS(event.getNewValue());
			}
		});
    
    	
    	treeTablePaciente.setEditable(true);
    	treeTablePaciente.setRoot(root);
    	treeTablePaciente.setShowRoot(false);
    	
    	
    }
    
	
	
	public void showTableCitasPaciente(int idtPueblerino) {
		// TODO Auto-generated method stub
		listTablePaciente.clear();
		Connection DB =null;
		ResultSet rs = null;
		PreparedStatement pst = null;
		try {
			DB = DriverManager.getConnection(URL, DBUSER, DBPASSWD);
			
			String query = "Select\n" + 
					"   \"Citas\".\"Fecha\",\n" + 
					"   \"Citas\".\"Hora\",\n" + 
					"   \"Medic\".\"Nombres\" As Medico,\n" + 
					"   \"Especialidades\".\"DescEspecialidad\" As Especialidad,\n" + 
					"   \"Estatus\".\"DescEstatus\"\n" + 
					"   FROM \"Citas\"\n" + 
					"   left join \"Usuario\" on \"Citas\".\"IdUsuarioPFK\" = \"Usuario\".\"IdUsuario\"\n" + 
					"   left join \"Usuario\" as \"Medic\" on \"Citas\".\"IdUsuarioM FK\" = \"Medic\".\"IdUsuario\"\n" + 
					"   join \"Estatus\" on \"Citas\".\"IdEstatusFK\" = \"Estatus\".\"IdEstatus\"\n" + 
					"   left join \"Especialidades\" on \"Especialidades\".\"IdEspecialidad\" = \"Citas\".\"IdEspecialidad\"\n" + 
					"   WHERE \"Citas\".\"IdUsuarioPFK\" = ?";
			
			pst= DB.prepareStatement(query);
			
			pst.setInt(1, idtPueblerino);
			
			rs = pst.executeQuery();
			
			while    ( rs.next() ) {
				
				//listTableMedico.addAll(new mtm
				listTablePaciente.addAll(new ModeloTableMedico(rs.getDate(1).toString(), 
						rs.getTime(2).toString(), rs.getString(3).toString(), rs.getString(4).toString(), rs.getString(5).toString()));
	        	
                
			}
		
			
			DB.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

    

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
        	
        	tableViewMedicoMetodo();
        	showTableCitasMedico(idtPueblerino);
        	//listTableMedico.addAll(new ModeloTableMedico("sss", "qqqq", "qqqqqq", "dd", "984654"));
        	//listTableMedico.addAll(new ModeloTableMedico("Cristian", "qqqq", "qqqqqq", "dd", "984654"));
        	//listTableMedico.clear();
        	
			//db.showTableCitasMedico1(idtPueblerino, listTableMedico, mtm);
    		
    	}else if(idTUser==Paciente){
    		
        	//Paneles genericos
        	panePerfilGenerico.setVisible(false);
        	paneCuenta.setVisible(false);
        	//Paciente
        	paneCitasPaciente.setVisible(true);
        	paneDatosClinicos.setVisible(false);
        	//Medico
        	paneCitasMedico.setVisible(false);
        	paneEspecialidad.setVisible(false);
        	
        	System.out.println("Metodo onActionCitas");
        	
        	tableViewPacienteMetodo();
        	showTableCitasPaciente(idtPueblerino);
        	
        	//MetodoCitasPaciente();
        	selectEspecialidadBox();
    		
    	}
    }
    
    
    
    
    
    
    /*
     * MEotodo de citas
     */
    private void MetodoCitasPaciente() {
		
    	// TODO Auto-generated method stub
    	String temp = null;
    	String compare;
		Connection DB =null;
		ResultSet rs = null;
		PreparedStatement pst = null;
		try {
			DB = DriverManager.getConnection(URL, DBUSER, DBPASSWD);
			
			String query = "SELECT \"IdCita \",  \"Hora\"\n" + 
					"	FROM public.\"Citas\"\n" + 
					"	WHERE \"IdCita \" = ?";
			
			pst= DB.prepareStatement(query);
			
			pst.setInt(1, 1);
			
			rs = pst.executeQuery();
			
			
			if (rs.next()) {
				
				temp = rs.getTime(2).toString();
			System.out.println("Hora:   "+rs.getTime(2));
			
			}
			
			
			if(temp.equals(rs.getTime(2).toString())) {
				System.out.println("iguales:  "+temp);
			}else {
				System.out.println(" no iguales");
			}
			
			
			DB.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

    @SuppressWarnings("unchecked")
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
        	
        	

        	selectGrupoSang();
        	
        	
        	
        	

        	
    	}
    	
    }
    
    
    /**
     * Este es coboBOX de especialidad
     */
	@SuppressWarnings("unchecked")
	public void selectEspecialidadBox() {
		// TODO Auto-generated method stub
		Connection DB =null;
		ResultSet rs = null;
		PreparedStatement pst = null;
		try {
			DB = DriverManager.getConnection(URL, DBUSER, DBPASSWD);
			
			String query = "SELECT \"IdEspecialidad\", \"DescEspecialidad\"\n" + 
					"	FROM \"Especialidades\";";
			
			pst= DB.prepareStatement(query);

			rs = pst.executeQuery();
			
			while    ( rs.next() ) {
				
				
				comboBoxEspecialidadCitaPaciente.getItems().addAll(rs.getString(2));

	        	
                
			}
		
			
			DB.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * Es el filtro para saber el medico que tiene x especialidad
	 * @param Especialidad
	 */
	@SuppressWarnings("unchecked")
	public void selectMedicoBox(int Especialidad) {
		// TODO Auto-generated method stub
		Connection DB =null;
		ResultSet rs = null;
		PreparedStatement pst = null;
		try {
			DB = DriverManager.getConnection(URL, DBUSER, DBPASSWD);
			
			String query = " SELECT distinct ON(\"idUsuarioFK\") \"Usuario_Especialidad\".\"idUsuario_Especialidad\" AS \"ID Esp. Medico\",\n" + 
					"    \"Usuario_Especialidad\".\"idUsuarioFK\" AS \"ID Usuario\",\n" + 
					"    \"Usuario\".\"Nombres\" AS \"Nombre\",\n" + 
					"    \"Usuario_Especialidad\".\"IdEspecialidadFK\" AS \"ID Esp.\",\n" + 
					"    \"Especialidades\".\"DescEspecialidad\" AS \"Especialidad\"\n" + 
					"   FROM \"Usuario_Especialidad\",\n" + 
					"    \"Usuario\",\n" + 
					"    \"Especialidades\"\n" + 
					"  WHERE \"IdEspecialidadFK\" = ? \n" + 
					"  AND \"Usuario\".\"IdUsuario\" = \"Usuario_Especialidad\".\"idUsuarioFK\" \n" + 
					"  AND \"Usuario_Especialidad\".\"IdEspecialidadFK\" = \"Especialidades\".\"IdEspecialidad\";";
			
			pst= DB.prepareStatement(query);
			
			pst.setInt(1, Especialidad);
			
			rs = pst.executeQuery();
			
			while    ( rs.next() ) {
				
				
				comboBocMedicoCitasPaciente.getItems().addAll(rs.getString(3));
				System.out.println("Medico especialista: "+rs.getString(3));

	        	
                
			}
		
			
			DB.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
    
    
    
	@SuppressWarnings("unchecked")
	public void selectGrupoSang() {
		// TODO Auto-generated method stub
		Connection DB =null;
		ResultSet rs = null;
		PreparedStatement pst = null;
		try {
			DB = DriverManager.getConnection(URL, DBUSER, DBPASSWD);
			
			String query = "SELECT \"IdTSangre\", \"DescTipoSangre\"\n" + 
					"	FROM public.\"TipoSangre\";";
			
			pst= DB.prepareStatement(query);

			rs = pst.executeQuery();
			
			while    ( rs.next() ) {
				
				//listTableMedico.addAll(new mtm
				comboGrupoSanguineo.getItems().addAll(rs.getString(2));
				System.out.println(rs.getString(2));
	        	
                
			}
		
			
			DB.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
    
    
    @FXML
    void onActionComboBoxEspecialidad(ActionEvent event) {
    	System.out.println("Esto es  el metodo onActionComboBoxEspecialidad");
    	
    	System.out.println((1+comboBoxEspecialidadCitaPaciente.getSelectionModel().getSelectedIndex())+" >>> "+comboBoxEspecialidadCitaPaciente.getSelectionModel().getSelectedItem());
    	selectMedicoBox(1+comboBoxEspecialidadCitaPaciente.getSelectionModel().getSelectedIndex());
    	
    }

    @FXML
    void onActionCrearCita(ActionEvent event) {
    	
    	System.out.println(comboBoxEspecialidadCitaPaciente.getSelectionModel().getSelectedIndex()+" >>> "+comboBoxEspecialidadCitaPaciente.getSelectionModel().getSelectedItem());

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
  
    	
    	String n[] = {"a","a","q","r","w"};
    	System.out.println(n);
    	
    	ArrayList<String> a = new ArrayList<String>();
    	a.add("a");
    	a.add("b");
    	a.add("c");
    	a.add("d");
    	a.add("e");
    	
    	
    	
    	
    	
	}

}
