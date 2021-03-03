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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import upmatch.services.terrainCRUD;
import upmatch.entities.terrain;
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
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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

/**
 * FXML Controller class
 *
 * @author Bedis
 */
public class TerrainInterfaceController implements Initializable {
    ObservableList<ObservableList> data = FXCollections.observableArrayList();

    @FXML
    private ImageView homeImg;
    @FXML
    private Button homeBtn;
    @FXML
    private Button ret4;
    @FXML
    private Button ajouter;
    @FXML
    private TextField nomt;
    @FXML
    private TextField etat;
    @FXML
    private TableView<terrain> tableGestionDesTerrains;
    @FXML
    private Button modifier;
    @FXML
    private Button supprimer;
    @FXML
    private Button rechercher;
    @FXML
    private TextField rech;
    @FXML
    private TextField typt;
    @FXML
    private TextField empt;
    @FXML
    private TableColumn<terrain,Integer> colid;
    @FXML
    private TableColumn<terrain,String> colnom;
    @FXML
    private TableColumn<terrain,String> coleml;
    @FXML
    private TableColumn<terrain,String> coltyp;
    @FXML
    private TableColumn<terrain,String> coleta;
    @FXML
    private TextField idt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       afficherter();
    }    

    @FXML
    private void LoginActionReturn(ActionEvent event) {
    }

    @FXML
    private void HomeActionReturn4(ActionEvent event) {
    }

    @FXML
    private void AjouterOnAction(ActionEvent event) {
        
            terrainCRUD tc = new terrainCRUD();
            terrain t = new terrain();
            
            
            t.setNom_terrain(nomt.getText());
            t.setEmplacement(empt.getText());
            t.setType(typt.getText());
            t.setEtat(etat.getText());
            
            tc.Addterrain(t);
            afficherter();
      
        
        
    }

    @FXML
    private void ModifierOnAction(ActionEvent event) {
        terrainCRUD tc = new terrainCRUD();
        terrain t = new terrain();
        int id = Integer.parseInt(idt.getText());
        t.setId_terrain(id);
        t.setEmplacement(empt.getText());
        t.setEtat(etat.getText());
        t.setNom_terrain(nomt.getText());
        t.setType(typt.getText());
        tc.modifierterrain(t);
        afficherter();
    }

    @FXML
    private void SupprimerOnAction(ActionEvent event) {
        terrainCRUD tc = new terrainCRUD();
        terrain t = new terrain();
        int id = Integer.parseInt(idt.getText());
        t.setId_terrain(id);
        tc.supprimerterrain(t);
        afficherter();
    }

    @FXML
    private void RechercherOnAction(ActionEvent event) {
         
       
    }
public void afficherter(){
       terrainCRUD tc = new terrainCRUD();
       ObservableList<terrain> list  = tc.getterList();
        colid.setCellValueFactory(new PropertyValueFactory<terrain,Integer>("id_terrain"));
       
        colnom.setCellValueFactory(new PropertyValueFactory<terrain,String>("nom_terrain"));
        coltyp.setCellValueFactory(new PropertyValueFactory<terrain,String>("type"));
        coleta.setCellValueFactory(new PropertyValueFactory<terrain,String>("etat"));
        coleml.setCellValueFactory(new PropertyValueFactory<terrain,String>("emplacement"));
        tableGestionDesTerrains.setItems(list);
   }    

    @FXML
    private void selectedl(MouseEvent event) {
        terrain evt = tableGestionDesTerrains.getSelectionModel().getSelectedItem();
        nomt.setText(evt.getNom_terrain());
       empt.setText(evt.getEmplacement());
        etat.setText(evt.getEtat());
        typt.setText(evt.getType());
        String a = Integer.toString(evt.getId_terrain());
        idt.setText(a);
       
    }

    @FXML
    private void search(KeyEvent event) {
         terrain l = new terrain();
         colnom.setCellValueFactory(new PropertyValueFactory<terrain,String>("nom_terrain"));
        coltyp.setCellValueFactory(new PropertyValueFactory<terrain,String>("type"));
        coleta.setCellValueFactory(new PropertyValueFactory<terrain,String>("etat"));
        coleml.setCellValueFactory(new PropertyValueFactory<terrain,String>("emplacement"));
        ObservableList<terrain> dataList;
        terrainCRUD se = new terrainCRUD();
        dataList = se.getterList();
       
        tableGestionDesTerrains.setItems(dataList);
       
        FilteredList<terrain> filteredData = new FilteredList<>(dataList, b -> true);
       
        rech.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate((terrain person) -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (person.getEmplacement().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches username
               
                } else if (person.getType().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                        }else if (person.getEtat().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                        }else if (person.getNom_terrain().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                        }
               
                else {
                    return false; 
                }
            });
        });
        SortedList<terrain> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableGestionDesTerrains.comparatorProperty());
        tableGestionDesTerrains.setItems(sortedData);
        
        
        
        
        
        
    }
}

