package solitaire.controle;

import java.util.LinkedList;
import java.util.List;

import solitaire.application.Carte;
import solitaire.application.Colonne;
import solitaire.application.Tas;
import solitaire.application.Usine;
import solitaire.presentation.PColonne;

/**
 * 
 * controle de la colonne
 *
 */
public class CColonne extends Colonne {

	private PColonne p;

	private CCarte tmpTransCarte;
	private CTasDeCartesAlternees tmpTransTas;
	private boolean isTransTas = false;

	private CSolitaire solitaire;
	
	/**
	 * construction d'une colonne
	 * @param nom Nom de la colonne
	 * @param u usine permet de créer les composants(TasDeCartes,TasDeCartesAlternees)
	 */
	public CColonne(String nom, Usine u) {
		super(nom, u);

		p = new PColonne(this, ((CTasDeCartes) cachees).getPresentation(),
				((CTasDeCartesAlternees) visibles).getPresentation());
	}
	
	/**
	 * 
	 * @return presentation de la colonne
	 */
	public PColonne getPresentation() {
		return p;
	}
	
	/**
	 * retourne la carte au sommet du tas de cartes cachées et la place sur le tas de cartes alternées
	 */
	public void retournerCarte() throws Exception {

		super.retournerCarte();

		if (!isCarteRetournable()) {
			p.desactiverRetournneCarte();
		}
	}
	
	/**
	 * affecter le controle solitaire au objet courant
	 * @param solitaire controle solitaire
	 */
	public void setSolitaire(CSolitaire solitaire) {
		this.solitaire = solitaire;
	}
	
	/**
	 * recopie d'un tas de cartes dans le tas de cartes cachées de la colonne
	 * @param Tas le tas de cartes à recopier
	 */
	public void setReserve(Tas tas) {

		super.setReserve(tas);

		if (!isCarteRetournable()) {
			p.desactiverRetournneCarte();
		}
	}
	
	/**
	 * indique si un tas de cartes est empilable sur la colonne
	 * @param Tas le tas de cartes à empiler 
	 */
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
	
	/**
	 * lancement de drap and drop
	 * @param c controle de la carte
	 * @param ctas controle TasDeCartesAlternees
	 */
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
	
	/**
	 * 
	 * @param dropSuccess envoie true si le drop fonctionne bien
	 * @throws Exception envoie une exception si le drop fonctionne pas
	 */
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
	
	/**
	 * quitter le drag
	 * @param cc controle de la carte
	 */
	public void p2c_dragExit(CCarte cc) {
		p.c2p_ShowNotre();
	}
	
	/**
	 * 
	 * @param cc controle de la carte
	 */
	public void p2c_drop(CCarte cc) {
		if (isEmpilable(cc) || isVide()) {
			empiler(cc);
			p.c2p_DropOK(cc.getPresentation());
		} else {
			p.c2p_DropKO(cc, getPresentation());
		}
		p.c2p_ShowNotre();
	}
	
	/**
	 * 
	 * @param cc TasDeCarteAternnées
	 * @throws Exception envoyer une exception
	 */
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
	
	/**
	 * voir s'il reste des cartes cachées alors ShowEmpilable
	 * @param cc controle de la carte
	 */
	public void p2c_dragEnter(CCarte cc) {
		if (isEmpilable(cc)
				|| (cachees.getNombre() >= 0 && visibles.getNombre() == 0)) {
			p.c2p_ShowEmpilable();
		} else {
			p.c2p_ShowNonEmpilable();
		}
	}
	
	/**
	 * voir s'il reste des cartes cachées alors ShowEmpilable
	 * @param cc controle TasDeCartesAlternee
	 */
	public void p2c_dragEnter(CTasDeCartesAlternees cc) {
		if (isEmpilable(cc)
				|| (cachees.getNombre() >= 0 && visibles.getNombre() == 0)) {
			p.c2p_ShowEmpilable();
		} else {
			p.c2p_ShowNonEmpilable();
		}
	}
}
