/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.legovichmeneghelortes.centraleidroelettrica.model.classes;


import com.legovichmeneghelortes.centraleidroelettrica.exceptions.DuplicateRecordException;
import com.legovichmeneghelortes.centraleidroelettrica.exceptions.PlantNotFoundException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.time.format.DateTimeFormatter;
import java.util.DuplicateFormatFlagsException;
import java.util.LinkedList;
import java.util.Map;
import org.yaml.snakeyaml.Yaml;

/**
 * @author ortes.riccardo Classe che rappresenta l'oggetto della centrale
 * idroelettrica
 */
public class Plant {

    private String identifies;
    private String address;
    private String province;
    private double nominal_power; //MW
    private boolean flag;

    /**
     * Metodo per costruire l'oggetto centrale
     *
     * @param identifies un codice alfanumerico di 4 cifre che la identifica in
     * maniera univoca
     * @param address ubicazione della centrale
     * @param province provincia italiana in cui si trova la centrale
     * @param nominal_power potenza nominale in megawatt
     * @param flag un flag che indica se la centrale e' attiva oppure in
     * manutenzione
     */
    public Plant(String identifies, String address, String province, double nominal_power, boolean flag) {
        this.identifies = identifies;
        this.address = address;
        this.province = province;
        this.nominal_power = nominal_power;
        this.flag = flag;
    }

    public Plant() {

    }

    public LinkedList<Record> getProduction() {

        RWHandler io = RWHandler.getInstance ();

        LinkedList < Record > production = io.getRecords ();
        LinkedList < Record > current = new LinkedList <> ();

        production.stream ().filter ( r -> ( r.belongsTo ( this ) ) ).forEachOrdered ( r -> {
            current.add ( r );
        } );

        return current;
    }

    public void addRecord (Record r) throws DuplicateRecordException, PlantNotFoundException {

        RWHandler io = RWHandler.getInstance ();

        io.writeRecord ( r );

    }

    public String getIdentifies() {
        return identifies;
    }

    public void setIdentifies(String identifies) {
        this.identifies = identifies;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public double getNominal_power() {
        return nominal_power;
    }

    public void setNominal_power(double nominal_power) {
        this.nominal_power = nominal_power;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

}
