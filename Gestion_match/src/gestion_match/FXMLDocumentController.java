/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_match;

import Entites.Match;
import Service.ServiceMatch;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 *
 * @author Hajer
 */
public class FXMLDocumentController implements Initializable {
    ServiceMatch m = new ServiceMatch();
    ObservableList<Match> list = m.getMatchList();
    private Label label;
    @FXML
    private TextField tfdate;
    @FXML
    private TextField tfnbjoueur;
    @FXML
    private TextField tftype;
    @FXML
    private TableColumn<Match, Integer> anbjoueurs;
    @FXML
    private TableColumn<Match, String> adate;
    @FXML
    private TableColumn<Match, String> atype;
    @FXML
    private TableView<Match> tableview;
    @FXML
    private TextField tfid;
    @FXML
    private TableColumn<Match, Integer> aid;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ShowMatch();
    }    

    @FXML
    private void Organisermatch1(ActionEvent event) {
         ServiceMatch org = new ServiceMatch();
        Match m = new Match();
     m.setId_match(parseInt(tfid.getText()));
     m.setType(tftype.getText());
     m.setDate(tfdate.getText());
        m.setNbjoueurs(parseInt(tfnbjoueur.getText()));
        org.Organisermatch(m);
    }
 
    public void ShowMatch(){

        aid.setCellValueFactory(new PropertyValueFactory<Match, Integer>("id_match"));
        atype.setCellValueFactory(new PropertyValueFactory<Match, String>("type"));
         adate.setCellValueFactory(new PropertyValueFactory<Match, String>("date"));
        anbjoueurs.setCellValueFactory(new PropertyValueFactory<Match, Integer>("nbjoueurs"));
       
        
       


        tableview.setItems(list);

    }

    
    
   public void reload() throws IOException{
       FXMLLoader fxmlloader = new FXMLLoader(getClass().getClassLoader().getResource("gestion_match/FXMLDocument.fxml"));
       Parent root = fxmlloader.load();
       Stage stage = (Stage) tableview.getScene().getWindow(); 
       stage.getScene().setRoot(root); 
   }

    @FXML
    private void Afficher(ActionEvent event) {
    }
 
}

