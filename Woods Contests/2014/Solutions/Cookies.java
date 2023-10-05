import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

			//change the class name
public class Cookies
{
	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("cookies.dat"));
		
			//read in the number at the top of the data file
		int times = file.nextInt(); 
			//pick up the left over enter key
		file.nextLine();
		
			//read in each data set
		for(int asdf = 0; asdf<times; asdf++)
		{
			int M = file.nextInt();
			int C = file.nextInt();boolean check = true;
			if(C == 0)
				check = false;
			int stat = C;
			int T = file.nextInt();
			int out = 0;
			if(T>4 && C > M)
			{
				T = T-5;
				C -= M;
				out += M;
			}
			else if (T>4 && check)
			{
				out += C;
				C = 0;
			}
			while(C>0 && T>9 && check)
			{
				if(M>C)
				{
					out += C;
					C = 0;
				}
				else
				{
					T-=10;
					out += M;
					C -= M;
				}
				
			}
			if(!check)System.out.println("So hungry!");
			if(out == stat && check)
			{
				System.out.println("All of them!");
			}
			else if(check) System.out.println(out);
		}
	}

	public static void main(String[] args) throws Exception
	{
			//change this to whatever your class name is
		new Cookies().run();
	}	
	
}