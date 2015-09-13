/*
 * ID: nareddyt
 * LANG: JAVA
 * TASK: relay
 */

import java.io.*;
import java.util.*;

public class crossings_TestOnly
{
	public static void main(String[] args) throws IOException
	{
		long start = System.currentTimeMillis();
		BufferedReader f = new BufferedReader(new FileReader("crossings.txt"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("crossingsOut.txt")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		
		int nums = Integer.parseInt(st.nextToken());
		int[] x1 = new int[nums];
		int[] x2 = new int[nums];
		boolean[] unsafe = new boolean[nums];
		for (int i = 0; i < x1.length; i++)
		{
			st = new StringTokenizer(f.readLine());
			x1[i] = Integer.parseInt(st.nextToken());
			x2[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < x1.length; i++) // Compute the number of UN-SAFE cows
		{
			for (int a = i; a < x1.length; a++)
			{
				if ((x1[a] < x1[i] && x2[a] > x2[i]) || (x1[a] > x1[i] && x2[a] < x2[i]))
				{
					unsafe[a] = true;
					unsafe[i] = true;
					break;
				}
			}
		}
		
		int total = 0;
		for (int i = 0; i < unsafe.length; i++)
		{
			if (unsafe[i])
			{
				total++;
			}
		}
		
		System.out.println(x1.length - total); // total safe cows
		
		long end = System.currentTimeMillis();
		System.out.println("Time = " + (end - start));
		
		f.close();
		out.close();
		System.exit(0);
	}
}
