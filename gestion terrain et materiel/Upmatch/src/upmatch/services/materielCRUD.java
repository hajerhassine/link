/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmatch.services;

/**
 *
 * @author Bedis
 */
import connection.myconnection;
import java.sql.Connection;
import java.util.List;
import service.iservicemateriel;
import upmatch.entities.materiel;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import service.iservicemateriel;
import upmatch.entities.terrain;
/**
 *
 * @author Bedis
 */
public class materielCRUD  implements iservicemateriel {
    
    Connection cnx;

    public materielCRUD() {
       cnx =myconnection.getInstance().getConnection();
    }

    @Override
    public void Addmateriel(materiel t) {
        try {
            Statement stm =cnx.createStatement();
      
       
       String query="INSERT INTO `materiel`(`id_materiel`, `type_mat`, `quant_mat`, `id_terrain`) VALUES ("+t.getId_materiel()+",'"+t.getType_mat()+"','"+t.getQuant_mat()+"','"+t.getNom_terrain()+"')";
        
       stm.executeUpdate(query);
       
       } catch (SQLException ex) {
            Logger.getLogger(materielCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
ObservableList<materiel> materielx = FXCollections.observableArrayList();
    @Override
    public List<materiel> affichermateriel() throws SQLException {
          Statement stm =cnx.createStatement();
        
         String query="select * from `materiel` " ;
            
         ResultSet rst =stm.executeQuery(query);
         List<materiel> materielx ;
         materielx = new ArrayList<>();
         
         
         while(rst.next())
         {
          materiel t =new materiel();
                t.setId_materiel(rst.getInt("id_materiel"));
                t.setNom_terrain(rst.getString("nom_terrain"));
                t.setType_mat(rst.getString("type_mat"));
                t.setQuant_mat(rst.getInt("quant_mat"));
                t.getId_terrain(rst.getInt("id_terrain"));
               
                materielx.add(t);
         
         }
        
        return materielx;
    }

    @Override
    public void modifiermateriel(materiel t) {
         try {
            Statement stm = cnx.createStatement();
              String query = "UPDATE  materiel  set type_mat = '"+t.getType_mat()+"', quant_mat = "+t.getQuant_mat()+" WHERE id_materiel= "+t.getId_materiel()+" ;";
            
           
            stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(materielCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprimermateriel(materiel t) {
        try {
            Statement stm = cnx.createStatement();
            String query = "DELETE FROM `materiel` WHERE id_materiel='"+t.getId_materiel()+"'";
            stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(materielCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ObservableList<materiel> getmatList() {
        ObservableList<materiel> matList = FXCollections.observableArrayList();
       String query = "SELECT * from materiel";
       Statement stm ;
       ResultSet rst;
       try{
           stm = cnx.createStatement();
           rst = stm.executeQuery(query);
           
           
       
           while (rst.next())
            {
                materiel t = new materiel();
                t.setId_materiel(rst.getInt("id_materiel"));
                t.setType_mat(rst.getString("type_mat"));
                t.setQuant_mat(rst.getInt("qunat_mat"));
                t.setNom_terrain(rst.getString("nom_terrain"));
                matList.add(t);
            
       }
       }catch(Exception ex)
       {
           ex.printStackTrace();
       }
        return matList;
       
    }}

   