package ballchaos;

/**
 * Diese Klasse repraesentiert genau einen Ball. Dieser wird mit Hoehe, Breite und seinen (x,y)-Koordinaten angegeben.
 * 
 * @author Lukas Schramm
 * @version 1.0
 *
 */
public class Ball {
	
	private int x, y;
	private int hoehe, breite;
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getHoehe() {
		return hoehe;
	}

	public void setHoehe(int hoehe) {
		this.hoehe = hoehe;
	}

	public int getBreite() {
		return breite;
	}

	public void setBreite(int breite) {
		this.breite = breite;
	}

}