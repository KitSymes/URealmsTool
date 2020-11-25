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
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import client.ClientUI;

// TODO 		

public class ServerGMUI {
	
	public Server		server;
	private ServerGMUI	sgmui	= this;
	
	private JFrame	frame;
	JFrame			optionsFrame;
	private JPanel	contentPane;
	public Timer	timer	= new Timer();
	
	private JLabel	halllbl;
	private JButton	hall1, hall3, hall5;
	
	private JLabel	dalllbl;
	private JButton	dall1, dall3, dall5;
	
	private int XOne = 10, XTwo = 420, YOne = 130, YTwo = 500;
	
	public GMAP g1, g2, g3, g4;
	
	public ServerGMUI(Server server)
	{
		this.server = server;
		EventQueue.invokeLater(new Runnable() {
			public void run()
			{
				initUI();
			}
		});
	}
	
	private void initUI()
	{
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 775, 820);
		frame.setLocation(
				(GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth() / 2) - (frame.getWidth() / 2),
				(GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight() / 2)
						- (frame.getHeight() / 2));
		frame.setResizable(false);
		frame.setTitle("Char's Stamina Tracker");
		frame.setIconImage(new ImageIcon(ClientUI.class.getResource("/resources/UI/anytime.png")).getImage());
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JButton settingsTab = new JButton("Settings");
		settingsTab.setForeground(Color.BLACK);
		settingsTab.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				if (optionsFrame == null)
				{
					optionsFrame = new JFrame();
					optionsFrame.setSize(500, 600);
					optionsFrame.setResizable(false);
					optionsFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
					
					JTabbedPane jtp = new JTabbedPane();
					optionsFrame.setContentPane(jtp);
					
					JPanel p1 = new JPanel();
					JPanel p2 = new JPanel();
					JPanel p3 = new JPanel();
					JPanel p4 = new JPanel();
					JPanel p0 = new JPanel();
					
					try
					{
						new Options(sgmui).decorate(p1, 1);
						new Options(sgmui).decorate(p2, 2);
						new Options(sgmui).decorate(p3, 3);
						new Options(sgmui).decorate(p4, 4);
					} catch (Exception e)
					{
						JOptionPane.showMessageDialog(new JFrame(), "An internal error has occurred (S-6f7074696f6e73)", "Error", JOptionPane.ERROR_MESSAGE);
						System.exit(1);
					}
					
					p0.setLayout(null);
					final JLabel gmImage = new JLabel();
					gmImage.setBounds((244 - 65), 55, 130, 130);
					p0.add(gmImage);
					JLabel gmImagelbl = new JLabel("GM Image Link", SwingConstants.CENTER);
					gmImagelbl.setBounds((244 - 100), 183, 200, 20);
					p0.add(gmImagelbl);
					final JTextField gmLink = new JTextField();
					gmLink.setColumns(1);
					gmLink.setBounds((244 - 100), 202, 200, 20);
					p0.add(gmLink);
					gmLink.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent arg0)
						{
							try
							{
								gmImage.setIcon(new ImageIcon(ImageIO.read(new URL(gmLink.getText())).getScaledInstance(gmImage.getWidth(),
										gmImage.getHeight(), Image.SCALE_SMOOTH)));
								Server.class.getDeclaredField("gmImage").set(server, gmLink.getText());
								server.input("gmimage " + gmLink.getText());
							} catch (IOException | IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
							{
								JOptionPane.showMessageDialog(new JFrame(), "Image is invalid", "Error", JOptionPane.ERROR_MESSAGE);
							}
						}
					});
					
					jtp.addTab("Player 1", p1);
					jtp.addTab("Player 2", p2);
					jtp.addTab("Player 3", p3);
					jtp.addTab("Player 4", p4);
					jtp.addTab("Miscellaneous", p0);
					
					optionsFrame.setVisible(true);
					optionsFrame.repaint();
				} else
					optionsFrame.setVisible(true);
			}
		});
		menuBar.add(settingsTab);
		
		/*
		 * BODY
		 */
		
		final JToggleButton p1 = new JToggleButton("");
		p1.setSelectedIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/EnablePlayers/P1E.png")));
		p1.setIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/EnablePlayers/P1D.png")));
		p1.setContentAreaFilled(false);
		p1.setBorderPainted(false);
		p1.setBounds(10, 10, 30, 30);
		p1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				if (p1.isSelected())
				{
					server.input("Player 1 enable");
					server.player1 = true;
				} else
				{
					server.input("Player 1 disable");
					server.player1 = false;
				}
			}
		});
		
		final JToggleButton p2 = new JToggleButton("");
		p2.setSelectedIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/EnablePlayers/P2E.png")));
		p2.setIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/EnablePlayers/P2D.png")));
		p2.setContentAreaFilled(false);
		p2.setBorderPainted(false);
		p2.setBounds(50, 10, 30, 30);
		p2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				if (p2.isSelected())
				{
					server.input("Player 2 enable");
					server.player2 = true;
				} else
				{
					server.input("Player 2 disable");
					server.player2 = false;
				}
			}
		});
		
		final JToggleButton p3 = new JToggleButton("");
		p3.setSelectedIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/EnablePlayers/P3E.png")));
		p3.setIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/EnablePlayers/P3D.png")));
		p3.setContentAreaFilled(false);
		p3.setBorderPainted(false);
		p3.setBounds(90, 10, 30, 30);
		p3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				if (p3.isSelected())
				{
					server.input("Player 3 enable");
					server.player3 = true;
				} else
				{
					server.input("Player 3 disable");
					server.player3 = false;
				}
			}
		});
		
		final JToggleButton p4 = new JToggleButton("");
		p4.setSelectedIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/EnablePlayers/P4E.png")));
		p4.setIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/EnablePlayers/P4D.png")));
		p4.setContentAreaFilled(false);
		p4.setBorderPainted(false);
		p4.setBounds(130, 10, 30, 30);
		p4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				if (p4.isSelected())
				{
					server.input("Player 4 enable");
					server.player4 = true;
				} else
				{
					server.input("Player 4 disable");
					server.player4 = false;
				}
			}
		});
		
		JLabel lblEP = new JLabel("Enable Players");
		lblEP.setHorizontalAlignment(SwingConstants.CENTER);
		lblEP.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
		lblEP.setBounds(10, 45, 100, 30);
		
		JButton ha = new JButton("Heal All");
		ha.setFont(new Font("Arial Unicode MS", Font.PLAIN, 11));
		ha.setBounds(180, 10, 100, 30);
		ha.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent paramActionEvent)
			{
				server.player1CStam = server.player1Stam;
				server.player2CStam = server.player2Stam;
				server.player3CStam = server.player3Stam;
				server.player4CStam = server.player4Stam;
				server.input("HealAll");
			}
		});
		
		JButton nr = new JButton("New Round");
		nr.setFont(new Font("Arial Unicode MS", Font.PLAIN, 11));
		nr.setBounds(180, 40, 100, 32);
		nr.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					g1.newround();
					g2.newround();
					g3.newround();
					g4.newround();
				} catch (Exception e)
				{
					JOptionPane.showMessageDialog(new JFrame(), "An internal error has occurred (S-6e6577726f756e64)", "Error",
							JOptionPane.ERROR_MESSAGE);
					System.exit(1);
				}
			}
		});
		
		halllbl = new JLabel("Heal All For");
		halllbl.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		halllbl.setHorizontalAlignment(SwingConstants.CENTER);
		halllbl.setBounds(290, 5, 100, 30);
		
		dalllbl = new JLabel("Damage All For");
		dalllbl.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		dalllbl.setHorizontalAlignment(SwingConstants.CENTER);
		dalllbl.setBounds(290, 40, 100, 30);
		
		hall1 = new JButton("");
		hall1.setIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/Stamina/1+.jpg")));
		hall1.setPressedIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/Stamina/1+p.jpg")));
		hall1.setContentAreaFilled(false);
		hall1.setBorderPainted(false);
		hall1.setBounds(400, 10, 40, 20);
		hall1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				hall1.setSelected(true);
				timer.schedule(new TimerTask() {
					
					@Override
					public void run()
					{
						hall1.setSelected(false);
					}
				}, 100L);
				
				server.player1CStam = server.player1CStam + 1;
				server.player1c1CStam = server.player1c1CStam + 1;
				server.player1c2CStam = server.player1c2CStam + 1;
				server.player1c3CStam = server.player1c3CStam + 1;
				
				server.player2CStam = server.player2CStam + 1;
				server.player2c1CStam = server.player2c1CStam + 1;
				server.player2c2CStam = server.player2c2CStam + 1;
				server.player2c3CStam = server.player2c3CStam + 1;
				
				server.player3CStam = server.player3CStam + 1;
				server.player3c1CStam = server.player3c1CStam + 1;
				server.player3c2CStam = server.player3c2CStam + 1;
				server.player3c3CStam = server.player3c3CStam + 1;
				
				server.player4CStam = server.player4CStam + 1;
				server.player4c1CStam = server.player4c1CStam + 1;
				server.player4c2CStam = server.player4c2CStam + 1;
				server.player4c3CStam = server.player4c3CStam + 1;
				
				server.input("Player 1 damage 1");
				server.input("Companion 1 1 damage 1");
				server.input("Companion 1 2 damage 1");
				server.input("Companion 1 3 damage 1");
				server.input("Player 2 damage 1");
				server.input("Companion 2 1 damage 1");
				server.input("Companion 2 2 damage 1");
				server.input("Companion 2 3 damage 1");
				server.input("Player 3 damage 1");
				server.input("Companion 3 1 damage 1");
				server.input("Companion 3 2 damage 1");
				server.input("Companion 3 3 damage 1");
				server.input("Player 4 damage 1");
				server.input("Companion 4 1 damage 1");
				server.input("Companion 4 2 damage 1");
				server.input("Companion 4 3 damage 1");
			}
		});
		
		hall3 = new JButton("");
		hall3.setIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/Stamina/5+.jpg")));
		hall3.setPressedIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/Stamina/5+p.jpg")));
		hall3.setContentAreaFilled(false);
		hall3.setBorderPainted(false);
		hall3.setBounds(440, 10, 40, 20);
		hall3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				hall3.setSelected(true);
				timer.schedule(new TimerTask() {
					
					@Override
					public void run()
					{
						hall3.setSelected(false);
					}
				}, 100L);
				
				server.player1CStam = server.player1CStam + 5;
				server.player1c1CStam = server.player1c1CStam + 5;
				server.player1c2CStam = server.player1c2CStam + 5;
				server.player1c3CStam = server.player1c3CStam + 5;
				
				server.player2CStam = server.player2CStam + 5;
				server.player2c1CStam = server.player2c1CStam + 5;
				server.player2c2CStam = server.player2c2CStam + 5;
				server.player2c3CStam = server.player2c3CStam + 5;
				
				server.player3CStam = server.player3CStam + 5;
				server.player3c1CStam = server.player3c1CStam + 5;
				server.player3c2CStam = server.player3c2CStam + 5;
				server.player3c3CStam = server.player3c3CStam + 5;
				
				server.player4CStam = server.player4CStam + 5;
				server.player4c1CStam = server.player4c1CStam + 5;
				server.player4c2CStam = server.player4c2CStam + 5;
				server.player4c3CStam = server.player4c3CStam + 5;
				
				server.input("Player 1 damage 5");
				server.input("Companion 1 1 damage 5");
				server.input("Companion 1 2 damage 5");
				server.input("Companion 1 3 damage 5");
				server.input("Player 2 damage 5");
				server.input("Companion 2 1 damage 5");
				server.input("Companion 2 2 damage 5");
				server.input("Companion 2 3 damage 5");
				server.input("Player 3 damage 5");
				server.input("Companion 3 1 damage 5");
				server.input("Companion 3 2 damage 5");
				server.input("Companion 3 3 damage 5");
				server.input("Player 4 damage 5");
				server.input("Companion 4 1 damage 5");
				server.input("Companion 4 2 damage 5");
				server.input("Companion 4 3 damage 5");
			}
		});
		
		hall5 = new JButton("");
		hall5.setIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/Stamina/10+.jpg")));
		hall5.setPressedIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/Stamina/10+p.jpg")));
		hall5.setContentAreaFilled(false);
		hall5.setBorderPainted(false);
		hall5.setBounds(480, 10, 40, 20);
		hall5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				hall5.setSelected(true);
				timer.schedule(new TimerTask() {
					
					@Override
					public void run()
					{
						hall5.setSelected(false);
					}
				}, 100L);
				
				server.player1CStam = server.player1CStam + 10;
				server.player1c1CStam = server.player1c1CStam + 10;
				server.player1c2CStam = server.player1c2CStam + 10;
				server.player1c3CStam = server.player1c3CStam + 10;
				
				server.player2CStam = server.player2CStam + 10;
				server.player2c1CStam = server.player2c1CStam + 10;
				server.player2c2CStam = server.player2c2CStam + 10;
				server.player2c3CStam = server.player2c3CStam + 10;
				
				server.player3CStam = server.player3CStam + 10;
				server.player3c1CStam = server.player3c1CStam + 10;
				server.player3c2CStam = server.player3c2CStam + 10;
				server.player3c3CStam = server.player3c3CStam + 10;
				
				server.player4CStam = server.player4CStam + 10;
				server.player4c1CStam = server.player4c1CStam + 10;
				server.player4c2CStam = server.player4c2CStam + 10;
				server.player4c3CStam = server.player4c3CStam + 10;
				
				server.input("Player 1 damage 10");
				server.input("Companion 1 1 damage 10");
				server.input("Companion 1 2 damage 10");
				server.input("Companion 1 3 damage 10");
				server.input("Player 2 damage 10");
				server.input("Companion 2 1 damage 10");
				server.input("Companion 2 2 damage 10");
				server.input("Companion 2 3 damage 10");
				server.input("Player 3 damage 10");
				server.input("Companion 3 1 damage 10");
				server.input("Companion 3 2 damage 10");
				server.input("Companion 3 3 damage 10");
				server.input("Player 4 damage 10");
				server.input("Companion 4 1 damage 10");
				server.input("Companion 4 2 damage 10");
				server.input("Companion 4 3 damage 10");
			}
		});
		
		dall1 = new JButton("");
		dall1.setIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/Stamina/1-.jpg")));
		dall1.setPressedIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/Stamina/1-p.jpg")));
		dall1.setContentAreaFilled(false);
		dall1.setBorderPainted(false);
		dall1.setBounds(400, 45, 40, 20);
		dall1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				dall1.setSelected(true);
				timer.schedule(new TimerTask() {
					
					@Override
					public void run()
					{
						dall1.setSelected(false);
					}
				}, 100L);
				
				server.player1CStam = server.player1CStam - 1;
				server.player1c1CStam = server.player1c1CStam - 1;
				server.player1c2CStam = server.player1c2CStam - 1;
				server.player1c3CStam = server.player1c3CStam - 1;
				server.player2CStam = server.player2CStam - 1;
				server.player2c1CStam = server.player2c1CStam - 1;
				server.player2c2CStam = server.player2c2CStam - 1;
				server.player2c3CStam = server.player2c3CStam - 1;
				server.player3CStam = server.player3CStam - 1;
				server.player3c1CStam = server.player3c1CStam - 1;
				server.player3c2CStam = server.player3c2CStam - 1;
				server.player3c3CStam = server.player3c3CStam - 1;
				server.player4CStam = server.player4CStam - 1;
				server.player4c1CStam = server.player4c1CStam - 1;
				server.player4c2CStam = server.player4c2CStam - 1;
				server.player4c3CStam = server.player4c3CStam - 1;
				
				server.input("Player 1 damage -1");
				server.input("Companion 1 1 damage -1");
				server.input("Companion 1 2 damage -1");
				server.input("Companion 1 3 damage -1");
				server.input("Player 2 damage -1");
				server.input("Companion 2 1 damage -1");
				server.input("Companion 2 2 damage -1");
				server.input("Companion 2 3 damage -1");
				server.input("Player 3 damage -1");
				server.input("Companion 3 1 damage -1");
				server.input("Companion 3 2 damage -1");
				server.input("Companion 3 3 damage -1");
				server.input("Player 4 damage -1");
				server.input("Companion 4 1 damage -1");
				server.input("Companion 4 2 damage -1");
				server.input("Companion 4 3 damage -1");
			}
		});
		
		dall3 = new JButton("");
		dall3.setIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/Stamina/5-.jpg")));
		dall3.setPressedIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/Stamina/5-p.jpg")));
		dall3.setContentAreaFilled(false);
		dall3.setBorderPainted(false);
		dall3.setBounds(440, 45, 40, 20);
		dall3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				dall3.setSelected(true);
				timer.schedule(new TimerTask() {
					
					@Override
					public void run()
					{
						dall3.setSelected(false);
					}
				}, 100L);
				
				server.player1CStam = server.player1CStam - 5;
				server.player1c1CStam = server.player1c1CStam - 5;
				server.player1c2CStam = server.player1c2CStam - 5;
				server.player1c3CStam = server.player1c3CStam - 5;
				server.player2CStam = server.player2CStam - 5;
				server.player2c1CStam = server.player2c1CStam - 5;
				server.player2c2CStam = server.player2c2CStam - 5;
				server.player2c3CStam = server.player2c3CStam - 5;
				server.player3CStam = server.player3CStam - 5;
				server.player3c1CStam = server.player3c1CStam - 5;
				server.player3c2CStam = server.player3c2CStam - 5;
				server.player3c3CStam = server.player3c3CStam - 5;
				server.player4CStam = server.player4CStam - 5;
				server.player4c1CStam = server.player4c1CStam - 5;
				server.player4c2CStam = server.player4c2CStam - 5;
				server.player4c3CStam = server.player4c3CStam - 5;
				
				server.input("Player 1 damage -5");
				server.input("Companion 1 1 damage -5");
				server.input("Companion 1 2 damage -5");
				server.input("Companion 1 3 damage -5");
				server.input("Player 2 damage -5");
				server.input("Companion 2 1 damage -5");
				server.input("Companion 2 2 damage -5");
				server.input("Companion 2 3 damage -5");
				server.input("Player 3 damage -5");
				server.input("Companion 3 1 damage -5");
				server.input("Companion 3 2 damage -5");
				server.input("Companion 3 3 damage -5");
				server.input("Player 4 damage -5");
				server.input("Companion 4 1 damage -5");
				server.input("Companion 4 2 damage -5");
				server.input("Companion 4 3 damage -5");
			}
		});
		
		dall5 = new JButton("");
		dall5.setIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/Stamina/10-.jpg")));
		dall5.setPressedIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/Stamina/10-p.jpg")));
		dall5.setContentAreaFilled(false);
		dall5.setBorderPainted(false);
		dall5.setBounds(480, 45, 40, 20);
		dall5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				dall5.setSelected(true);
				timer.schedule(new TimerTask() {
					
					@Override
					public void run()
					{
						dall5.setSelected(false);
					}
				}, 100L);
				
				server.player1CStam = server.player1CStam - 10;
				server.player1c1CStam = server.player1c1CStam - 10;
				server.player1c2CStam = server.player1c2CStam - 10;
				server.player1c3CStam = server.player1c3CStam - 10;
				server.player2CStam = server.player2CStam - 10;
				server.player2c1CStam = server.player2c1CStam - 10;
				server.player2c2CStam = server.player2c2CStam - 10;
				server.player2c3CStam = server.player2c3CStam - 10;
				server.player3CStam = server.player3CStam - 10;
				server.player3c1CStam = server.player3c1CStam - 10;
				server.player3c2CStam = server.player3c2CStam - 10;
				server.player3c3CStam = server.player3c3CStam - 10;
				server.player4CStam = server.player4CStam - 10;
				server.player4c1CStam = server.player4c1CStam - 10;
				server.player4c2CStam = server.player4c2CStam - 10;
				server.player4c3CStam = server.player4c3CStam - 10;
				
				server.input("Player 1 damage -10");
				server.input("Companion 1 1 damage -10");
				server.input("Companion 1 2 damage -10");
				server.input("Companion 1 3 damage -10");
				server.input("Player 2 damage -10");
				server.input("Companion 2 1 damage -10");
				server.input("Companion 2 2 damage -10");
				server.input("Companion 2 3 damage -10");
				server.input("Player 3 damage -10");
				server.input("Companion 3 1 damage -10");
				server.input("Companion 3 2 damage -10");
				server.input("Companion 3 3 damage -10");
				server.input("Player 4 damage -10");
				server.input("Companion 4 1 damage -10");
				server.input("Companion 4 2 damage -10");
				server.input("Companion 4 3 damage -10");
			}
		});
		
		g1 = new GMAP();
		g1.add(this, contentPane, 1, XOne, YOne);
		
		g2 = new GMAP();
		g2.add(this, contentPane, 2, XTwo, YOne);
		
		g3 = new GMAP();
		g3.add(this, contentPane, 3, XOne, YTwo);
		
		g4 = new GMAP();
		g4.add(this, contentPane, 4, XTwo, YTwo);
		
		contentPane.add(lblEP);
		contentPane.add(p1);
		contentPane.add(p2);
		contentPane.add(p3);
		contentPane.add(p4);
		contentPane.add(ha);
		contentPane.add(nr);
		contentPane.add(halllbl);
		contentPane.add(dalllbl);
		contentPane.add(hall1);
		contentPane.add(hall3);
		contentPane.add(hall5);
		contentPane.add(dall1);
		contentPane.add(dall3);
		contentPane.add(dall5);
		
		frame.setVisible(true);
		
		JLabel background = new JLabel();
		background.setBounds(0, 0, contentPane.getWidth(), contentPane.getHeight());
		background.setIcon(new ImageIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/GMUIBackground.jpg")).getImage()
				.getScaledInstance(background.getWidth(), background.getHeight(), Image.SCALE_SMOOTH)));
		contentPane.add(background);
	}
	
}
