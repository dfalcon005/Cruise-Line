package sample;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.*;

import javax.swing.*;
import java.io.IOException;



public class Controller{

    //declare radio buttons id's
    @FXML RadioButton interiorRoom;
    @FXML RadioButton oceanRoom;
    @FXML RadioButton balconyRoom;
    @FXML RadioButton suiteRoom;

    //declare checkbox id's
    @FXML CheckBox vip;
    @FXML CheckBox gratitude;
    @FXML CheckBox internet;
    @FXML CheckBox massage;
    @FXML CheckBox spa;
    @FXML CheckBox club;
    @FXML CheckBox surf;
    @FXML CheckBox theatre;
    @FXML CheckBox fitness;
    @FXML CheckBox trainer;
    @FXML CheckBox zipline;
    @FXML CheckBox horse;

    //declare button id
    @FXML Button totalPrice;

    //declare final label
    @FXML Label total;

    @FXML MenuItem exit;
    @FXML MenuItem undo;

    //close button pushed
    public void closeButtonClicked(){
        System.exit(0);
    }
    //

    //no button pushed on opening form
    public void noButtonClicked(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information dialog");
        alert.setHeaderText("");
        alert.setContentText("Please call our agency. This online form only allows for the purchase of cruise tickets for a family of two.");
        alert.showAndWait();
    }
    //yes button pushed on opening form
    public void yesButtonClicked() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("PriceCalculator.fxml"));
        Main.getPrimaryStage().setTitle("Falcon Cruise Line");
        Main.getPrimaryStage().setScene(new Scene(root, 800, 500));
        Main.getPrimaryStage().show();
    }


    //calc total
    @FXML
    private void handleButtonAction(){

        //set fields
        double cost, extra = 0.0, totalPrice;

        //radio buttons
        if (interiorRoom.isSelected())
            cost = 765 * 2;
        else if (oceanRoom.isSelected())
            cost = 810 * 2;
        else if (balconyRoom.isSelected())
            cost = 1090 * 2;
        else
            cost = 1560 * 2;

        //checkbox button
        if(internet.isSelected())
            extra += 25;
        if(massage.isSelected())
            extra += 100;
        if(spa.isSelected())
            extra += 95;
        if(club.isSelected())
            extra += 100;
        if(surf.isSelected())
            extra += 40;
        if(theatre.isSelected())
            extra += 50;
        if(fitness.isSelected())
            extra += 20;
        if(trainer.isSelected())
            extra += 45;
        if(zipline.isSelected())
            extra += 150;
        if(horse.isSelected())
            extra += 168;

        //vip and gratitude
        if(vip.isSelected())
            cost = cost - (cost * .10);
        if(gratitude.isSelected())
            cost = cost + 140;


        totalPrice = cost + extra;

        Main.getPrimaryStage().hide();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Total Price");
        alert.setHeaderText("");
        alert.setContentText((String.format("Your total price for a 7 day cruise is: $%,.2f", + totalPrice)));
        alert.showAndWait();
    }
}
