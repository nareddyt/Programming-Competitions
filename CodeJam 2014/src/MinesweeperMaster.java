import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

// Teju Nareddy, 4/12/14

// Center around lower left
// 1 spot, 4 spots, 6+ spots

public class MinesweeperMaster
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("C-small-attempt4.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("minesweeperOut.txt")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		
		int cases = Integer.parseInt(st.nextToken());
		int length;
		int width;
		int mines;
		
		int used;
		int free;
		int temp1;
		
		for (int i = 1; i <= cases; i++)
		{
			st = new StringTokenizer(f.readLine());
			length = Integer.parseInt(st.nextToken());
			width = Integer.parseInt(st.nextToken());
			mines = Integer.parseInt(st.nextToken());
			
			free = length * width - mines;
			
			if (((length == 1 || width == 1) && free >= 1) || free == 1 || free == 4 || free == 6 || free >= 8
					|| (length == 2 && free % 2 == 0 && free >= 4 || width == 2 && free % 2 == 0 && free >= 4)) // TODO
			{
				System.out.println("Case #" + i + ":");
				System.out.println("Possible");
				
				used = 0;
				temp1 = free / 2 - 1;
				for (int l = 0; l < length; l++)
				{
					for (int w = 0; w < width; w++)
					{
						if (l == 0 && w == 0)
						{
							System.out.print("c");
							used++;
						}
						else if (used == free)
						{
							System.out.print("*");
						}
						else if (w > temp1 && (length - l - 1) * (width - 1) / 2 > (free - used))
						{
							System.out.print("*");
						}
						else if (w == width - 1 && free - used == 2 && width > 2
								&& (length - l - 1) * (width - 1) > (free - used))
						{
							System.out.print("*");
						}
						else if (w == width - 2 && free - used == 2 && width > 3
								&& (length - l - 1) * (width - 1) > (free - used))
						{
							System.out.print("*");
						}
						else
						{
							System.out.print(".");
							used++;
						}
					}
					System.out.println();
				}
			}
			else
			{
				System.out.println("Case #" + i + ":");
				System.out.println("Impossible");
			}
		}
		
		f.close();
		out.close();
		System.exit(0);
	}
}
