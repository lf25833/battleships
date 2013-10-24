/**
 * 
 */
package gui;

import java.awt.*;
import javax.swing.*;
/**
 * @author Fan Lei
 * @since  2013-10-19
 */
public class HumanPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SingleGrid[][] positionSet;
	private int[] gridPosition;
	int[] num = new int[2];
	
	public HumanPanel(){
		init();
	}
	
	private void init(){
		positionSet = new SingleGrid[10][10];
		for(int i = 0 ; i < 10 ; i++){	//to generate a 10*10 grids for game
			for(int j = 0 ; j < 10 ; j++){
				gridPosition = new int[2];
				gridPosition[0] = i;
				gridPosition[1] = j;
				SingleGrid grid = new SingleGrid(gridPosition);
				positionSet[i][j] = grid;
			}
			
		}
		setLayout(new GridLayout(10, 10));
		for(int i = 0 ; i < 10 ; i++){	//to generate a 10*10 grids for game
			for(int j = 0 ; j < 10 ; j++){
				SingleGrid position = positionSet[i][j];
				add(position);
			}
		}
	}
	
	
	
	public SingleGrid[][] getPosition(){	
		
		return positionSet;
	}

}
