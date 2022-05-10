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

    private static String code;
    
    @FXML
    private Button cancel;

    @FXML
    private TextField month;

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
//        String c = AddRecordController.code;
//        Record rec = new Record(c, month.getText(), year.getText(), Double.parseDouble(power.getText()));
//        App.setRoot("centrale");
    }
    
    public void setCode(String c){
        AddRecordController.code = c;
    }
}
