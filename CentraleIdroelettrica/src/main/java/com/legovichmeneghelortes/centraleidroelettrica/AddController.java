package com.legovichmeneghelortes.centraleidroelettrica;

import com.legovichmeneghelortes.centraleidroelettrica.model.classes.Plant;
import com.legovichmeneghelortes.centraleidroelettrica.model.classes.RWHandler;
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
    void saveData(ActionEvent event) throws IOException { //creo la centrale inserendo tutti i dati presi dalle textview
        String name = identifier.getText();
        boolean isActive = flag.isSelected();
        double nomPower = Double.parseDouble(nPower.getText());
        String prov = province.getText();
        String addr = address.getText();
        Plant nP = new Plant(name, addr, prov, nomPower, isActive);
        RWHandler.getInstance().writePlant(nP);
        App.setRoot("index");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Plant newPlant = new Plant();
    }

}