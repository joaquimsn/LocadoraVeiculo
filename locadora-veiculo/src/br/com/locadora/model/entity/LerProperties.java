package br.com.locadora.model.entity;
import java.io.IOException;
import java.util.Properties;
import java.io.FileReader;

public class LerProperties{
      
      private ConexaoParametros cp;
      
   public LerProperties(){
      cp = new ConexaoParametros();
   }
   
   public ConexaoParametros ler(){
      
      
      Properties prop = new Properties();
      
      try{
         FileReader reader = new FileReader("config.properties");
         prop.load(reader);
         
         cp.setUsuario(prop.getProperty("Usuario")); 
         cp.setSenha(prop.getProperty("Senha"));
         cp.setPorta(prop.getProperty("Porta"));
         cp.setDbNome(prop.getProperty("DBNome"));       
      }
      catch(IOException e){
         e.printStackTrace();
      }
      
      return cp;
   }
}