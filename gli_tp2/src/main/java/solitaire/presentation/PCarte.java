<<<<<<< HEAD
package solitaire.presentation;

//import solitaire.controle.* ;
import java.awt.Color;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import solitaire.controle.CCarte;

/**
 * Composant Présentation d'une carte
 */
public class PCarte extends JPanel implements Transferable {

	private static final long serialVersionUID = -8788465623706460035L;

	protected CCarte controle; // contrôleur associé
	protected JLabel face, dos;
	protected ImageIcon icone; // image de la face
	protected static ImageIcon iconeDos; // image du dos
	public static int largeur, hauteur;

	/**
	 * initialiser une carte
	 * 
	 * @param chaine
	 *            : nom de la carte (exemple "3H" = 3 Heart)
	 */
	// public PCarte (final String chaine, final CCarte controle) {
	public PCarte(CCarte controle, final String chaine) {

		this.controle = controle;
		// image de la face
		icone = new ImageIcon(ClassLoader.getSystemResource("cartesCSHD/"
				+ chaine + ".gif"));

		face = new JLabel(icone);
		add(face);
		face.setLocation(0, 0);
		face.setSize(largeur, hauteur);

		// image du dos
		dos = new JLabel(iconeDos);
		add(dos);
		dos.setLocation(0, 0);
		dos.setSize(largeur, hauteur);

		// le JPanel
		setLayout(null);
		setBackground(Color.yellow);
		setOpaque(true);
		setSize(face.getSize());
		setPreferredSize(getSize());
		setFaceVisible(false);
		
		
//		this.addMouseMotionListener(new MouseMotionListener() {
//			public void mouseMoved(MouseEvent e) {
//				
//			}
//			
//			public void mouseDragged(MouseEvent e) {
//				System.out.println("Drage me !!!!");
//			}
//		});

	} // constructeur

	/**
	 * changer la visibilité de la carte
	 * 
	 * @param faceVisible
	 *            : vrai si la face est visible, faux sinon
	 */
	public void setFaceVisible(boolean faceVisible) {
		face.setVisible(faceVisible);
		dos.setVisible(!faceVisible);
	}

	public final CCarte getControle() {
		return (controle);
	}

	public ImageIcon getIcone() {
		return icone;
	}

	/**
	 * initialiser l'image du dos et les dimensions d'une PCarte
	 */
	static {
		iconeDos = new ImageIcon(
				ClassLoader.getSystemResource("cartesCSHD/dos.jpg"));
		largeur = iconeDos.getIconWidth() + 4;
		hauteur = iconeDos.getIconHeight() + 4;
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

} // PCarte

=======
package solitaire.presentation;

//import solitaire.controle.* ;
import java.awt.Color;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import solitaire.controle.CCarte;

/**
 * Composant Présentation d'une carte
 */
public class PCarte extends JPanel implements Transferable {

	private static final long serialVersionUID = -8788465623706460035L;

	protected CCarte controle; // contrôleur associé
	protected JLabel face, dos;
	protected ImageIcon icone; // image de la face
	protected static ImageIcon iconeDos; // image du dos
	public static int largeur, hauteur;

	/**
	 * initialiser une carte
	 * 
	 * @param chaine
	 *            : nom de la carte (exemple "3H" = 3 Heart)
	 */
	// public PCarte (final String chaine, final CCarte controle) {
	public PCarte(CCarte controle, final String chaine) {

		this.controle = controle;
		// image de la face
		icone = new ImageIcon(ClassLoader.getSystemResource("cartesCSHD/"
				+ chaine + ".gif"));

		face = new JLabel(icone);
		add(face);
		face.setLocation(0, 0);
		face.setSize(largeur, hauteur);

		// image du dos
		dos = new JLabel(iconeDos);
		add(dos);
		dos.setLocation(0, 0);
		dos.setSize(largeur, hauteur);

		// le JPanel
		setLayout(null);
		setBackground(Color.yellow);
		setOpaque(true);
		setSize(face.getSize());
		setPreferredSize(getSize());
		setFaceVisible(false);
		
		
//		this.addMouseMotionListener(new MouseMotionListener() {
//			public void mouseMoved(MouseEvent e) {
//				
//			}
//			
//			public void mouseDragged(MouseEvent e) {
//				System.out.println("Drage me !!!!");
//			}
//		});

	} // constructeur

	/**
	 * changer la visibilité de la carte
	 * 
	 * @param faceVisible
	 *            : vrai si la face est visible, faux sinon
	 */
	public void setFaceVisible(boolean faceVisible) {
		face.setVisible(faceVisible);
		dos.setVisible(!faceVisible);
	}

	public final CCarte getControle() {
		return (controle);
	}

	public ImageIcon getIcone() {
		return icone;
	}

	/**
	 * initialiser l'image du dos et les dimensions d'une PCarte
	 */
	static {
		iconeDos = new ImageIcon(
				ClassLoader.getSystemResource("cartesCSHD/dos.jpg"));
		largeur = iconeDos.getIconWidth() + 4;
		hauteur = iconeDos.getIconHeight() + 4;
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

} // PCarte

>>>>>>> c5b0cee9cc2730ddb101a31c71b61e885db652d6
