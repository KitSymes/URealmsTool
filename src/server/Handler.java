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

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;

public class Handler extends Thread {
	
	private Server		server;
	protected Socket	socket;
	
	public Handler(Server server, Socket clientSocket)
	{
		this.server = server;
		this.socket = clientSocket;
	}
	
	public void run()
	{
		InputStream inp = null;
		BufferedReader brinp = null;
		DataOutputStream out = null;
		try
		{
			inp = socket.getInputStream();
			brinp = new BufferedReader(new InputStreamReader(inp));
			out = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e)
		{
			return;
		}
		
		// String ip = socket.getRemoteSocketAddress().toString();
		
		final PrintWriter pr = new PrintWriter(out, true);
		server.writers.add(pr);
		// server.log(ip + " has connected.");
		pr.println("StartUI");
		new Timer().schedule(new TimerTask() {
			
			@Override
			public void run()
			{
				if (!server.gmImage.equals(""))
					pr.println("gmimage " + server.gmImage);
				
				if (server.player1)
					pr.println("Player 1 enable");
				if (!server.player1Image.equals(""))
					pr.println("Player 1 image " + server.player1Image);
				pr.println("Player 1 maxstamina " + server.player1Stam);
				pr.println("Player 1 stamina " + server.player1CStam);
				pr.println("Player 1 gold " + server.player1Gold);
				pr.println("Player 1 action 1 " + server.player1Action1);
				pr.println("Player 1 action 2 " + server.player1Action2);
				pr.println("Player 1 action 3 " + server.player1Action3);
				pr.println("Player 1 action 4 " + server.player1Action4);
				pr.println("Player 1 action 5 " + server.player1Action5);
				pr.println("Player 1 action 6 " + server.player1Action6);
				pr.println("Player 1 action 7 " + server.player1Action7);
				pr.println("Player 1 action 8 " + server.player1Action8);
				pr.println("Player 1 actionenable 1 " + server.player1Action1e);
				pr.println("Player 1 actionenable 2 " + server.player1Action2e);
				pr.println("Player 1 actionenable 3 " + server.player1Action3e);
				pr.println("Player 1 actionenable 4 " + server.player1Action4e);
				pr.println("Player 1 actionenable 5 " + server.player1Action5e);
				pr.println("Player 1 actionenable 6 " + server.player1Action6e);
				pr.println("Player 1 actionenable 7 " + server.player1Action7e);
				pr.println("Player 1 actionenable 8 " + server.player1Action8e);
				for (int i = 1; i <= 8; i++)
				{
					pr.println("Player 1 actiontype " + i + " " + server.actionTypes.get("p1a" + i));
				}
				
				if (server.player1c1enabled)
					pr.println("Companion 1 1 enable");
				pr.println("Companion 1 1 maxstamina " + server.player1c1Stam);
				pr.println("Companion 1 1 stamina " + server.player1c1CStam);
				
				if (server.player1c2enabled)
					pr.println("Companion 1 2 enable");
				pr.println("Companion 1 2 maxstamina " + server.player1c2Stam);
				pr.println("Companion 1 2 stamina " + server.player1c2CStam);
				
				if (server.player1c3enabled)
					pr.println("Companion 1 3 enable");
				pr.println("Companion 1 3 maxstamina " + server.player1c3Stam);
				pr.println("Companion 1 3 stamina " + server.player1c3CStam);
				
				// ----
				
				if (server.player2)
					pr.println("Player 2 enable");
				if (!server.player2Image.equals(""))
					pr.println("Player 2 image " + server.player2Image);
				pr.println("Player 2 maxstamina " + server.player2Stam);
				pr.println("Player 2 stamina " + server.player2CStam);
				pr.println("Player 2 gold " + server.player2Gold);
				pr.println("Player 2 action 1 " + server.player2Action1);
				pr.println("Player 2 action 2 " + server.player2Action2);
				pr.println("Player 2 action 3 " + server.player2Action3);
				pr.println("Player 2 action 4 " + server.player2Action4);
				pr.println("Player 2 action 5 " + server.player2Action5);
				pr.println("Player 2 action 6 " + server.player2Action6);
				pr.println("Player 2 action 7 " + server.player2Action7);
				pr.println("Player 2 action 8 " + server.player2Action8);
				pr.println("Player 2 actionenable 1 " + server.player2Action1e);
				pr.println("Player 2 actionenable 2 " + server.player2Action2e);
				pr.println("Player 2 actionenable 3 " + server.player2Action3e);
				pr.println("Player 2 actionenable 4 " + server.player2Action4e);
				pr.println("Player 2 actionenable 5 " + server.player2Action5e);
				pr.println("Player 2 actionenable 6 " + server.player2Action6e);
				pr.println("Player 2 actionenable 7 " + server.player2Action7e);
				pr.println("Player 2 actionenable 8 " + server.player2Action8e);
				for (int i = 1; i <= 8; i++)
				{
					pr.println("Player 2 actiontype " + i + " " + server.actionTypes.get("p2a" + i));
				}
				
				if (server.player2c1enabled)
					pr.println("Companion 2 1 enable");
				pr.println("Companion 2 1 maxstamina " + server.player2c1Stam);
				pr.println("Companion 2 1 stamina " + server.player2c1CStam);
				
				if (server.player2c2enabled)
					pr.println("Companion 2 2 enable");
				pr.println("Companion 2 2 maxstamina " + server.player2c2Stam);
				pr.println("Companion 2 2 stamina " + server.player2c2CStam);
				
				if (server.player2c3enabled)
					pr.println("Companion 2 3 enable");
				pr.println("Companion 2 3 maxstamina " + server.player2c3Stam);
				pr.println("Companion 2 3 stamina " + server.player2c3CStam);
				
				// ----
				
				if (server.player3)
					pr.println("Player 3 enable");
				if (!server.player3Image.equals(""))
					pr.println("Player 3 image " + server.player3Image);
				pr.println("Player 3 maxstamina " + server.player3Stam);
				pr.println("Player 3 stamina " + server.player3CStam);
				pr.println("Player 3 gold " + server.player3Gold);
				pr.println("Player 3 action 1 " + server.player3Action1);
				pr.println("Player 3 action 2 " + server.player3Action2);
				pr.println("Player 3 action 3 " + server.player3Action3);
				pr.println("Player 3 action 4 " + server.player3Action4);
				pr.println("Player 3 action 5 " + server.player3Action5);
				pr.println("Player 3 action 6 " + server.player3Action6);
				pr.println("Player 3 action 7 " + server.player3Action7);
				pr.println("Player 3 action 8 " + server.player3Action8);
				pr.println("Player 3 actionenable 1 " + server.player3Action1e);
				pr.println("Player 3 actionenable 2 " + server.player3Action2e);
				pr.println("Player 3 actionenable 3 " + server.player3Action3e);
				pr.println("Player 3 actionenable 4 " + server.player3Action4e);
				pr.println("Player 3 actionenable 5 " + server.player3Action5e);
				pr.println("Player 3 actionenable 6 " + server.player3Action6e);
				pr.println("Player 3 actionenable 7 " + server.player3Action7e);
				pr.println("Player 3 actionenable 8 " + server.player3Action8e);
				for (int i = 1; i <= 8; i++)
				{
					pr.println("Player 3 actiontype " + i + " " + server.actionTypes.get("p3a" + i));
				}
				
				if (server.player3c1enabled)
					pr.println("Companion 3 1 enable");
				pr.println("Companion 3 1 maxstamina " + server.player3c1Stam);
				pr.println("Companion 3 1 stamina " + server.player3c1CStam);
				
				if (server.player3c2enabled)
					pr.println("Companion 3 2 enable");
				pr.println("Companion 3 2 maxstamina " + server.player3c2Stam);
				pr.println("Companion 3 2 stamina " + server.player3c2CStam);
				
				if (server.player3c3enabled)
					pr.println("Companion 3 3 enable");
				pr.println("Companion 3 3 maxstamina " + server.player3c3Stam);
				pr.println("Companion 3 3 stamina " + server.player3c3CStam);
				
				// ----
				
				if (server.player4)
					pr.println("Player 4 enable");
				if (!server.player4Image.equals(""))
					pr.println("Player 4 image " + server.player4Image);
				pr.println("Player 4 maxstamina " + server.player4Stam);
				pr.println("Player 4 stamina " + server.player4CStam);
				pr.println("Player 4 gold " + server.player4Gold);
				pr.println("Player 4 action 1 " + server.player4Action1);
				pr.println("Player 4 action 2 " + server.player4Action2);
				pr.println("Player 4 action 3 " + server.player4Action3);
				pr.println("Player 4 action 4 " + server.player4Action4);
				pr.println("Player 4 action 5 " + server.player4Action5);
				pr.println("Player 4 action 6 " + server.player4Action6);
				pr.println("Player 4 action 7 " + server.player4Action7);
				pr.println("Player 4 action 8 " + server.player4Action8);
				pr.println("Player 4 actionenable 1 " + server.player4Action1e);
				pr.println("Player 4 actionenable 2 " + server.player4Action2e);
				pr.println("Player 4 actionenable 3 " + server.player4Action3e);
				pr.println("Player 4 actionenable 4 " + server.player4Action4e);
				pr.println("Player 4 actionenable 5 " + server.player4Action5e);
				pr.println("Player 4 actionenable 6 " + server.player4Action6e);
				pr.println("Player 4 actionenable 7 " + server.player4Action7e);
				pr.println("Player 4 actionenable 8 " + server.player4Action8e);
				for (int i = 1; i <= 8; i++)
				{
					pr.println("Player 4 actiontype " + i + " " + server.actionTypes.get("p4a" + i));
				}
				
				if (server.player4c1enabled)
					pr.println("Companion 4 1 enable");
				pr.println("Companion 4 1 maxstamina " + server.player4c1Stam);
				pr.println("Companion 4 1 stamina " + server.player4c1CStam);
				
				if (server.player4c2enabled)
					pr.println("Companion 4 2 enable");
				pr.println("Companion 4 2 maxstamina " + server.player4c2Stam);
				pr.println("Companion 4 2 stamina " + server.player4c2CStam);
				
				if (server.player4c3enabled)
					pr.println("Companion 4 3 enable");
				pr.println("Companion 4 3 maxstamina " + server.player4c3Stam);
				pr.println("Companion 4 3 stamina " + server.player4c3CStam);
				
			}
		}, 1200); // Changed from 350 milliseconds to 1.2 seconds due to extra math in the client
					// taking up more time
		
		String line;
		while (true)
		{
			try
			{
				line = brinp.readLine();
				if ((line == null))
					continue;
				
				String[] inputs = line.split(" ");
				
				switch (inputs[0])
				{
					case "Quit":
					{
						socket.close();
						return;
					}
					
				}
			} catch (IOException e)
			{
				// server.log(ip + " has disconnected");
				return;
			}
		}
	}
}
