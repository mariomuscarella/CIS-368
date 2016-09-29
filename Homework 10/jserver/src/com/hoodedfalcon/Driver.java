package com.hoodedfalcon;

import com.hoodedfalcon.control.RecordServer;

import java.util.Scanner;

/**
 * Launches RecordServer.
 *
 * @see RecordServer
 */
public class Driver
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		String inputString = "";
		int port;

		if (args.length == 0 || !isInteger(args[0]))
		{
			while (true)
			{
				System.out.print("Server Port: ");
				inputString = input.next();
				if (isInteger(inputString)) break;
			}
			port = Integer.parseInt(inputString);
		}
		else
		{
			port = Integer.parseInt(args[0]);
		}

		RecordServer server = new RecordServer();
		server.start(port);
	}

	private static boolean isInteger(String string)
	{
		for (int i = 0; i < string.length(); i++)
		{
			if (Character.isDigit(string.charAt(i)) != true) return false;
		}
		return true;
	}
	
}

