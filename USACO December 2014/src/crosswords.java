import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * ID: nareddyt
 * LANG: JAVA
 * TASK: crosswords
 */

public class crosswords
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("crosswords.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("crosswords.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		
		char[][] board = new char[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())];
		for (int i = 0; i < board.length; i++)
		{
			String line = f.readLine();
			for (int j = 0; j < line.length(); j++)
			{
				board[i][j] = line.charAt(j);
			}
		}
		
		ArrayList<Integer> locX = new ArrayList<Integer>();
		ArrayList<Integer> locY = new ArrayList<Integer>();
		for (int i = 0; i < board.length; i++)
		{
			for (int j = 0; j < board[0].length; j++)
			{
				boolean done = false;
				
				if (board[i][j] == '#')
				{
					done = true;
				}
				
				if (i >= 1 && i < board.length - 2 && !done) // Vertical
				{
					if (board[i - 1][j] == '#')
					{
						if (board[i + 1][j] == '.' && board[i + 2][j] == '.')
						{
							locX.add(i + 1);
							locY.add(j + 1);
							done = true;
						}
					}
				}
				if (j >= 1 && j < board[0].length - 2 && !done) // Horizontal
				{
					if (board[i][j - 1] == '#')
					{
						if (board[i][j + 1] == '.' && board[i][j + 2] == '.')
						{
							locX.add(i + 1);
							locY.add(j + 1);
							done = true;
						}
					}
				}
				if (i == 0 && !done) // Vertical
				{
					if (board[i + 1][j] == '.' && board[i + 2][j] == '.')
					{
						locX.add(i + 1);
						locY.add(j + 1);
						done = true;
					}
				}
				if (j == 0 && !done) // Horizontal
				{
					if (board[i][j + 1] == '.' && board[i][j + 2] == '.')
					{
						locX.add(i + 1);
						locY.add(j + 1);
						done = true;
					}
				}
			}
		}
		
		out.println(locX.size());
		for (int i = 0; i < locX.size(); i++)
		{
			out.println(locX.get(i) + " " + locY.get(i));
		}
		
		out.close();
		f.close();
		System.exit(0);
	}
}
