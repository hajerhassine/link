/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;
import Entites.Match;
import Entites.Tournoi;
import static java.awt.Event.INSERT;
import Services.IServiceTournoi;
import connection.myconnection;
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


/**
 *
 * @author Hajer
 */
public class ServiceTournoi implements IServiceTournoi{
    private  Connection cnx;
    private PreparedStatement ste;

    public ServiceTournoi() {
        cnx = myconnection.getInstance().getConnection();
    }
    ObservableList<Tournoi> TournoiList = FXCollections.observableArrayList();
     

    public ObservableList<Tournoi> getTournoiList(){
   
         
    
        String query="SELECT * FROM `tournoi`";
        PreparedStatement pre;
        try {
            pre = cnx.prepareStatement(query);
             ResultSet rs =pre.executeQuery();
        
            while(rs.next())
            {    int id_tournoi = rs.getInt("id_tournoi");
            String nom = rs.getString("nom");
            String type = rs.getString("type");
            
            Tournoi t = new Tournoi (id_tournoi, nom, type);
            TournoiList.add(t);
            }   } catch (SQLException ex) {
            Logger.getLogger(ServiceTournoi.class.getName()).log(Level.SEVERE, null, ex);
        } 
     
     return TournoiList;
    }
    
    
    @Override
    public void AjouterTournoi(Tournoi t){
        String req ="INSERT INTO `tournoi`(`id_tournoi`, `nom`, `type`)"+" VALUES(?,?,?)";
        try {
            ste = cnx.prepareStatement(req);
            ste.setInt(1,t.getId_tournoi());
            ste.setString(2,t.getNom());
            ste.setString(3,t.getType());
            ste.executeUpdate();
            System.out.println("Tournoi ajoutée");
            
            
            

            
        } catch (SQLException ex) {
            System.out.println("Problème");
            System.out.println(ex.getMessage());
            
        }
        
    }
    @Override
     public void ModifierTournoi(Tournoi t){
            String req="UPDATE tournoi SET `nom`='" + t.getNom() +"',`type`='" + t.getType() +  " WHERE `id_tournoi`=" + t.getId_tournoi();
            System.out.println(req);
                try {
                    ste = cnx.prepareStatement(req);
                    ste.executeUpdate();
                    System.out.println("Tournoi bien Modifié");
                }
                 
                catch (SQLException ex) {
                    System.out.println("Probléme");
                    System.out.println(ex.getMessage());
                }
                }
    @Override
          public void SupprimerTournoi(Tournoi t){  
        String req="DELETE FROM `tournoi` WHERE `id_tournoi`="+ t.getId_tournoi() ;
         try {
             ste = cnx.prepareStatement(req);
             ste.executeUpdate();
             System.out.println("Tournoi bien supprimé");
             
             
             
         }catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());
        
    }
}

    @Override
    public List<Tournoi> AfficherTournoi() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 


  

    
}




    

