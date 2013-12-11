<<<<<<< HEAD
package solitaire.presentation;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceAdapter;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import solitaire.controle.CCarte;
import solitaire.controle.CSabot;

public class PSabot extends JPanel {

	private static final long serialVersionUID = 5119385230762345237L;

	private CSabot controle;
	private PTasDeCartes cachees;
	private PTasDeCartes visibles;

	private RetourneTasListener rtl;
	private RetourneCarteListener rcl;

	private DragSource ds;
	private DragGestureEvent theInitialEvent;
	private DragSourceListener myDSL;

	public PSabot(CSabot controle, PTasDeCartes cachees, PTasDeCartes visibles) {

		super();

		this.controle = controle;
		this.cachees = cachees;
		this.visibles = visibles;

		cachees.setDxDy(0, 0);
		visibles.setDxDy(25, 0);

		this.setLayout(null);

		updateControlsSize();

		add(this.cachees);
		add(this.visibles);

		this.rtl = new RetourneTasListener();
		this.rcl = new RetourneCarteListener();

		myDSL = new MyDragSourceListener();
		ds = new DragSource();
		ds.createDefaultDragGestureRecognizer(this.visibles,
				DnDConstants.ACTION_MOVE, new MyDragGestureListener());

//		this.addMouseListener(new MyClickListener());

		activerRetourneCarte();
	}

	public CSabot getControle() {
		return controle;
	}

	public PTasDeCartes getCachees() {
		return cachees;
	}

	public PTasDeCartes getVisibles() {
		return visibles;
	}

	public void updateControlsSize() {

		if (visibles != null && cachees != null) {

			Dimension cacheesSize = cachees.getControleSize();
			Dimension visibleSize = visibles.getControleSize();

			cachees.setLocation(new Point(0, 0));

			cachees.setSize(cacheesSize);
			cachees.setPreferredSize(getSize());

			visibles.setSize(visibleSize);
			visibles.setLocation(cacheesSize.width, 0);
			visibles.setPreferredSize(getSize());

			int width = cacheesSize.width + visibleSize.width;
			int height = PCarte.hauteur;

			this.setSize(width, height);
			this.setPreferredSize(getSize());

		}
	}

	@Override
	public void repaint() {
		updateControlsSize();
		super.repaint();
	}

	public void activerRetourneCarte() {
		this.cachees.addMouseListener(rcl);
	}

	public void desactiverRetourneCarte() {
		this.cachees.removeMouseListener(rcl);
	}

	public void activerRetourneTas() {
		this.cachees.addMouseListener(rtl);
	}

	public void desactiverRetourneTas() {
		this.cachees.removeMouseListener(rtl);
	}

	public void c2p_debutDnDOK(CCarte c) {
		// TODO:
		System.out.println("BEGIN TO MOVE");

		ds.startDrag(theInitialEvent, DragSource.DefaultMoveDrop,
				c.getPresentation(), myDSL);
	}

	public void c2p_debutDnDKO(CCarte c) {

	}

	class RetourneTasListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			try {
				controle.retourner();
			} catch (Exception ex) {
				System.out.println(ex);
			}
		}

		public void mouseEntered(MouseEvent e) {

		}

		public void mouseExited(MouseEvent e) {

		}

		public void mousePressed(MouseEvent e) {
		}

		public void mouseReleased(MouseEvent e) {

		}
	}

	class RetourneCarteListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {

			try {
				controle.retournerCarte();
			} catch (Exception ex) {
				System.out.println(ex);
			}
		}

		public void mouseEntered(MouseEvent e) {

		}

		public void mouseExited(MouseEvent e) {

		}

		public void mousePressed(MouseEvent e) {

		}

		public void mouseReleased(MouseEvent e) {

		}

	}

	class MyDragSourceListener implements DragSourceListener {

		public void dragDropEnd(DragSourceDropEvent e) {
			controle.p2c_dragDropEnd(e.getDropSuccess());
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

			controle.p2c_debutDnD(cc);
		}

	}

//	class MyClickListener implements MouseListener {
//
//		public void mouseClicked(MouseEvent e) {
//			System.out.println("Click count: " + e.getClickCount());
//
//			if (e.getClickCount() == 2) {
//
//				PCarte pc = (PCarte) visibles.getComponentAt(e.getPoint());
//
//				controle.moveCarteToColorees(pc.getControle());
//			}
//		}
//
//		public void mouseEntered(MouseEvent e) {
//		
//
//		}
//
//		public void mouseExited(MouseEvent e) {
//		
//
//		}
//
//		public void mousePressed(MouseEvent e) {
//		
//
//		}
//
//		public void mouseReleased(MouseEvent e) {
//		
//
//		}

//	}

}
=======
package solitaire.presentation;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceAdapter;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import solitaire.controle.CCarte;
import solitaire.controle.CSabot;

public class PSabot extends JPanel {

	private static final long serialVersionUID = 5119385230762345237L;

	private CSabot controle;
	private PTasDeCartes cachees;
	private PTasDeCartes visibles;

	private RetourneTasListener rtl;
	private RetourneCarteListener rcl;

	private DragSource ds;
	private DragGestureEvent theInitialEvent;
	private DragSourceListener myDSL;

	public PSabot(CSabot controle, PTasDeCartes cachees, PTasDeCartes visibles) {

		super();

		this.controle = controle;
		this.cachees = cachees;
		this.visibles = visibles;

		cachees.setDxDy(0, 0);
		visibles.setDxDy(25, 0);

		this.setLayout(null);

		updateControlsSize();

		add(this.cachees);
		add(this.visibles);

		this.rtl = new RetourneTasListener();
		this.rcl = new RetourneCarteListener();

		myDSL = new MyDragSourceListener();
		ds = new DragSource();
		ds.createDefaultDragGestureRecognizer(this.visibles,
				DnDConstants.ACTION_MOVE, new MyDragGestureListener());

//		this.addMouseListener(new MyClickListener());

		activerRetourneCarte();
	}

	public CSabot getControle() {
		return controle;
	}

	public PTasDeCartes getCachees() {
		return cachees;
	}

	public PTasDeCartes getVisibles() {
		return visibles;
	}

	public void updateControlsSize() {

		if (visibles != null && cachees != null) {

			Dimension cacheesSize = cachees.getControleSize();
			Dimension visibleSize = visibles.getControleSize();

			cachees.setLocation(new Point(0, 0));

			cachees.setSize(cacheesSize);
			cachees.setPreferredSize(getSize());

			visibles.setSize(visibleSize);
			visibles.setLocation(cacheesSize.width, 0);
			visibles.setPreferredSize(getSize());

			int width = cacheesSize.width + visibleSize.width;
			int height = PCarte.hauteur;

			this.setSize(width, height);
			this.setPreferredSize(getSize());

		}
	}

	@Override
	public void repaint() {
		updateControlsSize();
		super.repaint();
	}

	public void activerRetourneCarte() {
		this.cachees.addMouseListener(rcl);
	}

	public void desactiverRetourneCarte() {
		this.cachees.removeMouseListener(rcl);
	}

	public void activerRetourneTas() {
		this.cachees.addMouseListener(rtl);
	}

	public void desactiverRetourneTas() {
		this.cachees.removeMouseListener(rtl);
	}

	public void c2p_debutDnDOK(CCarte c) {
		// TODO:
		System.out.println("BEGIN TO MOVE");

		ds.startDrag(theInitialEvent, DragSource.DefaultMoveDrop,
				c.getPresentation(), myDSL);
	}

	public void c2p_debutDnDKO(CCarte c) {

	}

	class RetourneTasListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			try {
				controle.retourner();
			} catch (Exception ex) {
				System.out.println(ex);
			}
		}

		public void mouseEntered(MouseEvent e) {

		}

		public void mouseExited(MouseEvent e) {

		}

		public void mousePressed(MouseEvent e) {
		}

		public void mouseReleased(MouseEvent e) {

		}
	}

	class RetourneCarteListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {

			try {
				controle.retournerCarte();
			} catch (Exception ex) {
				System.out.println(ex);
			}
		}

		public void mouseEntered(MouseEvent e) {

		}

		public void mouseExited(MouseEvent e) {

		}

		public void mousePressed(MouseEvent e) {

		}

		public void mouseReleased(MouseEvent e) {

		}

	}

	class MyDragSourceListener implements DragSourceListener {

		public void dragDropEnd(DragSourceDropEvent e) {
			controle.p2c_dragDropEnd(e.getDropSuccess());
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

			controle.p2c_debutDnD(cc);
		}

	}

//	class MyClickListener implements MouseListener {
//
//		public void mouseClicked(MouseEvent e) {
//			System.out.println("Click count: " + e.getClickCount());
//
//			if (e.getClickCount() == 2) {
//
//				PCarte pc = (PCarte) visibles.getComponentAt(e.getPoint());
//
//				controle.moveCarteToColorees(pc.getControle());
//			}
//		}
//
//		public void mouseEntered(MouseEvent e) {
//		
//
//		}
//
//		public void mouseExited(MouseEvent e) {
//		
//
//		}
//
//		public void mousePressed(MouseEvent e) {
//		
//
//		}
//
//		public void mouseReleased(MouseEvent e) {
//		
//
//		}

//	}

}
>>>>>>> c5b0cee9cc2730ddb101a31c71b61e885db652d6
