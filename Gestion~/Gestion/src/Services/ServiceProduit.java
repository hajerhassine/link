/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Categorie;
import Entities.Produit;
import IServices.IServicesProduit;
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
public class ServiceProduit implements IServicesProduit {
     private Connection cnx;
    private PreparedStatement ste;

    public ServiceProduit() {
        cnx=new myconnection().getInstance().getConnection();
    }
    ObservableList<Produit> ProduitList = FXCollections.observableArrayList();
    public ObservableList<Produit> getProduitList(){

        String query="select * from produit ";
        PreparedStatement pre;
        try {
            pre = cnx.prepareStatement(query);
             ResultSet rst =pre.executeQuery();
            while(rst.next())
            {    
            int id_produit = rst.getInt("id_produit");
            int id = rst.getInt("id");
            String nom_produit = rst.getString("nom_produit");
            int prix = rst.getInt("prix");
            int quantitie = rst.getInt("quantitie");
            String description = rst.getString("description");
            Produit p = new Produit (id_produit,id,nom_produit,prix,quantitie,description);
            ProduitList.add(p);
            }   } catch (SQLException ex) {
            Logger.getLogger(ServiceCategorie.class.getName()).log(Level.SEVERE, null, ex);
        } 
     
     return  ProduitList;
    }

    @Override
    public void AddProduit(Produit p) {
        String req ="INSERT INTO produit (id_produit,id, nom_produit, prix, quantitie,description)"+"values (?,?,?,?,?,?)";
        try {
            ste = cnx.prepareStatement(req);
            ste.setInt(1, p.getId_produit());
            ste.setInt(2, p.getId());
            ste.setString(3,p.getNom_produit());
            ste.setInt(4, p.getPrix());
            ste.setInt(5, p.getQuantitie());
            ste.setString(6,p.getDescription());
            
            ste.executeUpdate();
            System.out.println("Produit ajoutée");
               } catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());
            
        }
        
    }

    @Override
    public List<Produit> AfficherProduit() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ModifierProduit(Produit p) {
        String req="UPDATE produit SET `nom_produit`='" + p.getNom_produit()+"',`prix`="
                    + p.getPrix() + "',`quantitie`="+ p.getQuantitie()+ "',`description`="+ p.getDescription()+ " WHERE `id_produit`=" + p.getId_produit();
            System.out.println(req);
                try {
                    ste = cnx.prepareStatement(req);
                    ste.executeUpdate();
                    System.out.println("Produit bien Modifié");
                }
                 
                catch (SQLException ex) {
                    System.out.println("Probléme");
                    System.out.println(ex.getMessage());
                }
    }

    @Override
    public void SupprimerProduit(Produit p) {
        String req="DELETE FROM `produit` WHERE `id_produit`="+ p.getId_produit() ;
         try {
             ste = cnx.prepareStatement(req);
             ste.executeUpdate();
             System.out.println("Produit bien supprimé");
             
             
             
         }catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());
        
         }
        
    
        
    }
   
        
   

  
    
    
    
}
