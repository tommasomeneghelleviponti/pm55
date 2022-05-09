package com.legovichmeneghelortes.centraleidroelettrica;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class PrimaryController implements Initializable {
    
    ObservableList<String> items = FXCollections.observableArrayList (
            "Single", "Double", "Suite", "Family App");
    
    @FXML
    private TextField text;
    
    @FXML
    private ListView <String> list;
    
    @FXML
    private void switchToAdd() throws IOException {
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
    public void initialize(URL url, ResourceBundle rb) {
        list.getItems().addAll(items);
    }
}
