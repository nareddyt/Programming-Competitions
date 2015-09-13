/*
 * ID: nareddyt
 * LANG: JAVA
 * TASK: proximity
 */

import java.io.*;
import java.util.*;

public class proximity
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("proximity.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("proximity.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		
		int cows = Integer.parseInt(st.nextToken());
		int space = Integer.parseInt(st.nextToken());
		
		int[] ids = new int[cows];
		for (int i = 0; i < cows; i++)
		{
			st = new StringTokenizer(f.readLine());
			ids[i] = Integer.parseInt(st.nextToken());
		}
		
		int crowded = -1;
		for (int i = 0; i < ids.length - space; i++)
		{
			int cId = ids[i];
			for (int b = 1; b <= space; b++)
			{
				if (ids[b + i] == cId)
				{
					if (cId > crowded)
					{
						crowded = cId;
					}
				}
			}
		}
		for (int i = ids.length - space; i < ids.length; i++)
		{
			int cId = ids[i];
			for (int b = 1; b < ids.length - i; b++)
			{
				if (ids[b + i] == cId)
				{
					if (cId > crowded)
					{
						crowded = cId;
					}
				}
			}
		}
		
		out.println(crowded);
		f.close();
		out.close();
		System.exit(0);
	}
}
