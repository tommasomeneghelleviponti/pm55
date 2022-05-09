/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.legovichmeneghelortes.centraleidroelettrica;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddRecordController {

    @FXML
    private Button cancel;

    @FXML
    private TextField mounth;

    @FXML
    private TextField power;

    @FXML
    private Button save;

    @FXML
    private TextField year;

    @FXML
    void closeWindow(ActionEvent event) throws IOException {
        //delete and don't save
        App.setRoot("centrale");
    }
    
    @FXML
    void saveData(ActionEvent event) throws IOException {
        //new record and return to central screen
        App.setRoot("centrale");
    }
}
