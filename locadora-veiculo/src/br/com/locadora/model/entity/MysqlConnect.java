package br.com.locadora.model.entity;

import java.sql.*; 


public class MysqlConnect{

    public Connection conn = null; 
	 
	 
	 public MysqlConnect(){
    
        LerProperties prop = new LerProperties();
        	 
	     String url = "jdbc:mysql://localhost:" + prop.ler().getPorta() + "/";
		  String dbName = prop.ler().getDbNome();
		  String driver = "com.mysql.jdbc.Driver";
		  String userName = prop.ler().getUsuario();
		  String password = prop.ler().getSenha();
		  
		  try{
		      Class.forName(driver); 
				conn = DriverManager.getConnection(url+dbName,userName,password);  
		  }
        catch (Exception e){
		      System.out.println("erro:\n");
				e.printStackTrace();		  
		  }	 
	 }
	 
	 public void closeConnection(){
	    try{
		     conn.close();		 
		 }
		 
		 catch (Exception e){
			 e.printStackTrace();	 
		 }	 
	 }
    
}