import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * ID: nareddyt
 * LANG: JAVA
 * TASK: scode
 */

public class scodeDraft
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("scode.txt"));
		// PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("scode.out")));
		String code = f.readLine();
		
		int count = 0;
		count = breakStr(code, count);
		
		System.out.println(count + 2);
		f.close();
		System.exit(0);
	}
	
	public static int breakStr(String s, int c)
	{
		int l = s.length();
		if (l > 2)
			return breakStr(s.substring(0, l / 2 + 1), c) + breakStr(s.substring(l / 2, l), c);
		return ++c;
	}
}
