package solitaire.presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import javax.swing.JPanel;

import solitaire.controle.CTasDeCartesAlternees;

public class PTasDeCartesAlternees extends JPanel implements Transferable {

	private static final long serialVersionUID = -7484120698933048433L;

	private CTasDeCartesAlternees controle;

	private int lastX;
	private int lastY;

	private int dx;
	private int dy;

	public PTasDeCartesAlternees(CTasDeCartesAlternees contorle) {

		this.controle = contorle;
		setLayout(null);

		setSize(PCarte.largeur, PCarte.hauteur);
		setPreferredSize(getSize());

		this.lastX = 0;
		this.lastY = 0;
		
		setBackground(Color.lightGray);
	}

	public int getDx() {
		return dx;
	}

	public int getDy() {
		return dy;
	}

	public int getLastX() {
		return lastX;
	}

	public int getLastY() {
		return lastY;
	}

	public Dimension getControleSize() {

		int height = PCarte.hauteur + (controle.getNbCartes() - 1) * dy;
		int width = PCarte.largeur + (controle.getNbCartes() - 1) * dx;

		Dimension size = new Dimension(width, height);

		return size;
	}

	public final CTasDeCartesAlternees getControle() {
		return controle;
	}

	public void depiler(PCarte pc) {
		remove(pc);
		lastX -= dx;
		lastY -= dy;
	}

	public void empiler(PCarte pc) {
		add(pc, 0);
		pc.setLocation(lastX, lastY);
		lastX += dx;
		lastY += dy;
	}

	public void setDxDy(int dx, int dy) {
		this.dx = dx;
		this.dy = dy;
	}

	public Object getTransferData(DataFlavor flavor)
			throws UnsupportedFlavorException, IOException {

		Object result = null;

		if (flavor.isMimeTypeEqual(DataFlavor.javaJVMLocalObjectMimeType)) {
			result = this;
		}

		return result;
	}

	public DataFlavor[] getTransferDataFlavors() {
		DataFlavor data[] = new DataFlavor[1];

		try {
			data[0] = new DataFlavor(DataFlavor.javaJVMLocalObjectMimeType);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return data;
	}

	public boolean isDataFlavorSupported(DataFlavor flavor) {

		return flavor.isMimeTypeEqual(DataFlavor.javaJVMLocalObjectMimeType);
	}

}
