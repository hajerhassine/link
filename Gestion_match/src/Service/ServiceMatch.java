/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;
import Entites.Match;
import static java.awt.Event.INSERT;
import Services.IServiceMatch;
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
public class ServiceMatch  implements IServiceMatch {
    
 private  Connection cnx;
    private PreparedStatement ste;

    public ServiceMatch() {
        cnx = myconnection.getInstance().getConnection();
    }
    ObservableList<Match> MatchList = FXCollections.observableArrayList();
     

    public ObservableList<Match> getMatchList(){
   
         
    
        String query="SELECT * FROM `match`";
        PreparedStatement pre;
        try {
            pre = cnx.prepareStatement(query);
             ResultSet rs =pre.executeQuery();
        
            while(rs.next())
            {    int id_match = rs.getInt("id_match");
            String type = rs.getString("type");
            String date = rs.getString("date");
            int nbjoueur = rs.getInt("nbjoueurs");
            
            Match m = new Match (id_match, type, date, nbjoueur);
            MatchList.add(m);
            }   } catch (SQLException ex) {
            Logger.getLogger(ServiceMatch.class.getName()).log(Level.SEVERE, null, ex);
        } 
     
     return MatchList;
    }
    
    
    public void Organisermatch(Match m){
        String req ="INSERT INTO `match`(`id_match`, `type`, `date`, `nbjoueurs`)"+" VALUES(?,?,?,?)";
        try {
            ste = cnx.prepareStatement(req);
            ste.setInt(1,m.getId_match());
            ste.setString(2,m.getType());
            ste.setString(3,m.getDate());
            ste.setInt(4,m.getNbjoueurs());
            
            ste.executeUpdate();
            System.out.println("Match ajoutée");
            
            
            

            
        } catch (SQLException ex) {
            System.out.println("Problème");
            System.out.println(ex.getMessage());
            
        }
        
    }
     public void ModifierMatch(Match m){
            String req="UPDATE parking SET `type`='" + m.getType() +"',`date`='" + m.getDate() +"',`nbjoueurs`="
                    + m.getNbjoueurs() +  " WHERE `id_match`=" + m.getId_match();
            System.out.println(req);
                try {
                    ste = cnx.prepareStatement(req);
                    ste.executeUpdate();
                    System.out.println("Match bien Modifié");
                }
                 
                catch (SQLException ex) {
                    System.out.println("Probléme");
                    System.out.println(ex.getMessage());
                }
                }

    @Override
    public void OrganiserMatch(Match m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Match> AfficherMatch() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
  

    
}



