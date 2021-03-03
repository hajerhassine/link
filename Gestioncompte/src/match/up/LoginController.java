/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package match.up;

import connection.myconnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import connection.myconnection;

public class LoginController {
    private Connection cnx;
    private PreparedStatement ste;
 
    @FXML
    private TextField login;

    @FXML
    private TextField pswd;

    
    @FXML
    void loginActionAdm(ActionEvent event) {
cnx = myconnection.getInstance().getConnection();
    	Parent root;
        PreparedStatement pre;
        	try {
        	String req =  "select * from administrateur where email = '"+login.getText()+"' and mdp = '"+ pswd.getText()+"'" ;
	      
          pre = cnx.prepareStatement(req);
             ResultSet rs =pre.executeQuery();
            
	        int i = 0;
	        while (rs.next()) {
	        	i++;	 
	        }
	         if (i==1) {
	        	
		       try{
		            FXMLLoader loader = new FXMLLoader();
                            loader.setLocation(getClass().getResource("FXMLuser.fxml"));
                            root = loader.load();
                            Scene scene = new Scene(root);        
                            ((Stage)((Node)event.getTarget()).getScene().getWindow()).setScene(scene);
		            }
		            catch (IOException e) {
		                e.printStackTrace();
		            }
	         }else {
	            Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setContentText("Veuillez vérifier votre Identifiant et votre Mot de passe !");
                    alert.showAndWait();
	         }
        }catch(Exception e) {
        	System.out.println(e);
        }
    }
}