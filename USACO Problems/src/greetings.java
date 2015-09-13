/*
 * ID: nareddyt
 * LANG: Java
 * Task: greetings
 */

import java.io.*;
import java.util.*;

public class greetings
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("greetings.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("greetings.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		
		int Blength = Integer.parseInt(st.nextToken());
		int Elength = Integer.parseInt(st.nextToken());
		int Bpos = 0;
		int Epos = 0;
		int meets = 0;
		int higher;
		
		int[] bMoves = new int[Blength];
		int[] eMoves = new int[Elength];
		
		for (int i = 0; i < Blength; i++)
		{
			st = new StringTokenizer(f.readLine());
			int temp = Integer.parseInt(st.nextToken());
			if (st.nextToken() == "L")
			{
				temp *= -1;
			}
			
			bMoves[i] = temp;
		}
		
		for (int i = 0; i < Blength; i++)
		{
			st = new StringTokenizer(f.readLine());
			int temp = Integer.parseInt(st.nextToken());
			if (st.nextToken() == "L")
			{
				temp *= -1;
			}
			
			eMoves[i] = temp;
		}
		
		if (Blength > Elength)
		{
			higher = Elength;
		}
		else
		{
			higher = Blength;
		}
		
		for (int i = 0; i < higher; i++)
		{
			if (i < Elength)
			{
				if (eMoves[i] < 1)
				{
					for (int a = 0; a < (eMoves[i] * -1); a++)
					{
						Epos -= 1;
						if (Epos == Bpos)
						{
							meets++;
						}
					}
				}
				else
				{
					for (int a = 0; a < eMoves[i]; a++)
					{
						Epos += 1;
						if (Epos == Bpos)
						{
							meets++;
						}
					}
				}
			}
			
			if (i < Blength)
			{
				if (bMoves[i] < 1)
				{
					for (int a = 0; a < (bMoves[i] * -1); a++)
					{
						Bpos -= 1;
						if (Epos == Bpos)
						{
							meets++;
						}
					}
				}
				else
				{
					for (int a = 0; a < bMoves[i]; a++)
					{
						Bpos += 1;
						if (Epos == Bpos)
						{
							meets++;
						}
					}
				}
			}
			
		}
		
		out.println(meets);
		out.close();
		System.exit(0);
	}
}
