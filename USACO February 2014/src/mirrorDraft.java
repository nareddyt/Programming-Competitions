import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * ID: nareddyt
 * LANG: JAVA
 * TASK: mirror
 */

public class mirrorDraft
{
	public static char[][] mirrors;
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("mirror.txt"));
		// PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mirror.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		
		int max = 0;
		int current = 0;
		int length = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		mirrors = new char[length][width];
		
		// Fill in array with input
		for (int a = 0; a < length; a++)
		{
			String line = f.readLine();
			for (int b = 0; b < width; b++)
			{
				mirrors[a][b] = line.charAt(b);
			}
		}
		
		// Now all the input is in an array
		System.out.println(Arrays.toString(mirrors[0]));
		System.out.println(Arrays.toString(mirrors[1]));
		System.out.println(Arrays.toString(mirrors[2]));
		
		// Find all possible paths
		for (int i = 0; i < length; i++)
		{
			current = getNumber(0, i, 3);
			if (current > max)
			{
				max = current;
			}
		}
		for (int i = 0; i < length; i++)
		{
			current = getNumber(length - 1, i, 1);
			if (current > max)
			{
				max = current;
			}
		}
		for (int i = 0; i < width; i++)
		{
			current = getNumber(i, 0, 2);
			if (current > max)
			{
				max = current;
			}
		}
		for (int i = 0; i < width; i++)
		{
			current = getNumber(i, width - 1, 4);
			if (current > max)
			{
				max = current;
			}
		}
		
		System.out.println(max);
		f.close();
		System.exit(0);
	}
	
	public static int getNumber(int y, int x, int dir) // 1 = N, 2 = E, 3 = S, 4 = W
	{
		int count = 0;
		while (x >= 0 && x < mirrors.length && y >= 0 && y < mirrors[0].length)
		{
			char mir = mirrors[y][x];
			if (mir == '\\')
			{
				if (dir == 1)
				{
					x--;
					dir = 4;
				}
				else if (dir == 2)
				{
					y++;
					dir = 3;
				}
				else if (dir == 3)
				{
					x++;
					dir = 2;
				}
				else
				{
					y--;
					dir = 1;
				}
			}
			else
			{
				if (dir == 1)
				{
					x++;
					dir = 2;
				}
				else if (dir == 2)
				{
					y--;
					dir = 1;
				}
				else if (dir == 3)
				{
					x--;
					dir = 4;
				}
				else
				{
					y++;
					dir = 3;
				}
			}
			count++;
		}
		return count;
	}
}
