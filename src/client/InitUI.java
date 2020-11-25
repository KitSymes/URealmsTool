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
import java.awt.EventQueue;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import server.Server;

public class InitUI {
	
	Server	server	= null;
	Client	client	= null;
	
	public JFrame	frame;
	private JPanel	contentPane;
	private JButton	serverbtn, clientbtn;
	JLabel			background;
	
	private Timer				timer	= new Timer();
	private JTextField			ipField, portField;
	private JComboBox<Integer>	screens;
	private JButton				connect;
	
	public static void main(String[] args)
	{
		new InitUI();
	}
	
	public InitUI()
	{
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
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(InitUI.class.getResource("/resources/UI/action.png")));
		frame.setTitle("Char's Stamina Tracker");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(500, 200);
		frame.setBounds(100, 100, 587, 434);
		frame.getContentPane().setLayout(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(0, 0, 583, 406);
		contentPane.setLayout(null);
		frame.setContentPane(contentPane);
		
		clientbtn = new JButton("");
		clientbtn.setIcon(new ImageIcon(InitUI.class.getResource("/resources/Client/Client.png")));
		clientbtn.setSelectedIcon(new ImageIcon(InitUI.class.getResource("/resources/Client/ClientP.png")));
		clientbtn.setContentAreaFilled(false);
		clientbtn.setBorder(null);
		clientbtn.setBorderPainted(false);
		clientbtn.setBackground(Color.WHITE);
		clientbtn.setBounds(430, 305, 100, 49);
		contentPane.add(clientbtn);
		clientbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				clientbtn.setSelected(true);
				timer.schedule(new TimerTask() {
					
					@Override
					public void run()
					{
						clientbtn.setSelected(false);
						
						client();
					}
				}, 100L);
			}
		});
		
		serverbtn = new JButton("");
		serverbtn.setIcon(new ImageIcon(InitUI.class.getResource("/resources/Client/Server.png")));
		serverbtn.setSelectedIcon(new ImageIcon(InitUI.class.getResource("/resources/Client/ServerP.png")));
		serverbtn.setContentAreaFilled(false);
		serverbtn.setBorder(null);
		serverbtn.setBorderPainted(false);
		serverbtn.setBackground(Color.WHITE);
		serverbtn.setBounds(50, 305, 100, 49);
		contentPane.add(serverbtn);
		serverbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				serverbtn.setSelected(true);
				timer.schedule(new TimerTask() {
					
					@Override
					public void run()
					{
						serverbtn.setSelected(false);
						
						frame.setVisible(false);
						frame.dispose();
						
						server = new Server();
						server.main(9002);
					}
				}, 100L);
			}
		});
		
		background = new JLabel("");
		background.setIcon(new ImageIcon(new ImageIcon(InitUI.class.getResource("/resources/Client/background.png")).getImage().getScaledInstance(583,
				406, Image.SCALE_SMOOTH)));
		background.setBounds(0, 0, 583, 406);
		contentPane.add(background);
		
		frame.setVisible(true);
		
		// new Thread(new Runnable() {
		//
		// @Override
		// public void run()
		// {
		// HttpURLConnection con;
		// try
		// {
		// URL url = new URL("https://api.github.com/repos/Charzard4261/URealmsUI");
		// con = (HttpURLConnection) url.openConnection();
		// con.setRequestMethod("GET");
		// con.setRequestProperty("content-type", "application/json");
		// con.setRequestProperty("Accept", "application/vnd.github.v3+json");
		// con.connect();
		// BufferedReader in = new BufferedReader(new
		// InputStreamReader(con.getInputStream()));
		// String inputLine;
		// StringBuffer content = new StringBuffer();
		// while ((inputLine = in.readLine()) != null)
		// {
		// content.append(inputLine);
		// }
		// in.close();
		// con.disconnect();
		// System.out.print(content);
		// } catch (IOException e)
		// {
		// e.printStackTrace();
		// }
		// }
		// }).start();
	}
	
	public void client()
	{
		contentPane.removeAll();
		
		ipField = new JTextField();
		ipField.setBounds(250, 280, 100, 20);
		ipField.setText("127.0.0.1");
		ipField.setBorder(null);
		contentPane.add(ipField);
		
		portField = new JTextField();
		portField.setBounds(250, 300, 100, 20);
		portField.setColumns(13);
		portField.setText("9002");
		portField.setBorder(null);
		contentPane.add(portField);
		
		Integer[] screenList = new Integer[GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices().length];
		ArrayList<Integer> screenNumber = new ArrayList<Integer>();
		for (int i = 1; i <= GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices().length; i++)
		{
			screenNumber.add(i);
		}
		screenList = screenNumber.toArray(screenList);
		
		screens = new JComboBox<Integer>(screenList);
		screens.setBounds(290, 330, 20, 20);
		((JLabel) screens.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(screens);
		
		connect = new JButton("Connect");
		connect.setBounds(250, 360, 100, 20);
		contentPane.add(connect);
		connect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				
				connect();
				
			}
			
		});
		
		contentPane.add(background);
		
		contentPane.repaint();
		
	}
	
	public void connect()
	{
		
		new Timer().schedule(new TimerTask() {
			
			@Override
			public void run()
			{
				frame.setVisible(false);
				frame.dispose();
				String ip = "127.0.0.1";
				int port = 9002;
				
				if (ipField.getText() != null)
				{
					
					String[] t = ipField.getText().split("\\.");
					
					if (t.length == 4)
					{
						boolean f = false;
						try
						{
							@SuppressWarnings("unused")
							int i = Integer.valueOf(t[0]);
							i = Integer.valueOf(t[1]);
							i = Integer.valueOf(t[2]);
							i = Integer.valueOf(t[3]);
							f = true;
						} catch (NumberFormatException e)
						{
							JOptionPane.showMessageDialog(new JFrame(), "Couldn't read IP address\nIP should only contain numbers", "Error",
									JOptionPane.ERROR_MESSAGE);
							System.exit(1);
						}
						
						if (f)
						{
							ip = ipField.getText();
						}
						
					}
				}
				
				if (portField.getText() != null)
				{
					try
					{
						port = Integer.valueOf(portField.getText());
					} catch (Exception e)
					{
						port = 9002;
					}
					
				}
				client = new Client();
				client.main(ip, port, (int) screens.getSelectedItem());
				
			}
		}, 100);
		
	}
}
