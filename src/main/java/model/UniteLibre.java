/**
 * model/UniteLibre.java
 *
 * File generated from the UniteLibre uml Interface
 * Generated by the Acceleo UML 2.1 to Java generator module (Obeo)
 * $ Date : 2/26/14 2:00:37 PM (February 26, 2014) $
 */
package model;

// Start of user code to add imports for UniteLibre
 

// End of user code

/**
 * Description of the interface UniteLibre.
 *
 */

public interface UniteLibre {
	
	// Start of user code to add fields for UniteLibre
 
	// End of user code

    /**
     *  Description of the method seDeplacer.
     *
     *
     * @param caseLibre
     */
    public void seDeplacer(CaseLibre caseLibre);

    /**
     *  Description of the method seDeplacerCase.
     *
     *
     * @param caseAdjacente
     */
    public void seDeplacerCase(CaseLibre caseAdjacente);

    /**
     *  Description of the method suivreUnite.
     *
     *
     * @param cible
     */
    public void suivreUnite(UniteLibre cible);

    /**
     *  Description of the method reagir.
     *
     *
     */
    public void reagir();

	// Start of user code to add methods for UniteLibre
 
	// End of user code
}