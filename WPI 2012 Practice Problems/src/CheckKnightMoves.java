// Teju Nareddy, 12/25/12

import java.util.*;

public class CheckKnightMoves
{
	public static Scanner console = new Scanner(System.in);
	public static int[][] board = new int[4][4];
	
	public static void main(String[] args)
	{
		// For this program: a = row, b = column
		for (int a = 0; a < board.length; a++)
		{
			for (int b = 0; b < board.length; b++)
			{
				board[a][b] = console.nextInt();
			}
		}
		
		System.out.println(checkBoard().toUpperCase());
	}
	
	public static String checkBoard()
	{
		
		return "true";
	}
}
