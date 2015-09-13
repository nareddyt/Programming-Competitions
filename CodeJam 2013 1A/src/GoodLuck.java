import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class GoodLuck
{
	public static void main(String[] args) throws IOException
	{
		Random rand = new Random();
		File f = new File("C-small-1-attempt2.in");
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C-small-1-attempt2.out")));
		Scanner file = new Scanner(f);
		
		file.nextInt();
		System.out.println("Case #1: ");
		out.println("Case #1: ");
		
		int R = file.nextInt(); // Lines of subsets
		int N = file.nextInt(); // Num of Cards
		int M = file.nextInt(); // 2 - M
		int K = file.nextInt(); // Number of Products in each subset
		
		for (int r = 1; r <= R; r++)
		{
			int[] cards = new int[N];
			int cardI = 0;
			int[] prods = new int[K];
			
			for (int k = 0; k < K; k++)
			{
				prods[k] = file.nextInt();
				for (int i = 7; i >= 2; i--)
				{
					if (cardI == cards.length)
					{
						break;
					}
					else if (prods[k] % i == 0 && !contains(cards, i))
					{
						cards[cardI] = i;
						cardI++;
					}
				}
			}
			
			while (cardI < cards.length)
			{
				cards[cardI] = rand.nextInt(M - 1) + 2;
				cardI++;
			}
			
			for (int c : cards)
			{
				System.out.print(c);
				out.print(c);
			}
			System.out.println();
			out.println();
		}
		
		out.close();
		file.close();
		System.exit(0);
	}
	
	public static boolean contains(int[] cards, int i)
	{
		for (int c : cards)
		{
			if (c == i)
				return true;
		}
		return false;
	}
}
