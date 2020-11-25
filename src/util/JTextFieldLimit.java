package util;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

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

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

import server.ServerGMUI;

public class JTextFieldLimit extends PlainDocument {
	
	private static final long serialVersionUID = 8261647314558612547L;
	
	public JTextFieldLimit(ServerGMUI su, JTextField object, int player, boolean integer)
	{
		super();
		
		if (integer)
			setDocumentFilter(new MyDocumentFilter(su, object, player));
	}
}

class MyDocumentFilter extends DocumentFilter {
	
	public ServerGMUI	su;
	public JTextField	object;
	public int			player;
	
	public MyDocumentFilter(ServerGMUI su, JTextField object, int player)
	{
		this.su = su;
		this.object = object;
		this.player = player;
	}
	
	@Override
	public void insertString(FilterBypass fb, int off, String str, AttributeSet attr) throws BadLocationException
	{
		// Remove characters that aren't numbers
		fb.insertString(off, str.replaceAll("\\D++", ""), attr);
		
		try
		{
			if (object.getText().equals(""))
				return;
			else if (object.getName().startsWith("P"))
			{
				su.server.getClass().getField("player" + player + "Stam").setInt(su.server, Integer.valueOf(object.getText()));
			} else if (object.getName().startsWith("C"))
			{
				su.server.getClass().getField("player" + player + "c" + (object.getName().substring(12, 13)) + "Stam").setInt(su.server,
						Integer.valueOf(object.getText()));
			}
			
			su.server.input(object.getName() + " maxstamina " + object.getText());
		} catch (Exception e)
		{
			JOptionPane.showMessageDialog(new JFrame(), "An internal error has occurred (S-646f63696e73657274)", "Error", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
	}
	
	@Override
	public void replace(FilterBypass fb, int off, int len, String str, AttributeSet attr) throws BadLocationException
	{
		// Remove characters that aren't numbers
		fb.replace(off, len, str.replaceAll("\\D++", ""), attr);
		
		try
		{
			if (object.getText().equals(""))
				return;
			else if (object.getName().startsWith("P"))
			{
				su.server.getClass().getField("player" + player + "Stam").setInt(su.server, Integer.valueOf(object.getText()));
			} else if (object.getName().startsWith("C"))
			{
				su.server.getClass().getField("player" + player + "c" + (object.getName().substring(12, 13)) + "Stam").setInt(su.server,
						Integer.valueOf(object.getText()));
			}
			
			su.server.input(object.getName() + " maxstamina " + object.getText());
		} catch (Exception e)
		{
			JOptionPane.showMessageDialog(new JFrame(), "An internal error has occurred (S-646f637265706c616365)", "Error",
					JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
		
	}
	
	@Override
	public void remove(FilterBypass fb, int off, int len) throws BadLocationException
	{
		fb.remove(off, len);
		try
		{
			if (object.getText().equals(""))
				return;
			else if (object.getName().startsWith("P"))
			{
				su.server.getClass().getField("player" + player + "Stam").setInt(su.server, Integer.valueOf(object.getText()));
			} else if (object.getName().startsWith("C"))
			{
				su.server.getClass().getField("player" + player + "c" + (object.getName().substring(12, 13)) + "Stam").setInt(su.server,
						Integer.valueOf(object.getText()));
			}
			
			su.server.input(object.getName() + " maxstamina " + object.getText());
		} catch (Exception e)
		{
			JOptionPane.showMessageDialog(new JFrame(), "An internal error has occurred (S-646f6372656d6f7665)", "Error", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
	}
}
