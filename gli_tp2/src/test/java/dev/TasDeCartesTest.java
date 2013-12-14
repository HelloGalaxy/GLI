package dev;

import java.awt.Color;
import java.awt.FlowLayout;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import solitaire.controle.CCarte;
import solitaire.controle.CTasDeCartes;
import solitaire.controle.CUsine;

/**
 * 
 * tester le tas de cartes
 *
 */
public class TasDeCartesTest {

	public static void main(String args[]) {

		JFrame f = new JFrame("Test PTasDeCarte");
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setLayout(new FlowLayout());
		f.getContentPane().setBackground(new Color(143, 143, 195));

		CTasDeCartes controle = new CTasDeCartes("AH", new CUsine());

		Random r = new Random();
		int count = 10;
		for (int i = 0; i < count; i++) {
			CCarte controleDeCarte = new CCarte(r.nextInt(13), r.nextInt(4));
			controle.empiler(controleDeCarte);
		}

		// controle.setFaceVisible(true);

		f.getContentPane().add(controle.getPresentation());
		f.pack();
		f.setLocation(200, 100);
		f.setVisible(true);
	}
}
