package com.legovichmeneghelortes.centraleidroelettrica.model.classes;

import java.io.InputStream;
import java.util.Objects;
import org.yaml.snakeyaml.Yaml;

/**
 *
 * @author meneghel.tommaso
 */
public class SimplePlant {

    protected String identifies;

    public SimplePlant ( String identifies ) {
        this.identifies = identifies;
    }

    public String getIdentifies() {
        return identifies;
    }

    public void setIdentifies(String identifies) {
        this.identifies = identifies;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    public static SimplePlant[] getSummary() {
        InputStream is = SimplePlant.class.getClassLoader().getResourceAsStream ( "data/plants/summary.yaml" );
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SimplePlant other = (SimplePlant) obj;
        return Objects.equals(this.identifies, other.identifies);
    }

}
