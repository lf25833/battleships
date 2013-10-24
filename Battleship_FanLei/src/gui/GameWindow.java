package gui;

/**
 * @author Fan Lei
 * @since  2013-10-15
 */

import game.MainGameLogic;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameWindow implements ActionListener{
	private JFrame MainWin;
	//private ButtonGroup p1Buttons;
	//private ButtonGroup p2Buttons;
	//private JRadioButton Human;
	//private JRadioButton A1;
	//private JRadioButton Human2;
	//private JRadioButton Ai2;
	private JButton start;

	public GameWindow(){
		init();
	}
	
	private void init(){
		MainWin=new JFrame();
		MainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel topPanel = new JPanel();
		topPanel.setBorder(BorderFactory.createEmptyBorder(10, 40, 0, 40));
		JLabel gName = new JLabel("BattleShips");
		topPanel.add(gName);
		
		JPanel centerPanel = new JPanel();
		centerPanel.setBorder(BorderFactory.createEmptyBorder(80, 100, 0, 100));
		JLabel intro1 = new JLabel("Battle Ships Game Version 0.1");
		JLabel intro2 = new JLabel("Only for Human player Vs AI");
		
		centerPanel.add(intro1);
		centerPanel.add(intro2);

		JPanel bottomPanel = new JPanel();
		bottomPanel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
		start = new JButton("Battle Begin!");
		start.addActionListener(this);
		bottomPanel.add(start);
		
		MainWin.getContentPane().add(BorderLayout.NORTH, topPanel);
		MainWin.getContentPane().add(BorderLayout.CENTER, centerPanel);
		MainWin.getContentPane().add(BorderLayout.SOUTH, bottomPanel);
		MainWin.setSize(400, 400);
		MainWin.setResizable(false);
		MainWin.setVisible(true);
		MainWin.validate();
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		MainGameLogic.getInstance().startGame();
		MainWin.setVisible(false);
	}
}
