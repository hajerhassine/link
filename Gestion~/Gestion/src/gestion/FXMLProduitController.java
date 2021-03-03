/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;

import Entities.Categorie;
import Entities.Produit;
import Services.ServiceCategorie;
import Services.ServiceProduit;
import connection.myconnection;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class FXMLProduitController implements Initializable {
    private Label label;

    @FXML
    private TextField tfidprod;
    @FXML
    private TextField tfid;
    @FXML
    private TextField tfnomprod;
    @FXML
    private TextField tfprixprod;
    @FXML
    private TextField tfdesc;
    @FXML
    private TableView<Produit> tvprod;
    @FXML
    private TableColumn<Produit, Integer> colidprod;
    @FXML
    private TableColumn<Produit, Integer> colid;
    @FXML
    private TableColumn<Produit, String> colnomprod;
    @FXML
    private TableColumn<Produit, Integer> colprix;
    @FXML
    private TableColumn<Produit, String> coldesc;
    @FXML
    private Button bntAjouter;
    @FXML
    private Button bntmodifier;
    @FXML
    private Button bntsupprimer;
    @FXML
    private Button bntafficher;
    @FXML
    private TableColumn<Produit, Integer> coldquantite;
    @FXML
    private TextField tfquantite;
    ServiceProduit cp = new ServiceProduit();
    
    ObservableList<Produit> list = cp.getProduitList();
    
     private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
     myconnection cnx;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ShowProduit();
    }    

    @FXML
    private void AjouterProduit(ActionEvent event) {
        ServiceProduit serviceProduit=new ServiceProduit();
        Produit p = new Produit();
        p.setId_produit(parseInt(tfidprod.getText()));
        p.setId(parseInt(tfid.getText()));
        p.setNom_produit(tfnomprod.getText());
        p.setPrix(parseInt(tfprixprod.getText()));
        p.setQuantitie(parseInt(tfquantite.getText())); 
        p.setDescription((tfdesc.getText()));
        serviceProduit.AddProduit(p);
        
    }
    public void ShowProduit() {
        
        colidprod.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("id_produit"));
        colid.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("id"));
        colnomprod.setCellValueFactory(new PropertyValueFactory<Produit, String>("nom_produit"));
        colprix.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("prix"));
        coldquantite.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("quantite"));
        coldesc.setCellValueFactory(new PropertyValueFactory<Produit, String>("description"));
        tvprod.setItems(list);
    }

    @FXML
    private void ModifierProduit(ActionEvent event) {
        ServiceProduit serviceProduit=new ServiceProduit();
        Produit p = new Produit();
        p.setId_produit(parseInt(tfidprod.getText()));
        p.setNom_produit(tfnomprod.getText());
        p.setPrix(parseInt(tfprixprod.getText()));
        p.setQuantitie(parseInt(tfquantite.getText()));
        p.setDescription(tfdesc.getText());
        
        
        
        serviceProduit.ModifierProduit(p);
    }

    @FXML
    private void SupprimerProduit(ActionEvent event) {
        
        Produit p=tvprod.getSelectionModel().getSelectedItem();
        if(p==null){
        
           System.out.println("Veillez choisir un Produit");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("choisir une categorie");
            alert.setHeaderText(null);
            alert.setContentText("Veillez choisir un produit à supprimer !");

            alert.showAndWait();
     
        }else{
          ServiceProduit sp = new ServiceProduit();
          String nom_produit = p.getNom_produit();
          try {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Supprimer Categorie ..");
                alert.setHeaderText(null);
                alert.setContentText("Etes-vous sûr que vous voulez supprimer! " + p.getNom_produit());
                Optional<ButtonType> action = alert.showAndWait();
                if (action.get() == ButtonType.OK) {
                    // System.out.println("sup1");
                    sp.SupprimerProduit(p);
                    Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                    alert1.setTitle("SUPPRIMER Categorie");
                    alert1.setHeaderText(null);
                    alert1.setContentText("la catégorie est supprimée");

                    alert1.showAndWait();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
        
    
    }

    @FXML
    private void AfficherProduit(ActionEvent event) throws IOException{
        FXMLLoader fxmlloader = new FXMLLoader(getClass().getClassLoader().getResource("FXMLProduit.fxml"));
        Parent root = fxmlloader.load();
        Stage stage = (Stage) tvprod.getScene().getWindow(); 
        stage.getScene().setRoot(root);
    }
    
}
