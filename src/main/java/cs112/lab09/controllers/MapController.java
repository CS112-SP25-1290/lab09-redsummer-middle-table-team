package cs112.lab09.controllers;

import cs112.lab09.Constants;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import java.io.IOException;

public class MapController {
    @FXML
    private ImageView mapImageView;
    @FXML
    private Button sanFranciscoCaliforniaButton;
    @FXML
    private Button bisbeeAzButton;

    @FXML
    private void handleSanFranciscoButton() throws IOException {
        System.out.println("clicked San Francisco, California button");
        openCityPopup(Constants.Event.SAN_FRANCISCO);
    }

    @FXML
    private void handleBisbeeButton() throws IOException {
        System.out.println("clicked Bisbee, Arizona button");
        openCityPopup(Constants.Event.BISBEE);
    }

    private void openCityPopup(Constants.Event event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/cs112/lab09/" + Constants.CITY_VIEW_RESOURCE));
        Scene cityScene = new Scene(loader.load(), 500, 400);
        Stage popupStage = new Stage();
        popupStage.setScene(cityScene);
        popupStage.setTitle(Constants.CITY_VIEW_TITLE);
        popupStage.show();
    }
}