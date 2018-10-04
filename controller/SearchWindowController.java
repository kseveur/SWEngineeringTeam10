package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SearchWindowController implements Initializable{
	
	@FXML public ComboBox<String> degreeTypeCombo;
	@FXML public ComboBox<String> stateComboBox;
	@FXML private Button cancelButton;
	@FXML private Button searchButton;
	@FXML private TextField gradYearField;
	@FXML private TextField majorField;
	@FXML private TextField professionField;
	@FXML private TextField companyField;
	
	
	
	//Picklist Values
		ObservableList<String> degree = FXCollections.observableArrayList("Associates", "Bachelors", "Masters", "PhD");
		ObservableList<String> stateList = FXCollections.observableArrayList("AK", "AL", "AR", "AZ", "CA", "CO", "CT", 
                "DC", "DE", "FL", "GA", "HI", "IA", "ID", "IL", "IN", "KS", "KY", 
                "LA", "MA", "MD", "ME", "MI", "MN", "MO", "MS", "MT", "NC", "ND", 
                "NE", "NH", "NJ", "NM", "NV", "NY", "OH", "OK", "OR", "PA", "RI", 
                "SC", "SD", "TN", "TX", "UT", "VA", "VT", "WA", "WI", "WV", "WY");

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		degreeTypeCombo.setItems(degree);
		degreeTypeCombo.setValue("Bachelors");
		stateComboBox.setItems(stateList);
		stateComboBox.setValue("GA");
		
	}
	
	public void closeWindow() {
		Stage stage2 = (Stage) cancelButton.getScene().getWindow();
	    stage2.close();
	}
	
	public void getQuery() {
		System.out.println("School: GSU");
		System.out.println("Grad Year: " + gradYearField.getText());
		System.out.println("State: " + stateComboBox.getValue());
		System.out.println("Major: " + majorField.getText());
		System.out.println("Degree: " + degreeTypeCombo.getValue());
		System.out.println("Profession: " + professionField.getText());
		System.out.println("Company: " + companyField.getText());
	}
		
		

}
