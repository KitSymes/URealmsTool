package client;

/**
	This file is part of 'Char's Stamina Tracker' (Referred to as CST).

    CST is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    any later version.

    CST is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with CST.  If not, see <http://www.gnu.org/licenses/>.
    
    Copyright (C) 2018  Charzard4261
 **/

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

// Client Manager Add Players, or CAP for short - Uses reflection to cut the code needed by about a quarter

public class CAP {
	
	public boolean	enabled	= false;
	public double	scalar;
	
	public JProgressBar			playerStaminaBar		= new JProgressBar();
	public JLabel				playerImage				= new JLabel(), playerBackground = new JLabel("");
	public boolean				playerCompanion1enabled	= false;
	public JProgressBar			playerCompanion1		= new JProgressBar();
	public boolean				playerCompanion2enabled	= false;
	public JProgressBar			playerCompanion2		= new JProgressBar();
	public boolean				playerCompanion3enabled	= false;
	public JProgressBar			playerCompanion3		= new JProgressBar();
	public final JLabel			playerGold				= new JLabel("");
	public final JLabel			playerGoldlbl			= new JLabel("0");
	boolean						playeraction1			= true;
	boolean						playeraction2			= true;
	boolean						playeraction3			= true;
	boolean						playeraction4			= true;
	boolean						playeraction5			= true;
	boolean						playeraction6			= false;
	boolean						playeraction7			= false;
	boolean						playeraction8			= false;
	private ArrayList<JButton>	enabledActions			= new ArrayList<JButton>();
	public JButton				playerAction1			= new JButton("");
	public JButton				playerAction2			= new JButton("");
	public JButton				playerAction3			= new JButton("");
	public JButton				playerAction4			= new JButton("");
	public JButton				playerAction5			= new JButton("");
	public JButton				playerAction6			= new JButton("");
	public JButton				playerAction7			= new JButton("");
	public JButton				playerAction8			= new JButton("");
	
	private int XOne = 0, XTwo = 0, XOffset = 40, YOne = 0, YOffset = 80;
	
	public void add(JPanel panel, int number, double scalar, int xstart, int ystart)
	{
		this.scalar = scalar;
		XOne = xstart;
		XTwo = xstart - 6;
		YOne = ystart;
		
		playerStaminaBar.setBorder(new CompoundBorder(new MatteBorder(2, 1, 2, 1, (Color) new Color(64, 64, 64)),
				new EtchedBorder(EtchedBorder.LOWERED, new Color(128, 128, 128), null)));
		playerStaminaBar.setVisible(false);
		playerStaminaBar.setForeground(Color.GREEN);
		playerStaminaBar.setMaximum(10);
		playerStaminaBar.setValue(10);
		
		playerImage.setVisible(false);
		
		playerBackground.setVisible(false);
		playerBackground.setIcon(new ImageIcon(new ImageIcon(CAP.class.getResource("/resources/UI/character.png")).getImage()
				.getScaledInstance((int) Math.floor(scalar * 130), (int) Math.floor(scalar * 130), Image.SCALE_SMOOTH)));
		
		playerCompanion1.setFont(new Font("Tahoma", Font.PLAIN, 99));
		playerCompanion1.setStringPainted(true);
		playerCompanion1.setString("");
		playerCompanion1.setForeground(new Color(25, 255, 0));
		playerCompanion1.setBorder(new CompoundBorder(new MatteBorder(2, 1, 2, 1, (Color) new Color(64, 64, 64)),
				new EtchedBorder(EtchedBorder.LOWERED, new Color(128, 128, 128), null)));
		playerCompanion1.setMaximum(10);
		playerCompanion1.setValue(10);
		playerCompanion1.setVisible(false);
		
		playerCompanion2.setFont(new Font("Tahoma", Font.PLAIN, 99));
		playerCompanion2.setStringPainted(true);
		playerCompanion2.setString("");
		playerCompanion2.setForeground(new Color(25, 255, 0));
		playerCompanion2.setBorder(new CompoundBorder(new MatteBorder(2, 1, 2, 1, (Color) new Color(64, 64, 64)),
				new EtchedBorder(EtchedBorder.LOWERED, new Color(128, 128, 128), null)));
		playerCompanion2.setMaximum(10);
		playerCompanion2.setValue(10);
		playerCompanion2.setVisible(false);
		
		playerCompanion3 = new JProgressBar();
		playerCompanion3.setFont(new Font("Tahoma", Font.PLAIN, 99));
		playerCompanion3.setStringPainted(true);
		playerCompanion3.setString("");
		playerCompanion3.setForeground(new Color(25, 255, 0));
		playerCompanion3.setBorder(new CompoundBorder(new MatteBorder(2, 1, 2, 1, (Color) new Color(64, 64, 64)),
				new EtchedBorder(EtchedBorder.LOWERED, new Color(128, 128, 128), null)));
		playerCompanion3.setMaximum(10);
		playerCompanion3.setValue(10);
		playerCompanion3.setVisible(false);
		
		playerGoldlbl.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		playerGoldlbl.setOpaque(true);
		playerGoldlbl.setBackground(Color.DARK_GRAY);
		playerGoldlbl.setForeground(Color.ORANGE);
		playerGoldlbl.setHorizontalAlignment(SwingConstants.TRAILING);
		int font = 11;
		if (scalar < 1 && scalar >= 0.5)
			font = 6;
		else if (scalar > 1 && scalar <= 1.5)
			font = 1;
		else if (scalar > 1.5)
			font = 20;
		playerGoldlbl.setFont(new Font("Tahoma", Font.PLAIN, font));
		playerGoldlbl.setVisible(false);
		
		playerGold.setIcon(new ImageIcon(new ImageIcon(CAP.class.getResource("/resources/UI/gold.png")).getImage()
				.getScaledInstance((int) Math.floor(scalar * 30), (int) Math.floor(scalar * 30), Image.SCALE_SMOOTH)));
		playerGold.setVisible(false);
		
		// -------------------------------------------------------------------------------------------------------------------------------------------------------
		
		playerAction1.setBorderPainted(false);
		playerAction1.setContentAreaFilled(false);
		playerAction1.setVisible(false);
		playerAction1.setIcon(new ImageIcon(new ImageIcon(CAP.class.getResource("/resources/UI/move slot.png")).getImage()
				.getScaledInstance((int) Math.floor(scalar * 36), (int) Math.floor(scalar * 36), Image.SCALE_SMOOTH)));
		playerAction1.setSelectedIcon(new ImageIcon(
				new ImageIcon(CAP.class.getResource("/resources/UI/slot.png")).getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
		
		playerAction2.setBorderPainted(false);
		playerAction2.setContentAreaFilled(false);
		playerAction2.setVisible(false);
		playerAction2.setIcon(new ImageIcon(new ImageIcon(CAP.class.getResource("/resources/UI/action slot 2.png")).getImage()
				.getScaledInstance((int) Math.floor(scalar * 44), (int) Math.floor(scalar * 36), Image.SCALE_SMOOTH)));
		playerAction2.setSelectedIcon(new ImageIcon(
				new ImageIcon(CAP.class.getResource("/resources/UI/slot 2.png")).getImage().getScaledInstance(44, 36, Image.SCALE_SMOOTH)));
		
		playerAction3.setBorderPainted(false);
		playerAction3.setContentAreaFilled(false);
		playerAction3.setVisible(false);
		playerAction3.setIcon(new ImageIcon(new ImageIcon(CAP.class.getResource("/resources/UI/anytime slot 2.png")).getImage()
				.getScaledInstance((int) Math.floor(scalar * 44), (int) Math.floor(scalar * 36), Image.SCALE_SMOOTH)));
		playerAction3.setSelectedIcon(new ImageIcon(
				new ImageIcon(CAP.class.getResource("/resources/UI/slot 2.png")).getImage().getScaledInstance(44, 36, Image.SCALE_SMOOTH)));
		
		playerAction4.setContentAreaFilled(false);
		playerAction4.setBorderPainted(false);
		playerAction4.setVisible(false);
		playerAction4.setIcon(new ImageIcon(new ImageIcon(CAP.class.getResource("/resources/UI/anytime slot 2.png")).getImage()
				.getScaledInstance((int) Math.floor(scalar * 44), (int) Math.floor(scalar * 36), Image.SCALE_SMOOTH)));
		playerAction4.setSelectedIcon(new ImageIcon(
				new ImageIcon(CAP.class.getResource("/resources/UI/slot 2.png")).getImage().getScaledInstance(44, 36, Image.SCALE_SMOOTH)));
		
		playerAction5.setContentAreaFilled(false);
		playerAction5.setBorderPainted(false);
		playerAction5.setVisible(false);
		playerAction5.setIcon(new ImageIcon(new ImageIcon(CAP.class.getResource("/resources/UI/anytime slot 2.png")).getImage()
				.getScaledInstance((int) Math.floor(scalar * 44), (int) Math.floor(scalar * 36), Image.SCALE_SMOOTH)));
		playerAction5.setSelectedIcon(new ImageIcon(
				new ImageIcon(CAP.class.getResource("/resources/UI/slot 2.png")).getImage().getScaledInstance(44, 36, Image.SCALE_SMOOTH)));
		
		playerAction6.setContentAreaFilled(false);
		playerAction6.setBorderPainted(false);
		playerAction6.setVisible(false);
		playerAction6.setIcon(new ImageIcon(new ImageIcon(CAP.class.getResource("/resources/UI/anytime slot 2.png")).getImage()
				.getScaledInstance((int) Math.floor(scalar * 44), (int) Math.floor(scalar * 36), Image.SCALE_SMOOTH)));
		playerAction6.setSelectedIcon(new ImageIcon(
				new ImageIcon(CAP.class.getResource("/resources/UI/slot 2.png")).getImage().getScaledInstance(44, 36, Image.SCALE_SMOOTH)));
		
		playerAction7.setContentAreaFilled(false);
		playerAction7.setBorderPainted(false);
		playerAction7.setVisible(false);
		playerAction7.setIcon(new ImageIcon(new ImageIcon(CAP.class.getResource("/resources/UI/anytime slot 2.png")).getImage()
				.getScaledInstance((int) Math.floor(scalar * 44), (int) Math.floor(scalar * 36), Image.SCALE_SMOOTH)));
		playerAction7.setSelectedIcon(new ImageIcon(
				new ImageIcon(CAP.class.getResource("/resources/UI/slot 2.png")).getImage().getScaledInstance(44, 36, Image.SCALE_SMOOTH)));
		
		playerAction8.setContentAreaFilled(false);
		playerAction8.setBorderPainted(false);
		playerAction8.setVisible(false);
		playerAction8.setIcon(new ImageIcon(new ImageIcon(CAP.class.getResource("/resources/UI/anytime slot 2.png")).getImage()
				.getScaledInstance((int) Math.floor(scalar * 44), (int) Math.floor(scalar * 36), Image.SCALE_SMOOTH)));
		playerAction8.setSelectedIcon(new ImageIcon(
				new ImageIcon(CAP.class.getResource("/resources/UI/slot 2.png")).getImage().getScaledInstance(44, 36, Image.SCALE_SMOOTH)));
		
		playerAction1.setName("1");
		playerAction2.setName("2");
		playerAction3.setName("3");
		playerAction4.setName("4");
		playerAction5.setName("5");
		playerAction6.setName("6");
		playerAction7.setName("7");
		playerAction8.setName("8");
		
		// --------------------------------------------------------------------------------------------------------------------------------------
		// LOCATIONS default : 285 20 - Math.floor rounds the double down to the nearest
		// integer, but this does use some heavy math when starting
		// --------------------------------------------------------------------------------------------------------------------------------------
		
		playerStaminaBar.setBounds((int) Math.floor(scalar * XOne), (int) Math.floor(scalar * (YOne + 5)), (int) Math.floor(scalar * 130),
				(int) Math.floor(scalar * 15));
		
		playerImage.setBounds((int) Math.floor(scalar * (XOne + 10)), (int) Math.floor(scalar * (YOne + 1)), (int) Math.floor(scalar * 110),
				(int) Math.floor(scalar * 110));
		
		playerBackground.setBounds((int) Math.floor(scalar * XOne), (int) Math.floor(scalar * (YOne + 8)), (int) Math.floor(scalar * 130),
				(int) Math.floor(scalar * 130));
		
		playerCompanion1.setBounds((int) Math.floor(scalar * (XOne + 125)), (int) Math.floor(scalar * (YOne + 25)), (int) Math.floor(scalar * 100),
				(int) Math.floor(scalar * 15));
		playerCompanion2.setBounds((int) Math.floor(scalar * (XOne + 125)), (int) Math.floor(scalar * (YOne + 40)), (int) Math.floor(scalar * 100),
				(int) Math.floor(scalar * 15));
		playerCompanion3.setBounds((int) Math.floor(scalar * (XOne + 125)), (int) Math.floor(scalar * (YOne + 55)), (int) Math.floor(scalar * 100),
				(int) Math.floor(scalar * 15));
		
		playerGoldlbl.setBounds((int) Math.floor(scalar * (XOne - 45)), (int) Math.floor(scalar * (YOne + 70)), (int) Math.floor(scalar * 40),
				(int) Math.floor(scalar * 12));
		playerGold.setBounds((int) Math.floor(scalar * (XOne - 40)), (int) Math.floor(scalar * (YOne + 45)), (int) Math.floor(scalar * 30),
				(int) Math.floor(scalar * 30));
		
		playerAction1.setBounds((int) Math.floor(scalar * (XTwo - XOffset + 2)), (int) Math.floor(scalar * (YOne + YOffset)),
				(int) Math.floor(scalar * 60), (int) Math.floor(scalar * 60));
		
		playerAction2.setBounds((int) Math.floor(scalar * (XTwo - 2)), (int) Math.floor(scalar * (YOne + YOffset)), (int) Math.floor(scalar * 60),
				(int) Math.floor(scalar * 60));
		
		playerAction3.setBounds((int) Math.floor(scalar * (XTwo + XOffset - 2)), (int) Math.floor(scalar * (YOne + YOffset)),
				(int) Math.floor(scalar * 60), (int) Math.floor(scalar * 60));
		
		playerAction4.setBounds((int) Math.floor(scalar * (XTwo + (XOffset * 2) - 2)), (int) Math.floor(scalar * (YOne + YOffset)),
				(int) Math.floor(scalar * 60), (int) Math.floor(scalar * 60));
		
		playerAction5.setBounds((int) Math.floor(scalar * (XTwo + (XOffset * 3) - 2)), (int) Math.floor(scalar * (YOne + YOffset)),
				(int) Math.floor(scalar * 60), (int) Math.floor(scalar * 60));
		
		playerAction6.setBounds((int) Math.floor(scalar * (XTwo + (XOffset * 4) - 2)), (int) Math.floor(scalar * (YOne + YOffset)),
				(int) Math.floor(scalar * 60), (int) Math.floor(scalar * 60));
		
		playerAction7.setBounds((int) Math.floor(scalar * (XTwo + (XOffset * 5) - 2)), (int) Math.floor(scalar * (YOne + YOffset)),
				(int) Math.floor(scalar * 60), (int) Math.floor(scalar * 60));
		
		playerAction8.setBounds((int) Math.floor(scalar * (XTwo + (XOffset * 6) - 2)), (int) Math.floor(scalar * (YOne + YOffset)),
				(int) Math.floor(scalar * 60), (int) Math.floor(scalar * 60));
		
		// --------------------------------------------------------------------------------------------------------------------------------------
		// ADDING
		// --------------------------------------------------------------------------------------------------------------------------------------
		
		panel.add(playerStaminaBar);
		panel.add(playerCompanion1);
		panel.add(playerCompanion2);
		panel.add(playerCompanion3);
		panel.add(playerGoldlbl);
		panel.add(playerGold);
		panel.add(playerAction1);
		panel.add(playerAction2);
		panel.add(playerAction3);
		panel.add(playerAction4);
		panel.add(playerAction5);
		panel.add(playerAction6);
		panel.add(playerAction7);
		panel.add(playerAction8);
		panel.add(playerImage);
		panel.add(playerBackground);
	}
	
	public void enable()
	{
		enabled = true;
		
		playerStaminaBar.setVisible(true);
		playerImage.setVisible(true);
		playerBackground.setVisible(true);
		if (playerCompanion1enabled)
			playerCompanion1.setVisible(true);
		if (playerCompanion2enabled)
			playerCompanion2.setVisible(true);
		if (playerCompanion3enabled)
			playerCompanion3.setVisible(true);
		playerGoldlbl.setVisible(true);
		playerGold.setVisible(true);
		if (playeraction1)
			playerAction1.setVisible(true);
		if (playeraction2)
			playerAction2.setVisible(true);
		if (playeraction3)
			playerAction3.setVisible(true);
		if (playeraction4)
			playerAction4.setVisible(true);
		if (playeraction5)
			playerAction5.setVisible(true);
		if (playeraction6)
			playerAction6.setVisible(true);
		if (playeraction7)
			playerAction7.setVisible(true);
		if (playeraction8)
			playerAction8.setVisible(true);
	}
	
	public void disable()
	{
		enabled = false;
		
		playerStaminaBar.setVisible(false);
		playerImage.setVisible(false);
		playerBackground.setVisible(false);
		playerCompanion1.setVisible(false);
		playerCompanion2.setVisible(false);
		playerCompanion3.setVisible(false);
		playerGoldlbl.setVisible(false);
		playerGold.setVisible(false);
		playerAction1.setVisible(false);
		playerAction2.setVisible(false);
		playerAction3.setVisible(false);
		playerAction4.setVisible(false);
		playerAction5.setVisible(false);
		playerAction6.setVisible(false);
		playerAction7.setVisible(false);
		playerAction7.setVisible(false);
	}
	
	public void heal()
	{
		playerStaminaBar.setValue(playerStaminaBar.getMaximum());
	}
	
	public void enableAction(String action, String bool)
	{
		boolean b = Boolean.valueOf(bool);
		try
		{
			CAP.class.getDeclaredField("playeraction" + action).setBoolean(this, b);
			
			if (b)
				enabledActions.add(((JButton) CAP.class.getDeclaredField("playerAction" + action).get(this)));
			else
				enabledActions.remove(((JButton) CAP.class.getDeclaredField("playerAction" + action).get(this)));
			
			Collections.sort(enabledActions, new Comparator<JButton>() {
				@Override
				public int compare(JButton o1, JButton o2)
				{
					return Integer.valueOf(o1.getName()).compareTo(Integer.valueOf(o2.getName()));
				}
			});
			
			int startx = (int) Math.floor(scalar * ((XTwo + XOffset - 2) - (XOffset * (enabledActions.size() / 2))));
			
			if ((enabledActions.size() & 1) == 0)
				startx += 20;
			
			for (int i = 0; i < enabledActions.size(); i++)
			{
				JButton button = enabledActions.get(i);
				if (button.getName().equals("1"))
					button.setLocation(startx + (XOffset * i) + 4, button.getLocation().y);
				else
					button.setLocation(startx + (XOffset * i), button.getLocation().y);
			}
			
			if (enabled)
				((JButton) CAP.class.getDeclaredField("playerAction" + action).get(this)).setVisible(b);
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
		{
			JOptionPane.showMessageDialog(new JFrame(), "An internal error has occurred (C-656e616374)", "Error", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
	}
	
	public void setPlayerImage(final String image)
	{
		new Thread(new Runnable() {
			
			@Override
			public void run()
			{
				try
				{
					playerImage.setIcon(new ImageIcon(
							ImageIO.read(new URL(image)).getScaledInstance(playerImage.getWidth(), playerImage.getHeight(), Image.SCALE_SMOOTH)));
				} catch (IOException e)
				{
					JOptionPane.showMessageDialog(new JFrame(), "An internal error has occurred (C-706c696d616765)", "Error", JOptionPane.ERROR_MESSAGE);
					System.exit(1);
				}
			}
		}).run();
	}
	
}
