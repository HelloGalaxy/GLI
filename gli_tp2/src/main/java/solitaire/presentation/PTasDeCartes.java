package solitaire.presentation;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import solitaire.controle.CTasDeCartes;


/**
 * presentation de tas de cartes
 * @author 14010158
 *
 */
public class PTasDeCartes extends JPanel {

	private static final long serialVersionUID = 3620486048135778533L;

	private CTasDeCartes controle;

	private int lastX;
	private int lastY;

	private int dx;
	private int dy;

	// private int nbCarte;
	/**
	 * construction d'un tas de cartes
	 * @param contorle le controle de tas de cartes
	 */
	public PTasDeCartes(CTasDeCartes contorle) {
		init(contorle);
	}

	public PTasDeCartes(CTasDeCartes contorle, int dx, int dy) {

		init(contorle);
		this.dx = dx;
		this.dy = dy;
	}
	
	/**
	 * initialiser le tas de cartes
	 * @param contorle le controle de tas de cartes
	 */
	private void init(CTasDeCartes contorle) {
		this.controle = contorle;

		setLayout(null);
		setBackground(Color.lightGray);
		setSize(PCarte.largeur, PCarte.hauteur);
		setPreferredSize(getSize());

		this.lastX = 0;
		this.lastY = 0;
	}

	public int getDx() {
		return dx;
	}

	public int getDy() {
		return dy;
	}
	
	public int getLastX() {
		return lastX;
	}

	public int getLastY() {
		return lastY;
	}
	
	/**
	 * 
	 * @return la taille
	 */

	public Dimension getControleSize() {

		int height = PCarte.hauteur + (controle.getNbCartes() - 1) * dy;
		int width = PCarte.largeur + (controle.getNbCartes() - 1) * dx;

		Dimension size = new Dimension(width, height);

		return size;
	}
	
	/**
	 * 
	 * @return le controle tas de cartes
	 */
	public final CTasDeCartes getControle() {
		return controle;
	}
	
	/**
	 * depiler la carte
	 * @param pc la presentation de la carte
	 */
	public void depiler(PCarte pc) {
		remove(pc);
		lastX -= dx;
		lastY -= dy;
	}
	
	/**
	 *  empiler la carte
	 * @param pc la presentation de la carte
	 */
	public void empiler(PCarte pc) {
		add(pc, 0);
		pc.setLocation(lastX, lastY);
		lastX += dx;
		lastY += dy;
	}

	public void setDxDy(int dx, int dy) {
		this.dx = dx;
		this.dy = dy;
	}

}
