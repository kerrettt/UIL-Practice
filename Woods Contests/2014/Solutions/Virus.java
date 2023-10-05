import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class Virus
{
	public char[][] mat;
	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("virus.dat"));
		
		int times = file.nextInt();
		file.nextLine();
		mat = new char[10][10];
		
		for(int asdf = 0; asdf < times; asdf++)
		{
		  //fill maze
          for(int z = 0; z < mat.length; z++)
          {
        	mat[z] = file.nextLine().toCharArray();
          }
          
          //Get coords
          int days = file.nextInt();
          file.nextLine();
          
          ArrayList<Integer> xs = new ArrayList<Integer>();
          ArrayList<Integer> ys = new ArrayList<Integer>();
          
          for(int r = 0; r < mat.length; r++)
          {
          	for(int c  = 0; c < mat[r].length; c++)
          	{
          	  if(mat[r][c] == 'X')
          	  {
          	  	xs.add(r);
          	  	ys.add(c);
          	  }
          	}
          }
          
          //infect coords
          for(int i = 0; i < xs.size(); i++)
          {
          	infect(days+1,xs.get(i),ys.get(i));
          }
          
          //print
          for(char[] cc : mat)
          {
          	for(char c : cc)
          	{
          	  System.out.print(c);	
          	}
          	System.out.println();
          }
          
          System.out.println();
          			
		}
	}
	
	public void infect(int days,int r, int c)
	{
	  if(r >= 0 && r < mat.length && c >= 0 && c < mat[r].length && days > 0)
	  {
	  	mat[r][c] = 'X';
	  	infect(days - 1,r + 1,c);
	    infect(days - 1,r - 1,c);
	    infect(days - 1,r,c + 1);
	    infect(days - 1,r,c - 1);
	  }
	}

	public static void main(String[] args) throws Exception
	{
			//change this to whatever your class name is
		new Virus().run();
	}	
	
}