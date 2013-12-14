package solitaire.controle;

import solitaire.application.Carte;
import solitaire.application.Colonne;
import solitaire.application.Sabot;
import solitaire.application.Solitaire;
import solitaire.application.TasDeCartes;
import solitaire.application.TasDeCartesAlternees;
import solitaire.application.TasDeCartesColorees;
import solitaire.application.Usine;

/**
 * 
 * Controle Usine
 *
 */
public class CUsine extends Usine {
	
	/**
	 * creation de la carte
	 * @param v la valeur de la carte 
	 * @param c la couleur de la carte
	 */
	@Override
	public Carte newCarte(int v, int c) {
		return new CCarte(v, c);
	}
	
	/**
	 * creation de la colonne
	 * @param nom Nom de la colonne
	 * @param u usine à créer les composants
	 */
	@Override
	public Colonne newColonne(String nom, Usine u) {
		return new CColonne(nom, u);
	}
	
	/**
	 * creation de sabot
	 * @param nom Nom de sabot
	 * @param u  usine à créer les composants
	 */
	@Override
	public Sabot newSabot(String nom, Usine u) {
		return new CSabot(nom, u);
	}
	
	/**
	 * creation de tas de cartes
	 * @param nom le nom de tas de cartes
	 * @param u usine à créer les composants
	 */
	@Override
	public TasDeCartes newTasDeCartes(String nom, Usine u) {
		return new CTasDeCartes(nom, u);
	}
	
	/**
	 * creation de tas de cartes alternées
	 * @param nom le nom de tas de cartes amternées
	 * @param usine à créer les composants
	 */
	@Override
	public TasDeCartesAlternees newTasDeCartesAlternees(String nom, Usine u) {
		return new CTasDeCartesAlternees(nom, u);
	}
	
	/**
	 * creation de tas de cartes colorées
	 * @param nom le nom de tas de cartes colorées
	 * @param u usine à créer les composants
	 */
	@Override
	public TasDeCartesColorees newTasDeCartesColorees(String nom, int v, Usine u) {
		return new CTasDeCartesColores(nom, v, u);
	}
	
	/**
	 * creation de solitaire
	 * @param nom le nom de solitaire
	 * @param usine à créer les composants
	 */
	@Override
	public Solitaire newSolitaire(String nom, Usine usine) {

		return new CSolitaire(nom, usine);
	}

}
