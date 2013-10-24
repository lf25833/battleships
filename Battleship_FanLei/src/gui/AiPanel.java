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
public class AiPanel extends JPanel {
	
	private SingleGrid[][] positionSet = new SingleGrid[10][10];
	private int[] gridPosition = new int[2];
	int[] num = new int[2];
	public AiPanel(){
		init();
	}
	
	private void init(){
		for(int i = 0 ; i < 10 ; i++){	//to generate a 10*10 grids for game
			for(int j = 0 ; j < 10 ; j++){
				gridPosition[0] = i;
				gridPosition[1] = j;
				SingleGrid grid = new SingleGrid(gridPosition);
				positionSet[i][j] = grid;
			}
		}
		
		//SingleGrid sg = positionSet[0][0];
		//num=sg.getPosition();
		//System.out.println(num[0]+","+num[1]);
		
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
