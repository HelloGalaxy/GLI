package dev;

import java.awt.Color;
import java.awt.FlowLayout;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import solitaire.application.Usine;
import solitaire.controle.CCarte;
import solitaire.controle.CTasDeCartesColores;

/**
 * 
 * tester le tas de cartes colorées
 *
 */
public class TasDeCartesColoreesTest {
	public static void main(String args[]) {

		JFrame f = new JFrame("TasDeCartesColorees");
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setLayout(new FlowLayout());
		f.getContentPane().setBackground(new Color(143, 143, 195));

		CTasDeCartesColores controle = new CTasDeCartesColores("QH", 1,
				new Usine());

		Random r = new Random();
		int count = r.nextInt(13) + 1;
		for (int i = 0; i < count; i++) {
			CCarte controleDeCarte = new CCarte(i+1, 1);
			controle.empiler(controleDeCarte);
		}

		f.getContentPane().add(controle.getPresentation());
		f.pack();
		f.setLocation(200, 100);
		f.setVisible(true);
	}
}
