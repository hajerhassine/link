/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package match.up;

import connection.myconnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import matchup.entities.proprietaire;
import matchup.servies.proprietaireCRUD;

/**
 * FXML Controller class
 *
 * @author tpc
 */
public class FXMLuserController implements Initializable {
     private Connection cnx;
    private PreparedStatement ste;
proprietaireCRUD ps = new proprietaireCRUD();
    ObservableList<proprietaire> list = ps.getParkingList();
    @FXML
    private TableColumn<proprietaire, Integer> tfid;
    @FXML
    private TableColumn<proprietaire, String> tfnom;
    @FXML
    private TableColumn<proprietaire, String> tfprenom;
    @FXML
    private TableColumn<proprietaire, String> tfemail;
    @FXML
    private TableColumn<proprietaire, String> tfmdp;
    @FXML
    private TableColumn<proprietaire, String> tfadresse;
    @FXML
    private TableColumn<proprietaire, Integer> tfage;
    @FXML
    private TableColumn<proprietaire, String> tfgenre;
    @FXML
    private TableColumn<proprietaire, Integer> tfnb;
    @FXML
    private TableView<proprietaire> tftable;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ShowParking();
    }    

    @FXML
    private void ajouterp(ActionEvent event) throws IOException {

        
        Parent d_page = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene s = new Scene(d_page);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
 
                app_stage.hide(); //optional
                app_stage.setScene(s);
                app_stage.show(); 
    }

     public void ShowParking() {

        tfid.setCellValueFactory(new PropertyValueFactory<proprietaire, Integer>("id"));
        tfnom.setCellValueFactory(new PropertyValueFactory<proprietaire, String>("nom"));
        tfprenom.setCellValueFactory(new PropertyValueFactory<proprietaire, String>("prenom"));
        tfemail.setCellValueFactory(new PropertyValueFactory<proprietaire, String>("email"));
        tfmdp.setCellValueFactory(new PropertyValueFactory<proprietaire, String>("mdp"));
        tfadresse.setCellValueFactory(new PropertyValueFactory<proprietaire, String>("adresse"));
        tfage.setCellValueFactory(new PropertyValueFactory<proprietaire, Integer>("age"));
        tfgenre.setCellValueFactory(new PropertyValueFactory<proprietaire, String>("genre"));
        tfnb.setCellValueFactory(new PropertyValueFactory<proprietaire, Integer>("nb_terrain"));

        tftable.setItems(list);

    }

    @FXML
    private void d(ActionEvent event) {
       
    
}
}
