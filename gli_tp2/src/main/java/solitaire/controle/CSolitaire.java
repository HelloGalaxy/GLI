package solitaire.controle;

import solitaire.application.Colonne;
import solitaire.application.Solitaire;
import solitaire.application.TasDeCartesColorees;
import solitaire.application.Usine;
import solitaire.presentation.PSolitaire;

/**
 * Controle solitaire
 * 
 */
public class CSolitaire extends Solitaire {
	
	private PSolitaire p;
	public static final int deltaX = 15;
	public static final int deltaY = 25;
	
	/**
	 * 
	 * @param nom Nom de solitaire
	 * @param usine usine à créer les composants
	 */
	public CSolitaire(String nom, Usine usine) {
		super(nom, usine);
		this.initialiser();
		this.p = new PSolitaire(this, this.sabot, this.pilesAlternees, this.pilesColorees);
		
		((CSabot)this.sabot).setSolitaire(this);
		
		for(Colonne ctas : this.pilesAlternees) {
			((CColonne)ctas).setSolitaire(this);
		}
	}
	
	/**
	 * 
	 * @return presentation de solitaire
	 */
	public PSolitaire getPresentation() { return this.p; }
	
	/**
	 * deplacer la carte
	 * @param c controle de la carte
	 */
	public void moveCarteToColorees(CCarte c) {
		TasDeCartesColorees ctas = this.pilesColorees[c.getCouleur()];
		ctas.empiler(c);
	}
}
