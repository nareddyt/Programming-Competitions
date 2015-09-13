import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class Bullesye
{
	public static void main(String[] args) throws IOException
	{
		File f = new File("A-large.in");
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("A-large.out")));
		Scanner file = new Scanner(f);
		BigInteger count = new BigInteger("0");
		
		int num = file.nextInt();
		
		for (int i = 0; i < num; i++)
		{
			BigInteger start = new BigInteger(file.next());
			BigInteger t = new BigInteger(file.next());
			BigInteger total = new BigInteger("0");
			count = new BigInteger("0");
			
			if (i < 2016)
			{
				for (BigInteger r = new BigInteger(start.add(new BigInteger("1")).toString()); total.compareTo(t) <= 0; r = r
						.add(new BigInteger("2")))
				{
					BigInteger temp = new BigInteger(r.toString());
					total = total.add(temp.multiply(temp));
					temp = temp.subtract(new BigInteger("1"));
					total = total.subtract(temp.multiply(temp));
					if (total.compareTo(t) > 0)
					{
						break;
					}
					count = count.add(new BigInteger("1"));
				}
			}
			out.println("Case #" + (i + 1) + ": " + count);
			System.out.println("Case #" + (i + 1) + ": " + count);
		}
		
		file.close();
		out.close();
		System.exit(0);
	}
}
