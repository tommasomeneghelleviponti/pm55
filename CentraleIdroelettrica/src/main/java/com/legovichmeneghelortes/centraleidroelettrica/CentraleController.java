/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.legovichmeneghelortes.centraleidroelettrica;

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
    void delete(ActionEvent event) {

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
}
