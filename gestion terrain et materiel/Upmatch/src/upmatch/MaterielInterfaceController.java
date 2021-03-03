/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmatch;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import upmatch.services.materielCRUD;
import upmatch.entities.materiel;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collector;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.util.Callback;
import upmatch.entities.terrain;
import upmatch.services.terrainCRUD;

/**
 * FXML Controller class
 *
 * @author Bedis
 */
public class MaterielInterfaceController implements Initializable {

    @FXML
    private ImageView homeImg;
    @FXML
    private Button homeBtn;
    @FXML
    private Button ret4;
    @FXML
    private TextField typt;
    @FXML
    private Button ajouter;
    @FXML
    private TextField empt;
    @FXML
    private TextField nomt;
    @FXML
    private TextField etat;
    @FXML
    private TextField idt;
    @FXML
    private Button modifier;
    @FXML
    private Button supprimer;
    @FXML
    private Button rechercher;
    @FXML
    private TextField rech;
    @FXML
    private TableView<materiel> tableGestionDesTerrains;
    @FXML
    private TableColumn<materiel, Integer> colid;
    @FXML
    private TableColumn<materiel, String> colnom;
    @FXML
    private TableColumn<materiel, Integer> coleml;
    @FXML
    private TableColumn<materiel, Integer> coltyp;
    @FXML
    private TableColumn<materiel,String> coleta;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void LoginActionReturn(ActionEvent event) {
    }

    @FXML
    private void HomeActionReturn4(ActionEvent event) {
    }

    @FXML
    private void AjouterOnAction(ActionEvent event) {
        materielCRUD tc = new materielCRUD();
            materiel t = new materiel();
            
            
            t.setType_mat(nomt.getText());
            String a = Integer.toString(t.getQuant_mat());
            
            String b = Integer.toString(t.getId_terrain());
            empt.setText(a);
            etat.setText(b);
            
            tc.Addmateriel(t);
            affichermat();
    }

    @FXML
    private void ModifierOnAction(ActionEvent event) {
    }

    @FXML
    private void SupprimerOnAction(ActionEvent event) {
    }

    @FXML
    private void RechercherOnAction(ActionEvent event) {
    }

    @FXML
    private void selectedl(MouseEvent event) {
    }
    
    public void affichermat(){
       materielCRUD tc = new materielCRUD();
       ObservableList<materiel> list  = tc.getmatList();
        colid.setCellValueFactory(new PropertyValueFactory<materiel,Integer>("id_materiel"));
       
        colnom.setCellValueFactory(new PropertyValueFactory<materiel,String>("type_mat"));
        coltyp.setCellValueFactory(new PropertyValueFactory<materiel,Integer>("quant_mat"));
        coleta.setCellValueFactory(new PropertyValueFactory<materiel,String>("nom_terrain"));
        coleml.setCellValueFactory(new PropertyValueFactory<materiel,Integer>("id_terrain"));
        tableGestionDesTerrains.setItems(list);
   }   
    
}
