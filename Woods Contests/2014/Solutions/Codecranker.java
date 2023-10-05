/**
 * @(#)Codecranker.java
 *
 *
 * @author 
 * @version 1.00 2014/10/20
 */
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

public class Codecranker {
    	
    public void run() throws Exception
    {
    		Scanner file=new Scanner(new File("codecranker.dat"));
    		int run=file.nextInt();
    		file.nextLine();
    		for(int i=0;i<run;i++){
    			
    			int sum=0;
    			for(int x=0;x<3;x++){
    			  sum+=(file.nextInt()*2);
    			}
    			int need=630-sum;
    			if(need>=110)
    				System.out.println(need+" SHOULD HAVE CRANKED HARDER IN CLASS");
    			else if(need>100&&need<110)
    				System.out.println(need+" TIME TO BEG FOR BONUS");
    			else if(need<=40)
    			{
    				System.out.println(need + " 0");
    			}
    			else{
    				int study=need-40;
    				study/=4;
    				study=study*study;
    				System.out.println(need+" "+study);
    			}
    		}
    }
    
    public static void main(String[]args)throws Exception
    {
    	Codecranker a=new Codecranker();
    	a.run();
    }  
}