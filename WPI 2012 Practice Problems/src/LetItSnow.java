// Teju Nareddy, 12/22/12

import java.util.*;

public class LetItSnow
{
	public static Scanner console = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		// The original input is Quadrant #2 of a normal XY plane
		char[][] Quad2 = new char[5][5];
		
		for (int a = 0; a < 5; a++) // get the console input and store it...
		{
			String line = console.nextLine();
			for (int b = 0; b < 5; b++)
			{
				Quad2[a][b] = line.charAt(b);
			}
		}
		
		// In this whole program: a = row, b = column
		// The other arrays are created by using the data from the input
		char[][] Quad1 = new char[5][5];
		char[][] Quad3 = new char[5][5];
		char[][] Quad4 = new char[5][5];
		
		for (int a = 0; a < 5; a++)
		{
			for (int b = 0; b < 5; b++)
			{
				Quad1[a][4 - b] = Quad2[a][b];
			}
		}
		
		for (int a = 0; a < 5; a++)
		{
			for (int b = 0; b < 5; b++)
			{
				Quad3[4 - a][b] = Quad2[a][b];
			}
		}
		
		for (int a = 0; a < 5; a++)
		{
			for (int b = 0; b < 5; b++)
			{
				Quad4[4 - a][4 - b] = Quad2[a][b];
			}
		}
		
		// Put all these arrays together into a final array
		char[][] output = new char[10][10];
		for (int a = 0; a < 10; a++)
		{
			for (int b = 0; b < 10; b++)
			{
				if (a < 5 && b < 5)
				{
					output[a][b] = Quad2[a][b];
				}
				else if (a < 5 && b < 10)
				{
					output[a][b] = Quad1[a][b - 5];
				}
				else if (a < 10 && b < 5)
				{
					output[a][b] = Quad3[a - 5][b];
				}
				else
				{
					output[a][b] = Quad4[a - 5][b - 5];
				}
			}
		}
		
		// Display the array...
		for (int a = 0; a < 10; a++)
		{
			for (int b = 0; b < 10; b++)
			{
				System.out.print(output[a][b]);
			}
			System.out.println();
		}
	}
}
