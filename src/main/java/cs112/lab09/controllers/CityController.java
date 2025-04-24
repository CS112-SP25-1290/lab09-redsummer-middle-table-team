package cs112.lab09.controllers;

import cs112.lab09.Constants;
import cs112.lab09.Constants.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class CityController {

    @FXML
    private ImageView eventImageView;

    @FXML
    private Label locationLabel;

    @FXML
    private Label dateLabel;

    @FXML
    private Label descriptionLabel;

    @FXML
    private Label revisedDescriptionLabel;

    @FXML
    private Hyperlink citationHyperlink;

    @FXML
    private Button closeButton;

    @FXML
    private void initialize() {
        // Check which city is selected and update the labels accordingly
        Event selectedCity = Constants.selectedCity;

        if (selectedCity != null) {
            // Get event data based on selectedCity
            int cityIndex = selectedCity.ordinal();  // Get index based on enum order (SAN_FRANCISCO = 0, BISBEE = 1)
            String[] cityData = Constants.HISTORICAL_DATA[cityIndex];

            // Set location, date, and descriptions based on the selected city
            locationLabel.setText(cityData[1]); // Location
            dateLabel.setText(cityData[3]); // Date
            descriptionLabel.setText(cityData[2]); // Description
            revisedDescriptionLabel.setText(cityData[4]); // Revised Description

            // Set image for the selected city
            eventImageView.setImage(new Image(cityData[0])); // Image Path

            // Set the citation hyperlink (this can be adjusted based on how citations work in your app)
            citationHyperlink.setText(cityData[5]); // Citation text (you might need to add logic for handling the link)
            citationHyperlink.setOnAction(e -> System.out.println("Hyperlink clicked: " + cityData[5]));
        } else {
            // Set default values if no city is selected
            locationLabel.setText("Test Loc");
            dateLabel.setText("Default Date");
            descriptionLabel.setText("Default Description");
            revisedDescriptionLabel.setText("Default Revised Description");

            eventImageView.setImage(new Image(Constants.HISTORICAL_DATA[0][0])); // Default image for the first event

            // Example hyperlink action
            citationHyperlink.setOnAction(e -> System.out.println("Hyperlink clicked"));
        }

        // Close button logic (if relevant)
        closeButton.setOnAction(e -> handleClose());
        System.out.println("City information initialized.");
    }

    private void handleClose() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}
