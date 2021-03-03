/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;

import Entities.Categorie;
import Services.ServiceCategorie;
import connection.myconnection;
import java.awt.event.MouseEvent;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import static java.lang.System.load;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import static javafx.fxml.FXMLLoader.load;
import static javafx.fxml.FXMLLoader.load;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
 *
 * @author Asus
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private TextField tfidcat;
    @FXML
    private TextField tfnomcat;
    @FXML
    private Button bntajouter;
    @FXML
    private TableView<Categorie> tvcat;
    @FXML
    private TableColumn<Categorie, Integer> colid;
    @FXML
    private TableColumn<Categorie, String> colnom;
    ServiceCategorie cs = new ServiceCategorie();
    ObservableList<Categorie> list = cs.getCategorieList();
    @FXML
    private Button bntafficher;
    @FXML
    private Button bntsupprimer;
    @FXML
    private Button btnmore;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    myconnection cnx;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ShowCategorie();
    }    

    @FXML
    private void AjouterCategorie(ActionEvent event) {
        ServiceCategorie serviceCategorie=new ServiceCategorie();
        Categorie c = new Categorie();
        c.setId_categorie(parseInt(tfidcat.getText()));
        c.setNom_categorie((tfnomcat.getText()));
        serviceCategorie.AddCategorie(c);
    }
     public void ShowCategorie() {
        colid.setCellValueFactory(new PropertyValueFactory<Categorie, Integer>("id_categorie"));
        colnom.setCellValueFactory(new PropertyValueFactory<Categorie, String>("nom_categorie"));
        tvcat.setItems(list);

    }
    @FXML
   public void reload() throws IOException{
       FXMLLoader fxmlloader = new FXMLLoader(getClass().getClassLoader().getResource("FXMLDocument.fxml"));
       Parent root = fxmlloader.load();
       Stage stage = (Stage) tvcat.getScene().getWindow(); 
       stage.getScene().setRoot(root); 
//       ShowCategorie();
   }

    private void ModifierCategorie(ActionEvent event) {
        ServiceCategorie serviceCategorie=new ServiceCategorie();
        Categorie c = new Categorie();
        c.setId_categorie(parseInt(tfidcat.getText()));
        c.setNom_categorie(tfnomcat.getText());
        serviceCategorie.ModifierCategorie(c);
      
        
    }

    @FXML
    private void SupprimerCtaegorie(ActionEvent event) {

         Categorie c=tvcat.getSelectionModel().getSelectedItem();
        if(c==null){
        
           System.out.println("Veillez choisir une Catégorie");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("choisir une categorie");
            alert.setHeaderText(null);
            alert.setContentText("Veillez choisir une Catégorie à supprimer !");

            alert.showAndWait();
     
        }else{
          ServiceCategorie sc = new ServiceCategorie();
          String nom_categorie = c.getNom_categorie();
          try {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Supprimer Categorie ..");
                alert.setHeaderText(null);
                alert.setContentText("Etes-vous sûr que vous voulez supprimer! " + c.getNom_categorie());
                Optional<ButtonType> action = alert.showAndWait();
                if (action.get() == ButtonType.OK) {
                    // System.out.println("sup1");
                    sc.SupprimerCategorie(c);
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
    private void More(ActionEvent event) throws IOException {
        try {
             System.out.println(123);
      
              
//       Stage stage=(Stage)btnmore.getScene().getWindow();
//       Parent root=FXMLLoader.load(getClass().getResource("FXMLAutresOptions.fxml"));
//       Scene scene=new Scene(root);
//       stage.setScene(scene);
//       stage.show();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLOptions.fxml"));
            Parent root = loader.load();
            FXMLOptionsController opc = loader.getController();
            
       
       //FXMLDocumentController c1= load.getController();
       } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   

    
}
