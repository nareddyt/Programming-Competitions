// Teju Nareddy, 4/12/13

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FairAndSquare
{
	public static void main(String[] args) throws IOException, InterruptedException
	{
		File f = new File("C-large-1.in");
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C-large-1.out")));
		Scanner file = new Scanner(f);
		
		long[] squares = new long[10000000];
		for (int i = 0; i < squares.length; i++)
		{
			squares[i] = i * i;
		}
		System.out.println("DONE");
		long cases = file.nextLong();
		for (long i = 1; i <= cases; i++)
		{
			long min = file.nextLong();
			long max = file.nextLong();
			
			long count = 0;
			int index = 0;
			for (int c = 105000; c < squares.length; c++)
			{
				if (squares[c] > min)
				{
					index = c;
					break;
				}
			}
			System.out.println(index);
			for (long a = min; a <= max; a++)
			{
				int last = (int) (a % 10);
				if (last == 1 || last == 4 || last == 5 || last == 6 || last == 9 || a % 100 == 0)
				{
					int dRoot = getDigitalRoot(a);
					if (dRoot == 1 || dRoot == 4 || dRoot == 7 || dRoot == 9)
					{
						long k = squares[index];
						System.out.println(k + " " + a);
						Thread.sleep(1000);
						if (k > -1 && isPal(a) && isPal(index))
						{
							count++;
							index++;
							System.out.println("FOUND");
						}
					}
				}
			}
			
			out.println("Case #" + i + ": " + count);
			System.out.println("Case #" + i + ": " + count);
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
	
	public static int getDigitalRoot(long a)
	{
		int sum = 0;
		int fSum = 0;
		for (; a != 0; a /= 10)
		{
			sum += a % 10;
		}
		if (sum > 9)
		{
			for (; sum != 0; sum /= 10)
			{
				fSum += sum % 10;
			}
		}
		else
		{
			fSum = sum;
		}
		
		return fSum;
	}
}
