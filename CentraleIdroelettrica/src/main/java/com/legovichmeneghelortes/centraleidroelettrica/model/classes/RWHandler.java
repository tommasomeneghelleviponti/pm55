package com.legovichmeneghelortes.centraleidroelettrica.model.classes;

// singleton model

/**
 *
 * @author meneghel.tommaso
 */
public class RWHandler {

    private static RWHandler instance;

    private RWHandler () {
        // finish implementing
    }

    public static RWHandler getInstance () {
        if ( instance != null ) {
            instance = new RWHandler ();
        }
        return instance;
    }

    // all above is singleton boilerplate code


    
}
