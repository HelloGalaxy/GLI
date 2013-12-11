package solitaire.controle;

import solitaire.application.Sabot;
import solitaire.application.Tas;
import solitaire.application.Usine;
import solitaire.presentation.PSabot;

public class CSabot extends Sabot {

	private PSabot p;
	private int nbGroupeCartes;

	private CSolitaire solitaire;
	
	private CCarte tmpTransCarte;

	public CSabot(String nom, Usine u) {

		super(nom, u);

		this.p = new PSabot(this, ((CTasDeCartes) cachees).getPresentation(),
				((CTasDeCartes) visibles).getPresentation());

		this.nbGroupeCartes = 3;
	}
	
	public void setSolitaire(CSolitaire solitaire){
		this.solitaire = solitaire;
	}

	public PSabot getPresentation() {
		return p;
	}

	public int getNbGroupeCartes() {
		return nbGroupeCartes;
	}

	public void setNbGroupeCartes(int nbGroupeCartes) {
		this.nbGroupeCartes = nbGroupeCartes;
	}

	public void setReserve(Tas t) {

		super.setReserve(t);

		if (isCarteRetournable()) {
			p.activerRetourneCarte();
			p.desactiverRetourneTas();
		}
	}
	
	public void moveCarteToColorees(CCarte c) {
		this.solitaire.moveCarteToColorees(c);
	}

	public void retournerCarte() throws Exception {
		
		super.retournerCarte();

		if (isRetournable()) {
			p.desactiverRetourneCarte();
			p.activerRetourneTas();
		}

		p.repaint();
	}

	public void retourner() throws Exception {

		super.retourner();

		if (!isRetournable()) {
			p.desactiverRetourneTas();
		}

		if (isCarteRetournable()) {
			p.activerRetourneCarte();
		}

		p.repaint();
	}

	public void depiler() throws Exception {
		super.depiler();
		if (!isRetournable()) {
			p.desactiverRetourneTas();
		}
	}

	public void p2c_debutDnD(CCarte c) {
		
		// TODO:
		System.out.println("DEBUT DND");
		
		try {
			if (c == getSommet()) {
				
				depiler();
				tmpTransCarte = c;
				//TODO: dev
				System.out.println("Drag:" + c.getValeur()  + "-" + c.getCouleur());
				p.c2p_debutDnDOK(c);
				
			} else {
				p.c2p_debutDnDKO(c);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void p2c_dragDropEnd(boolean dropSuccess) {
		if (!dropSuccess) {
			empiler(tmpTransCarte);
		}
	}

}
