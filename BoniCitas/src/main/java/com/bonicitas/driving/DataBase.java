package com.bonicitas.driving;

import javafx.collections.ObservableList;


import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

import com.bonicitas.controller.ModeloTableMedico;
import com.bonicitas.controller.WhatPerson;
import com.bonicitas.permanent.GlobalData;

public class DataBase extends WhatPerson implements GlobalData{
	
	Connection DB =null;
	ResultSet rs = null;
	PreparedStatement pst = null;
	
	

	/**
	 * Insertar datos en la tabla Usuario cuando empieza el nuevo registro
	 * @param Nombres
	 * @param APaterno
	 * @param AMaterno
	 * @param Fecha_Nac
	 * @param IdGeneroFK
	 * @param Telefono
	 * @param Correo
	 * @param Usuario
	 * @param Contrasena
	 * @param IdTUsuarioFK
	 * @throws SQLException
	 */
	public void insertUsuarioTableRegister(String Nombres, String APaterno, String AMaterno, LocalDate Fecha_Nac, int IdGeneroFK, String Telefono, String Correo, String Usuario, String Contrasena, int IdTUsuarioFK) {
		System.out.println(Nombres+Fecha_Nac+IdGeneroFK+IdTUsuarioFK);
		
		try {
			DB = DriverManager.getConnection(URL, DBUSER, DBPASSWD);
			
			String query = "INSERT INTO public.\"Usuario\"(\n" + 
					"	\"Nombres\", \"APaterno\", \"AMaterno\", \"Fecha_Nac\", \"IdGeneroFK\", \"Telefono\", \"Correo\", \"Usuario\", \"Contraseña\", \"IdTUsuarioFK\")\n" + 
					"	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
			
			pst= DB.prepareStatement(query);
			
			pst.setString(1, Nombres);
			pst.setString(2, APaterno);
			pst.setString(3, AMaterno);
			pst.setDate(4, Date.valueOf(Fecha_Nac));
			pst.setInt(5, IdGeneroFK);
			pst.setString(6, Telefono);
			pst.setString(7, Correo);
			pst.setString(8, Usuario);
			pst.setString(9, Contrasena);
			pst.setInt(10, IdTUsuarioFK);
		
			
			pst.executeUpdate();
			pst.close();
			DB.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * Validar si el usuario y contrasena existen en la base de datos
	 * @param user
	 * @param password
	 * @return
	 */
	public boolean login(String user, String password) {
		
		try {
			DB = DriverManager.getConnection(URL, DBUSER, DBPASSWD);
			
			String query = "SELECT \"IdUsuario\", \"Nombres\", \"APaterno\", \"AMaterno\", \"Fecha_Nac\", \"IdGeneroFK\", \"Calle\", \"NoExt\", \"Colonia\", \"CodigPostal\", \"Telefono\", \"Correo\", \"Usuario\", \"Contraseña\", \"IdTUsuarioFK\", \"IdTSangreFK\"  \n" + 
					"FROM \"Usuario\"\n" + 
					" WHERE \"Usuario\" =  ? ;";
			
			pst= DB.prepareStatement(query);
			
			pst.setString(1, user);
			
			rs = pst.executeQuery();
			
			if (rs.next()) {
				
				if (password.equals(rs.getString(14))) {
					
					setIdUsuario(rs.getInt(1));
					setNombres(rs.getString(2));
					setAPaterno(rs.getString(3));
					setAMaterno(rs.getString(4));
					setFecha_Nac(rs.getDate(5));
					setIdGeneroFK(rs.getInt(6));
					setCalle(rs.getString(7));
					setNoExt(rs.getInt(8));
					setColonia(rs.getString(9));
					setCodigPostal(rs.getInt(10));
					setTelefono(rs.getString(11));
					setCorreo(rs.getString(12));
					setIdTUsuarioFK(rs.getInt(15));
					setIdTSangreFK(rs.getInt(16));
					
					
					
					return true;
				} else {
					System.out.println("Mal password");
				}
				
			}
			
			
			DB.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	
	public void showProfileUser(int id) {
		
		
		try {
			DB = DriverManager.getConnection(URL, DBUSER, DBPASSWD);
			
			String query = "SELECT \"IdUsuario\", \"Nombres\", \"APaterno\", \"AMaterno\", \"Fecha_Nac\", \"IdGeneroFK\", \"Calle\", \"NoExt\", \"Colonia\", \"CodigPostal\", \"Telefono\", \"Correo\", \"Usuario\", \"Contraseña\", \"IdTUsuarioFK\", \"IdTSangreFK\"  \n" + 
					"FROM \"Usuario\"\n" + 
					" WHERE \"IdUsuario\" =  ? ;";
			
			pst= DB.prepareStatement(query);
			
			pst.setInt(1, id);
			
			rs = pst.executeQuery();
			
			if (rs.next()) {

					
					setIdUsuario(rs.getInt(1));
					setNombres(rs.getString(2));
					setAPaterno(rs.getString(3));
					setAMaterno(rs.getString(4));
					setFecha_Nac(rs.getDate(5));
					setIdGeneroFK(rs.getInt(6));
					setCalle(rs.getString(7));
					setNoExt(rs.getInt(8));
					setColonia(rs.getString(9));
					setCodigPostal(rs.getInt(10));
					setTelefono(rs.getString(11));
					setCorreo(rs.getString(12));
					setUser(rs.getString(13));
					setPassword(rs.getString(14));
					setIdTUsuarioFK(rs.getInt(15));
					setIdTSangreFK(rs.getInt(16));
					
			
				} else {
					System.out.println("Mas informacion");
				}
				
			
			
			DB.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	public void updateProfileUser(WhatPerson wp) {
		
		try {
			DB = DriverManager.getConnection(URL, DBUSER, DBPASSWD);
			
			String query = "UPDATE public.\"Usuario\"\n" + 
					"	SET \"Nombres\"=?, \"APaterno\"=?, \"AMaterno\"=?, \"Fecha_Nac\"=?, \"IdGeneroFK\"=?, \"Calle\"=?, \"NoExt\"=?, \"Colonia\"=?, \"CodigPostal\"=?, \"Telefono\"=?\n" + 
					"	WHERE \"IdUsuario\" =? ;";
			
			pst= DB.prepareStatement(query);
			
			pst.setString(1, wp.getNombres());
			pst.setString(2, wp.getAPaterno());
			pst.setString(3, wp.getAMaterno());
			pst.setDate(4, wp.getFecha_Nac());
			pst.setInt(5, wp.getIdGeneroFK());
			pst.setString(6, wp.getCalle());
			pst.setInt(7, wp.getNoExt());
			pst.setString(8, wp.getColonia());
			pst.setInt(9, wp.getCodigPostal());
			pst.setString(10, wp.getTelefono());
			pst.setInt(11, wp.getIdUsuario());
		
			
			pst.executeUpdate();
			pst.close();
			DB.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		
		System.out.println(wp.getNombres());
	}
	

	public void updateCuentaUser(WhatPerson wp) {
		
		try {
			DB = DriverManager.getConnection(URL, DBUSER, DBPASSWD);
			
			String query = "UPDATE public.\"Usuario\"\n" + 
					"	SET \"Correo\"=?, \"Usuario\"=?, \"Contraseña\"=?\n" + 
					"	WHERE \"IdUsuario\" =? ;";
			
			pst= DB.prepareStatement(query);
			
			pst.setString(1, wp.getCorreo());
			pst.setString(2, wp.getUser());
			pst.setString(3, wp.getPassword());
			pst.setInt(4, wp.getIdUsuario());
		
			
			pst.executeUpdate();
			pst.close();
			DB.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		
	}
	

	public void insetEspecialidadMedico(int id, int NumEspec, ArrayList<Integer> Valores) {
		
		try {
			DB = DriverManager.getConnection(URL, DBUSER, DBPASSWD);
			
			String query = "INSERT INTO public.\"Usuario_Especialidad\"(\n" + 
					"	\"idUsuarioFK\", \"IdEspecialidadFK\")\n" + 
					"	VALUES (?, ?);";
			
			
			for (int i = 0; i < Valores.size(); i++) {
				
				pst= DB.prepareStatement(query);
				
				pst.setInt(1, id);
				pst.setInt(2, Valores.get(i));
				
				pst.executeUpdate();
				
			}
			

			pst.close();
			DB.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
	
	public ArrayList<Integer> countEspecialidadMedico(int idMedico) {
		//int idMedico = 3;
		 ArrayList<Integer> Valores = new ArrayList<>();
		
		try {
			DB = DriverManager.getConnection(URL, DBUSER, DBPASSWD);
			
			String query = " SELECT \"Usuario_Especialidad\".\"idUsuario_Especialidad\",\n" + 
					"    \"Usuario_Especialidad\".\"idUsuarioFK\",\n" + 
					"    \"Usuario\".\"Nombres\",\n" + 
					"    \"Usuario_Especialidad\".\"IdEspecialidadFK\",\n" + 
					"    \"Especialidades\".\"DescEspecialidad\"\n" + 
					"   FROM \"Usuario_Especialidad\",\n" + 
					"    \"Usuario\",\n" + 
					"    \"Especialidades\"\n" + 
					"  WHERE \"Usuario_Especialidad\".\"idUsuarioFK\" = ? "
					+ "AND \"Usuario\".\"IdUsuario\" = \"Usuario_Especialidad\".\"idUsuarioFK\" "
					+ "AND \"Usuario_Especialidad\".\"IdEspecialidadFK\" = \"Especialidades\".\"IdEspecialidad\";";
			
			pst= DB.prepareStatement(query);
			
			pst.setInt(1, idMedico);
			
			rs = pst.executeQuery();
			
			while ( rs.next() ) { 
				   // Read the next item
				Valores.add(rs.getInt(4));
				
			}
			

				
			
			DB.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return Valores;
		
	}

	


	public void showTableCitasMedico1(int idtPueblerino) {
		// TODO Auto-generated method stub
		try {
			DB = DriverManager.getConnection(URL, DBUSER, DBPASSWD);
			
			String query = "Select\n" + 
					"\"Citas\".\"Fecha\",\n" + 
					"\"Citas\".\"Hora\",\n" + 
					"\"Paciente\".\"Nombres\" As Paciente,\n" + 
					"\"Estatus\".\"DescEstatus\"\n" + 
					"FROM \"Citas\"\n" + 
					"left join \"Usuario\" on \"Citas\".\"IdUsuarioM FK\" = \"Usuario\".\"IdUsuario\"\n" + 
					"left join \"Usuario\" as \"Paciente\" on \"Citas\".\"IdUsuarioPFK\" = \"Paciente\".\"IdUsuario\"\n" + 
					"join \"Estatus\" on \"Citas\".\"IdEstatusFK\" = \"Estatus\".\"IdEstatus\"\n" + 
					"WHERE \"Citas\".\"IdUsuarioM FK\" = ?";
			
			pst= DB.prepareStatement(query);
			
			pst.setInt(1, idtPueblerino);
			
			rs = pst.executeQuery();
			
			while    ( rs.next() ) {
				
				//listTableMedico.addAll(new mtm
                
			}
		

				System.out.println(rs.getDate(1));
				System.out.println(rs.getTime(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));

			
			DB.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
