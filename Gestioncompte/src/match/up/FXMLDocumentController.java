/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package match.up;

import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import matchup.entities.proprietaire;
import matchup.servies.proprietaireCRUD;

/**
 *
 * @author tpc
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private TextField iNom;
    @FXML
    private TextField IPrenom;
    @FXML
    private TextField IEamail;
    @FXML
    private TextField IMdp;
    @FXML
    private TextField IAdresse;
    @FXML
    private TextField Iage;
    @FXML
    private TextField Igenre;
    @FXML
    private TextField INb;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouterPersonne(ActionEvent event) throws IOException {
        proprietaireCRUD sp = new proprietaireCRUD();
        proprietaire p = new proprietaire();
        p.setNom(iNom.getText());
        p.setPrenom(IPrenom.getText());
        p.setEmail(IEamail.getText());
        p.setMdp(IMdp.getText());
        p.setAdresse(IAdresse.getText());
        p.setAge(parseInt(Iage.getText()));
        p.setGenre(Igenre.getText());
        p.setNb_terrain(parseInt(INb.getText()));
        sp.ajouterPersonne(p);
         Parent d_page = FXMLLoader.load(getClass().getResource("FXMLuser.fxml"));
        Scene s = new Scene(d_page);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
 
                app_stage.hide(); //optional
                app_stage.setScene(s);
                app_stage.show(); 
    }
    
}
