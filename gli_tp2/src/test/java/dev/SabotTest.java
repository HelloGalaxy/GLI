package dev;

import java.awt.Color;
import java.awt.FlowLayout;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import solitaire.controle.CCarte;
import solitaire.controle.CSabot;
import solitaire.controle.CTasDeCartes;
import solitaire.controle.CUsine;
import solitaire.presentation.PSabot;

/**
 * 
 * tester le sabot
 *
 */
public class SabotTest {
	public static void main(String args[]) {

		JFrame f = new JFrame("Test PSabot");
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setLayout(new FlowLayout()); // au lieu de BorderLayout par défaut
		f.getContentPane().setBackground(new Color(143, 143, 195)); // violet
																	// pâle

		CSabot controle = new CSabot("Sabot", new CUsine());

		PSabot p = controle.getPresentation();
		//CTasDeCartes cv = p.getVisibles().getControle();
		CTasDeCartes cc = p.getCachees().getControle();

		Random r = new Random();
		int count = 5;
		for (int i = 0; i < count; i++) {
			CCarte controleDeCarte = new CCarte(r.nextInt(13), r.nextInt(4));
			//controle.empiler(controleDeCarte);
			//controleDeCarte = new CCarte(r.nextInt(13), r.nextInt(4));
			cc.empiler(controleDeCarte);
		}

	
		
		
		f.getContentPane().add(controle.getPresentation());
		f.pack(); // dimensionner le cadre
		f.setLocation(200, 100); // le positionner
		f.setVisible(true); // et le rendre visible
	} // main
}
