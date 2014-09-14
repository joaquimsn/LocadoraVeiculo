package br.com.locadora.model.entity;

public class ConexaoParametros{
   
   private String usuario, senha, dbNome, porta;
   
   public ConexaoParametros(){
      
      usuario = "root";
      senha = "";
      dbNome = "projeto";
      porta = "3306";
      
   }
   
   public String getUsuario(){
      return usuario;
   }
   
   public String getSenha(){
      return senha;
   }
   
   public String getDbNome(){
      return dbNome;
   }
   
   public String getPorta(){
      return porta;
   }
   
   public void setUsuario(String usuario){
      this.usuario = usuario;
   }
   
   public void setSenha(String senha){
      this.senha = senha;
   }
   
   public void setDbNome(String dbNome){
      this.dbNome = dbNome;
   }
   
   public void setPorta(String porta){
      this.porta = porta;
   }


}