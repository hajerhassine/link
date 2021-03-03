/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Categorie;
import IServices.IservicesCategorie;
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

/**
 *
 * @author Asus
 */
public class ServiceCategorie  implements IservicesCategorie {
    private Connection cnx;
    private PreparedStatement ste;

    public ServiceCategorie() {
        cnx=new myconnection().getInstance().getConnection();
    }
    ObservableList<Categorie> CategorieList = FXCollections.observableArrayList();
    
    public ObservableList<Categorie> getCategorieList(){

        String query="select * from categorie ";
        PreparedStatement pre;
        try {
            pre = cnx.prepareStatement(query);
             ResultSet rst =pre.executeQuery();
            while(rst.next())
            {    
            int id_categorie = rst.getInt("id_categorie");
            String nom_categorie = rst.getString("nom_categorie");
            Categorie c = new Categorie (id_categorie, nom_categorie);
             CategorieList.add(c);
            }   } catch (SQLException ex) {
            Logger.getLogger(ServiceCategorie.class.getName()).log(Level.SEVERE, null, ex);
        } 
     
     return  CategorieList;
    }
    
@Override
    public void AddCategorie(Categorie c) {
       String req ="INSERT INTO categorie (id_categorie, nom_categorie)"+"values (?,?)";
        try {
            ste = cnx.prepareStatement(req);
            ste.setInt(1, c.getId_categorie());
            ste.setString(2, c.getNom_categorie());
            ste.executeUpdate();
            System.out.println("Categorie ajoutée");
               } catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());
            
        }
        
    }
  
    @Override
    public List<Categorie> AfficherCategorie() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ModifierCategorie(Categorie c) {
         String req="UPDATE categorie SET `nom_categorie`='" + c.getNom_categorie()+"',`nom_categorie`="
                    + c.getNom_categorie() + " WHERE `id_categorie`=" + c.getId_categorie();
            System.out.println(req);
                try {
                    ste = cnx.prepareStatement(req);
                    ste.executeUpdate();
                    System.out.println("categorie bien Modifié");
                }
                 
                catch (SQLException ex) {
                    System.out.println("Probléme");
                    System.out.println(ex.getMessage());
                }
                }

    @Override
    public void SupprimerCategorie(Categorie c) {
        String req="DELETE FROM `categorie` WHERE `id_categorie`="+ c.getId_categorie() ;
         try {
             ste = cnx.prepareStatement(req);
             ste.executeUpdate();
             System.out.println("Categorie bien supprimé");
             
             
             
         }catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());
        
    }
        
    }
    
}

