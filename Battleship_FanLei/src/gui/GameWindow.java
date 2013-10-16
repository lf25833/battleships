package gui;

/**
 * @author Fan Lei
 * @since  2013-10-15
 */

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
public class GameWindow implements ActionListener{
	private JFrame MainWin;
	private ButtonGroup p1Buttons;
	private ButtonGroup p2Buttons;
	private JRadioButton Human1;
	private JRadioButton Ai1;
	private JRadioButton Human2;
	private JRadioButton Ai2;
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
		JLabel player1 = new JLabel("Player 1:");
		JLabel player2 = new JLabel("Player 2:");
		Human1 = new JRadioButton("Human");
		Ai1 = new JRadioButton("AI");
		Human2 = new JRadioButton("Human");
		Ai2 = new JRadioButton("AI");
		
		p1Buttons = new ButtonGroup();
		p1Buttons.add(Human1);
		p1Buttons.add(Ai1);
		Human1.setSelected(true);
		
		p2Buttons = new ButtonGroup();
		p2Buttons.add(Human2);
		p2Buttons.add(Ai2);
		Human2.setSelected(true);
		
		centerPanel.add(player1);
		centerPanel.add(Human1);
		centerPanel.add(Ai1);

		centerPanel.add(player2);
		centerPanel.add(Human2);
		centerPanel.add(Ai2);
		
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
		boolean p1 = true;
		boolean p2 = true;
		if(Ai1.isSelected()){
			p1=false;
		}
		if(Ai2.isSelected()){
			p2=false;
		}
	}
}
