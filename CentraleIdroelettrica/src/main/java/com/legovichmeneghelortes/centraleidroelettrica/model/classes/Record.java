/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.legovichmeneghelortes.centraleidroelettrica.model.classes;

/**
 * @author ortes.riccardo Classe che rappresenta i record della centrale
 * idroelettrica
 */
public class Record {

    private String code;
    private String month;
    private String year;
    private double megawatt_hour; //MW
    
    /**
    * @param code codice della centrale
    * @param month mese di rifermento 
    * @param year anno di rifermento
    * @param megawatt_hour Megawattora prodotti nel mese di riferimento.
    */
    public Record(String code, String month, String year, double megawatt_hour) {
        this.code = code;
        this.month = month;
        this.year = year;
        this.megawatt_hour = megawatt_hour;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public double getMegawatt_hour() {
        return megawatt_hour;
    }

    public void setMegawatt_hour(double megawatt_hour) {
        this.megawatt_hour = megawatt_hour;
    }
}
