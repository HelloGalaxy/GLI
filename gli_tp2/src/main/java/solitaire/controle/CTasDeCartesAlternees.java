package solitaire.controle;

import solitaire.application.Carte;
import solitaire.application.TasDeCartesAlternees;
import solitaire.application.Usine;
import solitaire.presentation.PTasDeCartesAlternees;

public class CTasDeCartesAlternees extends TasDeCartesAlternees {

	private PTasDeCartesAlternees p;
	private int nbCartes;

	public CTasDeCartesAlternees(String nom, Usine u) {
		super(nom, u);
		p = new PTasDeCartesAlternees(this);
		nbCartes = 0;
	}

	public PTasDeCartesAlternees getPresentation() {
		return p;
	}

	public int getNbCartes() {
		return nbCartes;
	}

	public void setNbCartes(int nbCartes) {
		this.nbCartes = nbCartes;
	}

	public void depiler() throws Exception {
		Carte s = getSommet();
		super.depiler();
		p.depiler(((CCarte) s).getPresentation());
		nbCartes--;
	}

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
