package solitaire.controle;

import solitaire.application.Carte;
import solitaire.application.TasDeCartes;
import solitaire.application.Usine;
import solitaire.presentation.PTasDeCartes;

public class CTasDeCartes extends TasDeCartes {

	private PTasDeCartes p;
	private int nbCartes;

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

	public int getNbCartes() {
		return nbCartes;
	}

	public void setNbCartes(int nbCartes) {
		this.nbCartes = nbCartes;
	}

	public PTasDeCartes getPresentation() {
		return p;
	}

	public void depiler() throws Exception {
		Carte s = getSommet();
		super.depiler();
		p.depiler(((CCarte) s).getPresentation());
		nbCartes--;
	}

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
