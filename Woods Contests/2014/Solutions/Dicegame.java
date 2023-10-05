import java.io.*;
import java.util.*;

public class Dicegame
{
	//instance variables go here
	
	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("dicegame.dat"));
		int run=file.nextInt();
		file.nextLine();
		for(int q=0; q<run; q++)
		{
			TreeMap<Integer,Integer> mp=new TreeMap<Integer,Integer>();
			for(int i=0; i<3; i++)
			{
				String[] sid=file.nextLine().split(":");
				int a=Integer.parseInt(sid[0]), b=Integer.parseInt(sid[1]);
				mp.put(a,b);
				mp.put(b,a);
			}
			int zz=file.nextInt();file.nextLine();
			int tot=0;
			for(int qwe=0; qwe<zz; qwe++)
			{
				String die="";
				for(int i=0; i<5; i++)
				{
					die+=file.nextLine();
				}
				die=die.replaceAll("[^\\*]","");
				tot+=mp.get(die.length());
			}
			System.out.println(tot);
		}
	}
	
	public static void main(String[] args)throws Exception
	{
		Dicegame a=new Dicegame();
		a.run();
	}	
}