package models;

/**
 * @author Fan Lei
 * @since  2013-10-17
 */
public enum Ship {
	
	AircraftCarrier(5), Battleship(4), Destroyer(3), Submarine(3), PatrolBoat(2);
	
	private int len;
	private int hits;
	
	private Ship(int len){
		this.len=len;
	}
	
	public boolean isDestroyed(){
		return hits == len;
	}
	
	public int getLength() {
		return len;
	}
	
	public int getHits() {
		return hits;
	}
	
	public void setHits(int hits) {
		this.hits = hits;
	}

}
