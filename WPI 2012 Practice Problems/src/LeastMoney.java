// Teju Nareddy, 12/24/12

import java.util.*;

public class LeastMoney
{
	public static Scanner console = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		String input = console.nextLine();
		input = input.substring(1);
		
		double money = Double.valueOf(input);
		
		int d1 = 0;
		int c50 = 0;
		int c25 = 0;
		int c10 = 0;
		int c5 = 0;
		int c1 = 0;
		
		while (money > 0.99)
		{
			d1++;
			money -= 1;
		}
		while (money > .49)
		{
			c50++;
			money -= .50;
		}
		while (money > .24)
		{
			c25++;
			money -= .25;
		}
		while (money > .09)
		{
			c10++;
			money -= .10;
		}
		while (money > .045)
		{
			c5++;
			money -= .05;
		}
		while (money > .005)
		{
			c1++;
			money -= .01;
		}
		
		System.out.println(getPlural(d1, "dollar"));
		System.out.println(getPlural(c50, "half-dollar"));
		System.out.println(getPlural(c25, "quarter"));
		System.out.println(getPlural(c10, "dime"));
		System.out.println(getPlural(c5, "nickel"));
		System.out.println(getPlural(c1, "penny"));
	}
	
	public static String getPlural(int amount, String type)
	{
		if (amount > 1)
		{
			if (type.equals("penny"))
				return amount + " " + type.substring(0, type.length() - 1) + "ies";
			else
				return amount + " " + type + "s";
		}
		else
			return amount + " " + type;
	}
}
