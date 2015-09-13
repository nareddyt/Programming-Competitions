/*
 * ID: nareddyt
 * LANG: JAVA
 * TASK: cowrace
 */

import java.io.*;
import java.util.*;

public class cowrace
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("cowrace.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowrace.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		
		int aNum = Integer.parseInt(st.nextToken());
		int bNum = Integer.parseInt(st.nextToken());
		
		int[] aSpeed = new int[aNum];
		int[] aTime = new int[aNum];
		int[] bSpeed = new int[bNum];
		int[] bTime = new int[bNum];
		
		for (int i = 0; i < aNum; i++)
		{
			st = new StringTokenizer(f.readLine());
			aSpeed[i] = Integer.parseInt(st.nextToken());
			aTime[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < bNum; i++)
		{
			st = new StringTokenizer(f.readLine());
			bSpeed[i] = Integer.parseInt(st.nextToken());
			bTime[i] = Integer.parseInt(st.nextToken());
		}
		
		int aCount = 0;
		int bCount = 0;
		int aLoc = 0;
		int bLoc = 0;
		boolean aLead = false;
		boolean bLead = false;
		int changes = 0;
		
		while (aCount < aTime.length || bCount < bTime.length)
		{
			if (aCount < aTime.length)
			{
				aLoc += aSpeed[aCount];
				aTime[aCount]--;
				if (aTime[aCount] == 0)
				{
					aCount++;
				}
			}
			if (bCount < bTime.length)
			{
				bLoc += bSpeed[bCount];
				bTime[bCount]--;
				if (bTime[bCount] == 0)
				{
					bCount++;
				}
			}
			
			if (!aLead && !bLead)
			{
				if (aLoc > bLoc)
				{
					aLead = true;
					changes++;
				}
				else if (bLoc > aLoc)
				{
					bLead = true;
					changes++;
				}
				else
				{
					// do nothing
				}
			}
			if (aLoc == bLoc)
			{
				// do nothing
			}
			else if (aLoc > bLoc && !aLead)
			{
				aLead = true;
				changes++;
			}
			else if (bLoc > aLoc && !bLead)
			{
				bLead = true;
				changes++;
			}
			else
			{
				// do nothing
			}
		}
		
		out.println(changes);
		f.close();
		out.close();
		System.exit(0);
	}
}
