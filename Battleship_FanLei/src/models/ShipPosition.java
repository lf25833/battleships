package models;

/**
 * @author Fan Lei
 * @since  2013-10-17
 */
public class ShipPosition {
	
	private int[] position;
	private Ship ship;
	
	public ShipPosition(Ship ship, int[] position) {
		this.position=new int[2];
		this.position = position;
		this.ship = ship;
	}
	
	/**
	 * @return the position
	 */
	public int[] getPosition() {
		return position;
	}
	
	/**
	 * @param the position which will be set
	 */
	public void setPosition(int[] position) {
		this.position = position;
	}
	
	/**
	 * @return the ship object
	 */
	public Ship getShip() {
		return ship;
	}
	
	/**
	 * @param the ship to set
	 */
	public void setShip(Ship ship) {
		this.ship = ship;
	}

}
