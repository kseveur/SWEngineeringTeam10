package controller;

import java.net.URL;
import java.rmi.Naming;
import java.util.ResourceBundle;
import controller.RMIClientInitializer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import controller.BackendServerInterface;
import controller.FrontendQuery;


public class SearchWindowController extends RMIClientInitializer implements Initializable{
	
	@FXML private Button cancelButton;
	@FXML private Button searchButton;
	@FXML private TextField firstNameField;
	@FXML private TextField lastNameField;
	@FXML private TextField stateField;
	@FXML private TextField industryField;
	@FXML private TextField positionField;

	

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}
	
	public void closeWindow() {
		Stage stage2 = (Stage) cancelButton.getScene().getWindow();
	    stage2.close();
	}
	
	@SuppressWarnings("unused")
	public void getQuery() {
		boolean firstAllLetters = ((CharSequence) firstNameField).chars().allMatch(Character::isLetter);
		boolean lastAllLetters = ((CharSequence) firstNameField).chars().allMatch(Character::isLetter);
		if(!firstAllLetters || !lastAllLetters) {
			alertAlphasOnly();
			return;
		}
		/////////////////////////********* RMI CODE START *********////////////////////////

		RMILoader();
		try {
			BackendServerInterface backend = (BackendServerInterface) Naming.lookup("rmi://"+ getBackendIp() +"/binded"); //connecting to RMI Server
			System.out.println("Successfully Connected to Admin module's RMI Server");	//if connection successful

			FrontendQuery frontendQuery = new FrontendQuery();
			frontendQuery.setFirstName(firstNameField.getText());
			frontendQuery.setLastName(lastNameField.getText());
			frontendQuery.setIndustry(industryField.getText());
			frontendQuery.setPosition(positionField.getText());
			frontendQuery.setState(stateField.getText());

			String result = backend.sendQuery(frontendQuery);

		} catch (Exception e) {
			System.out.println ("Could not Connect to RMI Server. Make sure rmi registry is running on server machine and Server IP is correct. ");
			System.out.println(e);
		}

		/////////////////////////********* RMI CODE END *********////////////////////////

		System.out.println("First Name: " + firstNameField.getText());
		System.out.println("Last Name: " + lastNameField.getText());
		System.out.println("State: " + stateField.getText());
		System.out.println("Industry: " + industryField.getText());
		System.out.println("Position: " + positionField.getText());
	}
	
	public void alertAlphasOnly() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText("Incorrect name format!");
		alert.setContentText("Please enter only letters in the first name and last name fields!");
		alert.showAndWait();		
	}
		
		

}
