package solitaire.controle;

import solitaire.application.Carte;
import solitaire.application.TasDeCartesColorees;
import solitaire.application.Usine;
import solitaire.presentation.PTasDeCartesColorees;

public class CTasDeCartesColores extends TasDeCartesColorees {

	private PTasDeCartesColorees p;
	private int nbCartes;

	public CTasDeCartesColores(String nom, int v, Usine u) {
		super(nom, v, u);

		this.p = new PTasDeCartesColorees(this);
		this.nbCartes = 0;

	}

	public int getNbCartes() {
		return nbCartes;
	}

	public void setNbCartes(int nbCartes) {
		this.nbCartes = nbCartes;
	}

	public PTasDeCartesColorees getPresentation() {
		return p;
	}

	public void depiler() throws Exception {
		Carte s = getSommet();
		super.depiler();
		p.depiler(((CCarte) s).getPresentation());
	}

	public void empiler(Carte c) {
		if (isEmpilable(c)) {
			super.empiler(c);
			p.empiler(((CCarte) c).getPresentation());
		}
	}

	public void p2c_dragExit(CCarte cc) {
		p.c2p_ShowNotre();
	}

	public void p2c_drop(CCarte cc) {

		if (isEmpilable(cc)) {

			empiler(cc);
			p.c2p_DropOK(cc.getPresentation());
		} else {
			p.c2p_DropKO(cc, getPresentation());
		}

		p.c2p_ShowNotre();

	}

	public void p2c_dragEnter(CCarte cc) {
		if (isEmpilable(cc)) {
			p.c2p_ShowEmpilable();
		} else {
			p.c2p_ShowNonEmpilable();
		}
	}
}
