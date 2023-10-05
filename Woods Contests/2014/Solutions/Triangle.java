
import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

			//change the class name
public class Triangle
{
	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("triangle.dat"));
		
		int h = file.nextInt();
		
		for(int asdf =0; asdf < h; asdf++){
			
		int p = file.nextInt();
		for(int i = 0; i < p; i++){
			addspace(i);
			addchar((p-i) *2);
			System.out.println();
		}
		
			
		}
	
	}
	public void addchar(int a){
		for(int i =0; i  < a;i++)
			System.out.print(".");
	}
	public void addspace(int a){
		for(int i =0; i <= a;i++){
			System.out.print(" ");
		}
		
	}

	public static void main(String[] args) throws Exception
	{
			//change this to whatever your class name is
		new Triangle().run();
	}	
	
}