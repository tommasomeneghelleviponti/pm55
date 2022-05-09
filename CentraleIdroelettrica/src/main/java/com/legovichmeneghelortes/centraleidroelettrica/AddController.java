package com.legovichmeneghelortes.centraleidroelettrica;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class AddController implements Initializable{

    @FXML
    private TextField address;

    @FXML
    private Button cancel;

    @FXML
    private CheckBox flag;

    @FXML
    private TextField identifier;

    @FXML
    private TextField nPower;

    @FXML
    private TextField province;

    @FXML
    private Button save;

    @FXML
    void closeWindow(ActionEvent event) throws IOException {
        App.setRoot("index");
    }

    @FXML
    void saveData(ActionEvent event) throws IOException {
        String name = identifier.getText();
        //newPlant.setIdentifies(name);
        //newPlant.setIdentifies(name);
        //newPlant.setIdentifies(name);
        //newPlant.setIdentifies(name);
        //newPlant.setIdentifies(name);
        boolean isActive = flag.isSelected();
        closeWindow(new ActionEvent());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Plant newPlant = new Plant();
    }

}