package dev;

import java.awt.Color;
import java.awt.FlowLayout;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import solitaire.controle.CCarte;
import solitaire.controle.CTasDeCartesAlternees;
import solitaire.controle.CUsine;

public class TasDeCartesAlternnesTest {
	public static void main(String args[]) {

		JFrame f = new JFrame("TasDeCartesAlternnes");
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setLayout(new FlowLayout()); 
		f.getContentPane().setBackground(new Color(143, 143, 195)); 

		CTasDeCartesAlternees controle = new CTasDeCartesAlternees("2D", new CUsine());
		controle.getPresentation().setDxDy(0, 25);
		
		Random r = new Random();
		int count = 5;
		for (int i = 0; i < count; i++) {
			CCarte controleDeCarte = new CCarte(r.nextInt(13), r.nextInt(4));
			controle.empiler(controleDeCarte);
		}

		f.getContentPane().add(controle.getPresentation());
		f.pack();
		f.setLocation(200, 100);
		f.setVisible(true);
	}
}
