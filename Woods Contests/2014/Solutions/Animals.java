import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

			
public class Animals
{
	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("animals.dat"));
		int times = file.nextInt(); 
		file.nextLine();
		String usable = "";
		char first;
		for(int asdf = 0; asdf<times; asdf++)
		{
			usable = file.nextLine();
			first = usable.charAt(0);
			if (first >= 65 && first <= 77)
			{
				System.out.println("Cat");
			}
			
			if (first >= 78 && first <= 90)
			{
				System.out.println("Dog");
			}
		}
	}

	public static void main(String[] args) throws Exception
	{
		
		new Animals().run();
	}	
	
}