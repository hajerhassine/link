/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Entites.Parking;
import static java.awt.Event.INSERT;
import services.IServiceParking;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import static jdk.nashorn.internal.runtime.Debug.id;
import utils.Maconnexion;

/**
 *
 * @author yousra
 */
public class ServiceParking  implements IServiceParking{
    private Connection cnx;
    private PreparedStatement ste;
    
     public ServiceParking() {
        cnx=new Maconnexion().getInstance().getconnection();
    }
     
     ObservableList<Parking> ParkingList = FXCollections.observableArrayList();
     

    public ObservableList<Parking> getParkingList(){
   
         
    
        String query="select * from parking ";
        PreparedStatement pre;
        try {
            pre = cnx.prepareStatement(query);
             ResultSet rst =pre.executeQuery();
    
             while(rst.next())
            {   
                int id_parking = rst.getInt("id_parking");
            int id = rst.getInt("id");
            String adresse = rst.getString("adresse");
            int nbdeplace = rst.getInt("nbdeplace");
            
            Parking p = new Parking (id_parking, id, nbdeplace, adresse);
            ParkingList.add(p);
            }   } catch (SQLException ex) {
            Logger.getLogger(ServiceParking.class.getName()).log(Level.SEVERE, null, ex);
        } 
     
     return ParkingList;
    }
    
            

    @Override
    public void AddParking(Parking p) {
       String req ="INSERT INTO parking(id_parking, id, adresse, nbdeplace)"+"values (?,?,?,?)";
        try {
            ste = cnx.prepareStatement(req);
            ste.setInt(1, p.getId_Parking());
            ste.setInt(2,5);
            ste.setString(3, p.getAdresse());
            ste.setInt(4, p.getNb_de_place());
            ste.executeUpdate();
            System.out.println("Parking ajoutée");
               } catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());
            
        }
        
    }
  
    public void ModifierParking(Parking p){
            String req="UPDATE parking SET `adresse`='" + p.getAdresse() +"',`nbdeplace`="
                    + p.getNb_de_place() + " WHERE `id_parking`=" + p.getId_Parking();
            System.out.println(req);
                try {
                    ste = cnx.prepareStatement(req);
                    ste.executeUpdate();
                    System.out.println("parking bien Modifié");
                }
                 
                catch (SQLException ex) {
                    System.out.println("Probléme");
                    System.out.println(ex.getMessage());
                }
                }
  
      public void SupprimerParking(Parking p){  
        String req="DELETE FROM `parking` WHERE `id_parking`="+ p.getId_Parking() ;
         try {
             ste = cnx.prepareStatement(req);
             ste.executeUpdate();
             System.out.println("parking bien supprimé");
             
             
             
         }catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());
        
    }
}

    @Override
    public List<Parking> AfficherParking() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
}

   
