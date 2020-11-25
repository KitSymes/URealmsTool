package client;

import java.awt.Image;

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
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Client {
	
	private ClientUI UI;
	
	public void main(String hostName, int portNumber, int screen)
	{
		
		try (Socket socket = new Socket(hostName, portNumber);
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));)
		{
			String fromServer;
			while (true)
			{
				fromServer = in.readLine();
				
				if (fromServer.equals("StartUI"))
				{
					UI = new ClientUI(screen);
					continue;
				} else if (fromServer.equals("HealAll"))
				{
					UI.healAll();
					continue;
				}
				
				final String[] inputs = fromServer.split(" ");
				if (inputs.length > 1)
				{
					if (inputs[0].equals("gmimage"))
					{
						new Thread(new Runnable() {
							
							@Override
							public void run()
							{
								try
								{
									UI.gmimage.setIcon(new ImageIcon(ImageIO.read(new URL(inputs[1])).getScaledInstance(UI.gmimage.getWidth(),
											UI.gmimage.getHeight(), Image.SCALE_SMOOTH)));
								} catch (IOException e)
								{
									JOptionPane.showMessageDialog(new JFrame(), "An internal error has occurred (C-676d696d616765)", "Error", JOptionPane.ERROR_MESSAGE);
									System.exit(1);
								}
							}
						}).run();
					}
					
					// -------------------------------------------------------------------------
					else if (inputs[0].equals("Player")) // Player [Number] [Command] <args>
					{
						switch (inputs[2])
						{
							case "enable":
								UI.playerEnable(inputs[1]);
								break;
							case "disable":
								UI.playerDisable(inputs[1]);
								break;
							case "maxstamina":
								UI.playerMaxStamina(inputs[1], inputs[3]);
								break;
							case "stamina":
								UI.playerStamina(inputs[1], inputs[3]);
								break;
							case "damage":
								UI.playerDamage(inputs[1], inputs[3]);
								break;
							case "gold":
								UI.playerGold(inputs[1], inputs[3]);
								break;
							case "modifygold":
								UI.playerModifyGold(inputs[1], inputs[3]);
								break;
							case "action":
								UI.playerAction(inputs[1], inputs[3], inputs[4]);
								break;
							case "actiontype":
								UI.playerActionType(inputs[1], inputs[3], inputs[4]);
								break;
							case "actionenable":
								((CAP) ClientUI.class.getDeclaredField("c" + inputs[1]).get(UI)).enableAction(inputs[3], inputs[4]);
								break;
							case "image":
								((CAP) ClientUI.class.getDeclaredField("c" + inputs[1]).get(UI)).setPlayerImage(inputs[3]);
								break;
						}
					} else if (inputs[0].equals("Companion")) // Companion [Player] [Number] [Command] <args> e.g.
																// Companion 4 1 enable
					{
						if (inputs.length == 4)
						{
							UI.companion(inputs[1], inputs[2], inputs[3], null);
						}
						if (inputs.length > 4)
						{
							ArrayList<String> args = new ArrayList<String>();
							for (int i = 0; i < inputs.length; i++)
							{
								if (i == 0 || i == 1 || i == 2 || i == 3) // Ignore Companion [Player] [Number] [Command]
									continue;
								else
									args.add(inputs[i]); // Only add <args>
							}
							UI.companion(inputs[1], inputs[2], inputs[3], args);
						}
						continue;
					}
					// -------------------------------------------------------------------------
				}
			}
		} catch (UnknownHostException e)
		{
			JOptionPane.showMessageDialog(new JFrame(), "Can't find host " + hostName, "Error", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		} catch (IOException e)
		{
			JOptionPane.showMessageDialog(new JFrame(), "Couldn't get I/O for the connection to " + hostName, "Error", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		} catch (IllegalArgumentException e)
		{
			e.printStackTrace();
		} catch (IllegalAccessException e)
		{
			e.printStackTrace();
		} catch (NoSuchFieldException e)
		{
			e.printStackTrace();
		} catch (SecurityException e)
		{
			e.printStackTrace();
		}
	}
}