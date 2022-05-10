/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.legovichmeneghelortes.centraleidroelettrica;

import com.legovichmeneghelortes.centraleidroelettrica.model.classes.Plant;
import com.legovichmeneghelortes.centraleidroelettrica.model.classes.RWHandler;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author jordi
 */
public class CentraleController implements Initializable{

    boolean loaded;
    
    private static String code; //nome della centrale
    
    @FXML
    private Label home;
    
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
        RWHandler.getInstance().deletePlant(code);
        App.setRoot("index");
    }
    
    @FXML
    public void caricaCentrale(String code){
        CentraleController.code = code;
        System.out.println(code);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //set text con gli attributi della centrale
        LinkedList <Plant> allPlants = RWHandler.getInstance().getPlants();
        Plant rightOne = new Plant();
        for(Plant s : allPlants){
            if(s.getIdentifies().equals(code)){
                rightOne = s;
            }
        }
        identifier.setText(rightOne.getIdentifies());
        address.setText(rightOne.getAddress());
        province.setText(rightOne.getProvince());
        nPower.setText(String.valueOf(rightOne.getNominal_power()));
        active.setText(rightOne.isFlag() ? "yes" : "no");
        
    }
    
    @FXML
    void newRecord(ActionEvent event) throws IOException {
        AddRecordController ad = new AddRecordController();
        ad.setCode(code);
        App.setRoot("addRecord");
    }
    
    @FXML
    void goHome(MouseEvent event) throws IOException {
        App.setRoot("index");
    }
    
    public static String getCode(){
        return code;
    }
}