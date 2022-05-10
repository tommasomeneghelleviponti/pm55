package com.legovichmeneghelortes.centraleidroelettrica.model.classes;

// singleton model
import com.legovichmeneghelortes.centraleidroelettrica.exceptions.DuplicateRecordException;
import com.legovichmeneghelortes.centraleidroelettrica.exceptions.PlantNotFoundException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import org.yaml.snakeyaml.Yaml;

/**
 *
 * @author meneghel.tommaso
 */
public class RWHandler {

    private static RWHandler instance;

    private RWHandler () {
        this.yaml = new Yaml ();
        this.modified = false;
        this.plants = new LinkedList<> ();
        this.records = new LinkedList<> ();
        update ();
    }

    public static RWHandler getInstance () {
        if ( instance == null ) {
            instance = new RWHandler ();
        }
        return instance;
    }

    // all above is singleton boilerplate code
    private boolean modified;
    private LinkedList< Record> records;
    private LinkedList< Plant> plants;
    private Yaml yaml;

    private void write () {
        try {
        FileOutputStream os = new FileOutputStream ( new File ( "data/plants/extended.yaml" ) );
        PrintWriter pw = new PrintWriter ( os );

        yaml.dumpAll ( plants.iterator (), pw ); 
        } catch ( IOException ex ) {
            System.out.println ( "err" );
        }
    }

    public void update () {
        records.clear ();
        plants.clear ();

        InputStream is;
//        try {
//            is = new FileInputStream ( new File ( "data/records/storic.yaml" ) );
//            for ( Object o : yaml.loadAll ( is ) ) {
//                Map < String, Object > map = ( Map < String, Object > ) o;
//                String code = ( String ) map.get ( "code" );
////                int month = ( Integer ) map.get ( "month" ) ;
//                int month = Integer.parseInt ( ( String ) map.get ( "month" ) );
//                int year = ( Integer ) map.get ( "year" );
////                int year = Integer.parseInt ( ( String ) map.get ( "year" ) );
//                double megawatt_hours = ( Double ) map.get ( "megawatt_hours" );
////                double megawatt_hours = Double.parseDouble ( ( String ) map.get ( "year" ) );
//                Record r = new Record ( code, month, year, megawatt_hours );
//
//                records.add ( r );
//            }
//        } catch ( FileNotFoundException ex ) {
//            ex.printStackTrace ();
//        }

        try {
            is = new FileInputStream ( new File ( "data/plants/extended.yaml" ) );
            for ( Object o : yaml.loadAll ( is ) ) {
//                Map < String, Object > map = ( Map < String, Object > ) o;
//                String identifies = ( String ) map.get ( "identifies" );
//                String address = ( String ) map.get ( "address" );
//                String province = ( String ) map.get ( "province" );
//                double nominal_power = ( Double ) map.get ( "nominal_power" );
//                boolean flag = ( Boolean ) map.get ( "flag" );
//                Plant p = new Plant (identifies, address, province, nominal_power, flag );

//                plants.add ( p );

                plants.add ( ( Plant ) o );
            }
        } catch ( FileNotFoundException ex ) {
            ex.printStackTrace ();
        }

        for ( Plant p : plants ) {
            System.out.println ( p.getIdentifies () );
        }

        for ( Record r : records ) {
            System.out.println ( r.getCode () );
        }

        modified = false;
    }

    public LinkedList<Record> getRecords () {
        if (  ! modified ) {
            return records;
        }
        return null;
    }

    public LinkedList<Plant> getPlants () {
        if (  ! modified ) {
            return plants;
        }
        return null;
    }

    // aggiungere controllo se già presente
    public void writePlant ( Plant p ) {
        if ( p != null ) {
            plants.add ( p );
        }
        this.write ();
        modified = false;
    }

    // TODO: unificare i due writerecord
    public void writeRecord ( Record r ) throws DuplicateRecordException, PlantNotFoundException {
        if ( r != null ) {
            if ( records.contains ( r ) ) {
                throw new DuplicateRecordException ( "record already there" );
            }
            records.add ( r );
        }

        this.write ();
        modified = false;
    }

    public void writeRecord ( String id, int month, int year, double power ) throws PlantNotFoundException {
        Plant x = null;
        Record r = new Record ( id, month, year, power );
        for ( Plant p : plants ) {
            if ( p.getIdentifies ().equals ( id ) ) {
                x = p;
                break;
            }
        }
        if ( x != null ) {
            records.add ( r );
        } else {
            throw new PlantNotFoundException ( "no plant with id " + id + " was found" );
        }
    }
    
    public void deletePlant(String code){
        for(Plant p : this.plants){
            if(p.getIdentifies().equals(code)){
                plants.remove(p);
            }
        }
        write();
    }
}
