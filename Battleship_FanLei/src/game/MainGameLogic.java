package game;

/**
 * @author Fan Lei
 * @since  2013-10-17
 */

import gui.AiPanel;
import gui.GameBattleWindow;
import gui.HumanPanel;
import gui.SingleGrid;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class MainGameLogic {
	
	private SingleGrid[][] PlayerPositionSet;
	private SingleGrid[][] AiPositionSet;
	private static MainGameLogic instance;
	private GameBattleWindow gameWindow;
	private HumanLogic player;
	private AiLogic ai;
	private ArrayList<SingleGrid> clickedPositions;
	private short gameRound = 1;	//1=player's setup, 2=player's round, 3=Ai's round, 0=end
	private ImageIcon hitIcon;
	private ImageIcon missIcon;
	private ImageIcon shipIcon;
	//private ImageIcon boomIcon;
	private HumanPanel hp;
	private AiPanel ap;
	
	private MainGameLogic(){
		missIcon = new ImageIcon(getClass().getResource("/miss_15x15.gif"));
		hitIcon = new ImageIcon(getClass().getResource("/hit_15x15.gif"));
		shipIcon = new ImageIcon(getClass().getResource("/cargo_ship.gif"));
	}
	
	
	public synchronized static MainGameLogic getInstance() {
        if (instance == null) {
            instance = new MainGameLogic();
        }
        return instance;
    }
	
	public void startGame(){
		this.gameWindow = new GameBattleWindow();
		hp = new HumanPanel();
		ap = new AiPanel();
		player = new HumanLogic();
		PlayerPositionSet = hp.getPosition();
		AiPositionSet = ap.getPosition();
		player.setShipListener(gameWindow, hp, PlayerPositionSet, shipIcon);
		gameWindow.setHumanPanel(hp);
		gameWindow.setAiPanel(ap);
	}

	
	

}
