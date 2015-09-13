import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

// Teju Nareddy, 4/12/13

public class Treasure
{
	public static void main(String[] args) throws IOException
	{
		File f = new File("D-small-attempt0.in");
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("D-small-attempt0.out")));
		Scanner file = new Scanner(f);
		
		int cases = file.nextInt();
		
		for (int i = 1; i <= cases; i++)
		{
			System.out.println("\n\nCase #" + i + ": ");
			
			int numK = file.nextInt();
			int numC = file.nextInt();
			int[] startKeys = new int[numK]; // Starting keys
			
			int[] keysNeeded = new int[numC]; // Keys needed to open each cooresponding chest
			int[][] keysInside = new int[numC][]; // Keys inside each cooresponding chest
			
			for (int k = 0; k < startKeys.length; k++)
			{
				startKeys[k] = file.nextInt();
			}
			for (int k = 0; k < numC; k++)
			{
				int needed = file.nextInt();
				int inside = file.nextInt();
				keysNeeded[k] = needed;
				keysInside[k] = new int[inside];
				
				for (int j = 0; j < inside; j++)
				{
					keysInside[k][j] = file.nextInt();
				}
			}
			
			// Print it out
			System.out.print("Starting keys: ");
			for (int k = 0; k < startKeys.length; k++)
			{
				System.out.print(startKeys[k] + " ");
			}
			
			System.out.println("\nChests: \t Need \t Inside");
			for (int k = 0; k < keysInside.length; k++)
			{
				System.out.print("Chest " + (k + 1) + ":\t");
				System.out.print("--" + keysNeeded[k] + "--\t");
				for (int j = 0; j < keysInside[k].length; j++)
				{
					System.out.print(keysInside[k][j] + " ");
				}
				if (keysInside[k].length == 0)
				{
					System.out.print("-----");
				}
				System.out.println();
			}
		}
		
		// TODO
	}
}
