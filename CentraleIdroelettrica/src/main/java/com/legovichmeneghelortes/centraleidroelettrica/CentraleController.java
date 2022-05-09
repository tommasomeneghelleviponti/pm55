/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.legovichmeneghelortes.centraleidroelettrica;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author jordi
 */
public class CentraleController implements Initializable{

    boolean loaded;
    
    private static String code; //nome della centrale
    
    @FXML
    private Label active;

    @FXML
    private Label address;

    @FXML
    private Label identifier;

    @FXML
    private Label nPower;

    @FXML
    private Label province;

    @FXML
    void delete(ActionEvent event) throws IOException {
        // cancello la centrale caricata e i record e torno alla home
        App.setRoot("index");
    }
    
    @FXML
    public void caricaCentrale(String code){
        //creo una centrale in base al nome (code) dato
        CentraleController.code = code;
        System.out.println(code);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //set text con gli attributi della centrale
        identifier.setText(code); //questo era una prova, code è il nome della centrale
    }
    
    @FXML
    void newRecord(ActionEvent event) throws IOException {
        App.setRoot("addRecord");
    }
}
