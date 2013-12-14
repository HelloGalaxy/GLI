package solitaire.controle;

import solitaire.application.Carte;
import solitaire.application.TasDeCartes;
import solitaire.application.Usine;
import solitaire.presentation.PTasDeCartes;

/**
 * 
 * Controle TasDeCartes
 *
 */
public class CTasDeCartes extends TasDeCartes {

	private PTasDeCartes p;
	private int nbCartes;
	
	/**
	 * construction d'un tas de cartes : 
	 * @param nom nom de tas de cartes
	 * @param u usine à créer les composants(TasDeCartes)
	 */
	public CTasDeCartes(String nom, Usine u) {
		super(nom, u);
		p = new PTasDeCartes(this);
		this.nbCartes = 0;
	}

	public CTasDeCartes(String nom, Usine u, int dx, int dy) {
		super(nom, u);
		p = new PTasDeCartes(this, dx, dy);
		this.nbCartes = 0;
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
	 * 
	 * @return presentation de TasDeCartes
	 */
	public PTasDeCartes getPresentation() {
		return p;
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
	 * empiler la carte
	 */
	public void empiler(Carte c) {
		if (isEmpilable(c)) {
			super.empiler(c);
			p.empiler(((CCarte) c).getPresentation());
			nbCartes++;
			// TODO: set parent?? for dnd
		}
	}

	// TODO: dnd
}
