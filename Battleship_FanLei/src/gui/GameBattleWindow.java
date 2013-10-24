package gui;

/**
 * @author Fan Lei
 * @since  2013-10-16
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import game.GameMain;

public class GameBattleWindow {
	
	private JFrame gameFrame;
	private JButton endGame;
	private JPanel botPanel;
	private JPanel HumanContent;
	private JPanel AiContent;
	private JPanel centerPanel;
	private	JPanel topPanel;
	public JPanel rotatePanel;
	private JLabel info;
	private JLabel infoValue;
	private	JLabel reportLabel;
	private JCheckBox isRotated;
	private final int ShipNum=5; //default ship numbers
	
	
	public GameBattleWindow(){
		init();
	}
	
	private void init(){
		gameFrame = new JFrame();
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setSize(1000, 500);
		gameFrame.setResizable(false);
		
		topPanel = new JPanel();
		topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
		rotatePanel = new JPanel();
		
		reportLabel=new JLabel("Welcome! My dear player!");
		isRotated=new JCheckBox("Place Ship Vertically");
		rotatePanel.add(isRotated);
		topPanel.add(reportLabel);
		topPanel.add(rotatePanel);
		gameFrame.getContentPane().add(BorderLayout.NORTH, topPanel);
		
		botPanel = new JPanel();
		endGame = new JButton("End Game");
		endGame.addActionListener(new ExitListener());
		botPanel.add(endGame);
		gameFrame.getContentPane().add(BorderLayout.SOUTH, botPanel);
		centerPanel = new JPanel();
		//info = new JLabel("Info:");
		//infoValue = new JLabel("-");
		//centerPanel.add(info);
		//centerPanel.add(infoValue);
		//JPanel shotInfoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,10,0));
		//shotInfoPanel.add(centerPanel);
		//gameFrame.getContentPane().add(BorderLayout.NORTH, shotInfoPanel);
		//rot = new JCheckBox("Place Ship Vertically");
		//centerPanel.add(rotated);
		//gameFrame.getContentPane().add(BorderLayout.WEST, centerPanel);
		
		gameFrame.setVisible(true);
		gameFrame.validate();
		
	}
	
	public void setHumanPanel(JPanel content){
		if(this.HumanContent != null){
			gameFrame.remove(this.HumanContent);
		}
		this.HumanContent = content;
		HumanContent.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 10));
		HumanContent.setPreferredSize(new Dimension(400,400));
		gameFrame.getContentPane().add(BorderLayout.WEST, HumanContent);
		HumanContent.updateUI();
	}
	
	public void setAiPanel(JPanel content){
		if(this.AiContent != null){
			gameFrame.remove(this.AiContent);
		}
		this.AiContent = content;
		AiContent.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 20));
		AiContent.setPreferredSize(new Dimension(400,400));
		gameFrame.getContentPane().add(BorderLayout.EAST, AiContent);
		AiContent.updateUI();
	}
	
	class ExitListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			System.exit(0);
		}

	}
	
	public JLabel getReports() {
		return reportLabel;
	}
	
	public boolean checkRotate(){
		return isRotated.isSelected();
	}
	
	public void setRotate(){
		isRotated.setSelected(false);
	}
	
}
