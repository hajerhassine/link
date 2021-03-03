/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_match;


import Entites.Tournoi;

import Service.ServiceTournoi;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hajer
 */
public class TOURNOIController implements Initializable {
     ServiceTournoi t = new ServiceTournoi();
    ObservableList<Tournoi> list = t.getTournoiList();

    @FXML
    private TextField tfid;
    @FXML
    private TextField tfnom;
    @FXML
    private TextField tftype;
    @FXML
    private TableView<Tournoi> tableview;
    @FXML
    private TableColumn<Tournoi,Integer> aid;
    @FXML
    private TableColumn<Tournoi, String> anom;
    @FXML
    private TableColumn<Tournoi, String> atype;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ShowMatch();
    }    

    @FXML
    private void ajoutertournoi(ActionEvent event) {
        ServiceTournoi ser = new ServiceTournoi();
        Tournoi t = new Tournoi();
     t.setId_tournoi(parseInt(tfid.getText()));
     t.setNom(tfnom.getText());
    t.setType(tftype.getText());
        ser.AjouterTournoi(t);
    }

    @FXML
    private void modifiertournoi(ActionEvent event) {
        ServiceTournoi serviceTournoi=new ServiceTournoi();
        Tournoi t = new Tournoi();
        t.setId_tournoi(parseInt(tfid.getText()));
        t.setNom(tfnom.getText());
        t.setType(tftype.getText());
        serviceTournoi.ModifierTournoi(t);
    }

    @FXML
    private void supprimertournoi(ActionEvent event) {
         ServiceTournoi serviceTournoi=new ServiceTournoi();
        Tournoi t = new Tournoi();
        t.setId_tournoi(parseInt(tfid.getText()));
        t.setNom(tfnom.getText());
        t.setType(tftype.getText());
        serviceTournoi.SupprimerTournoi(t);

    }
   public void ShowMatch(){

        aid.setCellValueFactory(new PropertyValueFactory<Tournoi, Integer>("id_tournoi"));
        anom.setCellValueFactory(new PropertyValueFactory<Tournoi, String>("nom"));
         atype.setCellValueFactory(new PropertyValueFactory<Tournoi, String>("type"));
        
       


      tableview.setItems(list);

    }

    
    
   public void reload() throws IOException{
       FXMLLoader fxmlloader = new FXMLLoader(getClass().getClassLoader().getResource("gestion_match/TOURNOI.fxml"));
       Parent root = fxmlloader.load();
       Stage stage = (Stage) tableview.getScene().getWindow(); 
       stage.getScene().setRoot(root); 
   }

 
}



