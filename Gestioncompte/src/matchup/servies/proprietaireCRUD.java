/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matchup.servies;

/**
 *
 * @author tpc
 */

import connection.myconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import matchup.entities.proprietaire;
import services.Iservies;


public class proprietaireCRUD implements Iservies {
    private Connection cnx;
    private PreparedStatement ste;

    public proprietaireCRUD() {
        cnx = myconnection.getInstance().getConnection();
    }
         ObservableList<proprietaire> ParkingList = FXCollections.observableArrayList();
     

    public ObservableList<proprietaire> getParkingList(){
   
         
    
        String query="select * from proprietaire ";
        PreparedStatement pre;
        try {
            pre = cnx.prepareStatement(query);
             ResultSet rst =pre.executeQuery();
        
     
      
    
        
            while(rst.next())
            {
            int id = rst.getInt("id");
            String nom =rst.getString("nom"); 
            String prenom =rst.getString("prenom"); 
            String email =rst.getString("email"); 
            String mdp =rst.getString("mdp"); 
            String adresse = rst.getString("adresse");
            int age = rst.getInt("age");
            String genre =rst.getString("genre");
            int nb_terrain = rst.getInt("nb_terrain");
            
            proprietaire p = new proprietaire(id, nom,  prenom ,  email ,  mdp ,   adresse ,   age ,   genre ,  nb_terrain);
            ParkingList.add(p);
            }   } catch (SQLException ex) {
            Logger.getLogger(proprietaireCRUD.class.getName()).log(Level.SEVERE, null, ex);
        } 
     
     return ParkingList;
    }
    public void ajouterPersonne(proprietaire p){
        String req ="INSERT INTO proprietaire ( nom,  prenom ,  email ,  mdp ,  adresse ,   age ,   genre ,  nb_terrain)"+"values (?,?,?,?,?,?,?,?)";
        try {
            ste = cnx.prepareStatement(req);
            ste.setString(1, p.getNom());
            ste.setString(2, p.getPrenom());
            ste.setString(3, p.getEmail());
            ste.setString(4, p.getMdp());
            ste.setString(5, p.getAdresse());
            ste.setInt(6, p.getAge());
            ste.setString(7, p.getGenre());
            ste.setInt(8, p.getNb_terrain());
            ste.executeUpdate();
            System.out.println("Personne ajoutée");
            
        } catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());
            
        }
        
    }
////    ObservableList<proprietaire> ClientList = FXCollections.observableArrayList();
////    public ObservableList<proprietaire> getproprietaireList() {
////            
////        
////        try {
////            String query = "select * from proprietaire";
////            PreparedStatement pre = cnx.prepareStatement(query);
////            ResultSet rs = pre.executeQuery();
////                  
////            while (rs.next()) {
//////                int id = rs.getInt("id_client");
//////                String username = rs.getString("username");
//////                String email = rs.getString("email");
//////                String password = rs.getString("password");
//////                String nom = rs.getString("nom");
//////                String prenom = rs.getString("prenom");
//////                Timestamp dateNai = rs.getTimestamp("dateNai");
//////                String tel = rs.getString("tel");
//////                String adresse = rs.getString("adresse");
//////                String sexe = rs.getString("sexe");
////                
////                proprietaire c = new proprietaire(id, username, email, password, nom, prenom, dateNai, sexe,tel, adresse);
////                ClientList.add(c);
////               
////               
////            }
////        } catch (SQLException ex) {
////            ex.printStackTrace();
////        }
////
////        return ClientList;
////
////    }

    @Override
    public List<proprietaire> Afficherproprietaire() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}


