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
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

// Game Manager Add Players, or GMAP for short - Uses reflection to cut the code needed by about a quarter

public class GMAP {
	
	private ServerGMUI	sgmu;
	private int			number;
	public JTextField	playerName, playerStam, playerGold, playercStam;
	JComboBox<String>	playerclbl;
	JCheckBox			enabled;
	JButton				playerAction1	= new JButton(), playerAction2 = new JButton(), playerAction3 = new JButton(), playerAction4 = new JButton(),
			playerAction5 = new JButton(), playerAction6 = new JButton(), playerAction7 = new JButton(), playerAction8 = new JButton();
	
	private int	XOne, XOffsetOne = 45, XOffsetTwo = 120, YOne, YOffset = 60;
	public int	c	= 1;
	
	public void add(ServerGMUI s, JPanel panel, final int number, int xstart, int ystart)
	{
		sgmu = s;
		this.number = number;
		final Timer timer = sgmu.timer;
		final Server server = sgmu.server;
		XOne = xstart;
		YOne = ystart;
		
		JLabel lbl = new JLabel("Player " + number + " Options");
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		lbl.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
		
		playerName = new JTextField();
		playerName.setBackground(new Color(211, 186, 146));
		playerName.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(62, 47, 28)));
		
		playerStam = new JTextField("10/10");
		playerStam.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		playerStam.setEditable(false);
		playerStam.setHorizontalAlignment(SwingConstants.CENTER);
		
		final JButton playerplus1 = new JButton("");
		playerplus1.setContentAreaFilled(false);
		playerplus1.setIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/Stamina/1+.jpg")));
		playerplus1.setSelectedIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/Stamina/1+p.jpg")));
		playerplus1.setBorderPainted(false);
		playerplus1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				playerplus1.setSelected(true);
				timer.schedule(new TimerTask() {
					
					@Override
					public void run()
					{
						playerplus1.setSelected(false);
					}
				}, 100L);
				
				try
				{
					server.getClass().getField("player" + number + "CStam").setInt(server,
							server.getClass().getField("player" + number + "CStam").getInt(server) + 1);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
				
				server.input("Player " + number + " damage 1");
			}
		});
		
		final JButton playerplus5 = new JButton("");
		playerplus5.setIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/Stamina/5+.jpg")));
		playerplus5.setSelectedIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/Stamina/5+p.jpg")));
		playerplus5.setContentAreaFilled(false);
		playerplus5.setBorderPainted(false);
		playerplus5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				playerplus5.setSelected(true);
				timer.schedule(new TimerTask() {
					
					@Override
					public void run()
					{
						playerplus5.setSelected(false);
					}
				}, 100L);
				
				try
				{
					server.getClass().getField("player" + number + "CStam").setInt(server,
							server.getClass().getField("player" + number + "CStam").getInt(server) + 5);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
				
				server.input("Player " + number + " damage 5");
			}
		});
		
		final JButton playerplus10 = new JButton("");
		playerplus10.setIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/Stamina/10+.jpg")));
		playerplus10.setSelectedIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/Stamina/10+p.jpg")));
		playerplus10.setContentAreaFilled(false);
		playerplus10.setBorderPainted(false);
		playerplus10.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				playerplus10.setSelected(true);
				timer.schedule(new TimerTask() {
					
					@Override
					public void run()
					{
						playerplus10.setSelected(false);
					}
				}, 100L);
				
				try
				{
					server.getClass().getField("player" + number + "CStam").setInt(server,
							server.getClass().getField("player" + number + "CStam").getInt(server) + 10);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
				
				server.input("Player " + number + " damage 10");
			}
		});
		
		final JButton playerminus1 = new JButton("");
		playerminus1.setIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/Stamina/1-.jpg")));
		playerminus1.setSelectedIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/Stamina/1-p.jpg")));
		playerminus1.setContentAreaFilled(false);
		playerminus1.setBorderPainted(false);
		playerminus1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				playerminus1.setSelected(true);
				timer.schedule(new TimerTask() {
					
					@Override
					public void run()
					{
						playerminus1.setSelected(false);
					}
				}, 100L);
				
				try
				{
					server.getClass().getField("player" + number + "CStam").setInt(server,
							server.getClass().getField("player" + number + "CStam").getInt(server) - 1);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
				
				server.input("Player " + number + " damage -1");
			}
		});
		
		final JButton playerminus5 = new JButton("");
		playerminus5.setIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/Stamina/5-.jpg")));
		playerminus5.setSelectedIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/Stamina/5-p.jpg")));
		playerminus5.setContentAreaFilled(false);
		playerminus5.setBorderPainted(false);
		playerminus5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				playerminus5.setSelected(true);
				timer.schedule(new TimerTask() {
					
					@Override
					public void run()
					{
						playerminus5.setSelected(false);
					}
				}, 100L);
				
				try
				{
					server.getClass().getField("player" + number + "CStam").setInt(server,
							server.getClass().getField("player" + number + "CStam").getInt(server) - 5);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
				
				server.input("Player " + number + " damage -5");
			}
		});
		
		final JButton playerminus10 = new JButton("");
		playerminus10.setIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/Stamina/10-.jpg")));
		playerminus10.setSelectedIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/Stamina/10-p.jpg")));
		playerminus10.setContentAreaFilled(false);
		playerminus10.setBorderPainted(false);
		playerminus10.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				playerminus10.setSelected(true);
				timer.schedule(new TimerTask() {
					
					@Override
					public void run()
					{
						playerminus10.setSelected(false);
					}
				}, 100L);
				
				try
				{
					server.getClass().getField("player" + number + "CStam").setInt(server,
							server.getClass().getField("player" + number + "CStam").getInt(server) - 10);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
				
				server.input("Player " + number + " damage -10");
			}
		});
		
		final JLabel playerGoldlbl = new JLabel("Gold");
		playerGoldlbl.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		playerGoldlbl.setHorizontalAlignment(SwingConstants.CENTER);
		
		playerGold = new JTextField("0");
		playerGold.setHorizontalAlignment(SwingConstants.CENTER);
		playerGold.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		playerGold.setEditable(false);
		
		final JButton playerplus10gold = new JButton("");
		playerplus10gold.setBorderPainted(false);
		playerplus10gold.setContentAreaFilled(false);
		playerplus10gold.setIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/Gold/10+.png")));
		playerplus10gold.setSelectedIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/Gold/10+p.jpg")));
		playerplus10gold.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				playerplus10gold.setSelected(true);
				timer.schedule(new TimerTask() {
					
					@Override
					public void run()
					{
						playerplus10gold.setSelected(false);
					}
				}, 100L);
				
				try
				{
					server.getClass().getField("player" + number + "Gold").setInt(server,
							server.getClass().getField("player" + number + "Gold").getInt(server) + 10);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
				
				server.input("Player " + number + " modifygold 10");
			}
		});
		
		final JButton playerplus100gold = new JButton("");
		playerplus100gold.setSelectedIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/Gold/100+p.jpg")));
		playerplus100gold.setIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/Gold/100+.jpg")));
		playerplus100gold.setContentAreaFilled(false);
		playerplus100gold.setBorderPainted(false);
		playerplus100gold.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				playerplus100gold.setSelected(true);
				timer.schedule(new TimerTask() {
					
					@Override
					public void run()
					{
						playerplus100gold.setSelected(false);
					}
				}, 100L);
				
				try
				{
					server.getClass().getField("player" + number + "Gold").setInt(server,
							server.getClass().getField("player" + number + "Gold").getInt(server) + 100);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
				
				server.input("Player " + number + " modifygold 100");
			}
		});
		
		final JButton playerplus500gold = new JButton("");
		playerplus500gold.setSelectedIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/Gold/500+p.jpg")));
		playerplus500gold.setIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/Gold/500+.jpg")));
		playerplus500gold.setContentAreaFilled(false);
		playerplus500gold.setBorderPainted(false);
		playerplus500gold.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				playerplus500gold.setSelected(true);
				timer.schedule(new TimerTask() {
					
					@Override
					public void run()
					{
						playerplus500gold.setSelected(false);
					}
				}, 100L);
				
				try
				{
					server.getClass().getField("player" + number + "Gold").setInt(server,
							server.getClass().getField("player" + number + "Gold").getInt(server) + 500);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
				
				server.input("Player " + number + " modifygold 500");
			}
		});
		
		final JButton playerminus10gold = new JButton("");
		playerminus10gold.setContentAreaFilled(false);
		playerminus10gold.setBorderPainted(false);
		playerminus10gold.setIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/Gold/10-.png")));
		playerminus10gold.setSelectedIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/Gold/10-p.jpg")));
		playerminus10gold.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				playerminus10gold.setSelected(true);
				timer.schedule(new TimerTask() {
					
					@Override
					public void run()
					{
						playerminus10gold.setSelected(false);
					}
				}, 100L);
				
				try
				{
					server.getClass().getField("player" + number + "Gold").setInt(server,
							server.getClass().getField("player" + number + "Gold").getInt(server) - 10);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
				
				server.input("Player " + number + " modifygold -10");
			}
		});
		
		final JButton playerminus100gold = new JButton("");
		playerminus100gold.setSelectedIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/Gold/100-p.jpg")));
		playerminus100gold.setIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/Gold/100-.jpg")));
		playerminus100gold.setContentAreaFilled(false);
		playerminus100gold.setBorderPainted(false);
		playerminus100gold.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				playerminus100gold.setSelected(true);
				timer.schedule(new TimerTask() {
					
					@Override
					public void run()
					{
						playerminus100gold.setSelected(false);
					}
				}, 100L);
				
				try
				{
					server.getClass().getField("player" + number + "Gold").setInt(server,
							server.getClass().getField("player" + number + "Gold").getInt(server) - 100);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
				
				server.input("Player " + number + " modifygold -100");
			}
		});
		
		final JButton playerminus500gold = new JButton("");
		playerminus500gold.setSelectedIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/Gold/500-p.jpg")));
		playerminus500gold.setIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/Gold/500-.jpg")));
		playerminus500gold.setContentAreaFilled(false);
		playerminus500gold.setBorderPainted(false);
		playerminus500gold.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				playerminus500gold.setSelected(true);
				timer.schedule(new TimerTask() {
					
					@Override
					public void run()
					{
						playerminus500gold.setSelected(false);
					}
				}, 100L);
				
				try
				{
					server.getClass().getField("player" + number + "Gold").setInt(server,
							server.getClass().getField("player" + number + "Gold").getInt(server) - 500);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
				
				server.input("Player " + number + " modifygold -500");
			}
		});
		
		playerclbl = new JComboBox<String>(new String[] { "Companion 1", "Companion 2", "Companion 3" });
		playerclbl.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		playerclbl.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				c = Integer.valueOf(((String) playerclbl.getSelectedItem()).replaceAll("[^0-9]", ""));
				try
				{
					playercStam.setText(sgmu.server.getClass().getField("player" + number + "c" + c + "CStam").getInt(sgmu.server) + "/"
							+ sgmu.server.getClass().getField("player" + number + "c" + c + "Stam").getInt(sgmu.server));
					enabled.setSelected(server.getClass().getField("player" + number + "c" + c + "enabled").getBoolean(server));
				} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e1)
				{
					e1.printStackTrace();
				}
			}
		});
		
		enabled = new JCheckBox();
		enabled.setText("");
		enabled.setOpaque(false);
		enabled.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					server.getClass().getField("player" + number + "c" + c + "enabled").setBoolean(server, enabled.isSelected());
					if (server.getClass().getField("player" + number + "c" + c + "enabled").getBoolean(server))
						server.input("Companion " + number + " " + c + " enable");
					else
						server.input("Companion " + number + " " + c + " disable");
				} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
				{
					e.printStackTrace();
				}
			}
		});
		
		playercStam = new JTextField("10/10");
		playercStam.setHorizontalAlignment(SwingConstants.CENTER);
		playercStam.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		playercStam.setEditable(false);
		
		final JButton playercplus1 = new JButton("");
		playercplus1.setSelectedIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/Stamina/1+p.jpg")));
		playercplus1.setIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/Stamina/1+.jpg")));
		playercplus1.setBorderPainted(false);
		playercplus1.setContentAreaFilled(false);
		playercplus1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent paramActionEvent)
			{
				playercplus1.setSelected(true);
				timer.schedule(new TimerTask() {
					
					@Override
					public void run()
					{
						playercplus1.setSelected(false);
					}
				}, 100L);
				
				try
				{
					server.getClass().getField("player" + number + "c" + c + "CStam").setInt(server,
							server.getClass().getField("player" + number + "c" + c + "CStam").getInt(server) + 1);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
				
				server.input("Companion " + number + " " + c + " damage 1");
			}
		});
		
		final JButton playercplus5 = new JButton("");
		playercplus5.setIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/Stamina/5+.jpg")));
		playercplus5.setSelectedIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/Stamina/5+p.jpg")));
		playercplus5.setBorderPainted(false);
		playercplus5.setContentAreaFilled(false);
		playercplus5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent paramActionEvent)
			{
				playercplus5.setSelected(true);
				timer.schedule(new TimerTask() {
					
					@Override
					public void run()
					{
						playercplus5.setSelected(false);
					}
				}, 100L);
				
				try
				{
					server.getClass().getField("player" + number + "c" + c + "CStam").setInt(server,
							server.getClass().getField("player" + number + "c" + c + "CStam").getInt(server) + 5);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
				
				server.input("Companion " + number + " " + c + " damage 5");
			}
		});
		
		final JButton playercplus10 = new JButton("");
		playercplus10.setIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/Stamina/10+.jpg")));
		playercplus10.setSelectedIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/Stamina/10+p.jpg")));
		playercplus10.setBorderPainted(false);
		playercplus10.setContentAreaFilled(false);
		playercplus10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent paramActionEvent)
			{
				playercplus10.setSelected(true);
				timer.schedule(new TimerTask() {
					
					@Override
					public void run()
					{
						playercplus10.setSelected(false);
					}
				}, 100L);
				
				try
				{
					server.getClass().getField("player" + number + "c" + c + "CStam").setInt(server,
							server.getClass().getField("player" + number + "c" + c + "CStam").getInt(server) + 10);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
				
				server.input("Companion " + number + " " + c + " damage 10");
			}
		});
		
		final JButton playercminus1 = new JButton("");
		playercminus1.setIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/Stamina/1-.jpg")));
		playercminus1.setSelectedIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/Stamina/1-p.jpg")));
		playercminus1.setBorderPainted(false);
		playercminus1.setContentAreaFilled(false);
		playercminus1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent paramActionEvent)
			{
				playercminus1.setSelected(true);
				timer.schedule(new TimerTask() {
					
					@Override
					public void run()
					{
						playercminus1.setSelected(false);
					}
				}, 100L);
				
				try
				{
					server.getClass().getField("player" + number + "c" + c + "CStam").setInt(server,
							server.getClass().getField("player" + number + "c" + c + "CStam").getInt(server) - 1);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
				
				server.input("Companion " + number + " " + c + " damage -1");
			}
		});
		
		final JButton playercminus5 = new JButton("");
		playercminus5.setIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/Stamina/5-.jpg")));
		playercminus5.setSelectedIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/Stamina/5-p.jpg")));
		playercminus5.setBorderPainted(false);
		playercminus5.setContentAreaFilled(false);
		playercminus5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent paramActionEvent)
			{
				playercminus5.setSelected(true);
				timer.schedule(new TimerTask() {
					
					@Override
					public void run()
					{
						playercminus5.setSelected(false);
					}
				}, 100L);
				
				try
				{
					server.getClass().getField("player" + number + "c" + c + "CStam").setInt(server,
							server.getClass().getField("player" + number + "c" + c + "CStam").getInt(server) - 5);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
				
				server.input("Companion " + number + " " + c + " damage -5");
			}
		});
		
		final JButton playercminus10 = new JButton("");
		playercminus10.setIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/Stamina/10-.jpg")));
		playercminus10.setSelectedIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/Stamina/10-p.jpg")));
		playercminus10.setBorderPainted(false);
		playercminus10.setContentAreaFilled(false);
		playercminus10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent paramActionEvent)
			{
				playercminus10.setSelected(true);
				timer.schedule(new TimerTask() {
					
					@Override
					public void run()
					{
						playercminus10.setSelected(false);
					}
				}, 100L);
				
				try
				{
					server.getClass().getField("player" + number + "c" + c + "CStam").setInt(server,
							server.getClass().getField("player" + number + "c" + c + "CStam").getInt(server) - 10);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
				
				server.input("Companion " + number + " " + c + " damage -10");
			}
		});
		
		playerAction1.setBorder(null);
		playerAction1.setContentAreaFilled(false);
		playerAction1.setIcon(new ImageIcon(
				new ImageIcon(GMAP.class.getResource("/resources/UI/move slot.png")).getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
		playerAction1.setSelectedIcon(new ImageIcon(
				new ImageIcon(GMAP.class.getResource("/resources/UI/slot.png")).getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
		playerAction1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				if (playerAction1.isSelected())
				{
					playerAction1.setSelected(false);
					try
					{
						server.getClass().getField("player" + number + "Action1").setBoolean(server, true);
					} catch (Exception e)
					{
						e.printStackTrace();
					}
					server.input("Player " + number + " action 1 true");
				} else
				{
					playerAction1.setSelected(true);
					try
					{
						server.getClass().getField("player" + number + "Action1").setBoolean(server, false);
					} catch (Exception e)
					{
						e.printStackTrace();
					}
					server.input("Player " + number + " action 1 false");
				}
			}
		});
		
		playerAction2.setBorder(null);
		playerAction2.setContentAreaFilled(false);
		playerAction2.setIcon(new ImageIcon(
				new ImageIcon(GMAP.class.getResource("/resources/UI/action slot.png")).getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
		playerAction2.setSelectedIcon(new ImageIcon(
				new ImageIcon(GMAP.class.getResource("/resources/UI/slot.png")).getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
		playerAction2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				if (playerAction2.isSelected())
				{
					playerAction2.setSelected(false);
					try
					{
						server.getClass().getField("player" + number + "Action2").setBoolean(server, true);
					} catch (Exception e)
					{
						e.printStackTrace();
					}
					server.input("Player " + number + " action 2 true");
				} else
				{
					playerAction2.setSelected(true);
					try
					{
						server.getClass().getField("player" + number + "Action2").setBoolean(server, false);
					} catch (Exception e)
					{
						e.printStackTrace();
					}
					server.input("Player " + number + " action 2 false");
				}
			}
		});
		
		playerAction3.setBorder(null);
		playerAction3.setContentAreaFilled(false);
		playerAction3.setIcon(new ImageIcon(
				new ImageIcon(GMAP.class.getResource("/resources/UI/anytime slot.png")).getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
		playerAction3.setSelectedIcon(new ImageIcon(
				new ImageIcon(GMAP.class.getResource("/resources/UI/slot.png")).getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
		playerAction3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				if (playerAction3.isSelected())
				{
					playerAction3.setSelected(false);
					try
					{
						server.getClass().getField("player" + number + "Action3").setBoolean(server, true);
					} catch (Exception e)
					{
						e.printStackTrace();
					}
					server.input("Player " + number + " action 3 true");
				} else
				{
					playerAction3.setSelected(true);
					try
					{
						server.getClass().getField("player" + number + "Action3").setBoolean(server, false);
					} catch (Exception e)
					{
						e.printStackTrace();
					}
					server.input("Player " + number + " action 3 false");
				}
			}
		});
		
		playerAction4.setBorder(null);
		playerAction4.setContentAreaFilled(false);
		playerAction4.setIcon(new ImageIcon(
				new ImageIcon(GMAP.class.getResource("/resources/UI/anytime slot.png")).getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
		playerAction4.setSelectedIcon(new ImageIcon(
				new ImageIcon(GMAP.class.getResource("/resources/UI/slot.png")).getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
		playerAction4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				if (playerAction4.isSelected())
				{
					playerAction4.setSelected(false);
					try
					{
						server.getClass().getField("player" + number + "Action4").setBoolean(server, true);
					} catch (Exception e)
					{
						e.printStackTrace();
					}
					server.input("Player " + number + " action 4 true");
				} else
				{
					playerAction4.setSelected(true);
					try
					{
						server.getClass().getField("player" + number + "Action4").setBoolean(server, false);
					} catch (Exception e)
					{
						e.printStackTrace();
					}
					server.input("Player " + number + " action 4 false");
				}
			}
		});
		
		playerAction5.setBorder(null);
		playerAction5.setContentAreaFilled(false);
		playerAction5.setIcon(new ImageIcon(
				new ImageIcon(GMAP.class.getResource("/resources/UI/anytime slot.png")).getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
		playerAction5.setSelectedIcon(new ImageIcon(
				new ImageIcon(GMAP.class.getResource("/resources/UI/slot.png")).getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
		playerAction5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				if (playerAction5.isSelected())
				{
					playerAction5.setSelected(false);
					try
					{
						server.getClass().getField("player" + number + "Action5").setBoolean(server, true);
					} catch (Exception e)
					{
						e.printStackTrace();
					}
					server.input("Player " + number + " action 5 true");
				} else
				{
					playerAction5.setSelected(true);
					try
					{
						server.getClass().getField("player" + number + "Action5").setBoolean(server, false);
					} catch (Exception e)
					{
						e.printStackTrace();
					}
					server.input("Player " + number + " action 5 false");
				}
			}
		});
		
		playerAction6.setBorder(null);
		playerAction6.setContentAreaFilled(false);
		playerAction6.setIcon(new ImageIcon(
				new ImageIcon(GMAP.class.getResource("/resources/UI/anytime slot.png")).getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
		playerAction6.setSelectedIcon(new ImageIcon(
				new ImageIcon(GMAP.class.getResource("/resources/UI/slot.png")).getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
		playerAction6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				if (playerAction6.isSelected())
				{
					playerAction6.setSelected(false);
					try
					{
						server.getClass().getField("player" + number + "Action6").setBoolean(server, true);
					} catch (Exception e)
					{
						e.printStackTrace();
					}
					server.input("Player " + number + " action 6 true");
				} else
				{
					playerAction6.setSelected(true);
					try
					{
						server.getClass().getField("player" + number + "Action6").setBoolean(server, false);
					} catch (Exception e)
					{
						e.printStackTrace();
					}
					server.input("Player " + number + " action 6 false");
				}
			}
		});
		
		playerAction7.setBorder(null);
		playerAction7.setContentAreaFilled(false);
		playerAction7.setIcon(new ImageIcon(
				new ImageIcon(GMAP.class.getResource("/resources/UI/anytime slot.png")).getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
		playerAction7.setSelectedIcon(new ImageIcon(
				new ImageIcon(GMAP.class.getResource("/resources/UI/slot.png")).getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
		playerAction7.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				if (playerAction7.isSelected())
				{
					playerAction7.setSelected(false);
					try
					{
						server.getClass().getField("player" + number + "Action7").setBoolean(server, true);
					} catch (Exception e)
					{
						e.printStackTrace();
					}
					server.input("Player " + number + " action 7 true");
				} else
				{
					playerAction7.setSelected(true);
					try
					{
						server.getClass().getField("player" + number + "Action7").setBoolean(server, false);
					} catch (Exception e)
					{
						e.printStackTrace();
					}
					server.input("Player " + number + " action 7 false");
				}
			}
		});
		
		playerAction8.setBorder(null);
		playerAction8.setContentAreaFilled(false);
		playerAction8.setIcon(new ImageIcon(
				new ImageIcon(GMAP.class.getResource("/resources/UI/anytime slot.png")).getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
		playerAction8.setSelectedIcon(new ImageIcon(
				new ImageIcon(GMAP.class.getResource("/resources/UI/slot.png")).getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
		playerAction8.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				if (playerAction8.isSelected())
				{
					playerAction8.setSelected(false);
					try
					{
						server.getClass().getField("player" + number + "Action8").setBoolean(server, true);
					} catch (Exception e)
					{
						e.printStackTrace();
					}
					server.input("Player " + number + " action 8 true");
				} else
				{
					playerAction8.setSelected(true);
					try
					{
						server.getClass().getField("player" + number + "Action8").setBoolean(server, false);
					} catch (Exception e)
					{
						e.printStackTrace();
					}
					server.input("Player " + number + " action 8 false");
				}
			}
		});
		
		playerAction6.setEnabled(false);
		playerAction7.setEnabled(false);
		playerAction8.setEnabled(false);
		
		// --------------------------------------------------------------------------------------------------------------------------------------
		// LOCATIONS
		// --------------------------------------------------------------------------------------------------------------------------------------
		
		lbl.setBounds(XOne + 115, YOne - 40, 110, 30);
		playerName.setBounds(XOne + 235, YOne - 35, 86, 20);
		playerStam.setBounds(XOne + 135, YOne - 5, 70, 30);
		playerGoldlbl.setBounds(XOne + 135, YOne + 30, 70, 20);
		playerGold.setBounds(XOne + 135, YOne + 55, 70, 30);
		
		playerminus1.setBounds(XOne, YOne, 40, 20);
		playerminus5.setBounds(XOne + XOffsetOne, YOne, 40, 20);
		playerminus10.setBounds(XOne + (XOffsetOne * 2), YOne, 40, 20);
		playerplus1.setBounds(XOne + (XOffsetOne * 2) + XOffsetTwo, YOne, 40, 20);
		playerplus5.setBounds(XOne + (XOffsetOne * 3) + XOffsetTwo, YOne, 40, 20);
		playerplus10.setBounds(XOne + (XOffsetOne * 4) + XOffsetTwo, YOne, 40, 20);
		
		playerminus10gold.setBounds(XOne, YOne + YOffset, 40, 20);
		playerminus100gold.setBounds(XOne + XOffsetOne, YOne + YOffset, 40, 20);
		playerminus500gold.setBounds(XOne + (XOffsetOne * 2), YOne + YOffset, 40, 20);
		playerplus10gold.setBounds(XOne + (XOffsetOne * 2) + XOffsetTwo, YOne + YOffset, 40, 20);
		playerplus100gold.setBounds(XOne + (XOffsetOne * 3) + XOffsetTwo, YOne + YOffset, 40, 20);
		playerplus500gold.setBounds(XOne + (XOffsetOne * 4) + XOffsetTwo, YOne + YOffset, 40, 20);
		
		playerclbl.setBounds(XOne + 120, YOne + 90, 100, 20);
		enabled.setBounds(XOne + 250, YOne + 90, 20, 20);
		playercStam.setBounds(XOne + 135, YOne + 115, 70, 30);
		
		playercminus1.setBounds(XOne, YOne + (YOffset * 2), 40, 20);
		playercminus5.setBounds(XOne + XOffsetOne, YOne + (YOffset * 2), 40, 20);
		playercminus10.setBounds(XOne + (XOffsetOne * 2), YOne + (YOffset * 2), 40, 20);
		playercplus1.setBounds(XOne + (XOffsetOne * 2) + XOffsetTwo, YOne + (YOffset * 2), 40, 20);
		playercplus5.setBounds(XOne + (XOffsetOne * 3) + XOffsetTwo, YOne + (YOffset * 2), 40, 20);
		playercplus10.setBounds(XOne + (XOffsetOne * 4) + XOffsetTwo, YOne + (YOffset * 2), 40, 20);
		
		playerAction1.setBounds(XOne - 10 + (45 * 2) - 60, YOne + (YOffset * 2) + 30, 60, 60);
		playerAction2.setBounds(XOne - 10 + (45 * 2), YOne + (YOffset * 2) + 30, 60, 60);
		playerAction3.setBounds(XOne - 10 + (45 * 2) + 60, YOne + (YOffset * 2) + 30, 60, 60);
		playerAction4.setBounds(XOne - 10 + (45 * 2) + 120, YOne + (YOffset * 2) + 30, 60, 60);
		playerAction5.setBounds(XOne - 10 + (45 * 2) + 180, YOne + (YOffset * 2) + 30, 60, 60);
		
		playerAction6.setBounds(XOne - 10 + (45 * 2), YOne + (YOffset * 2) + 80, 60, 60);
		playerAction7.setBounds(XOne - 10 + (45 * 2) + 60, YOne + (YOffset * 2) + 80, 60, 60);
		playerAction8.setBounds(XOne - 10 + (45 * 2) + 120, YOne + (YOffset * 2) + 80, 60, 60);
		
		// --------------------------------------------------------------------------------------------------------------------------------------
		// ADDING
		// --------------------------------------------------------------------------------------------------------------------------------------
		
		panel.add(lbl);
		panel.add(playerName);
		panel.add(playerStam);
		panel.add(playerminus1);
		panel.add(playerminus5);
		panel.add(playerminus10);
		panel.add(playerplus5);
		panel.add(playerplus10);
		panel.add(playerplus1);
		panel.add(playerGoldlbl);
		panel.add(playerGold);
		panel.add(playerminus10gold);
		panel.add(playerminus100gold);
		panel.add(playerminus500gold);
		panel.add(playerplus10gold);
		panel.add(playerplus100gold);
		panel.add(playerplus500gold);
		panel.add(playerclbl);
		panel.add(enabled);
		panel.add(playercStam);
		panel.add(playercminus1);
		panel.add(playercminus5);
		panel.add(playercminus10);
		panel.add(playercplus1);
		panel.add(playercplus5);
		panel.add(playercplus10);
		panel.add(playerAction1);
		panel.add(playerAction2);
		panel.add(playerAction3);
		panel.add(playerAction4);
		panel.add(playerAction5);
		panel.add(playerAction6);
		panel.add(playerAction7);
		panel.add(playerAction8);
	}
	
	public void newround() throws Exception
	{
		if (sgmu.server.actionTypes.get("p" + number + "a1") != "ANYTIME")
		{
			playerAction1.setSelected(false);
			Server.class.getDeclaredField("player" + number + "Action1").setBoolean(sgmu.server, true);
			sgmu.server.input("Player " + number + " action 1 true");
		}
		if (sgmu.server.actionTypes.get("p" + number + "a2") != "ANYTIME")
		{
			playerAction2.setSelected(false);
			Server.class.getDeclaredField("player" + number + "Action2").setBoolean(sgmu.server, true);
			sgmu.server.input("Player " + number + " action 2 true");
		}
		if (sgmu.server.actionTypes.get("p" + number + "a3") != "ANYTIME")
		{
			playerAction3.setSelected(false);
			Server.class.getDeclaredField("player" + number + "Action3").setBoolean(sgmu.server, true);
			sgmu.server.input("Player " + number + " action 3 true");
		}
		if (sgmu.server.actionTypes.get("p" + number + "a4") != "ANYTIME")
		{
			playerAction4.setSelected(false);
			Server.class.getDeclaredField("player" + number + "Action4").setBoolean(sgmu.server, true);
			sgmu.server.input("Player " + number + " action 4 true");
		}
		if (sgmu.server.actionTypes.get("p" + number + "a5") != "ANYTIME")
		{
			playerAction5.setSelected(false);
			Server.class.getDeclaredField("player" + number + "Action5").setBoolean(sgmu.server, true);
			sgmu.server.input("Player " + number + " action 5 true");
		}
		if (sgmu.server.actionTypes.get("p" + number + "a6") != "ANYTIME")
		{
			playerAction6.setSelected(false);
			Server.class.getDeclaredField("player" + number + "Action6").setBoolean(sgmu.server, true);
			sgmu.server.input("Player " + number + " action 6 true");
		}
		if (sgmu.server.actionTypes.get("p" + number + "a7") != "ANYTIME")
		{
			playerAction7.setSelected(false);
			Server.class.getDeclaredField("player" + number + "Action7").setBoolean(sgmu.server, true);
			sgmu.server.input("Player " + number + " action 7 true");
		}
		if (sgmu.server.actionTypes.get("p" + number + "a8") != "ANYTIME")
		{
			playerAction8.setSelected(false);
			Server.class.getDeclaredField("player" + number + "Action8").setBoolean(sgmu.server, true);
			sgmu.server.input("Player " + number + " action 8 true");
		}
	}
	
}
