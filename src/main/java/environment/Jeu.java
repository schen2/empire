/**
* model/Jeu.java
*
* File generated from the Jeu uml Class
* Generated by the Acceleo UML 2.1 to Java generator module (Obeo)
* $ Date : 2/26/14 2:00:37 PM (February 26, 2014) $
*/
package environment;

// Start of user code to add imports for Jeu

import agents.Base;

import java.util.ArrayList;


// End of user code

/**
* Description of the class Jeu.
*
*/

public class Jeu {
    private ArrayList<Base> bases;
    private ArrayList<Base> playedBases;
    private Carte carte;
    private Base baseCourante;
    private double t;

    // Start of user code to add fields for Jeu

    // End of user code

    /**
     * Constructor.
     */
    public Jeu() {
        // Start of user code for constructor Jeu
        super();
        t = 0;
        // End of user code
    }

    /**
     * Return bases.
     * @return bases
     */
    public ArrayList<Base> getBases() {
        return bases;
    }

    /**
     * Set a value to attribute bases.
     * @param bases
     */
    public void setBases(ArrayList<Base> bases) {
        this.bases = bases;
    }

    /**
     * Add a bases to the bases collection.
     * @param bases_elt Element to add.
     */
    public void addBases(Base bases_elt) {
        this.bases.add(bases_elt);
    }

    /**
     * Remove a bases to the bases collection.
     * @param bases_elt Element to remove
     */
    public void removeBases(Base bases_elt) {
        this.bases.remove(bases_elt);
    }

    /**
     * Return carte.
     * @return carte
     */
    public Carte getCarte() {
        return carte;
    }

    /**
     * Set a value to attribute carte.
     * @param carte
     */
    public void setCarte(Carte carte) {
        this.carte = carte;
    }


    /**
     * Description of the method avancerTemps.
     *
     */
    public void avancerTemps() {
        // Start of user code for method avancerTemps
        t++;
        // End of user code
    }

    /**
     * Description of the method jouer.
     *
     * @param baseCourante
     */
    public void jouer(Base baseCourante) {
        // Start of user code for method jouer
        Base b = getBaseCourante();

        baseCourante.jouer();
        changerBaseCourante();
        // End of user code
    }

    /**
     * Description of the method fini.
     *
     * @return ret
     */
    public boolean fini() {
        // Start of user code for method fini

        boolean ret = false;
        ret = playedBases.size() == 0;

        for(Base b : bases) {
            if (b.getPv() == 0)
                ret = true;
        }

        return ret;
        // End of user code
    }

    /**
     * Description of the method getBaseCourante.
     *
     * @return ret
     */
    public Base getBaseCourante() {
        // Start of user code for method getBaseCourante
        return baseCourante;
        // End of user code
    }

    /**
     * Description of the method changerBaseCourante.
     *
     */
    public void changerBaseCourante() {
        // Start of user code for method changerBaseCourante
        playedBases.remove(baseCourante);

        int n = playedBases.size();
        int number = (int)(Math.random()*n);
        baseCourante = playedBases.get(number);
        // End of user code
    }

    /**
     * Description of the method changerBaseCourante.
     *
     */
    public void initTour() {
        // Start of user code for method changerBaseCourante
        playedBases = bases;
        // End of user code
    }

    // Start of user code to add methods for Jeu

    // End of user code
}