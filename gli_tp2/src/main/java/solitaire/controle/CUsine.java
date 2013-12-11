package solitaire.controle;

import solitaire.application.Carte;
import solitaire.application.Colonne;
import solitaire.application.Sabot;
import solitaire.application.Solitaire;
import solitaire.application.TasDeCartes;
import solitaire.application.TasDeCartesAlternees;
import solitaire.application.TasDeCartesColorees;
import solitaire.application.Usine;

public class CUsine extends Usine {

	@Override
	public Carte newCarte(int v, int c) {
		return new CCarte(v, c);
	}

	@Override
	public Colonne newColonne(String nom, Usine u) {
		return new CColonne(nom, u);
	}

	@Override
	public Sabot newSabot(String nom, Usine u) {
		return new CSabot(nom, u);
	}

	@Override
	public TasDeCartes newTasDeCartes(String nom, Usine u) {
		return new CTasDeCartes(nom, u);
	}

	@Override
	public TasDeCartesAlternees newTasDeCartesAlternees(String nom, Usine u) {
		return new CTasDeCartesAlternees(nom, u);
	}

	@Override
	public TasDeCartesColorees newTasDeCartesColorees(String nom, int v, Usine u) {
		return new CTasDeCartesColores(nom, v, u);
	}

	@Override
	public Solitaire newSolitaire(String nom, Usine usine) {

		return new CSolitaire(nom, usine);
	}

}
