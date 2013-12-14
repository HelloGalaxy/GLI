package solitaire.presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.io.IOException;

import javax.swing.JPanel;

import solitaire.controle.CCarte;
import solitaire.controle.CTasDeCartesColores;

/**
 * 
 * la presentation de tas de cartes colorées
 *
 */
public class PTasDeCartesColorees extends JPanel {

	private static final long serialVersionUID = 3390303295175333340L;
	private CTasDeCartesColores controle;

	private DropTargetDropEvent theFinalEvent;
	private DropTarget dt;
	
	/**
	 * contruction PTasDeCartesColorees
	 * @param contorle controle tas de cartes colorées 
	 */
	public PTasDeCartesColorees(CTasDeCartesColores contorle) {

		this.controle = contorle;
		this.setLayout(null);
		this.setSize(this.getControleSize());
		this.setPreferredSize(getSize());

		this.dt = new DropTarget(this, new MyDropTargetListener());
		setBackground(Color.lightGray);
	}
	
	/**
	 * 
	 * @return Tas de cartes colorées
	 */

	public final CTasDeCartesColores getControle() {
		return controle;
	}
	
	/**
	 * 
	 * @return la taille du controle
	 */
	public Dimension getControleSize() {

		Dimension size = new Dimension(PCarte.largeur, PCarte.hauteur);

		return size;
	}
	
	/**
	 * depiler la carte
	 * @param pc presentation de la carte
	 */
	public void depiler(PCarte pc) {
		remove(pc);
		this.repaint();
	}
	
	/**
	 * empiler la carte
	 * @param pc presentation de la carte
	 */
	public void empiler(PCarte pc) {
		add(pc, 0);
		pc.setLocation(0, 0);
		this.repaint();
	}

	class MyDropTargetListener implements DropTargetListener {

		private PCarte pc;

		public void dragEnter(DropTargetDragEvent e) {

			System.out.println("Entrer");

			try {
				pc = (PCarte) e.getTransferable().getTransferData(
						new DataFlavor(DataFlavor.javaJVMLocalObjectMimeType));
				controle.p2c_dragEnter(pc.getControle());

				System.out
						.println("I get you "
								+ e.getTransferable()
										.getTransferData(
												new DataFlavor(
														DataFlavor.javaJVMLocalObjectMimeType)));

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (UnsupportedFlavorException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		/**
		 * quitter le drag
		 */
		public void dragExit(DropTargetEvent arg0) {
			System.out.println("exit");
			// controle.p2c_dragExit(pc.getControle());
			setBackground(Color.lightGray);
		}

		public void dragOver(DropTargetDragEvent arg0) {
			System.out.println("over");
		}

		public void drop(DropTargetDropEvent e) {

			// TODO
			System.out.println("Drop the " + pc);
			System.out.println("Location: " + e.getLocation());
			System.out.println("Remember event:" + e);

			theFinalEvent = e;
			controle.p2c_drop(pc.getControle());
			setBackground(Color.lightGray);
		}

		public void dropActionChanged(DropTargetDragEvent arg0) {
		}

	}
	
	/**
	 * modifier la couleur
	 */
	public void c2p_ShowEmpilable() {
		this.setBackground(Color.green);
	}

	public void c2p_ShowNonEmpilable() {
		this.setBackground(Color.red);
	}

	public void c2p_ShowNotre() {
		repaint();
	}
	
	/**
	 * 
	 * @param presentation presentation de la carte
	 */
	public void c2p_DropOK(PCarte presentation) {
		theFinalEvent.acceptDrop(DnDConstants.ACTION_MOVE);
		theFinalEvent.getDropTargetContext().dropComplete(true);
	}
	
	/**
	 * 
	 * @param cc controle de la carte
	 * @param presentation la presentation de tas de cartes colorées
	 */
	public void c2p_DropKO(CCarte cc, PTasDeCartesColorees presentation) {

		// TODO
		System.out.println("Final Event:" + theFinalEvent);
		theFinalEvent.rejectDrop();
	}

}
