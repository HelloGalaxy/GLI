package solitaire.presentation;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceAdapter;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.io.IOException;

import javax.swing.JPanel;

import solitaire.controle.CCarte;
import solitaire.controle.CColonne;
import solitaire.controle.CTasDeCartesAlternees;

public class PColonne extends JPanel {

	private static final long serialVersionUID = -7531553579310128111L;

	private CColonne controle;
	private PTasDeCartes cachees;
	private PTasDeCartesAlternees visibles;

	private DragSource ds;
	private DragGestureEvent theInitialEvent;
	private DragSourceListener myDSL;

	private DropTargetDropEvent theFinalEvent;
	private DropTarget dt;

	public PColonne(CColonne controle, PTasDeCartes cachees,
			PTasDeCartesAlternees pTasDeCartesAlternees) {
		super();

		// this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		this.controle = controle;
		this.cachees = cachees;
		this.visibles = pTasDeCartesAlternees;

		add(this.cachees);
		add(this.visibles);

		this.cachees.setDxDy(0, 15);
		this.visibles.setDxDy(0, 25);

		updateControlsSize();

		this.myDSL = new MyDragSourceListener();
		this.ds = new DragSource();
		this.ds.createDefaultDragGestureRecognizer(this.visibles,
				DnDConstants.ACTION_MOVE, new MyDragGestureListener());

		this.dt = new DropTarget(this, new MyDropTargetListener());
		
		this.setBackground(Color.lightGray);
	}

	public CColonne getControle() {
		return this.controle;
	}

	public PTasDeCartes getCachees() {
		return cachees;
	}

	public PTasDeCartesAlternees getVisibles() {
		return visibles;
	}

	public void updateControlsSize() {
		if (cachees != null && visibles != null) {

			Dimension cacheesSize = cachees.getControleSize();
			Dimension visibleSize = visibles.getControleSize();

			this.cachees.setLocation(0, 0);
			this.cachees.setSize(cacheesSize);
			this.cachees.setPreferredSize(getSize());

			this.visibles.setLocation(0, cachees.getLastY() + visibles.getDy());
			this.visibles.setSize(visibleSize);
			this.visibles.setPreferredSize(getSize());

			this.setLayout(null);

			this.setComponentZOrder(this.visibles, 0);
			this.setComponentZOrder(this.cachees, 1);

			int width = PCarte.largeur;
			int height = cacheesSize.height + visibleSize.height
					- (PCarte.hauteur - visibles.getDy() * 2);

			this.setSize(width, height);
			this.setPreferredSize(this.getSize());
		}
	}

	@Override
	public void repaint() {
		updateControlsSize();
		super.repaint();
	}

	public void activerReourenneCarte() {

	}

	public void desactiverRetournneCarte() {

	}

	public void c2p_debutDnDOK(CCarte c) {
		// TODO:
		System.out.println("BEGIN TO MOVE");

		ds.startDrag(theInitialEvent, DragSource.DefaultMoveDrop,
				c.getPresentation(), myDSL);
	}

	public void c2p_debutDnDOK(CTasDeCartesAlternees ctas) {
		// TODO:
		System.out.println("BEGIN TO MOVE");

		ds.startDrag(theInitialEvent, DragSource.DefaultMoveDrop,
				ctas.getPresentation(), myDSL);
	}

	public void c2p_debutDnDKO(CCarte c) {

	}

	class MyDragSourceListener implements DragSourceListener {

		public void dragDropEnd(DragSourceDropEvent e) {

			try {
				controle.p2c_dragDropEnd(e.getDropSuccess());
				controle.retournerCarte();
			} catch (Exception e1) {
				e1.printStackTrace();
			}

			repaint();
		}

		public void dragEnter(DragSourceDragEvent arg0) {

		}

		public void dragExit(DragSourceEvent arg0) {

		}

		public void dragOver(DragSourceDragEvent arg0) {

		}

		public void dropActionChanged(DragSourceDragEvent arg0) {

		}

	}

	class MyDragGestureListener extends DragSourceAdapter implements
			DragGestureListener {

		public void dragGestureRecognized(DragGestureEvent dge) {
			theInitialEvent = dge;
			PCarte pc = null;
			CCarte cc = null;

			try {

				// TODO: DEV
				System.out.println("Drag in " + dge.getDragOrigin());
				System.out.println("There are " + visibles.getComponentCount()
						+ " cartes.");

				pc = (PCarte) visibles.getComponentAt(dge.getDragOrigin());

				cc = pc.getControle();

			} catch (Exception ex) {
				System.out.println(ex);
			}

			controle.p2c_debutDnD(cc, visibles.getControle());
		}
	}

	class MyDropTargetListener implements DropTargetListener {

		private Object presentation;

		public void dragEnter(DropTargetDragEvent e) {

			System.out.println("Entrer");

			try {
				presentation = e.getTransferable().getTransferData(
						new DataFlavor(DataFlavor.javaJVMLocalObjectMimeType));

				if (presentation instanceof PCarte) {
					controle.p2c_dragEnter(((PCarte) presentation)
							.getControle());
				} else if (presentation instanceof PTasDeCartesAlternees) {
					controle.p2c_dragEnter(((PTasDeCartesAlternees) presentation)
							.getControle());
				}

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
			System.out.println("Drop the " + presentation);
			System.out.println("Location: " + e.getLocation());
			System.out.println("Remember event:" + e);

			theFinalEvent = e;

			if (presentation instanceof PCarte) {
				controle.p2c_drop(((PCarte) presentation).getControle());
			} else if (presentation instanceof PTasDeCartesAlternees) {
				try {
					controle.p2c_drop(((PTasDeCartesAlternees) presentation)
							.getControle());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			
			setBackground(Color.lightGray);
		}

		public void dropActionChanged(DropTargetDragEvent arg0) {

		}

	}

	public void c2p_ShowEmpilable() {
		this.setBackground(Color.green);
	}

	public void c2p_ShowNonEmpilable() {
		this.setBackground(Color.red);
	}

	public void c2p_ShowNotre() {
		repaint();
	}

	public void c2p_DropOK(PCarte presentation) {
		theFinalEvent.acceptDrop(DnDConstants.ACTION_MOVE);
		theFinalEvent.getDropTargetContext().dropComplete(true);
	}

	public void c2p_DropOK(PTasDeCartesAlternees presentation) {
		theFinalEvent.acceptDrop(DnDConstants.ACTION_MOVE);
		theFinalEvent.getDropTargetContext().dropComplete(true);
	}

	public void c2p_DropKO(CCarte cc, PColonne pColonne) {
		// TODO
		System.out.println("Final Event:" + theFinalEvent);
		theFinalEvent.rejectDrop();
	}

	public void c2p_DropKO() {
		// TODO
		System.out.println("Final Event:" + theFinalEvent);
		theFinalEvent.rejectDrop();
	}

}
