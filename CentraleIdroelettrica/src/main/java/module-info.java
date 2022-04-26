module com.legovichmeneghelortes.centraleidroelettrica {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.yaml.snakeyaml;

    opens com.legovichmeneghelortes.centraleidroelettrica to javafx.fxml;
    exports com.legovichmeneghelortes.centraleidroelettrica;
}
