package solitaire.controle;

import solitaire.application.Carte;
import solitaire.application.TasDeCartesAlternees;
import solitaire.application.Usine;
import solitaire.presentation.PTasDeCartesAlternees;

/**
 * 
 * controle de TasDeCartes Alternées
 *
 */
public class CTasDeCartesAlternees extends TasDeCartesAlternees {

	private PTasDeCartesAlternees p;
	private int nbCartes;
	
	/**
	 * construction d'un tas de cartes alternées
	 * @param nom le nom de tas de carte
	 * @param u usine à créer les composants
	 */
	public CTasDeCartesAlternees(String nom, Usine u) {
		super(nom, u);
		p = new PTasDeCartesAlternees(this);
		nbCartes = 0;
	}
	
	/**
	 * 
	 * @return presentation de TasDeCartes Alternées
	 */
	public PTasDeCartesAlternees getPresentation() {
		return p;
	}
	
	/**
	 * 
	 * @return nombre de cartes
	 */
	public int getNbCartes() {
		return nbCartes;
	}
	
	/**
	 * modifier l'attribut nombre de cartes
	 * @param nbCartes nombre de cartes
	 */
	public void setNbCartes(int nbCartes) {
		this.nbCartes = nbCartes;
	}
	
	/**
	 * depiler la carte
	 */
	public void depiler() throws Exception {
		Carte s = getSommet();
		super.depiler();
		p.depiler(((CCarte) s).getPresentation());
		nbCartes--;
	}
	
	/**
	 * depiler la carte
	 */
	public void empiler(Carte c) {
		super.empiler(c);
		try {
			if (c == getSommet()) {
				p.empiler(((CCarte) c).getPresentation());
				nbCartes++;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
