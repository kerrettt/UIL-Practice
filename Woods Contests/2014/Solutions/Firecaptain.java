import java.io.*;
import java.util.*;
import java.text.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Character.*;
import static java.util.Collections.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;

public class Firecaptain {
        	private String[] abc;
        	private ArrayList<String> s,ss;
        	private ArrayList<Integer> r;
       public void run()throws Exception 
       { Scanner file = new Scanner(new File("firecaptain.dat"));
         int run = file.nextInt();
         boolean flag = false;
         for (int i=0;i<run;i++)
         {	
         	 s = new ArrayList<String>();
         	 r = new ArrayList<Integer>();
         	 ss = new ArrayList<String>();
         	
        
         	
         	if (!flag)
         	{file.nextLine();
         	 flag = true;
         	}
         
         	int ind =0;
         	boolean flag2 = false;
         	while (ind <3)
         	{	Scanner scan = new Scanner(file.nextLine());
         		if (!flag2)
         			{while(scan.hasNext())
         				s.add(scan.next());
         			}
         		if (ind==1)
         			{while(scan.hasNextInt())
         				r.add(scan.nextInt());
         			}
         		if (flag2 && ind==2)
         			{while(scan.hasNext())
         				ss.add(scan.next());
         			}
         		flag2 = true;
         		ind++;	
         	}
         System.out.println(compare(s,ss));
         	
        
         	
         			if (!(i+1==run))
         			file.nextLine();
         }
       	
       	}
       	public ArrayList<Integer> compare(ArrayList<String> a,ArrayList<String> b)
       	{   ArrayList<Integer> rr =new ArrayList<Integer>();
       		int j=0;
       		if (ss.size()==0)
       			return r;
       		for (int i=0;i<a.size();i++)
       		{ 
       			if (j<b.size() && !a.get(i).equals(b.get(j)))
       			{rr.add(r.get(i));
       			 
       			}
       			else if (j<a.size() && j>=b.size())
       				rr.add(r.get(i));
       			else j++;
       		}
       		return rr;
       	}
       
       	
       	
       	public static void main(String[] args)throws Exception
       	{Firecaptain a= new Firecaptain();
       	a.run();
       	}
       	}
       
    

