package com.legovichmeneghelortes.centraleidroelettrica;

import com.legovichmeneghelortes.centraleidroelettrica.model.classes.Plant;
import com.legovichmeneghelortes.centraleidroelettrica.model.classes.RWHandler;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class PrimaryController implements Initializable {
    
    LinkedList <Plant> allPlants; //array di prova da cambiare con quello delle centrali
    
    LinkedList<String> items;
            
    @FXML
    private TextField text;
    
    @FXML
    private ListView <String> list;
    
    @FXML
    private void switchToAdd() throws IOException { //switch alla pagina per creare la centrale
        App.setRoot("add");
    }

    @FXML
    void search(KeyEvent event) {
        list.getItems().clear();
        String search = text.getText();
        for(String s : items){
            if(s.toLowerCase().contains(search.toLowerCase())){
                list.getItems().add(s);
            }
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) { // inizializzo con la listview con il nome delle centra
        
        allPlants = RWHandler.getInstance().getPlants();
        items = new LinkedList<String>();
        
        for(Plant p : allPlants){
            System.out.println(p.getIdentifies());
        }
        
        if(allPlants != null && !(allPlants.isEmpty())){
           for(Plant p : allPlants){
                items.add(p.getIdentifies());
            }
            list.getItems().addAll(items);
            
            list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){
            @Override
                public void changed(ObservableValue<? extends String> ov, String t, String t1String) { // listener che passa al controller della centrale la centrale cliccata
                    String current = list.getSelectionModel().getSelectedItem();
                    CentraleController cc = new CentraleController();
                    cc.caricaCentrale(current);
                    try {
                        App.setRoot("centrale");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            });
        }
    }
}
