package dev;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import solitaire.controle.CCarte;

public class CarteTest {
	/**
	 * programme de test : à déplacer dans une classe dédiée aux tests
	 * 
	 * @param args
	 */
	public static void main(String args[]) {

		JFrame f = new JFrame("Test PCarte");
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setLayout(new FlowLayout()); // au lieu de BorderLayout par défaut
		f.getContentPane().setBackground(new Color(143, 143, 195)); // violet
																	// pâle

		CCarte controle = new CCarte(3, 2);
		controle.setFaceVisible(true);
		// // une carte visible
		// PCarte pc = new PCarte (controle, "QH");
		// pc.setFaceVisible(true);
		// f.getContentPane ().add(pc) ;
		//
		// // une carte cachée
		// pc = new PCarte(controle, "1D");
		// pc.setFaceVisible(false);
		// f.getContentPane ().add(pc) ;

		f.getContentPane().add(controle.getPresentation());
		f.pack(); // dimensionner le cadre
		f.setLocation(200, 100); // le positionner
		f.setVisible(true); // et le rendre visible
	} // main

}
