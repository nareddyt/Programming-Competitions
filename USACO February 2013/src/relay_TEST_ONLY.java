/*
 * ID: nareddyt
 * LANG: JAVA
 * TASK: relay
 */

import java.io.*;
import java.util.*;

public class relay_TEST_ONLY
{
	public static void main(String[] args) throws IOException
	{
		long start = System.currentTimeMillis();
		BufferedReader f = new BufferedReader(new FileReader("relay.txt"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("relayOut.text")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		
		int[] cows = new int[Integer.parseInt(st.nextToken())];
		for (int i = 0; i < cows.length; i++)
		{
			st = new StringTokenizer(f.readLine());
			cows[i] = Integer.parseInt(st.nextToken());
		}
		// Array is now finished being initialized
		
		int noLoopy = 0;
		for (int i = 0; i < cows.length; i++)
		{
			if (cows[i] == 0)
			{
				noLoopy++;
			}
			else
			{
				int indexRec = i;
				int count = 0;
				while (count < cows.length)
				{
					int next = cows[indexRec]; // where cow nth is sending
					indexRec = next - 1; // the index of cow that n is sending to
					if (cows[indexRec] == 0)
					{
						noLoopy++;
						break;
					}
					count++;
				}
			}
		}
		
		System.out.println(noLoopy);
		long end = System.currentTimeMillis();
		System.out.println("Time = " + (end - start));
		
		f.close();
		out.close();
		System.exit(0);
	}
}
