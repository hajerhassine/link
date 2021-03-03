/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;

import Entities.Categorie;
import Services.ServiceCategorie;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class FXMLOptionsController implements Initializable {
    Categorie c;

    @FXML
    private TextField tfnewid;
    @FXML
    private TextField tfnewcat;
    @FXML
    private Button bntmodifier;
    @FXML
    private Button bntrechercher;
    @FXML
    private TableView<Categorie> tvcatmore;
    @FXML
    private TableColumn<Categorie, Integer> colidmore;
    @FXML
    private TableColumn<Categorie, String> colnommore;
    private final ObservableList<Categorie> dataList = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        

    

        }
        
        // TODO
       
         public void setCategorie(Categorie c1) {
        this.c = c1;
    }

    @FXML
    private void ModifCategorie(ActionEvent event) {
        Categorie c2 = new Categorie();
        if (c2 == null) {

            System.out.println("choisir une categorie");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Modify category");
            alert.setHeaderText(null);
            alert.setContentText("la catégorie n'est pas modifiée!");

            alert.showAndWait();
        } else {
            c2.setId_categorie(Integer.valueOf(tfnewid.getText()));
            c2.setNom_categorie(tfnewcat.getText());
           
           
              try {
                  ServiceCategorie sc = new ServiceCategorie();
            
            sc.ModifierCategorie(c);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
           

        System.out.println("modification terminé");
          
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Catégorie enregistré avec succès.");
        alert.setHeaderText(null);
        alert.setContentText("La catégorie" + c.getNom_categorie() + " est bien modifié.");
        alert.showAndWait();
             
      
         
        }
        
    }
    

    @FXML
    private void ChercherCat(ActionEvent event) {
    }
    
}
