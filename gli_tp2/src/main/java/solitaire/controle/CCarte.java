package solitaire.controle;

import solitaire.application.Carte;
import solitaire.presentation.*;

public class CCarte extends Carte {

	private PCarte p;

	public CCarte(int v, int c) {

		super(Math.min(Math.max(1, v), NbCartesParCouleur), Math.min(
				Math.max(1, c), NbCouleurs));

		p = new PCarte(this, valeurs[getValeur() - 1]
				+ couleurs[getCouleur() - 1]);
		p.setFaceVisible(isFaceVisible());

	}

	public void setFaceVisible(boolean v) {
		super.setFaceVisible(v);
		p.setFaceVisible(isFaceVisible());
	}

	public PCarte getPresentation() {
		return this.p;
	}
	
}
