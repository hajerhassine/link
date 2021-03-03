
package service;

import Entites.reservation;
import static java.awt.Event.INSERT;
import services.IServiceReservation;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.beans.binding.Bindings.and;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import static jdk.nashorn.internal.runtime.Debug.id;
import utils.Maconnexion;




public class ServiceReservation implements IServiceReservation{
     private Connection cnx;
    private PreparedStatement ste;
    
  public void ServiceReservation() {
        cnx=new Maconnexion().getInstance().getconnection();
    }
  ObservableList<reservation> reservationList = FXCollections.observableArrayList();
   public ObservableList<reservation> getreservationList(){
       
   
       String query="select * from reservationparking ";
        PreparedStatement pre;
        try 
        {
            pre = cnx.prepareStatement(query);
             ResultSet rst =pre.executeQuery();
   
                 while(rst.next())
                         
                 {    
                int idrsvparking = rst.getInt("idrsvparking");
                 int id = rst.getInt("id");
                 int id_parking = rst.getInt("id_parking");
                 Date date_d = rst.getDate("date_d");
                 Date date_f = rst.getDate("date_f");
            
            reservation rs = new reservation (idrsvparking, id, id_parking, date_d,date_f);
            reservationList.add(rs);
            }  
   
        }
              catch (SQLException ex) {
                      
            Logger.getLogger(ServiceReservation.class.getName()).log(Level.SEVERE, null, ex);
        } 
     
     return reservationList;
    
}
   
    public void Addreservation (reservation rs) {
       String req ="INSERT INTO reservationparking (idrsvparking, id , id_parking, date_d, date_f)"+" VALUES (?,?,?,?,?)";
        try {
            ste = cnx.prepareStatement(req);
            ste.setInt(1, rs.getIdrsvparking());
            ste.setInt(2,5);
            ste.setInt(3, rs.getId_parking());
            ste.setDate(4, rs.getDate_d());
            ste.setDate(5, rs.getDate_f());
            
            ste.executeUpdate();
            System.out.println("Reservation ajoutée");
               } catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());
            
        }
        
    }
      public void Modifierreservation(reservation rs){
            String req="UPDATE reservationparking SET `date_d`='"+ rs.getDate_d()+"',`date_f`='"
                    + rs.getDate_f() + " WHERE `idrsvparking`=" + rs.getIdrsvparking();
            System.out.println(req);
                try {
                    ste = cnx.prepareStatement(req);
                    ste.executeUpdate();
                    System.out.println("Reservation bien Modifié");
                }
                 
                catch (SQLException ex) {
                    System.out.println("Probléme");
                    System.out.println(ex.getMessage());
                }
                }

 public void Supprimerreservation(reservation rs){  
        String req="DELETE FROM `reservationparking` WHERE `date_d`="+ rs.getDate_d()+" and `date_f`=" + rs.getDate_f() ;
        System.err.println(req); 
        try {
             ste = cnx.prepareStatement(req);
             ste.executeUpdate();
             System.out.println("Reservation bien supprimé");
             
             
             
         }catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());
        
    }
}
  
    public List<reservation> Afficherreservation() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<reservation> AfficherParking() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
}
