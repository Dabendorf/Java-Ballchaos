package ballchaos;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Diese Klasse ist die Hauptklasse des BallchaosProjektes. Sie steuert die Generierung der Baelle und das graphische Zeichnen selbiger.
 * 
 * @author Lukas Schramm
 * @version 1.0
 *
 */
public class BaelleZeichnen {
	
	private JFrame frame1 = new JFrame("Ballchaos");
	private Canvas canvas = new Canvas() {
		public void paint(Graphics stift) {
			zeichne(stift);
		}
	};
	private JCheckBox checkboxfuellung = new JCheckBox("Sollen die Bälle gefüllt sein?");
	private JCheckBox checkboxneuekugeln = new JCheckBox("Sollen die Bälle nach einer Weile verschwinden?");
	private JCheckBox checksw = new JCheckBox("Sollen die Bälle Farbig sein?");
	private boolean boolfuellung;
	private boolean boolneuekugeln;
	private boolean boolsw;
	
	private BaelleZeichnen() {
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setPreferredSize(new Dimension(600,600));
		frame1.setResizable(true);
		Container cp = frame1.getContentPane();
		cp.setLayout(new GridLayout(1,1));
		frame1.add(canvas);
		
		frame1.pack();
		frame1.setLocationRelativeTo(null);
		generiere();
		frame1.setVisible(true);
	}
	
	/**
	 * Diese Methode nimmt vom Nutzer in einem Dialog drei Eigenschaften (Ballfuellung, Lebensdauer und Farbigkeit) entgegen und schreibt diese in drei boolean.
	 */
	private void generiere() {
		Object[] parameter = {checkboxfuellung, checkboxneuekugeln, checksw};
		JOptionPane pane = new JOptionPane(parameter, JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION);
		pane.createDialog(null, "Wähle Deine Einstellungen").setVisible(true);
		boolfuellung = checkboxfuellung.isSelected();
		boolneuekugeln = checkboxneuekugeln.isSelected();
		boolsw = checksw.isSelected();
	}

	/**
	 * Diese Methode generiert, abhaengig von den oben angegebenen Eigenschaften die Baelle auf dem Bildschirm.
	 * @param stift Nimmt das GraphicsElement zum Zeichnen auf dem Canvas entgegen.
	 */
	private void zeichne(Graphics stift) {
		Random wuerfel = new Random();
		boolean weiter = true;
		if(boolneuekugeln == true) {
			for(int n=0;n<50;n++) {
				Ball ball = new Ball();
				ball.setX(wuerfel.nextInt(frame1.getWidth()));
				ball.setY(wuerfel.nextInt(frame1.getHeight()));
				ball.setBreite(20);
				ball.setHoehe(20);
				if(boolsw == true) {
					stift.setColor(new Color(wuerfel.nextInt(256), wuerfel.nextInt(256), wuerfel.nextInt(256)));
				} else {
					stift.setColor(Color.black);
				}
				if(boolfuellung == true) {
					stift.fillOval(ball.getX(), ball.getY(), ball.getBreite(), ball.getHoehe());
				} else {
					stift.drawOval(ball.getX(), ball.getY(), ball.getBreite(), ball.getHoehe());
				}
				
			}
			canvas.repaint();
		} else {
			while(weiter == true) {
				for(int n=0;n<50;n++) {
					Ball ball = new Ball();
					ball.setX(wuerfel.nextInt(frame1.getWidth()));
					ball.setY(wuerfel.nextInt(frame1.getHeight()));
					ball.setBreite(20);
					ball.setHoehe(20);
					if(boolsw == true) {
						stift.setColor(new Color(wuerfel.nextInt(256), wuerfel.nextInt(256), wuerfel.nextInt(256)));
					} else {
						stift.setColor(Color.black);
					}
					if(boolfuellung == true) {
						stift.fillOval(ball.getX(), ball.getY(), ball.getBreite(), ball.getHoehe());
					} else {
						stift.drawOval(ball.getX(), ball.getY(), ball.getBreite(), ball.getHoehe());
					}
					
				}
				canvas.repaint();
			}
		}
	}

	public static void main(String[] args) {
		new BaelleZeichnen();
	}
}