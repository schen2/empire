/**
 * model/Carte.java
 *
 * File generated from the Carte uml Class
 * Generated by the Acceleo UML 2.1 to Java generator module (Obeo)
 * $ Date : 2/26/14 2:00:37 PM (February 26, 2014) $
 */
package environment;

// Start of user code to add imports for Carte
 
import agents.Unite;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

// End of user code

/**
 * Description of the class Carte.
 *
 */

public class Carte {
    private int hauteur;
    private int largeur;
    private HashSet<Position> positions;
    private Map map = new HashMap();
    // private HashSet<Case> cases;
    // private HashSet<Arete> aretes;

    // Start of user code to add fields for Carte

    // End of user code

    /**
     * Constructor.
     */
    public Carte() {
        // Start of user code for constructor Carte
        super();
        hauteur = 10;
        largeur = 10;
        map = new HashMap();
        positions = new HashSet<Position>();
        for(int i=0; i<largeur; ++i)
            for(int j=0; j<hauteur; ++j) {
                Position p = new Position(i,j);
                positions.add(p);
                Case c = new Case();
                map.put(p,c);
            }
        // End of user code
    }

    public Case getCase(Unite unite) {
        return null;
    }

    /**
     * Return hauteur.
     * @return hauteur
     */
    public int getHauteur() {
        return hauteur;
    }

    /**
     * Return largeur.
     * @return largeur
     */
    public int getLargeur() {
        return largeur;
    }




    // Start of user code to add methods for Carte

    // End of user code
}