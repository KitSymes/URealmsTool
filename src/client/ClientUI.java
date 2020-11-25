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

import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;

public class ClientUI {
	
	private JFrame	frame;
	private JPanel	contentPane;
	public JLabel	gmimage;
	
	public CAP		c1, c2, c3, c4;
	public double	scalar;
	
	Client c;
	
	public ClientUI(final int screen)
	{
		frame = new JFrame();
		frame.setUndecorated(true);
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run()
			{
				init(screen);
			}
		});
	}
	
	public void print(String s)
	{
		System.out.println(s);
	}
	
	public void init(int screen)
	{
		
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice[] gd = ge.getScreenDevices();
		if (screen > -1 && screen < gd.length)
		{
			frame.setLocation(gd[screen].getDefaultConfiguration().getBounds().x, gd[screen].getDefaultConfiguration().getBounds().y + frame.getY());
		} else if (gd.length > 0)
		{
			frame.setLocation(gd[0].getDefaultConfiguration().getBounds().x, gd[0].getDefaultConfiguration().getBounds().y + frame.getY());
			screen = 0;
		} else
		{
			throw new RuntimeException("No Screens Found");
		}
		
		scalar = ((double) gd[screen].getDisplayMode().getWidth() / 1920D);
		int width = (int) Math.floor(gd[screen].getDisplayMode().getWidth()), height = (int) Math.floor(scalar * 200); // 1080 / 1920 returns 0
		
		// I HAVE NO CLUE WHAT I'M DOING ABOVE IT JUST WORKS
		
		frame.setSize(width, height);
		frame.setTitle("Char's Stamina Tracker");
		frame.setAlwaysOnTop(false);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIconImage(new ImageIcon(ClientUI.class.getResource("/resources/UI/action.png")).getImage());
		
		Rectangle winSize = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
		int taskBarHeight = gd[screen].getDisplayMode().getHeight() - winSize.height;
		int y = (int) gd[screen].getDisplayMode().getHeight() - frame.getHeight() - taskBarHeight;
		frame.setLocation(frame.getX(), y);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setVisible(true);
		
		gmimage = new JLabel();
		gmimage.setBounds((int) Math.floor(scalar * 22), (int) Math.floor(scalar * 22), (int) Math.floor(scalar * 139),
				(int) Math.floor(scalar * 139));
		contentPane.add(gmimage);
		
		c1 = new CAP();
		c1.add(contentPane, 1, scalar, 285, 20 + 5); // Components and co-ordinates get scaled in the add function
		
		c2 = new CAP();
		c2.add(contentPane, 2, scalar, 585 + 40, 20 + 5);
		
		c3 = new CAP();
		c3.add(contentPane, 3, scalar, 885 + 80, 20 + 5);
		
		c4 = new CAP();
		c4.add(contentPane, 4, scalar, 1185 + 120, 20 + 5);
		
		/**
		 * MISC
		 **/
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(new ImageIcon(ClientUI.class.getResource("/resources/UI/background.png")).getImage()
				.getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH)));
		background.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		contentPane.add(background);
		
		frame.setVisible(true);
	}
	
	/**
	 * Enabling Player Sections
	 **/
	
	public void playerEnable(String player)
	{
		switch (player)
		{
			case "1":
				c1.enable();
				break;
			case "2":
				c2.enable();
				break;
			case "3":
				c3.enable();
				break;
			case "4":
				c4.enable();
				break;
		}
	}
	
	public void playerDisable(String player)
	{
		switch (player)
		{
			case "1":
				c1.disable();
				break;
			case "2":
				c2.disable();
				break;
			case "3":
				c3.disable();
				break;
			case "4":
				c4.disable();
				break;
		}
	}
	
	public void playerStamina(String player, String value)
	{
		switch (player)
		{
			case "1":
				c1.playerStaminaBar.setValue(Integer.valueOf(value));
				break;
			case "2":
				c2.playerStaminaBar.setValue(Integer.valueOf(value));
				break;
			case "3":
				c3.playerStaminaBar.setValue(Integer.valueOf(value));
				break;
			case "4":
				c4.playerStaminaBar.setValue(Integer.valueOf(value));
				break;
		}
	}
	
	public void playerMaxStamina(String player, String max)
	{
		switch (player)
		{
			case "1":
				c1.playerStaminaBar.setMaximum(Integer.valueOf(max));
				break;
			case "2":
				c2.playerStaminaBar.setMaximum(Integer.valueOf(max));
				break;
			case "3":
				c3.playerStaminaBar.setMaximum(Integer.valueOf(max));
				break;
			case "4":
				c4.playerStaminaBar.setMaximum(Integer.valueOf(max));
				break;
		}
	}
	
	public void playerDamage(String player, String damage)
	{
		int d = Integer.valueOf(damage);
		
		if (d > 0)
			healSound();
		else
			hurtSound();
		
		switch (player)
		{
			case "1":
				c1.playerStaminaBar.setValue(c1.playerStaminaBar.getValue() + d);
				break;
			case "2":
				c2.playerStaminaBar.setValue(c2.playerStaminaBar.getValue() + d);
				break;
			case "3":
				c3.playerStaminaBar.setValue(c3.playerStaminaBar.getValue() + d);
				break;
			case "4":
				c4.playerStaminaBar.setValue(c4.playerStaminaBar.getValue() + d);
				break;
		}
	}
	
	public void playerGold(String player, String amount)
	{
		
		switch (player)
		{
			case "1":
				c1.playerGoldlbl.setText(amount);
				break;
			case "2":
				c2.playerGoldlbl.setText(amount);
				break;
			case "3":
				c3.playerGoldlbl.setText(amount);
				break;
			case "4":
				c4.playerGoldlbl.setText(amount);
				break;
		}
	}
	
	public void playerModifyGold(String player, String amount)
	{
		int g = Integer.valueOf(amount);
		
		if (g > 0)
			goldAddSound();
		else
			goldRemoveSound();
		
		switch (player)
		{
			case "1":
				c1.playerGoldlbl.setText("" + (Integer.valueOf(c1.playerGoldlbl.getText()) + g));
				break;
			case "2":
				c2.playerGoldlbl.setText("" + (Integer.valueOf(c2.playerGoldlbl.getText()) + g));
				break;
			case "3":
				c3.playerGoldlbl.setText("" + (Integer.valueOf(c3.playerGoldlbl.getText()) + g));
				break;
			case "4":
				c4.playerGoldlbl.setText("" + (Integer.valueOf(c4.playerGoldlbl.getText()) + g));
				break;
		}
	}
	
	public void playerAction(String player, String action, String enabled)
	{
		try
		{
			((JButton) CAP.class.getDeclaredField("playerAction" + action).get(ClientUI.class.getDeclaredField("c" + player).get(this)))
					.setSelected(!Boolean.valueOf(enabled));
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
		{
			JOptionPane.showMessageDialog(new JFrame(), "An internal error has occurred (C-706c616374696f6e)", "Error", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
	}
	
	public void playerActionType(String player, String action, String actionType)
	{
		
		try
		{
			if (action.equals("1"))
				((JButton) CAP.class.getDeclaredField("playerAction" + action).get(ClientUI.class.getDeclaredField("c" + player).get(this)))
						.setIcon(new ImageIcon(new ImageIcon(ClientUI.class.getResource("/resources/UI/" + actionType.toLowerCase() + " slot.png"))
								.getImage().getScaledInstance((int) Math.floor(scalar * 36), (int) Math.floor(scalar * 36), Image.SCALE_SMOOTH)));
			else
				((JButton) CAP.class.getDeclaredField("playerAction" + action).get(ClientUI.class.getDeclaredField("c" + player).get(this)))
						.setIcon(new ImageIcon(new ImageIcon(ClientUI.class.getResource("/resources/UI/" + actionType.toLowerCase() + " slot 2.png"))
								.getImage().getScaledInstance((int) Math.floor(scalar * 44), (int) Math.floor(scalar * 36), Image.SCALE_SMOOTH)));
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
		{
			JOptionPane.showMessageDialog(new JFrame(), "An internal error has occurred (C-706c61637474797065)", "Error", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
	}
	
	/**
	 * Companions
	 **/
	
	public void companion(String player, String companion, String command, ArrayList<String> args)
	{
		switch (command)
		{
			case "enable":
				switch (player)
				{
					case "1":
						switch (companion)
						{
							case "1":
								c1.playerCompanion1enabled = true;
								if (c1.enabled)
									c1.playerCompanion1.setVisible(true);
								break;
							case "2":
								c1.playerCompanion2enabled = true;
								if (c1.enabled)
									c1.playerCompanion2.setVisible(true);
								break;
							case "3":
								c1.playerCompanion3enabled = true;
								if (c1.enabled)
									c1.playerCompanion3.setVisible(true);
								break;
						}
						break;
					case "2":
						switch (companion)
						{
							case "1":
								c2.playerCompanion1enabled = true;
								if (c2.enabled)
									c2.playerCompanion1.setVisible(true);
								break;
							case "2":
								c2.playerCompanion2enabled = true;
								if (c2.enabled)
									c2.playerCompanion2.setVisible(true);
								break;
							case "3":
								c2.playerCompanion3enabled = true;
								if (c2.enabled)
									c2.playerCompanion3.setVisible(true);
								break;
						}
						break;
					case "3":
						switch (companion)
						{
							case "1":
								c3.playerCompanion1enabled = true;
								if (c3.enabled)
									c3.playerCompanion1.setVisible(true);
								break;
							case "2":
								c3.playerCompanion2enabled = true;
								if (c3.enabled)
									c3.playerCompanion2.setVisible(true);
								break;
							case "3":
								c3.playerCompanion3enabled = true;
								if (c3.enabled)
									c3.playerCompanion3.setVisible(true);
								break;
						}
						break;
					case "4":
						switch (companion)
						{
							case "1":
								c4.playerCompanion1enabled = true;
								if (c4.enabled)
									c4.playerCompanion1.setVisible(true);
								break;
							case "2":
								c4.playerCompanion2enabled = true;
								if (c4.enabled)
									c4.playerCompanion2.setVisible(true);
								break;
							case "3":
								c4.playerCompanion3enabled = true;
								if (c4.enabled)
									c4.playerCompanion3.setVisible(true);
								break;
						}
						break;
				}
				break;
			case "disable":
				switch (player)
				{
					case "1":
						switch (companion)
						{
							case "1":
								c1.playerCompanion1enabled = false;
								c1.playerCompanion1.setVisible(false);
								break;
							case "2":
								c1.playerCompanion2enabled = false;
								c1.playerCompanion2.setVisible(false);
								break;
							case "3":
								c1.playerCompanion3enabled = false;
								c1.playerCompanion3.setVisible(false);
								break;
						}
						break;
					case "2":
						switch (companion)
						{
							case "1":
								c2.playerCompanion1enabled = false;
								c2.playerCompanion1.setVisible(false);
								break;
							case "2":
								c2.playerCompanion2enabled = false;
								c2.playerCompanion2.setVisible(false);
								break;
							case "3":
								c2.playerCompanion3enabled = false;
								c2.playerCompanion3.setVisible(false);
								break;
						}
						break;
					case "3":
						switch (companion)
						{
							case "1":
								c3.playerCompanion1enabled = false;
								c3.playerCompanion1.setVisible(false);
								break;
							case "2":
								c3.playerCompanion2enabled = false;
								c3.playerCompanion2.setVisible(false);
								break;
							case "3":
								c3.playerCompanion3enabled = false;
								c3.playerCompanion3.setVisible(false);
								break;
						}
						break;
					case "4":
						switch (companion)
						{
							case "1":
								c4.playerCompanion1enabled = false;
								c4.playerCompanion1.setVisible(false);
								break;
							case "2":
								c4.playerCompanion2enabled = false;
								c4.playerCompanion2.setVisible(false);
								break;
							case "3":
								c4.playerCompanion3enabled = false;
								c4.playerCompanion3.setVisible(false);
								break;
						}
						break;
				}
				break;
			// ----------------------------------------------------------------------------------------
			case "damage":
				switch (player)
				{
					case "1":
						switch (companion)
						{
							case "1":
								c1.playerCompanion1.setValue(c1.playerCompanion1.getValue() + Integer.valueOf(args.get(0)));
								break;
							case "2":
								c1.playerCompanion2.setValue(c1.playerCompanion2.getValue() + Integer.valueOf(args.get(0)));
								break;
							case "3":
								c1.playerCompanion3.setValue(c1.playerCompanion3.getValue() + Integer.valueOf(args.get(0)));
								break;
						}
						break;
					case "2":
						switch (companion)
						{
							case "1":
								c2.playerCompanion1.setValue(c2.playerCompanion1.getValue() + Integer.valueOf(args.get(0)));
								break;
							case "2":
								c2.playerCompanion2.setValue(c2.playerCompanion2.getValue() + Integer.valueOf(args.get(0)));
								break;
							case "3":
								c2.playerCompanion3.setValue(c2.playerCompanion3.getValue() + Integer.valueOf(args.get(0)));
								break;
						}
						break;
					case "3":
						switch (companion)
						{
							case "1":
								c3.playerCompanion1.setValue(c3.playerCompanion1.getValue() + Integer.valueOf(args.get(0)));
								break;
							case "2":
								c3.playerCompanion2.setValue(c3.playerCompanion2.getValue() + Integer.valueOf(args.get(0)));
								break;
							case "3":
								c3.playerCompanion3.setValue(c3.playerCompanion3.getValue() + Integer.valueOf(args.get(0)));
								break;
						}
						break;
					case "4":
						switch (companion)
						{
							case "1":
								c4.playerCompanion1.setValue(c4.playerCompanion1.getValue() + Integer.valueOf(args.get(0)));
								break;
							case "2":
								c4.playerCompanion2.setValue(c4.playerCompanion2.getValue() + Integer.valueOf(args.get(0)));
								break;
							case "3":
								c4.playerCompanion3.setValue(c4.playerCompanion3.getValue() + Integer.valueOf(args.get(0)));
								break;
						}
						break;
				}
				break;
			case "maxstamina":
				switch (player)
				{
					case "1":
						switch (companion)
						{
							case "1":
								c1.playerCompanion1.setMaximum(Integer.valueOf(args.get(0)));
								break;
							case "2":
								c1.playerCompanion2.setMaximum(Integer.valueOf(args.get(0)));
								break;
							case "3":
								c1.playerCompanion3.setMaximum(Integer.valueOf(args.get(0)));
								break;
						}
						break;
					case "2":
						switch (companion)
						{
							case "1":
								c2.playerCompanion1.setMaximum(Integer.valueOf(args.get(0)));
								break;
							case "2":
								c2.playerCompanion2.setMaximum(Integer.valueOf(args.get(0)));
								break;
							case "3":
								c2.playerCompanion3.setMaximum(Integer.valueOf(args.get(0)));
								break;
						}
						break;
					case "3":
						switch (companion)
						{
							case "1":
								c3.playerCompanion1.setMaximum(Integer.valueOf(args.get(0)));
								break;
							case "2":
								c3.playerCompanion2.setMaximum(Integer.valueOf(args.get(0)));
								break;
							case "3":
								c3.playerCompanion3.setMaximum(Integer.valueOf(args.get(0)));
								break;
						}
						break;
					case "4":
						switch (companion)
						{
							case "1":
								c4.playerCompanion1.setMaximum(Integer.valueOf(args.get(0)));
								break;
							case "2":
								c4.playerCompanion2.setMaximum(Integer.valueOf(args.get(0)));
								break;
							case "3":
								c4.playerCompanion3.setMaximum(Integer.valueOf(args.get(0)));
								break;
						}
						break;
				}
				break;
			case "stamina":
				try
				{
					((JProgressBar) CAP.class.getDeclaredField("playerCompanion" + companion)
							.get(ClientUI.class.getDeclaredField("c" + player).get(this))).setValue(Integer.valueOf(args.get(0)));
				} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
				{
					JOptionPane.showMessageDialog(new JFrame(), "An internal error has occurred (C-637569637374616d)", "Error", JOptionPane.ERROR_MESSAGE);
					System.exit(1);
				}
				break;
		}
	}
	
	/**
	 * Setting Player Current Stamina
	 **/
	
	public void healAll()
	{
		c1.heal();
		c2.heal();
		c3.heal();
		c4.heal();
	}
	
	/**
	 * Setting Player Images
	 **/
	
	// public void setPlayer1Image(String img)
	// {
	// try
	// {
	// p1Image.setIcon(new ImageIcon(ImageIO.read(new URL(img))));
	// } catch (IOException e)
	// {
	// e.printStackTrace();
	// }
	//
	// }
	//
	// public void setPlayer2Image(String img)
	// {
	// try
	// {
	// p2Image.setIcon(new ImageIcon(ImageIO.read(new URL(img))));
	// } catch (IOException e)
	// {
	// e.printStackTrace();
	// }
	//
	// }
	//
	// public void setPlayer3Image(String img)
	// {
	// try
	// {
	// p3Image.setIcon(new ImageIcon(ImageIO.read(new URL(img))));
	// } catch (IOException e)
	// {
	// e.printStackTrace();
	// }
	//
	// }
	//
	// public void setPlayer4Image(String img)
	// {
	// try
	// {
	// p4Image.setIcon(new ImageIcon(ImageIO.read(new URL(img))));
	// } catch (IOException e)
	// {
	// e.printStackTrace();
	// }
	//
	// }
	
	// ---------------------
	
	public void healSound()
	{
		Random rand = new Random();
		int randomNum = rand.nextInt((3 - 1) + 1) + 1;
		try
		{
			Clip clip = AudioSystem.getClip();
			AudioInputStream inputStream = AudioSystem
					.getAudioInputStream(ClientUI.class.getResource("/resources/Sounds/Heal " + randomNum + ".wav"));
			clip.open(inputStream);
			FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			volume.setValue(-20.0f);
			clip.start();
		} catch (Exception e)
		{
			System.err.println(e.getMessage());
		}
	}
	
	public void hurtSound()
	{
		Random rand = new Random();
		int randomNum = rand.nextInt((3 - 1) + 1) + 1;
		try
		{
			Clip clip = AudioSystem.getClip();
			AudioInputStream inputStream = AudioSystem
					.getAudioInputStream(ClientUI.class.getResource("/resources/Sounds/Damage " + randomNum + ".wav"));
			clip.open(inputStream);
			FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			volume.setValue(-20.0f);
			clip.start();
		} catch (Exception e)
		{
			System.err.println(e.getMessage());
		}
	}
	
	public void goldAddSound()
	{
		Random rand = new Random();
		int randomNum = rand.nextInt((3 - 1) + 1) + 1;
		try
		{
			Clip clip = AudioSystem.getClip();
			AudioInputStream inputStream = AudioSystem
					.getAudioInputStream(ClientUI.class.getResource("/resources/Sounds/Gold Increase " + randomNum + ".wav"));
			clip.open(inputStream);
			FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			volume.setValue(-20.0f);
			clip.start();
		} catch (Exception e)
		{
			System.err.println(e.getMessage());
		}
	}
	
	public void goldRemoveSound()
	{
		Random rand = new Random();
		int randomNum = rand.nextInt((3 - 1) + 1) + 1;
		try
		{
			Clip clip = AudioSystem.getClip();
			AudioInputStream inputStream = AudioSystem
					.getAudioInputStream(ClientUI.class.getResource("/resources/Sounds/Gold Decrease " + randomNum + ".wav"));
			clip.open(inputStream);
			FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			volume.setValue(-20.0f);
			clip.start();
		} catch (Exception e)
		{
			System.err.println(e.getMessage());
		}
	}
	
}

// JFrame f = new JFrame("URealms");
// f.getContentPane().add(new JPanel() {
//
// @Override // placeholder for actual content
// public Dimension getPreferredSize() {
// return new Dimension(320, 240);
// }
//
// });
// f.pack();
// f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
// GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
// Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
// int x = 0;
// int y = (int) rect.getMaxY() - f.getHeight();
// f.setLocation(x, y);
// f.setVisible(true);