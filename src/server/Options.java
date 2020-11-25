package server;

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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.security.cert.PKIXRevocationChecker.Option;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicComboBoxUI;

import util.JTextFieldLimit;

public class Options {
	
	private ServerGMUI				su;
	private JLabel					stamCount, c1stamCount, c2stamCount, c3stamCount, playerImage;
	private JTextField				stamCountSet, c1stamCountSet, c2stamCountSet, c3stamCountSet;
	private JComboBox<ImageIcon>	action1, action2, action3, action4, action5, action6, action7, action8;
	
	public Options(ServerGMUI su)
	{
		this.su = su;
	}
	
	@SuppressWarnings("unchecked")
	public void decorate(JPanel panel, final int number)
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException
	{
		panel.setLayout(null);
		
		// ----------------------------------------------------------------------------------------
		
		stamCount = new JLabel("Max Stamina");
		stamCount.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		stamCountSet = new JTextField();
		stamCountSet.setName("Player " + number);
		stamCountSet.setDocument(new JTextFieldLimit(su, stamCountSet, number, true));
		stamCountSet.setColumns(2);
		stamCountSet.setText("" + su.server.getClass().getField("player" + number + "Stam").getInt(su.server));
		
		// ----------------------------------------------------------------------------------------
		
		c1stamCount = new JLabel("C1 Max Stamina");
		c1stamCount.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		c1stamCountSet = new JTextField();
		c1stamCountSet.setName("Companion " + number + " 1");
		c1stamCountSet.setDocument(new JTextFieldLimit(su, c1stamCountSet, number, true));
		c1stamCountSet.setColumns(2);
		c1stamCountSet.setText("" + su.server.getClass().getField("player" + number + "c1Stam").getInt(su.server));
		
		// ----------------------------------------------------------------------------------------
		
		c2stamCount = new JLabel("C2 Max Stamina");
		c2stamCount.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		c2stamCountSet = new JTextField();
		c2stamCountSet.setName("Companion " + number + " 2");
		c2stamCountSet.setDocument(new JTextFieldLimit(su, c2stamCountSet, number, true));
		c2stamCountSet.setColumns(2);
		c2stamCountSet.setText("" + su.server.getClass().getField("player" + number + "c2Stam").getInt(su.server));
		
		// ----------------------------------------------------------------------------------------
		
		c3stamCount = new JLabel("C3 Max Stamina");
		c3stamCount.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		c3stamCountSet = new JTextField();
		c3stamCountSet.setName("Companion " + number + " 3");
		c3stamCountSet.setDocument(new JTextFieldLimit(su, c3stamCountSet, number, true));
		c3stamCountSet.setColumns(2);
		c3stamCountSet.setText("" + su.server.getClass().getField("player" + number + "c3Stam").getInt(su.server));
		
		// ----------------------------------------------------------------------------------------
		
		ImageIcon[] actionTypes = new ImageIcon[] {
				new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/move slot.png")).getImage().getScaledInstance(60, 60,
						Image.SCALE_SMOOTH)),
				new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/action slot.png")).getImage().getScaledInstance(60, 60,
						Image.SCALE_SMOOTH)),
				new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/anytime slot.png")).getImage().getScaledInstance(60, 60,
						Image.SCALE_SMOOTH)),
				new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/companion slot.png")).getImage().getScaledInstance(60, 60,
						Image.SCALE_SMOOTH)),
				new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/dual slot.png")).getImage().getScaledInstance(60, 60,
						Image.SCALE_SMOOTH)) };
		
		action1 = new ButtonlessComboBox<ImageIcon>(actionTypes);
		action1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				if (action1.getSelectedIndex() == 0)
				{
					su.server.input("Player " + number + " actiontype 1 MOVE");
					su.server.actionTypes.put("p" + number + "a1", "MOVE");
					try
					{
						;
						((JButton) GMAP.class.getDeclaredField("playerAction1").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/move slot.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				} else if (action1.getSelectedIndex() == 1)
				{
					su.server.input("Player " + number + " actiontype 1 ACTION");
					su.server.actionTypes.put("p" + number + "a1", "ACTION");
					try
					{
						((JButton) GMAP.class.getDeclaredField("playerAction1").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/action slot.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				} else if (action1.getSelectedIndex() == 2)
				{
					su.server.input("Player " + number + " actiontype 1 ANYTIME");
					su.server.actionTypes.put("p" + number + "a1", "ANYTIME");
					try
					{
						((JButton) GMAP.class.getDeclaredField("playerAction1").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/anytime slot.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				} else if (action1.getSelectedIndex() == 3)
				{
					su.server.input("Player " + number + " actiontype 1 COMPANION");
					su.server.actionTypes.put("p" + number + "a1", "COMPANION");
					try
					{
						((JButton) GMAP.class.getDeclaredField("playerAction1").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/companion slot.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				} else if (action1.getSelectedIndex() == 4)
				{
					su.server.input("Player " + number + " actiontype 1 DUAL");
					su.server.actionTypes.put("p" + number + "a1", "DUAL");
					try
					{
						((JButton) GMAP.class.getDeclaredField("playerAction1").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/dual slot.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				}
			}
		});
		
		action2 = new ButtonlessComboBox<ImageIcon>(actionTypes);
		action2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				if (action2.getSelectedIndex() == 0)
				{
					su.server.input("Player " + number + " actiontype 2 MOVE");
					su.server.actionTypes.put("p" + number + "a2", "MOVE");
					try
					{
						;
						((JButton) GMAP.class.getDeclaredField("playerAction2").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/move slot.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				} else if (action2.getSelectedIndex() == 1)
				{
					su.server.input("Player " + number + " actiontype 2 ACTION");
					su.server.actionTypes.put("p" + number + "a2", "ACTION");
					try
					{
						((JButton) GMAP.class.getDeclaredField("playerAction2").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/action slot.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				} else if (action2.getSelectedIndex() == 2)
				{
					su.server.input("Player " + number + " actiontype 2 ANYTIME");
					su.server.actionTypes.put("p" + number + "a2", "ANYTIME");
					try
					{
						((JButton) GMAP.class.getDeclaredField("playerAction2").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/anytime slot.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				} else if (action2.getSelectedIndex() == 3)
				{
					su.server.input("Player " + number + " actiontype 2 COMPANION");
					su.server.actionTypes.put("p" + number + "a2", "COMPANION");
					try
					{
						((JButton) GMAP.class.getDeclaredField("playerAction2").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/companion slot.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				} else if (action2.getSelectedIndex() == 4)
				{
					su.server.input("Player " + number + " actiontype 2 DUAL");
					su.server.actionTypes.put("p" + number + "a2", "DUAL");
					try
					{
						((JButton) GMAP.class.getDeclaredField("playerAction2").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/dual slot.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				}
			}
		});
		
		action3 = new ButtonlessComboBox<ImageIcon>(actionTypes);
		action3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				if (action3.getSelectedIndex() == 0)
				{
					su.server.input("Player " + number + " actiontype 3 MOVE");
					su.server.actionTypes.put("p" + number + "a3", "MOVE");
					try
					{
						;
						((JButton) GMAP.class.getDeclaredField("playerAction3").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/move slot.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				} else if (action3.getSelectedIndex() == 1)
				{
					su.server.input("Player " + number + " actiontype 3 ACTION");
					su.server.actionTypes.put("p" + number + "a3", "ACTION");
					try
					{
						((JButton) GMAP.class.getDeclaredField("playerAction3").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/action slot.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				} else if (action3.getSelectedIndex() == 2)
				{
					su.server.input("Player " + number + " actiontype 3 ANYTIME");
					su.server.actionTypes.put("p" + number + "a3", "ANYTIME");
					try
					{
						((JButton) GMAP.class.getDeclaredField("playerAction3").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/anytime slot.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				} else if (action3.getSelectedIndex() == 3)
				{
					su.server.input("Player " + number + " actiontype 3 COMPANION");
					su.server.actionTypes.put("p" + number + "a3", "COMPANION");
					try
					{
						((JButton) GMAP.class.getDeclaredField("playerAction3").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/companion slot.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				} else if (action3.getSelectedIndex() == 4)
				{
					su.server.input("Player " + number + " actiontype 3 DUAL");
					su.server.actionTypes.put("p" + number + "a3", "DUAL");
					try
					{
						((JButton) GMAP.class.getDeclaredField("playerAction3").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/dual slot.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				}
			}
		});
		
		action4 = new ButtonlessComboBox<ImageIcon>(actionTypes);
		action4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				if (action4.getSelectedIndex() == 0)
				{
					su.server.input("Player " + number + " actiontype 4 MOVE");
					su.server.actionTypes.put("p" + number + "a4", "MOVE");
					try
					{
						;
						((JButton) GMAP.class.getDeclaredField("playerAction4").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/move slot.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				} else if (action4.getSelectedIndex() == 1)
				{
					su.server.input("Player " + number + " actiontype 4 ACTION");
					su.server.actionTypes.put("p" + number + "a4", "ACTION");
					try
					{
						((JButton) GMAP.class.getDeclaredField("playerAction4").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/action slot.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				} else if (action4.getSelectedIndex() == 2)
				{
					su.server.input("Player " + number + " actiontype 4 ANYTIME");
					su.server.actionTypes.put("p" + number + "a4", "ANYTIME");
					try
					{
						((JButton) GMAP.class.getDeclaredField("playerAction4").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/anytime slot.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				} else if (action4.getSelectedIndex() == 3)
				{
					su.server.input("Player " + number + " actiontype 4 COMPANION");
					su.server.actionTypes.put("p" + number + "a4", "COMPANION");
					try
					{
						((JButton) GMAP.class.getDeclaredField("playerAction4").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/companion slot.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				} else if (action4.getSelectedIndex() == 4)
				{
					su.server.input("Player " + number + " actiontype 4 DUAL");
					su.server.actionTypes.put("p" + number + "a4", "DUAL");
					try
					{
						((JButton) GMAP.class.getDeclaredField("playerAction4").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/dual slot.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				}
			}
		});
		
		action5 = new ButtonlessComboBox<ImageIcon>(actionTypes);
		action5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				if (action5.getSelectedIndex() == 0)
				{
					su.server.input("Player " + number + " actiontype 5 MOVE");
					su.server.actionTypes.put("p" + number + "a5", "MOVE");
					try
					{
						;
						((JButton) GMAP.class.getDeclaredField("playerAction5").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/move slot.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				} else if (action5.getSelectedIndex() == 1)
				{
					su.server.input("Player " + number + " actiontype 5 ACTION");
					su.server.actionTypes.put("p" + number + "a5", "ACTION");
					try
					{
						((JButton) GMAP.class.getDeclaredField("playerAction5").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/action slot.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				} else if (action5.getSelectedIndex() == 2)
				{
					su.server.input("Player " + number + " actiontype 5 ANYTIME");
					su.server.actionTypes.put("p" + number + "a5", "ANYTIME");
					try
					{
						((JButton) GMAP.class.getDeclaredField("playerAction5").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/anytime slot.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				} else if (action5.getSelectedIndex() == 3)
				{
					su.server.input("Player " + number + " actiontype 5 COMPANION");
					su.server.actionTypes.put("p" + number + "a5", "COMPANION");
					try
					{
						((JButton) GMAP.class.getDeclaredField("playerAction5").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/companion slot.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				} else if (action5.getSelectedIndex() == 4)
				{
					su.server.input("Player " + number + " actiontype 5 DUAL");
					su.server.actionTypes.put("p" + number + "a5", "DUAL");
					try
					{
						((JButton) GMAP.class.getDeclaredField("playerAction5").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/dual slot.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				}
			}
		});
		
		action6 = new ButtonlessComboBox<ImageIcon>(actionTypes);
		action6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				if (action6.getSelectedIndex() == 0)
				{
					su.server.input("Player " + number + " actiontype 6 MOVE");
					su.server.actionTypes.put("p" + number + "a6", "MOVE");
					try
					{
						;
						((JButton) GMAP.class.getDeclaredField("playerAction6").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/move slot.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				} else if (action6.getSelectedIndex() == 1)
				{
					su.server.input("Player " + number + " actiontype 6 ACTION");
					su.server.actionTypes.put("p" + number + "a6", "ACTION");
					try
					{
						((JButton) GMAP.class.getDeclaredField("playerAction6").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/action slot.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				} else if (action6.getSelectedIndex() == 2)
				{
					su.server.input("Player " + number + " actiontype 6 ANYTIME");
					su.server.actionTypes.put("p" + number + "a6", "ANYTIME");
					try
					{
						((JButton) GMAP.class.getDeclaredField("playerAction6").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/anytime slot.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				} else if (action6.getSelectedIndex() == 3)
				{
					su.server.input("Player " + number + " actiontype 6 COMPANION");
					su.server.actionTypes.put("p" + number + "a6", "COMPANION");
					try
					{
						((JButton) GMAP.class.getDeclaredField("playerAction6").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/companion slot.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				} else if (action6.getSelectedIndex() == 4)
				{
					su.server.input("Player " + number + " actiontype 6 DUAL");
					su.server.actionTypes.put("p" + number + "a6", "DUAL");
					try
					{
						((JButton) GMAP.class.getDeclaredField("playerAction6").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/dual slot.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				}
			}
		});
		
		action7 = new ButtonlessComboBox<ImageIcon>(actionTypes);
		action7.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				if (action7.getSelectedIndex() == 0)
				{
					su.server.input("Player " + number + " actiontype 7 MOVE");
					su.server.actionTypes.put("p" + number + "a7", "MOVE");
					try
					{
						;
						((JButton) GMAP.class.getDeclaredField("playerAction7").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/move slot.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				} else if (action7.getSelectedIndex() == 1)
				{
					su.server.input("Player " + number + " actiontype 7 ACTION");
					su.server.actionTypes.put("p" + number + "a7", "ACTION");
					try
					{
						((JButton) GMAP.class.getDeclaredField("playerAction7").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/action slot.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				} else if (action7.getSelectedIndex() == 2)
				{
					su.server.input("Player " + number + " actiontype 7 ANYTIME");
					su.server.actionTypes.put("p" + number + "a7", "ANYTIME");
					try
					{
						((JButton) GMAP.class.getDeclaredField("playerAction7").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/anytime slot.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				} else if (action7.getSelectedIndex() == 3)
				{
					su.server.input("Player " + number + " actiontype 7 COMPANION");
					su.server.actionTypes.put("p" + number + "a7", "COMPANION");
					try
					{
						((JButton) GMAP.class.getDeclaredField("playerAction7").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/companion slot.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				} else if (action7.getSelectedIndex() == 4)
				{
					su.server.input("Player " + number + " actiontype 7 DUAL");
					su.server.actionTypes.put("p" + number + "a7", "DUAL");
					try
					{
						((JButton) GMAP.class.getDeclaredField("playerAction7").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/dual slot.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				}
			}
		});
		
		action8 = new ButtonlessComboBox<ImageIcon>(actionTypes);
		action8.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				if (action8.getSelectedIndex() == 0)
				{
					su.server.input("Player " + number + " actiontype 8 MOVE");
					su.server.actionTypes.put("p" + number + "a8", "MOVE");
					try
					{
						;
						((JButton) GMAP.class.getDeclaredField("playerAction8").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/move slot.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				} else if (action8.getSelectedIndex() == 1)
				{
					su.server.input("Player " + number + " actiontype 8 ACTION");
					su.server.actionTypes.put("p" + number + "a8", "ACTION");
					try
					{
						((JButton) GMAP.class.getDeclaredField("playerAction8").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/action slot.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				} else if (action8.getSelectedIndex() == 2)
				{
					su.server.input("Player " + number + " actiontype 8 ANYTIME");
					su.server.actionTypes.put("p" + number + "a8", "ANYTIME");
					try
					{
						((JButton) GMAP.class.getDeclaredField("playerAction8").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/anytime slot.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				} else if (action8.getSelectedIndex() == 3)
				{
					su.server.input("Player " + number + " actiontype 8 COMPANION");
					su.server.actionTypes.put("p" + number + "a8", "COMPANION");
					try
					{
						((JButton) GMAP.class.getDeclaredField("playerAction8").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/companion slot.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				} else if (action8.getSelectedIndex() == 4)
				{
					su.server.input("Player " + number + " actiontype 8 DUAL");
					su.server.actionTypes.put("p" + number + "a8", "DUAL");
					try
					{
						((JButton) GMAP.class.getDeclaredField("playerAction8").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/dual slot.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				}
			}
		});
		
		// ----------------------------------------------------------------------------------------
		
		for (int i = 1; i <= 8; i++)
		{
			switch (su.server.actionTypes.get("p" + number + "a" + i))
			{
				case "MOVE":
					((JComboBox<ImageIcon>) Options.class.getDeclaredField("action" + i).get(this)).setSelectedIndex(0);
					break;
				case "ACTION":
					((JComboBox<ImageIcon>) Options.class.getDeclaredField("action" + i).get(this)).setSelectedIndex(1);
					break;
				case "ANYTIME":
					((JComboBox<ImageIcon>) Options.class.getDeclaredField("action" + i).get(this)).setSelectedIndex(2);
					break;
				case "COMPANION":
					((JComboBox<ImageIcon>) Options.class.getDeclaredField("action" + i).get(this)).setSelectedIndex(3);
					break;
				case "DUAL":
					((JComboBox<ImageIcon>) Options.class.getDeclaredField("action" + i).get(this)).setSelectedIndex(4);
					break;
			}
		}
		
		// ----------------------------------------------------------------------------------------
		
		final JCheckBox action1enabled = new JCheckBox();
		action1enabled.setOpaque(false);
		if ((Server.class.getDeclaredField("player" + number + "Action1e").getBoolean(su.server)))
			action1enabled.setSelected(true);
		action1enabled.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				su.server.input("Player " + number + " actionenable 1 " + action1enabled.isSelected());
				try
				{
					Server.class.getDeclaredField("player" + number + "Action1e").setBoolean(su.server, action1enabled.isSelected());
					((JButton) GMAP.class.getDeclaredField("playerAction1").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
							.setEnabled(action1enabled.isSelected());
				} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
				{
					e.printStackTrace();
				}
			}
		});
		
		final JCheckBox action2enabled = new JCheckBox();
		action2enabled.setOpaque(false);
		if ((Server.class.getDeclaredField("player" + number + "Action2e").getBoolean(su.server)))
			action2enabled.setSelected(true);
		action2enabled.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				su.server.input("Player " + number + " actionenable 2 " + action2enabled.isSelected());
				try
				{
					Server.class.getDeclaredField("player" + number + "Action2e").setBoolean(su.server, action2enabled.isSelected());
					((JButton) GMAP.class.getDeclaredField("playerAction2").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
							.setEnabled(action2enabled.isSelected());
				} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
				{
					e.printStackTrace();
				}
			}
		});
		
		final JCheckBox action3enabled = new JCheckBox();
		action3enabled.setOpaque(false);
		if ((Server.class.getDeclaredField("player" + number + "Action3e").getBoolean(su.server)))
			action3enabled.setSelected(true);
		action3enabled.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				su.server.input("Player " + number + " actionenable 3 " + action3enabled.isSelected());
				try
				{
					Server.class.getDeclaredField("player" + number + "Action3e").setBoolean(su.server, action3enabled.isSelected());
					((JButton) GMAP.class.getDeclaredField("playerAction3").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
							.setEnabled(action3enabled.isSelected());
				} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
				{
					e.printStackTrace();
				}
			}
		});
		
		final JCheckBox action4enabled = new JCheckBox();
		action4enabled.setOpaque(false);
		if ((Server.class.getDeclaredField("player" + number + "Action4e").getBoolean(su.server)))
			action4enabled.setSelected(true);
		action4enabled.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				su.server.input("Player " + number + " actionenable 4 " + action4enabled.isSelected());
				try
				{
					Server.class.getDeclaredField("player" + number + "Action4e").setBoolean(su.server, action4enabled.isSelected());
					((JButton) GMAP.class.getDeclaredField("playerAction4").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
							.setEnabled(action4enabled.isSelected());
				} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
				{
					e.printStackTrace();
				}
			}
		});
		
		final JCheckBox action5enabled = new JCheckBox();
		action5enabled.setOpaque(false);
		if ((Server.class.getDeclaredField("player" + number + "Action5e").getBoolean(su.server)))
			action5enabled.setSelected(true);
		action5enabled.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				su.server.input("Player " + number + " actionenable 5 " + action5enabled.isSelected());
				try
				{
					Server.class.getDeclaredField("player" + number + "Action5e").setBoolean(su.server, action5enabled.isSelected());
					((JButton) GMAP.class.getDeclaredField("playerAction5").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
							.setEnabled(action5enabled.isSelected());
				} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
				{
					e.printStackTrace();
				}
			}
		});
		
		final JCheckBox action6enabled = new JCheckBox();
		action6enabled.setOpaque(false);
		if ((Server.class.getDeclaredField("player" + number + "Action6e").getBoolean(su.server)))
			action6enabled.setSelected(true);
		action6enabled.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				su.server.input("Player " + number + " actionenable 6 " + action6enabled.isSelected());
				try
				{
					Server.class.getDeclaredField("player" + number + "Action6e").setBoolean(su.server, action6enabled.isSelected());
					((JButton) GMAP.class.getDeclaredField("playerAction6").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
							.setEnabled(action6enabled.isSelected());
				} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
				{
					e.printStackTrace();
				}
			}
		});
		
		final JCheckBox action7enabled = new JCheckBox();
		action7enabled.setOpaque(false);
		if ((Server.class.getDeclaredField("player" + number + "Action7e").getBoolean(su.server)))
			action7enabled.setSelected(true);
		action7enabled.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				su.server.input("Player " + number + " actionenable 7 " + action7enabled.isSelected());
				try
				{
					Server.class.getDeclaredField("player" + number + "Action7e").setBoolean(su.server, action7enabled.isSelected());
					((JButton) GMAP.class.getDeclaredField("playerAction7").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
							.setEnabled(action7enabled.isSelected());
				} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
				{
					e.printStackTrace();
				}
			}
		});
		
		final JCheckBox action8enabled = new JCheckBox();
		action8enabled.setOpaque(false);
		if ((Server.class.getDeclaredField("player" + number + "Action8e").getBoolean(su.server)))
			action8enabled.setSelected(true);
		action8enabled.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				su.server.input("Player " + number + " actionenable 8 " + action8enabled.isSelected());
				try
				{
					Server.class.getDeclaredField("player" + number + "Action8e").setBoolean(su.server, action8enabled.isSelected());
					((JButton) GMAP.class.getDeclaredField("playerAction8").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
							.setEnabled(action8enabled.isSelected());
				} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
				{
					e.printStackTrace();
				}
			}
		});
		
		// ----------------------------------------------------------------------------------------
		
		playerImage = new JLabel();
		
		JLabel imagelbl = new JLabel("Player Image Link", SwingConstants.CENTER);
		
		final JTextField link = new JTextField();
		link.setColumns(1);
		link.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					playerImage.setIcon(new ImageIcon(ImageIO.read(new URL(link.getText())).getScaledInstance(playerImage.getWidth(),
							playerImage.getHeight(), Image.SCALE_SMOOTH)));
					Server.class.getDeclaredField("player" + number + "Image").set(su.server, link.getText());
					su.server.input("Player " + number + " image " + link.getText());
				} catch (IOException | IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
				{
					JOptionPane.showMessageDialog(new JFrame(), "Image is invalid", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		// ----------------------------------------------------------------------------------------
		
		/**
		 * BOUNDS
		 **/
		
		stamCount.setBounds(30 + 98, 30, 100, 20);
		stamCountSet.setBounds(150 + 98, 30, 100, 20);
		
		c1stamCount.setBounds(30 + 98, 60, 100, 20);
		c1stamCountSet.setBounds(150 + 98, 60, 100, 20);
		
		c2stamCount.setBounds(30 + 98, 90, 100, 20);
		c2stamCountSet.setBounds(150 + 98, 90, 100, 20);
		
		c3stamCount.setBounds(30 + 98, 120, 100, 20);
		c3stamCountSet.setBounds(150 + 98, 120, 100, 20);
		
		action1.setBounds(212 - 140, 200, 64, 64);
		action2.setBounds(212 - 70, 200, 64, 64);
		action3.setBounds(212, 200, 64, 64);
		action4.setBounds(212 + 70, 200, 64, 64);
		action5.setBounds(212 + 140, 200, 64, 64);
		action6.setBounds(212 - 70, 281, 64, 64);
		action7.setBounds(212, 281, 64, 64);
		action8.setBounds(212 + 70, 281, 64, 64);
		
		action1enabled.setBounds((212 - 140 + 32) - 11, 176, 30, 30);
		action2enabled.setBounds((212 - 70 + 32) - 11, 176, 30, 30);
		action3enabled.setBounds((212 + 32) - 11, 176, 30, 30);
		action4enabled.setBounds((212 + 70 + 32) - 11, 176, 30, 30);
		action5enabled.setBounds((212 + 140 + 32) - 11, 176, 30, 30);
		action6enabled.setBounds((212 - 70 + 32) - 11, 257, 30, 30);
		action7enabled.setBounds((212 + 32) - 11, 257, 30, 30);
		action8enabled.setBounds((212 + 70 + 32) - 11, 257, 30, 30);
		
		playerImage.setBounds((244 - 65), 355, 130, 130);
		imagelbl.setBounds((244 - 100), 483, 200, 20);
		link.setBounds((244 - 100), 502, 200, 20);
		
		/**
		 * ADDING
		 **/
		
		panel.add(stamCount);
		panel.add(stamCountSet);
		
		panel.add(c1stamCount);
		panel.add(c1stamCountSet);
		
		panel.add(c2stamCount);
		panel.add(c2stamCountSet);
		
		panel.add(c3stamCount);
		panel.add(c3stamCountSet);
		
		panel.add(action1);
		panel.add(action2);
		panel.add(action3);
		panel.add(action4);
		panel.add(action5);
		panel.add(action6);
		panel.add(action7);
		panel.add(action8);
		
		panel.add(action1enabled);
		panel.add(action2enabled);
		panel.add(action3enabled);
		panel.add(action4enabled);
		panel.add(action5enabled);
		panel.add(action6enabled);
		panel.add(action7enabled);
		panel.add(action8enabled);
		
		panel.add(playerImage);
		panel.add(imagelbl);
		panel.add(link);
	}
	
	class ButtonlessComboBox<E> extends JComboBox<E> {
		/**
		 * Taken from
		 * http://www.java2s.com/Tutorials/Java/Swing_How_to/JComboBox/Hide_arrow_button_from_JComboBox.htm
		 */
		private static final long serialVersionUID = -3963843217388449591L;
		
		public ButtonlessComboBox(E[] list)
		{
			super(list);
		}
		
		@Override
		public void updateUI()
		{
			super.updateUI();
			UIManager.put("ComboBox.squareButton", Boolean.FALSE);
			setUI(new BasicComboBoxUI() {
				@Override
				protected JButton createArrowButton()
				{
					JButton b = new JButton();
					b.setBorder(BorderFactory.createEmptyBorder());
					b.setVisible(false);
					return b;
				}
			});
			setBorder(BorderFactory.createLineBorder(Color.GRAY));
		}
	}
}
