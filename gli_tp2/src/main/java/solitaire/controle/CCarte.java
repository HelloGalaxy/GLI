package solitaire.controle;

import solitaire.application.Carte;
import solitaire.presentation.*;

/**
 * 
 * controle de la carte
 *
 */
public class CCarte extends Carte {

	private PCarte p;

	/**
	 * Construteur de la Carte qui prend deux valeures comme paramétres
	 * @param v valeur d'une carte comprise entre 1 et 13 
	 * @param c couleur d'une carte comprise entre 1 et 4
	 */
	public CCarte(int v, int c) {

		super(Math.min(Math.max(1, v), NbCartesParCouleur), Math.min(
				Math.max(1, c), NbCouleurs));

		p = new PCarte(this, valeurs[getValeur() - 1]
				+ couleurs[getCouleur() - 1]);
		p.setFaceVisible(isFaceVisible());

	}

	/**
	 * rend la carte visible ou non
	 * @param v indiquer si la carte est visible ou pas
	 */
	public void setFaceVisible(boolean v) {
		super.setFaceVisible(v);
		p.setFaceVisible(isFaceVisible());
	}

	/**
	 * 
	 * @return presentation de la carte
	 */
	public PCarte getPresentation() {
		return this.p;
	}
	
}
