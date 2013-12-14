package solitaire.controle;

import solitaire.application.Carte;
import solitaire.application.TasDeCartesColorees;
import solitaire.application.Usine;
import solitaire.presentation.PTasDeCartesColorees;

/**
 * 
 * Controle TasDeCartes colorés
 *
 */
public class CTasDeCartesColores extends TasDeCartesColorees {

	private PTasDeCartesColorees p;
	private int nbCartes;
	
	/**
	 * construction d'un tas de cartes colorées
	 * @param nom nom de tas de carte
	 * @param v la valeur de la carte
	 * @param u usine à créer les composants
	 */
	public CTasDeCartesColores(String nom, int v, Usine u) {
		super(nom, v, u);

		this.p = new PTasDeCartesColorees(this);
		this.nbCartes = 0;

	}
	
	/**
	 * 
	 * @return le nombre de cartes
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
	 * @return la presentation de tas de cartes colorées
	 */
	public PTasDeCartesColorees getPresentation() {
		return p;
	}
	
	/**
	 * depiler la carte
	 */
	public void depiler() throws Exception {
		Carte s = getSommet();
		super.depiler();
		p.depiler(((CCarte) s).getPresentation());
	}
	
	/**
	 * empiler la carte
	 */
	public void empiler(Carte c) {
		if (isEmpilable(c)) {
			super.empiler(c);
			p.empiler(((CCarte) c).getPresentation());
		}
	}
	
	/**
	 * quitter le drag
	 * @param cc controle de la carte
	 */
	public void p2c_dragExit(CCarte cc) {
		p.c2p_ShowNotre();
	}
	
	/**
	 * 
	 * @param cc controle de la carte
	 */
	public void p2c_drop(CCarte cc) {

		if (isEmpilable(cc)) {

			empiler(cc);
			p.c2p_DropOK(cc.getPresentation());
		} else {
			p.c2p_DropKO(cc, getPresentation());
		}

		p.c2p_ShowNotre();

	}
	
	/**
	 * voir si la carte est empilable ou pas 
	 * @param cc controle de la carte
	 */
	public void p2c_dragEnter(CCarte cc) {
		if (isEmpilable(cc)) {
			p.c2p_ShowEmpilable();
		} else {
			p.c2p_ShowNonEmpilable();
		}
	}
}
