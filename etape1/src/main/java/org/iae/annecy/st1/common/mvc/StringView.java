/**
 * 
 */

package org.iae.annecy.st1.common.mvc;

/**
 * DÃ©finie le comportement d'une vue.
 * 
 * @author Djer1013
 */
public interface StringView {

	/**
	 * Construit une representation des donnÃ©es.
	 * 
	 * @param datas
	 *            Données à  intégrer dans la representation
	 * @return Une chaine de caractère representant les donnÃ©es pour un
	 *         utilisateur
	 */
	String build(DataView datas);

}
