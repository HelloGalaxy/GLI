package solitaire.controle;

import solitaire.application.Sabot;
import solitaire.application.Tas;
import solitaire.application.Usine;
import solitaire.presentation.PSabot;

/**
 * Controle Sabot
 *
 */
public class CSabot extends Sabot {

	private PSabot p;
	private int nbGroupeCartes;

	private CSolitaire solitaire;
	
	private CCarte tmpTransCarte;
	
	/**
	 * contructeur de sabot
	 * @param nom Nom de sabot
	 * @param u usine à créer les composants(deux TasDeCartes)
	 * 
	 */
	public CSabot(String nom, Usine u) {

		super(nom, u);

		this.p = new PSabot(this, ((CTasDeCartes) cachees).getPresentation(),
				((CTasDeCartes) visibles).getPresentation());

		this.nbGroupeCartes = 3;
	}
	
	/**
	 * affecter le controle solitaire au objet courant
	 * @param solitaire controle solitaire
	 */
	public void setSolitaire(CSolitaire solitaire){
		this.solitaire = solitaire;
	}
	
	/**
	 * 
	 * @return presentation du sabot
	 */
	public PSabot getPresentation() {
		return p;
	}
	
	/**
	 * 
	 * @return le nombre de groupes Cartes
	 */
	public int getNbGroupeCartes() {
		return nbGroupeCartes;
	}
	
	/**
	 * modifier l'attribut nbGroupeCartes
	 * @param nbGroupeCartes nombre de groupes Cartes
	 */
	public void setNbGroupeCartes(int nbGroupeCartes) {
		this.nbGroupeCartes = nbGroupeCartes;
	}
	
	/**
	 * recopie d'un tas de cartes dans le tas de cartes cachées de la colonne
	 * @param Tas tasDeCartes
	 */
	public void setReserve(Tas t) {

		super.setReserve(t);

		if (isCarteRetournable()) {
			p.activerRetourneCarte();
			p.desactiverRetourneTas();
		}
	}
	
	/**
	 * deplacer la carte
	 * @param c controle de la carte
	 */
	public void moveCarteToColorees(CCarte c) {
		this.solitaire.moveCarteToColorees(c);
	}
	
	/**
	 * retourner une carte
	 */
	public void retournerCarte() throws Exception {
		
		super.retournerCarte();

		if (isRetournable()) {
			p.desactiverRetourneCarte();
			p.activerRetourneTas();
		}

		p.repaint();
	}
	
	/**
	 * activer ou desactiver la carte ou bien le tasDeCarte retournées
	 */
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
	
	/**
	 * dépile une carte du double tas
	 */
	public void depiler() throws Exception {
		super.depiler();
		if (!isRetournable()) {
			p.desactiverRetourneTas();
		}
	}
	
	/**
	 * le lancement du Drag and drop
	 * @param c controle de la carte
	 */
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
	
	/**
	 * 
	 * @param dropSuccess indique si le drop fonctionne bien
	 */
	public void p2c_dragDropEnd(boolean dropSuccess) {
		if (!dropSuccess) {
			empiler(tmpTransCarte);
		}
	}

}
