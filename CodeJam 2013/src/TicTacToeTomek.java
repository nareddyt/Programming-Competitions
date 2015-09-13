// Teju Nareddy, 4/12/13

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TicTacToeTomek
{
	public static void main(String[] args) throws IOException
	{
		File f = new File("A-large.in");
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("A-large.out")));
		Scanner file = new Scanner(f);
		
		int max = file.nextInt();
		
		for (int i = 1; i <= max; i++)
		{
			int xs = 0;
			int os = 0;
			int ts = 0;
			
			char[][] board = new char[4][4];
			for (int a = 0; a < 4; a++)
			{
				String line = file.next();
				for (int b = 0; b < 4; b++)
				{
					char c = line.charAt(b);
					board[a][b] = c;
					if (c == 'X')
					{
						xs++;
					}
					else if (c == 'O')
					{
						os++;
					}
					else if (c == 'T')
					{
						ts++;
					}
				}
			}// Now the board is stored in a 2D array
			if (xs + ts < 4 && os + ts < 4)
			{
				out.println("Case #" + i + ": Game has not completed");
			}
			else
			// TODO
			{
				boolean isFilled = true; // DONE
				boolean xWin = false;
				boolean oWin = false;
				
				for (int a = 0; a < 4; a++)
				{
					for (int b = 0; b < 4; b++)
					{
						if (board[a][b] == '.')
						{
							isFilled = false;
						}
					}
				}
				
				// FIXME for T
				for (int a = 0; a < 4; a++)
				{
					if (xWin || oWin)
					{
						break;
					}
					boolean over = false;
					for (int b = 0; b < 4; b++)
					{
						if (xWin || oWin)
						{
							break;
						}
						if (a > 0 && b > 0)
						{
							break;
						}
						int r = a, c = b;
						char ch = board[r][c];
						if (ch == 'X' || ch == 'T')
						{
							if (r == 0 && c == 0)
							{
								// TODO
								while (r < 4)
								{
									r++;
									ch = board[r][r];
									if (ch != 'X' && ch != 'T')
									{
										break;
									}
									if (r == 3)
									{
										xWin = true;
										break;
									}
								}
							}
							r = a;
							c = b;
							if (r == 3 && c == 0)
							{
								while (r >= 0)
								{
									r--;
									c++;
									ch = board[r][c];
									if (ch != 'X' && ch != 'T')
									{
										break;
									}
									if (r == 0)
									{
										xWin = true;
										break;
									}
								}
							}
							r = a;
							c = b;
							if (r == 0)
							{
								while (r < 4)
								{
									r++;
									ch = board[r][c];
									if (ch != 'X' && ch != 'T')
									{
										break;
									}
									if (r == 3)
									{
										xWin = true;
										break;
									}
								}
							}
							r = a;
							c = b;
							if (c == 0)
							{
								while (c < 4)
								{
									c++;
									ch = board[r][c];
									if (ch != 'X' && ch != 'T')
									{
										break;
									}
									if (c == 3)
									{
										xWin = true;
										break; // Case 1
									}
								}
							}
						}
						r = a;
						c = b;
						ch = board[r][c];
						if (ch == 'O' || ch == 'T')
						{
							if (r == 0 && c == 0)
							{
								// TODO
								while (r < 4)
								{
									r++;
									ch = board[r][r];
									if (ch != 'O' && ch != 'T')
									{
										break;
									}
									if (r == 3)
									{
										oWin = true;
										break;
									}
								}
							}
							r = a;
							c = b;
							if (r == 3 && c == 0)
							{
								while (r >= 0)
								{
									r--;
									c++;
									ch = board[r][c];
									if (ch != 'O' && ch != 'T')
									{
										break;
									}
									if (r == 0)
									{
										oWin = true;
										break;
									}
								}
							}
							r = a;
							c = b;
							if (r == 0)
							{
								while (r < 4)
								{
									r++;
									ch = board[r][c];
									if (ch != 'O' && ch != 'T')
									{
										break;
									}
									if (r == 3)
									{
										oWin = true;
										break;
									}
								}
							}
							r = a;
							c = b;
							if (c == 0)
							{
								while (c < 4)
								{
									c++;
									ch = board[r][c];
									if (ch != 'O' && ch != 'T')
									{
										break;
									}
									if (c == 3)
									{
										oWin = true;
										break;
									}
								}
							}
						}
					}
					if (xWin || oWin)
					{
						break;
					}
				}
				
				if (xWin)
				{
					out.println("Case #" + i + ": X won");
				}
				else if (oWin)
				{
					out.println("Case #" + i + ": O won");
				}
				else if (isFilled)
				{
					out.println("Case #" + i + ": Draw");
				}
				else
				{
					out.println("Case #" + i + ": Game has not completed");
				}
			}
		}
		
		out.close();
		file.close();
		System.exit(0);
	}
	
	/*
	 * public static void outputBoard(char[][] board) // The board is inputed properly
	 * {
	 * for (int a = 0; a < 4; a++)
	 * {
	 * for (int b = 0; b < 4; b++)
	 * {
	 * System.out.print(board[a][b]);
	 * }
	 * System.out.println();
	 * }
	 * }
	 */
}
