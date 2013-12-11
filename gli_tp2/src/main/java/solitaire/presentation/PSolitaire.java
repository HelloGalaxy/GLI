package solitaire.presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import solitaire.application.Colonne;
import solitaire.application.Sabot;
import solitaire.application.TasDeCartesColorees;
import solitaire.controle.CColonne;
import solitaire.controle.CSabot;
import solitaire.controle.CSolitaire;
import solitaire.controle.CTasDeCartesColores;

public class PSolitaire extends JFrame {

	private static final long serialVersionUID = -8201490869683184236L;

	private CSolitaire controle;

	public PSolitaire(CSolitaire controle, Sabot sabot, Colonne[] colonnes,
			TasDeCartesColorees[] pilesColorees) {

		this.controle = controle;

		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setVisible(true);

		this.setSize(1000, 700);
		this.setPreferredSize(getSize());

		Dimension screenSize = this.getToolkit().getScreenSize();
		Point location = new Point((screenSize.width - this.getWidth()) / 2,
				(screenSize.height - this.getHeight()) / 2 - 20);
		this.setLocation(location.x, location.y);

		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(new Color(0, 30, 120, 255));
		mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
		mainPanel.setLayout(new BorderLayout());
		this.add(mainPanel);

		PSabot psabot = ((CSabot) sabot).getPresentation();
		mainPanel.add(psabot, BorderLayout.NORTH);

		JPanel coloeesPanel = new JPanel();
		coloeesPanel.setLayout(new GridLayout(4, 1, 0, 10));
		coloeesPanel.setBackground(null);
		mainPanel.add(coloeesPanel, BorderLayout.EAST);

		for (int i = 0; i < pilesColorees.length; i++) {
			PTasDeCartesColorees colorees = ((CTasDeCartesColores) pilesColorees[i])
					.getPresentation();
			coloeesPanel.add(colorees);
		}

		JPanel colonnesPanel = new JPanel();
		colonnesPanel.setLayout(new GridLayout(1, 0, 20, 0));
		colonnesPanel.setBackground(null);
		colonnesPanel.setBorder(new EmptyBorder(30, 0, 0, 0));
		mainPanel.add(colonnesPanel, BorderLayout.CENTER);

		for (int i = 0; i < colonnes.length; i++) {
			PColonne pcol = ((CColonne) colonnes[i]).getPresentation();
			colonnesPanel.add(pcol);
		}

		this.addComponentListener(new ComponentListener() {

			private final int MINHEIGHT = 620;
			private final int MINWIDTH = 835;

			public void componentShown(ComponentEvent arg0) {

			}

			public void componentResized(ComponentEvent arg0) {
				Dimension size = getSize();

				if (size.height < MINHEIGHT) {
					size.height = MINHEIGHT;
				}

				if (size.width < MINWIDTH) {
					size.width = MINWIDTH;
				}

				setSize(size);
			}

			public void componentMoved(ComponentEvent arg0) {

			}

			public void componentHidden(ComponentEvent arg0) {

			}
		});
	}

	public CSolitaire getControle() {
		return controle;
	}

}
