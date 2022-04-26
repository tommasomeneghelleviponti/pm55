/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.legovichmeneghelortes.centraleidroelettrica.model.classes;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.Map;

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
    private LinkedList<Record> production;

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

    public void loadRecords() {
        production = new LinkedList<Record>();
        try ( BufferedReader bfr = new BufferedReader(new FileReader("data/records/" + identifies + "storic.txt"))) {
            String currentLine, year, month;
            while ((currentLine = bfr.readLine()) != null) {
                String[] sections = currentLine.split("-");
                year = sections[0];
                month = sections[1];
                double mw = Double.parseDouble(bfr.readLine());

                Record r = new Record(identifies, month, year, mw);
                production.add(r);
                bfr.readLine();
            }

        } catch (FileNotFoundException ex) {
            System.out.println("fnfex");
        } catch (IOException ex) {
            System.out.println("ioex");
        }
    }

    public LinkedList<Record> getProduction() {

//        production = new LinkedList<Record>();
//        try ( BufferedReader bfr = new BufferedReader(new FileReader("data/records/" + identifies + "storic.txt"))) {
//            String currentLine, year, month;
//            while ((currentLine = bfr.readLine()) != null) {
//                String[] sections = currentLine.split("-");
//                year = sections[0];
//                month = sections[1];
//                double mw = Double.parseDouble(bfr.readLine());
//
//                Record r = new Record(identifies, month, year, mw);
//                production.add(r);
//                bfr.readLine();
//            }
//
//        } catch (FileNotFoundException ex) {
//            System.out.println("fnfex");
//        } catch (IOException ex) {
//            System.out.println("ioex");
//        }
        this.loadRecords();

        return production;
    }

    public void logProduction(Record r) {
        String code = r.getCode();
        double mw = r.getMegawatt_hour();
        String year = r.getYear();
        String month = r.getMonth();
        boolean reserch = reserchRecord(code, mw, year, month);
        if(!reserch){
            production.add(new Record(code, month, year, mw));
        }
        org.yaml.snakeyaml.Yaml l = new org.yaml.snakeyaml.Yaml();

        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream("customer.yaml");
        Map<String, Object> obj = l.load(inputStream);
        System.out.println(obj);
    }

    public boolean reserchRecord(String code, double mw, String year, String month) {

    }

    public void setProduction(LinkedList<Record> production) {
        this.production = production;
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
