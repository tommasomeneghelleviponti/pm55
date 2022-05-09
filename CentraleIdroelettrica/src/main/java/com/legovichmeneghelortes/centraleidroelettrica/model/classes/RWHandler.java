package com.legovichmeneghelortes.centraleidroelettrica.model.classes;

// singleton model
import com.legovichmeneghelortes.centraleidroelettrica.exceptions.DuplicateRecordException;
import com.legovichmeneghelortes.centraleidroelettrica.exceptions.PlantNotFoundException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
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
        update();
    }

    public static RWHandler getInstance () {
        if ( instance != null ) {
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
            yaml.dumpAll ( records.iterator (), new FileWriter ( new File ( "data/storic/records.yaml" ) ) );
            yaml.dumpAll ( plants.iterator (), new FileWriter ( new File ( "data/plants/extended.yaml" ) ) );
        } catch ( IOException ex ) {
            System.out.println ( "err" );
        }
    }

    public void update () {
        records.clear ();
        plants.clear ();
        try {
            for ( Object o : yaml.loadAll ( new FileInputStream ( new File ( "data/records/storic.yaml" ) ) ) ) {
                records.add ( ( Record ) o );
            }
            for ( Object o : yaml.loadAll ( new FileInputStream ( new File ( "data/plants/extended.yaml" ) ) ) ) {
                plants.add ( ( Plant ) o );
            }
        } catch ( FileNotFoundException ex ) {
            System.out.println ( "err" );
        }
        modified = false;
    }

    public LinkedList<Record> getRecords () {
        if ( !modified ) return records;
        return null;
    }

    public LinkedList<Plant> getPlants () {
        if ( !modified ) return plants;
        return null;
    }

    public void writePlant ( Plant p ) {
        if ( p != null ) {
            plants.add ( p );
        }
        this.write ();
        modified = false;
    }

    public void writeRecord ( Record r ) throws DuplicateRecordException {
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
}
