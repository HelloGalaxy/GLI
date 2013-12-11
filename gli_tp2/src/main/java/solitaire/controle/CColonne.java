package solitaire.controle;

import java.util.LinkedList;
import java.util.List;

import solitaire.application.Carte;
import solitaire.application.Colonne;
import solitaire.application.Tas;
import solitaire.application.Usine;
import solitaire.presentation.PColonne;

public class CColonne extends Colonne {

	private PColonne p;

	private CCarte tmpTransCarte;
	private CTasDeCartesAlternees tmpTransTas;
	private boolean isTransTas = false;

	private CSolitaire solitaire;

	public CColonne(String nom, Usine u) {
		super(nom, u);

		p = new PColonne(this, ((CTasDeCartes) cachees).getPresentation(),
				((CTasDeCartesAlternees) visibles).getPresentation());
	}

	public PColonne getPresentation() {
		return p;
	}

	public void retournerCarte() throws Exception {

		super.retournerCarte();

		if (!isCarteRetournable()) {
			p.desactiverRetournneCarte();
		}
	}

	public void setSolitaire(CSolitaire solitaire) {
		this.solitaire = solitaire;
	}

	public void setReserve(Tas tas) {

		super.setReserve(tas);

		if (!isCarteRetournable()) {
			p.desactiverRetournneCarte();
		}
	}

	@Override
	public boolean isEmpilable(Tas tas) {
		Carte c = null;
		try {
			c = tas.getCarte(tas.getNombre());
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(c);

		if (c != null) {
			return isEmpilable(c);
		}

		return false;
	}

	public void p2c_debutDnD(CCarte c, CTasDeCartesAlternees ctas) {

		// TODO:
		System.out.println("DEBUT DND");

		try {
			if (c == getSommet()) {
				depiler();
				isTransTas = false;
				tmpTransCarte = c;
				// TODO: dev
				System.out.println("Drag:" + c.getValeur() + "-"
						+ c.getCouleur());
				p.c2p_debutDnDOK(c);

			} else {
				// TODO: dev
				System.out.println("Drag tas!!!");
				isTransTas = true;
				tmpTransTas = ctas;
				p.c2p_debutDnDOK(ctas);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void p2c_dragDropEnd(boolean dropSuccess) throws Exception {
		// TODO: dev
		System.out.println("dropSuccess " + dropSuccess);
		if (!dropSuccess) {
			// TODO: dev
			System.out.println("isTransTas " + isTransTas);
			if (!isTransTas) {
				System.out.println("TTTT");
				empiler(tmpTransCarte);
			} else {
				// empiler(tmpTransTas);
				List<Carte> ctas = new LinkedList<Carte>();

				while (tmpTransTas.getNbCartes() != 0) {
					ctas.add(0, tmpTransTas.getSommet());
					tmpTransTas.depiler();
				}

				for (Carte c : ctas) {
					empiler(c);
				}
			}
		} else {

		}
	}

	public void p2c_dragExit(CCarte cc) {
		p.c2p_ShowNotre();
	}

	public void p2c_drop(CCarte cc) {
		if (isEmpilable(cc) || isVide()) {
			empiler(cc);
			p.c2p_DropOK(cc.getPresentation());
		} else {
			p.c2p_DropKO(cc, getPresentation());
		}
		p.c2p_ShowNotre();
	}

	public void p2c_drop(CTasDeCartesAlternees cc) throws Exception {
		if (isEmpilable(cc) || isVide()) {
			List<Carte> ctas = new LinkedList<Carte>();

			while (cc.getNbCartes() != 0) {
				ctas.add(0, cc.getSommet());
				System.out.println(cc.getSommet().getValeur());
				cc.depiler();
			}

			for (Carte c : ctas) {
				empiler(c);
			}
			p.c2p_DropOK(cc.getPresentation());
		} else {
			p.c2p_DropKO();
		}
		p.c2p_ShowNotre();
	}

	public void p2c_dragEnter(CCarte cc) {
		if (isEmpilable(cc)
				|| (cachees.getNombre() >= 0 && visibles.getNombre() == 0)) {
			p.c2p_ShowEmpilable();
		} else {
			p.c2p_ShowNonEmpilable();
		}
	}

	public void p2c_dragEnter(CTasDeCartesAlternees cc) {
		if (isEmpilable(cc)
				|| (cachees.getNombre() >= 0 && visibles.getNombre() == 0)) {
			p.c2p_ShowEmpilable();
		} else {
			p.c2p_ShowNonEmpilable();
		}
	}
}
