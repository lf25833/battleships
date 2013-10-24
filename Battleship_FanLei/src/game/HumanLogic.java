package game;

/**
 * @author Fan Lei
 * @since  2013-10-17
 */

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import gui.HumanPanel;
import gui.SingleGrid;
import gui.GameBattleWindow;
import models.Ship;
import models.ShipPosition;

public class HumanLogic {
	
	private ArrayList<SingleGrid> clickedPositions;
	//private ArrayList<ShipPosition> ShipPositions;
	private ArrayList<Ship> SunkShips;
	private int[] gridPosition;
	//private SingleGrid[] shipGrids;
	private boolean isShipAdded;
	private boolean switchShip;
	private Ship ship;
	
	
	public HumanLogic(){
		//ShipPositions = new ArrayList<ShipPosition>();
		clickedPositions = new ArrayList<SingleGrid>();
		SunkShips = new ArrayList<Ship>();
		//gridPosition = new int[2];
		isShipAdded = false;
		switchShip = true;
		ship = Ship.AircraftCarrier;
	}
	
	public void setShipListener(final GameBattleWindow gameWindow, final HumanPanel humanPanel,final SingleGrid[][] PlayerPositionSet, final ImageIcon shipIcon){
		humanPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e){
				try{
					SingleGrid clickedGrid = (SingleGrid)humanPanel.getComponentAt(e.getPoint());
					switch(ship){
					case AircraftCarrier:
						gameWindow.getReports().setText("Please set your "+ship.name()+", length is "+ship.getLength()+". You can set ship vertically by choosing the option below.");
						setupShips(gameWindow,ship,clickedGrid,PlayerPositionSet,shipIcon);
						if(switchShip){
							ship = Ship.Battleship;
						}
						System.out.println("SWITCH AircraftCarrier! Next is "+ship.name());
						break;
						
					case Battleship:
						gameWindow.getReports().setText("Please set your "+ship.name()+", length is "+ship.getLength()+". You can set ship vertically by choosing the option below.");
						setupShips(gameWindow,ship,clickedGrid,PlayerPositionSet,shipIcon);
						if(switchShip){
							ship = Ship.Destroyer;
						}
						System.out.println("SWITCH Battleship!  Next is "+ship.name());
						break;
						
					case Destroyer:
						gameWindow.getReports().setText("Please set your "+ship.name()+", length is "+ship.getLength()+". You can set ship vertically by choosing the option below.");
						setupShips(gameWindow,ship,clickedGrid,PlayerPositionSet,shipIcon);
						if(switchShip){
							ship = Ship.Submarine;
						}
						System.out.println("SWITCH Destroyer!  Next is "+ship.name());
						break;
						
					case Submarine:
						gameWindow.getReports().setText("Please set your "+ship.name()+", length is "+ship.getLength()+". You can set ship vertically by choosing the option below.");
						setupShips(gameWindow,ship,clickedGrid,PlayerPositionSet,shipIcon);
						if(switchShip){
							ship = Ship.PatrolBoat;
						}
						System.out.println("SWITCH Submarine!  Next is "+ship.name());
						break;
						
					case PatrolBoat:
						gameWindow.getReports().setText("Please set your "+ship.name()+", length is "+ship.getLength()+". You can set ship vertically by choosing the option below.");
						setupShips(gameWindow,ship,clickedGrid,PlayerPositionSet,shipIcon);
						if(isShipAdded){
							System.out.println("Finish!");
						}
						break;
					}
						//int[] position = new int[2];
						//position=clickedGrid.getPosition();
						//clickedGrid.setText(position[0]+","+position[1]);
					if(isShipAdded){
						humanPanel.removeMouseListener(humanPanel.getMouseListeners()[0]);
					}
					Thread.sleep(5);
					//humanPanel.removeMouseListener(humanPanel.getMouseListeners()[0]);
				}catch(Exception ex){
					// TODO: handle exception
				}
			}
		});
	}
	
	private void setupShips(GameBattleWindow gameWindow, Ship ship, SingleGrid position, SingleGrid[][] PlayerPositionSet, ImageIcon shipIcon) throws InterruptedException{
		//Ship ship = Ship.AircraftCarrier; //initialize the ship
		int size;
		switch(ship){
		case AircraftCarrier:
			size = ship.getLength();
			if(!isShipAdded){
				gameWindow.getReports().setText("Please set your "+ship.name()+", length is "+size+". You can set ship vertically by choosing the option below.");
				boolean rotated = gameWindow.checkRotate();
				addShips(ship,position,PlayerPositionSet,shipIcon,rotated);
				if(isShipAdded){
					gameWindow.setRotate();
					isShipAdded = false;
					switchShip = true;
					gameWindow.getReports().setText("You have set the "+ship.name());
					Thread.sleep(10);
					break;
				}else{
					//gameWindow.getReports().setText("You connot put ship here! Please Try again!");
					//ship= Ship.AircraftCarrier;
					switchShip = false;
					JOptionPane.showMessageDialog(null, "You connot put "+ship.name()+" here! Please Try again!");
					break;
				}
			}
			break;
			
		case Battleship:
			size = ship.getLength();
			if(!isShipAdded){
				gameWindow.getReports().setText("Please set your "+ship.name()+", length is "+size+". You can set ship vertically by choosing the option below.");
				boolean rotated = gameWindow.checkRotate();
				addShips(ship,position,PlayerPositionSet,shipIcon,rotated);
				if(isShipAdded){
					gameWindow.setRotate();
					isShipAdded = false;
					switchShip = true;
					gameWindow.getReports().setText("You have set the "+ship.name());
					Thread.sleep(10);
					break;
				}else{
					//gameWindow.getReports().setText("You connot put ship here! Please Try again!");
					switchShip = false;
					JOptionPane.showMessageDialog(null, "You connot put "+ship.name()+" here! Please Try again!");
					break;
				}
			}
			break;
			
		case Destroyer:
			size = ship.getLength();
			if(!isShipAdded){
				gameWindow.getReports().setText("Please set your "+ship.name()+", length is "+size+". You can set ship vertically by choosing the option below.");
				boolean rotated = gameWindow.checkRotate();
				addShips(ship,position,PlayerPositionSet,shipIcon,rotated);
				if(isShipAdded){
					gameWindow.setRotate();
					isShipAdded = false;
					switchShip = true;
					gameWindow.getReports().setText("You have set the "+ship.name());
					Thread.sleep(10);
					break;
				}else{
					//gameWindow.getReports().setText("You connot put ship here! Please Try again!");
					switchShip = false;
					JOptionPane.showMessageDialog(null, "You connot put "+ship.name()+" here! Please Try again!");
					break;
				}
			}
			break;
			
		case Submarine:
			size = ship.getLength();
			if(!isShipAdded){
				gameWindow.getReports().setText("Please set your "+ship.name()+", length is "+size+". You can set ship vertically by choosing the option below.");
				boolean rotated = gameWindow.checkRotate();
				addShips(ship,position,PlayerPositionSet,shipIcon,rotated);
				if(isShipAdded){
					gameWindow.setRotate();
					isShipAdded = false;
					switchShip = true;
					gameWindow.getReports().setText("You have set the "+ship.name());
					Thread.sleep(10);
					break;
				}else{
					//gameWindow.getReports().setText("You connot put ship here! Please Try again!");
					switchShip = false;
					JOptionPane.showMessageDialog(null, "You connot put "+ship.name()+" here! Please Try again!");
					break;
				}
			}
			break;
			
		case PatrolBoat:
			size = ship.getLength();
			if(!isShipAdded){
				gameWindow.getReports().setText("Please set your "+ship.name()+", length is "+size+". You can set ship vertically by choosing the option below.");
				boolean rotated = gameWindow.checkRotate();
				addShips(ship,position,PlayerPositionSet,shipIcon,rotated);
				if(isShipAdded){
					gameWindow.rotatePanel.setVisible(false);
					switchShip = true;
					//gameWindow.getReports().setText("You have set the "+ship.name());
					gameWindow.getReports().setText("The Battle Begins! Computer will shot on your panel(left side), your enemy's ships are on the right panel!--- Kill them all!");
					Thread.sleep(10);
					//JOptionPane.showMessageDialog(null, "Ship setting completed! Now you can shot in the right Panel!");
					break;
				}else{
					//gameWindow.getReports().setText("You connot put ship here! Please Try again!");
					JOptionPane.showMessageDialog(null, "You connot put "+ship.name()+" here! Please Try again!");
					switchShip = false;
					break;
				}
			}
			break;
		}
		
	}
	
	private void interAddShip(Ship s,SingleGrid grid){ //after the judgment, put ship into the single grid
		ShipPosition sp = new ShipPosition(s, gridPosition);
		grid.setShipPosition(sp);
		//grid.setIcon(shipIcon);
		//isShipAdded = true;
	}
	
	private void addShips(Ship s, SingleGrid position, SingleGrid[][] PlayerPositionSet, ImageIcon shipIcon, boolean rotated){
		int size = s.getLength();
		SingleGrid sg = null;
		ArrayList<SingleGrid> shipGrids = new ArrayList<SingleGrid>();
		gridPosition = position.getPosition(); //start point
		int rows = gridPosition[0];
		int cols = gridPosition[1];
		try{
			for(int i=0; i<size; i++){
				try{
					if(rotated){	//vertical
						sg = PlayerPositionSet[rows+i][cols]; //grid which the ship put on vertically
						
						if(sg.checkPositionFree()){
							try{
								PlayerPositionSet[rows+i][cols-1].setInterspace(false);
							}catch(Exception e){
								System.out.println("left interspace generate failed! code1.1");
								//e.printStackTrace();
							}
							try{
								PlayerPositionSet[rows+i][cols+1].setInterspace(false);
							}catch(Exception e){
								System.out.println("right interspace generate failed! code1.2");
								//e.printStackTrace();
							}
							try{
								PlayerPositionSet[rows-1][cols].setInterspace(false);
							}catch(Exception e){
								System.out.println("top interspace generate failed! code1.3");
								//e.printStackTrace();
							}
							try{
								PlayerPositionSet[rows+size][cols].setInterspace(false);
							}catch(Exception e){
								System.out.println("bottom interspace generate failed! code1.4");
								//e.printStackTrace();
							}
						}else break;
					}
					else{	//horizontal
						sg = PlayerPositionSet[rows][cols+i]; 	//grid which the ship put on horizontally
						
						if(sg.checkPositionFree()){
							try{
								PlayerPositionSet[rows][cols-1].setInterspace(false);
							}catch(Exception e){
								System.out.println("left interspace generate failed! code2.1");
								//e.printStackTrace();
							}
							try{
								PlayerPositionSet[rows][cols+size].setInterspace(false);
							}catch(Exception e){
								System.out.println("right interspace generate failed! code2.2");
								//e.printStackTrace();
							}
							try{
								PlayerPositionSet[rows-1][cols+i].setInterspace(false);
							}catch(Exception e){
								System.out.println("upper interspace generate failed! code2.3");
								//e.printStackTrace();
							}
							try{
								PlayerPositionSet[rows+1][cols+i].setInterspace(false);
							}catch(Exception e){
								System.out.println("lower interspace generate failed! code2.4");
								//e.printStackTrace();
							}
						}else break;
					}
				}catch(Exception e){
					System.out.println("ship generate failed! The ship out of the bound!");
					//e.printStackTrace();
				}
				if(sg.checkPositionFree()){
					interAddShip(s,sg);
					shipGrids.add(sg);
				}else break;
			} //end of for loop
			
			if(shipGrids.size() == size){ //ship has been set
				for(int i=0; i< size; i++){
					shipGrids.get(i).setIcon(shipIcon);
					isShipAdded = true;
				}
				System.out.println(s.name()+" has been set!");
			}else{
				for(int i=0; i< shipGrids.size(); i++){
					SingleGrid grid = shipGrids.get(i);
					grid.defaulfShipPosition();
					grid.setInterspace(true);
					if(rotated){
						try{
							PlayerPositionSet[grid.getPosition()[0]-1][grid.getPosition()[1]].setInterspace(true);
						}catch(Exception e){}
						try{
							PlayerPositionSet[grid.getPosition()[0]+size][grid.getPosition()[1]].setInterspace(true);
						}catch(Exception e){}
						try{
							PlayerPositionSet[grid.getPosition()[0]][grid.getPosition()[1]-1].setInterspace(true);
						}catch(Exception e){}
						try{
							PlayerPositionSet[grid.getPosition()[0]][grid.getPosition()[1]+1].setInterspace(true);
						}catch(Exception e){}
					}else{
						try{
							PlayerPositionSet[grid.getPosition()[0]-1][grid.getPosition()[1]].setInterspace(true);
						}catch(Exception e){}
						try{
							PlayerPositionSet[grid.getPosition()[0]+1][grid.getPosition()[1]].setInterspace(true);
						}catch(Exception e){}
						try{
							PlayerPositionSet[grid.getPosition()[0]][grid.getPosition()[1]-1].setInterspace(true);
						}catch(Exception e){}
						try{
							PlayerPositionSet[grid.getPosition()[0]][grid.getPosition()[1]+size].setInterspace(true);
						}catch(Exception e){}
					}
				}
			}
		}catch(Exception e){
			// TODO Auto-generated catch block
			isShipAdded = false;
			e.printStackTrace();
		}
	} //end of addShips()
}
