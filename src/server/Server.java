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

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Server {
	
//	public ServerUI		gui;
	public ServerGMUI	gmui;
	
	public HashSet<Handler> handlers = new HashSet<Handler>();
	
	public HashSet<String> names = new HashSet<String>();
	
	public HashSet<PrintWriter> writers = new HashSet<PrintWriter>();
	
	// @formatter:off

	public Map<String, String> actionTypes = new HashMap<String, String>();
	{
		actionTypes.put("p1a1", "MOVE");
		actionTypes.put("p1a2", "ACTION");
		actionTypes.put("p1a3", "ANYTIME");
		actionTypes.put("p1a4", "ANYTIME");
		actionTypes.put("p1a5", "ANYTIME");
		actionTypes.put("p1a6", "ANYTIME");
		actionTypes.put("p1a7", "ANYTIME");
		actionTypes.put("p1a8", "ANYTIME");

		actionTypes.put("p2a1", "MOVE");
		actionTypes.put("p2a2", "ACTION");
		actionTypes.put("p2a3", "ANYTIME");
		actionTypes.put("p2a4", "ANYTIME");
		actionTypes.put("p2a5", "ANYTIME");
		actionTypes.put("p2a6", "ANYTIME");
		actionTypes.put("p2a7", "ANYTIME");
		actionTypes.put("p2a8", "ANYTIME");

		actionTypes.put("p3a1", "MOVE");
		actionTypes.put("p3a2", "ACTION");
		actionTypes.put("p3a3", "ANYTIME");
		actionTypes.put("p3a4", "ANYTIME");
		actionTypes.put("p3a5", "ANYTIME");
		actionTypes.put("p3a6", "ANYTIME");
		actionTypes.put("p3a7", "ANYTIME");
		actionTypes.put("p3a8", "ANYTIME");

		actionTypes.put("p4a1", "MOVE");
		actionTypes.put("p4a2", "ACTION");
		actionTypes.put("p4a3", "ANYTIME");
		actionTypes.put("p4a4", "ANYTIME");
		actionTypes.put("p4a5", "ANYTIME");
		actionTypes.put("p4a6", "ANYTIME");
		actionTypes.put("p4a7", "ANYTIME");
		actionTypes.put("p4a8", "ANYTIME");
	}

	public String gmImage = "";
	
	public boolean player1 = false;
	public String player1Image = "";
	public int player1Stam = 10, player1CStam = 10;
	public int player1Gold = 0;
	public boolean player1c1enabled = false;
	public int player1c1Stam = 10, player1c1CStam = 10;
	public boolean player1c2enabled = false;
	public int player1c2Stam = 10, player1c2CStam = 10;
	public boolean player1c3enabled = false;
	public int player1c3Stam = 10, player1c3CStam = 10;
	public boolean 
			player1Action1 = true, 
			player1Action2 = true, 
			player1Action3 = true,
			player1Action4 = true, 
			player1Action5 = true,
			player1Action6 = true,
			player1Action7 = true,
			player1Action8 = true,
			player1Action1e = true,
			player1Action2e = true,
			player1Action3e = true,
			player1Action4e = true,
			player1Action5e = true,
			player1Action6e = false,
			player1Action7e = false,
			player1Action8e = false;

	public boolean player2 = false;
	public String player2Image = "";
	public int player2Stam = 10, player2CStam = 10;
	public int player2Gold = 0;
	public boolean player2c1enabled = false;
	public int player2c1Stam = 10, player2c1CStam = 10;
	public boolean player2c2enabled = false;
	public int player2c2Stam = 10, player2c2CStam = 10;
	public boolean player2c3enabled = false;
	public int player2c3Stam = 10, player2c3CStam = 10;
	public boolean 
			player2Action1 = true, 
			player2Action2 = true, 
			player2Action3 = true,
			player2Action4 = true, 
			player2Action5 = true, 
			player2Action6 = true,
			player2Action7 = true, 
			player2Action8 = true,
			player2Action1e = true,
			player2Action2e = true,
			player2Action3e = true,
			player2Action4e = true,
			player2Action5e = true,
			player2Action6e = false,
			player2Action7e = false,
			player2Action8e = false;

	public boolean player3 = false;
	public String player3Image = "";
	public int player3Stam = 10, player3CStam = 10;
	public int player3Gold = 0;
	public boolean player3c1enabled = false;
	public int player3c1Stam = 10, player3c1CStam = 10;
	public boolean player3c2enabled = false;
	public int player3c2Stam = 10, player3c2CStam = 10;
	public boolean player3c3enabled = false;
	public int player3c3Stam = 10, player3c3CStam = 10;
	public boolean 
			player3Action1 = true, 
			player3Action2 = true, 
			player3Action3 = true,
			player3Action4 = true, 
			player3Action5 = true, 
			player3Action6 = true,
			player3Action7 = true, 
			player3Action8 = true,
			player3Action1e = true,
			player3Action2e = true,
			player3Action3e = true,
			player3Action4e = true,
			player3Action5e = true,
			player3Action6e = false,
			player3Action7e = false,
			player3Action8e = false;

	public boolean player4 = false;
	public String player4Image = "";
	public int player4Stam = 10, player4CStam = 10;
	public int player4Gold = 0;
	public boolean player4c1enabled = false;
	public int player4c1Stam = 10, player4c1CStam = 10;
	public boolean player4c2enabled = false;
	public int player4c2Stam = 10, player4c2CStam = 10;
	public boolean player4c3enabled = false;
	public int player4c3Stam = 10, player4c3CStam = 10;
	public boolean 
			player4Action1 = true, 
			player4Action2 = true, 
			player4Action3 = true,
			player4Action4 = true, 
			player4Action5 = true, 
			player4Action6 = true,
			player4Action7 = true, 
			player4Action8 = true,
			player4Action1e = true,
			player4Action2e = true,
			player4Action3e = true,
			player4Action4e = true,
			player4Action5e = true,
			player4Action6e = false,
			player4Action7e = false,
			player4Action8e = false;

	// @formatter:on
	
	// private static ServerUI ui = new ServerUI(); DEBUG BUILD UI
	
	public void main(int port)
	{
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		try
		{
			serverSocket = new ServerSocket(port);
		} catch (IOException e)
		{
			JOptionPane.showMessageDialog(new JFrame(), "Couldn't bind port " + port + "\nCheck if another application is using it and try again",
					"Error", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
			// ui.log("Couldn't bind port " + port + ".");
			// ui.log("Check if another application is using it and try again.");
			return;
		}
		
		gmui = new ServerGMUI(this);
		
		// ui.log("Successfully created URealms Manager server.");
		
		while (true)
		{
			try
			{
				socket = serverSocket.accept();
			} catch (IOException e)
			{
				JOptionPane.showMessageDialog(new JFrame(), "I/O error: " + e, "Error", JOptionPane.ERROR_MESSAGE);
				System.exit(1);
				// ui.log("I/O error: " + e);
				break;
			}
			new Handler(this, socket).start();
		}
		
		try
		{
			socket.close();
			serverSocket.close();
		} catch (IOException e)
		{
			
		}
		
	}
	
	public void stamcheck()
	{
		if (player1CStam > player1Stam)
		{
			player1CStam = player1Stam;
		}
		
		if (player2CStam > player2Stam)
		{
			player2CStam = player2Stam;
		}
		
		if (player3CStam > player3Stam)
		{
			player3CStam = player3Stam;
		}
		
		if (player4CStam > player4Stam)
		{
			player4CStam = player4Stam;
		}
		
		if (player1CStam < 0)
		{
			player1CStam = 0;
		}
		
		if (player2CStam < 0)
		{
			player2CStam = 0;
		}
		
		if (player3CStam < 0)
		{
			player3CStam = 0;
		}
		
		if (player4CStam < 0)
		{
			player4CStam = 0;
		}
		
		// Companions
		
		if (player1c1CStam > player1c1Stam)
		{
			player1c1CStam = player1c1Stam;
		}
		
		if (player1c1CStam < 0)
		{
			player1c1CStam = 0;
		}
		
		if (player1c2CStam > player1c2Stam)
		{
			player1c2CStam = player1c2Stam;
		}
		
		if (player1c2CStam < 0)
		{
			player1c2CStam = 0;
		}
		
		if (player1c3CStam > player1c3Stam)
		{
			player1c3CStam = player1c3Stam;
		}
		
		if (player1c3CStam < 0)
		{
			player1c3CStam = 0;
		}
		
		// -------------------------------------------------
		
		if (player2c1CStam > player2c1Stam)
		{
			player2c1CStam = player2c1Stam;
		}
		
		if (player2c1CStam < 0)
		{
			player2c1CStam = 0;
		}
		
		if (player2c2CStam > player2c2Stam)
		{
			player2c2CStam = player2c2Stam;
		}
		
		if (player2c2CStam < 0)
		{
			player2c2CStam = 0;
		}
		
		if (player2c3CStam > player2c3Stam)
		{
			player2c3CStam = player2c3Stam;
		}
		
		if (player2c3CStam < 0)
		{
			player2c3CStam = 0;
		}
		
		// -------------------------------------------------
		
		if (player3c1CStam > player3c1Stam)
		{
			player3c1CStam = player3c1Stam;
		}
		
		if (player3c1CStam < 0)
		{
			player3c1CStam = 0;
		}
		
		if (player3c2CStam > player3c2Stam)
		{
			player3c2CStam = player3c2Stam;
		}
		
		if (player3c2CStam < 0)
		{
			player3c2CStam = 0;
		}
		
		if (player3c3CStam > player3c3Stam)
		{
			player3c3CStam = player3c3Stam;
		}
		
		if (player3c3CStam < 0)
		{
			player3c3CStam = 0;
		}
		
		// -------------------------------------------------
		
		if (player4c1CStam > player4c1Stam)
		{
			player4c1CStam = player4c1Stam;
		}
		
		if (player4c1CStam < 0)
		{
			player4c1CStam = 0;
		}
		
		if (player4c2CStam > player4c2Stam)
		{
			player4c2CStam = player4c2Stam;
		}
		
		if (player4c2CStam < 0)
		{
			player4c2CStam = 0;
		}
		
		if (player4c3CStam > player4c3Stam)
		{
			player4c3CStam = player4c3Stam;
		}
		
		if (player4c3CStam < 0)
		{
			player4c3CStam = 0;
		}
	}
	
	public void input(String s)
	{
		for (PrintWriter out : writers)
		{
			out.println(s);
		}
		
		stamcheck();
		
		gmui.g1.playerStam.setText(player1CStam + "/" + player1Stam);
		gmui.g1.playerGold.setText("" + player1Gold + "");
		if (gmui.g1.c == 1)
			gmui.g1.playercStam.setText(player1c1CStam + "/" + player1c1Stam);
		else if (gmui.g1.c == 2)
			gmui.g1.playercStam.setText(player1c2CStam + "/" + player1c2Stam);
		else if (gmui.g1.c == 3)
			gmui.g1.playercStam.setText(player1c3CStam + "/" + player1c3Stam);
		
		gmui.g2.playerStam.setText(player2CStam + "/" + player2Stam);
		gmui.g2.playerGold.setText("" + player2Gold + "");
		if (gmui.g2.c == 1)
			gmui.g2.playercStam.setText(player2c1CStam + "/" + player2c1Stam);
		else if (gmui.g2.c == 2)
			gmui.g2.playercStam.setText(player2c2CStam + "/" + player2c2Stam);
		else if (gmui.g2.c == 3)
			gmui.g2.playercStam.setText(player2c3CStam + "/" + player2c3Stam);
		
		gmui.g3.playerStam.setText(player3CStam + "/" + player3Stam);
		gmui.g3.playerGold.setText("" + player3Gold + "");
		if (gmui.g3.c == 1)
			gmui.g3.playercStam.setText(player3c1CStam + "/" + player3c1Stam);
		else if (gmui.g3.c == 2)
			gmui.g3.playercStam.setText(player3c2CStam + "/" + player3c2Stam);
		else if (gmui.g3.c == 3)
			gmui.g3.playercStam.setText(player3c3CStam + "/" + player3c3Stam);
		
		gmui.g4.playerStam.setText(player4CStam + "/" + player4Stam);
		gmui.g4.playerGold.setText("" + player4Gold + "");
		if (gmui.g4.c == 1)
			gmui.g4.playercStam.setText(player4c1CStam + "/" + player4c1Stam);
		else if (gmui.g4.c == 2)
			gmui.g4.playercStam.setText(player4c2CStam + "/" + player4c2Stam);
		else if (gmui.g4.c == 3)
			gmui.g4.playercStam.setText(player4c3CStam + "/" + player4c3Stam);
	}
	
	// public void log(String s)
	// {
	// ui.log(s);
	// }
}
