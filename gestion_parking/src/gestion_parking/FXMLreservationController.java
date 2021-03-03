
package gestion_parking;

import Entites.reservation;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import service.ServiceReservation;
import utils.Maconnexion;


/**
 * FXML Controller class
 *
 * @author yousra
 */
public class FXMLreservationController implements Initializable {
    
    private Label label;

    @FXML
    private TextField tfidrsv;
    @FXML
    private TextField tfidusr;
    @FXML
    private TextField tfidprk;
    @FXML
    private TextField tfdte;
    @FXML
    private Label lidrsv;
    @FXML
    private Label lidusr;
    @FXML
    private Label lidprk;
    @FXML
    private Label ldte;
    @FXML
    private TextField tfdtef;
    @FXML
    private Label ldtef;
    @FXML
    private TableView<reservation> tvfoxes;
    @FXML
    private TableColumn<reservation, Integer> colidrsvp;
    @FXML
    private TableColumn<reservation, Integer> colidusr;
    @FXML
    private TableColumn<reservation, Integer> colidp;
    @FXML
    private TableColumn<reservation, Date> coldte;
    @FXML
    private TableColumn<reservation, Date> coldtef;

    ServiceReservation ps = new ServiceReservation();
    ObservableList<reservation> list = ps.getreservationList();
    
  
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    Maconnexion con;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Showreservation();
    }    

    @FXML
    private void AjouterReservation(ActionEvent event) throws ParseException {
          ServiceReservation ServiceReservation=new ServiceReservation();
        reservation rs = new reservation();
        rs.setIdrsvparking(parseInt(tfidrsv.getText()));
        rs.setId(parseInt(tfidusr.getText()));
        rs.setId_parking(parseInt(tfidprk.getText()));
        rs.setDate_d((Date) new SimpleDateFormat("dd/MM/yyyy").parse(tfdte.getText()));
        rs.setDate_f((Date) new SimpleDateFormat("dd/MM/yyyy").parse(tfdtef.getText()));
        ServiceReservation.Addreservation(rs);
        
    }
    

    @FXML
    private void ModifierReservation(ActionEvent event) throws ParseException {
          ServiceReservation ServiceReservation=new ServiceReservation();
        reservation rs = new reservation();
        rs.setDate_d((Date) new SimpleDateFormat("dd/MM/yyyy").parse(tfdte.getText()));
        rs.setDate_f((Date) new SimpleDateFormat("dd/MM/yyyy").parse(tfdtef.getText()));
        ServiceReservation.Modifierreservation(rs);
    }

    @FXML
    private void SupprimerReservation(ActionEvent event) throws ParseException {
        
         ServiceReservation ServiceReservation=new ServiceReservation();
        reservation rs = new reservation();
        
       rs.setDate_d((Date) new SimpleDateFormat("dd/MM/yyyy").parse(tfdte.getText()));
        rs.setDate_f((Date) new SimpleDateFormat("dd/MM/yyyy").parse(tfdtef.getText()));
        ServiceReservation.Supprimerreservation(rs);
    }
     public void Showreservation() {

        colidrsvp.setCellValueFactory(new PropertyValueFactory<reservation, Integer>("idrsvparking"));
        colidusr.setCellValueFactory(new PropertyValueFactory<reservation, Integer>("id"));
        colidp.setCellValueFactory(new PropertyValueFactory<reservation, Integer>("id_parking"));
        coldte.setCellValueFactory(new PropertyValueFactory<reservation, Date>("date_d"));
        coldtef.setCellValueFactory(new PropertyValueFactory<reservation, Date>("date_f"));


        tvfoxes.setItems(list);

    }

     @FXML
   public void reload() throws IOException{
       FXMLLoader fxmlloader = new FXMLLoader(getClass().getClassLoader().getResource("gestion_parking/FXMLreservation.fxml"));
       Parent root = fxmlloader.load();
       Stage stage = (Stage) tvfoxes.getScene().getWindow(); 
       stage.getScene().setRoot(root); 
   }
 
}
