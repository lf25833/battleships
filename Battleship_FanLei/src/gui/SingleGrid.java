package gui;

/**
 * @author Fan Lei
 * @since  2013-10-17
 */

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

import models.ShipPosition;

public class SingleGrid extends JLabel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ShipPosition shipPosition;
	private int[] gridPosition;
	private boolean interSpace;
	
	public SingleGrid(int[] gridPosition) {
		this.gridPosition = new int[2];
		this.gridPosition = gridPosition;
		interSpace = true;
		init();
	}
	
	public SingleGrid(ShipPosition shipPosition) {
		this.shipPosition = shipPosition;
		init();
	}
	
	private void init() { 	//set the content position in a single grid
		setVerticalTextPosition(JLabel.CENTER);
		setHorizontalTextPosition(JLabel.CENTER);
		setVerticalAlignment(JLabel.CENTER);
		setHorizontalAlignment(JLabel.CENTER);
		setBorder(BorderFactory.createLineBorder(Color.black));
	}
	
	public boolean checkPositionFree(){
		return (shipPosition == null && interSpace);
	}
	
	public boolean checkInterspace(){
		return interSpace;
	}
	
	public void setInterspace(boolean boo){
		interSpace = boo;
	}
	
	public int[] getPosition() {
		return gridPosition;
	}
	
	/**
	 * @return the shipPosition
	 */
	public ShipPosition getShipPosition() {
		return shipPosition;
	}
	
	/**
	 * @param shipPosition the shipPosition to set
	 */
	public void setShipPosition(ShipPosition shipPosition) {
		this.shipPosition = shipPosition;
		interSpace = false;
	}
	
	public void defaulfShipPosition(){
		this.shipPosition = null;
	}

}
