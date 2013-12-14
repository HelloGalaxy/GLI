package dev;

import solitaire.controle.CSolitaire;
import solitaire.controle.CUsine;

/**
 * 
 * tester le jeu de solitaire
 *
 */
public class SolitaireTest {
	
	public static void main(String args[]) {
		CUsine usine = new CUsine();
		CSolitaire mainSolitaire = (CSolitaire) usine.newSolitaire("TEST", usine);
		mainSolitaire.initialiser();
	}
}
