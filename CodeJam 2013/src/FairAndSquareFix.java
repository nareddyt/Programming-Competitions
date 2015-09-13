// Teju Nareddy, 4/12/13

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FairAndSquareFix
{
	public static void main(String[] args) throws IOException
	{
		File f = new File("C-large-2.in");
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C-large-2.out")));
		Scanner file = new Scanner(f);
		
		int cases = file.nextInt();
		for (long i = 1; i <= cases; i++)
		{
			long min = file.nextLong();
			long max = file.nextLong();
			
			int count = 0;
			double stop = Math.sqrt(max);
			for (long a = (long) (Math.sqrt(min)); a <= stop; a++)
			{
				if (isPal(a))
				{
					long square = a * a;
					if (square >= min && square <= max && isPal(square))
					{
						count++;
					}
				}
			}
			
			System.out.println("Case #" + i + ": " + count);
			out.println("Case #" + i + ": " + count);
		}
		
		out.close();
		file.close();
		System.exit(0);
	}
	
	// Precondition: a is a positive integer
	public static boolean isPal(long a)
	{
		long temp = a;
		int length = 0;
		for (; temp != 0; temp /= 10) // gets number of digits in the number
		{
			length++;
		}
		
		if (length == 1)
			return true;
		
		temp = a;
		long[] num = new long[length];
		for (int i = num.length - 1; i >= 0; i--) // stores the digits in an array for easier use...
		{
			num[i] = temp % 10;
			temp /= 10;
		}
		
		for (int i = 0; i < num.length / 2; i++)
		{
			if (num[i] != num[num.length - i - 1])
				return false;
		}
		return true;
	}
}
