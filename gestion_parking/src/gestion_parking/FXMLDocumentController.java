/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_parking;

import Entites.Parking;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import service.ServiceParking;
import utils.Maconnexion;

/**
 *
 * @author yousra
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private TextField tfid;
    @FXML
    private TextField tfadresse;
    @FXML
    private TextField tfplace;
    @FXML
    private TextField tfidparking;
    @FXML
    private TableView<Parking> tvfoxes;
    @FXML
    private TableColumn<Parking, Integer> colidp;
    @FXML
    private TableColumn<Parking, Integer> colid;
    @FXML
    private TableColumn<Parking, String> coladr;
    @FXML
    private TableColumn<Parking, Integer> colnb;
    
    ServiceParking ps = new ServiceParking();
    ObservableList<Parking> list = ps.getParkingList();
    @FXML
    private Label lid;
    @FXML
    private Label ladr;
    @FXML
    private Label lnb;
    @FXML
    private Label lidp;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    Maconnexion con;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ShowParking();
    }    
    

    @FXML
    private void AjouterParking(ActionEvent event) {
        
        ServiceParking serviceParking=new ServiceParking();
        Parking p = new Parking();
        p.setId(parseInt(tfid.getText()));
        p.setId_Parking(parseInt(tfidparking.getText()));
        p.setAdresse(tfadresse.getText());
        p.setNb_de_place(parseInt(tfplace.getText()));
        serviceParking.AddParking(p);
        
    }

    @FXML
    private void ModifierParking(ActionEvent event) {
        
        ServiceParking serviceParking=new ServiceParking();
        Parking p = new Parking();
        p.setId_Parking(parseInt(tfidparking.getText()));
        p.setAdresse(tfadresse.getText());
        p.setNb_de_place(parseInt(tfplace.getText()));
        serviceParking.ModifierParking(p);
        
    }

    @FXML
    private void SupprimerParking(ActionEvent event) {
        
        ServiceParking serviceParking=new ServiceParking();
        Parking p = new Parking();
        p.setId_Parking(parseInt(tfidparking.getText()));
        p.setAdresse(tfadresse.getText());
        p.setNb_de_place(parseInt(tfplace.getText()));
        serviceParking.SupprimerParking(p);
    }

 /*private void AfficherParking(ActionEvent event)throws SQLException {
     
 
         ServiceParking p = new ServiceParking (); 
         List<Parking> list = p.AfficherParking();   
         ObservableList<Parking> parkingList = FXCollections.observableArrayList();
         //public ObservableList<Parking> getparkingList() {
            
        
        try {
            con = new Maconnexion();
            String query = "select * from client";
            PreparedStatement pre = con.getconnection().prepareStatement(query);
            ResultSet rs = pre.executeQuery();
                  
            while (rs.next()) {
                int Id_Parking = rs.getInt("id_parking");
                int Id = rs.getInt("id");
                String Adresse = rs.getString("adresse");
                int Nb_de_palce = rs.getInt("nbdepalce");
                
                Parking pr = new Parking(Id_Parking, Id, Nb_de_palce, Adresse);
                parkingList.add(pr);
               
         
                 
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    //}
       
    }
}*/
 public void ShowParking() {

        colidp.setCellValueFactory(new PropertyValueFactory<Parking, Integer>("id_parking"));
        colid.setCellValueFactory(new PropertyValueFactory<Parking, Integer>("id"));
        coladr.setCellValueFactory(new PropertyValueFactory<Parking, String>("adresse"));
        colnb.setCellValueFactory(new PropertyValueFactory<Parking, Integer>("nbdeplace"));
       


        tvfoxes.setItems(list);

    }

    
    
    @FXML
   public void reload() throws IOException{
       FXMLLoader fxmlloader = new FXMLLoader(getClass().getClassLoader().getResource("gestion_parking/FXMLDocument.fxml"));
       Parent root = fxmlloader.load();
       Stage stage = (Stage) tvfoxes.getScene().getWindow(); 
       stage.getScene().setRoot(root); 
   }
 
}

