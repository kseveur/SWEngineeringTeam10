package controller;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

public class SignUpController implements Initializable{
	
	//Views
	@FXML private Text errorText;
	@FXML private TextField firstNameSUField;
	@FXML private TextField lastNameSUField;
	@FXML private TextField userNameSUField;
	@FXML private TextField passwordSUField;
	@FXML private Button signUpButton;

	private Main main;
	private Stage primaryStage;

	
	public void setMain(Main main) {
		this.main = main;
	}
	
	
	
	public void signUp() {
		System.out.println("FirstName: " + firstNameSUField.getText());
		System.out.println("LastName: " + lastNameSUField.getText());
		System.out.println("Email: " + userNameSUField.getText());
		System.out.println("Password: " + passwordSUField.getText());
	}
	
	public void showAlert2() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText("Username not available!");
		alert.setContentText("Please use a different username for signup");
		alert.showAndWait();		
	}
	

	/*public void searchViewSwitch() {
		Stage stage = (Stage) signUpButton.getScene().getWindow();
	    stage.close();
	}*/

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//degreeTypeCombo.setItems(degree);
		
	}
	
	
	
	
	//This method is only an event listener for testing and will be changed to a remove the action event.
	//Method will be called upon complete sign-in
	public void handleButtonAction(ActionEvent event) {
		Stage stage2 = (Stage) signUpButton.getScene().getWindow();
	    stage2.close();
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/SearchView.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root1));  
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

