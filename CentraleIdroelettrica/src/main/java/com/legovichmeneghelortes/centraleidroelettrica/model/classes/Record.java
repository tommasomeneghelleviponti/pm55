/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.legovichmeneghelortes.centraleidroelettrica.model.classes;

import java.util.LinkedList;

/**
 * @author ortes.riccardo Classe che rappresenta i record della centrale
 * idroelettrica
 */
public class Record {

    private String code;
    private int month;
    private int year;
    private double megawatt_hour; //MW
    
    /**
    * @param code codice della centrale
    * @param month mese di rifermento 
    * @param year anno di rifermento
    * @param megawatt_hour Megawattora prodotti nel mese di riferimento.
    */
    public Record(String code, int month, int year, double megawatt_hour) {
        this.code = code;
        this.month = month;
        this.year = year;
        this.megawatt_hour = megawatt_hour;
    }

    public Record ( Record other ) {
        this.code = other.code;
        this.month = other.month;
        this.year = other.year;
        this.megawatt_hour = other.megawatt_hour;
    }

//    public static LinkedList <Record> getProduction ( String id ) {
//        RWHandler io = RWHandler.getInstance();
//        io.get
//    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getMegawatt_hour() {
        return megawatt_hour;
    }

    public void setMegawatt_hour(double megawatt_hour) {
        this.megawatt_hour = megawatt_hour;
    }

    public boolean belongsTo ( Plant plant ) {
        return this.code.equals(plant.getIdentifies());
    }

    public boolean equals ( Record r ) {
        boolean condition = false;

        condition = code.equals ( r.code ) && month == r.month && year == r.year 
                && megawatt_hour == r.megawatt_hour;

        return condition;
    }
}
