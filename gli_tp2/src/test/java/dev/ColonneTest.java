package dev;

import java.awt.Color;
import java.awt.FlowLayout;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import solitaire.controle.CCarte;
import solitaire.controle.CColonne;
import solitaire.controle.CTasDeCartes;
import solitaire.controle.CTasDeCartesAlternees;
import solitaire.controle.CUsine;
import solitaire.presentation.PColonne;

/**
 * 
 * tester les colonnes 
 *
 */
public class ColonneTest {
	public static void main(String args[]) {

		JFrame f = new JFrame("Test Colonne");
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setLayout(new FlowLayout()); // au lieu de BorderLayout par défaut
		f.getContentPane().setBackground(new Color(143, 143, 195)); // violet
																	// pâle

		CColonne controle = new CColonne("QH", new CUsine());

		PColonne p = controle.getPresentation();
		CTasDeCartesAlternees cv = p.getVisibles().getControle();
		CTasDeCartes cc = p.getCachees().getControle();

		Random r = new Random();
		int count = 5;
		for (int i = 0; i < count; i++) {

			CCarte controleDeCarte = new CCarte(r.nextInt(13), r.nextInt(4));
			cv.empiler(controleDeCarte);

			controleDeCarte = new CCarte(r.nextInt(13), r.nextInt(4));
			cc.empiler(controleDeCarte);
		}
		
		p.repaint();

		f.getContentPane().add(controle.getPresentation());
		f.pack(); // dimensionner le cadre
		f.setLocation(200, 100); // le positionner
		f.setVisible(true); // et le rendre visible
	} // main
}
