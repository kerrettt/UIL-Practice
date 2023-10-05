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

public class Pancakeoman {
    	
    public void run() throws Exception
    {
    		Scanner file=new Scanner(new File("pancakeoman.dat"));
    		int run=file.nextInt();
    		file.nextLine();
    		
    		for(int i=0;i<run;i++){	
    			double skill=0.0;
    			double road=5.0;
    			for(int x=file.nextInt()-2;x>0;x=x-2)
    				road*=3;
    			skill+=0.1*((double)(file.nextInt()));
    			skill+=0.3*((double)(file.nextInt()));
    			skill+=0.6*((double)(file.nextInt()));
    			
    			if(road>skill)
    				System.out.println("PANCAKE-O WAS PANCAKE-OED");
    			else
    				System.out.println("NOM NOM CUPCAKE");
    		}
    }
    
    public static void main(String[]args)throws Exception
    {
    	Pancakeoman a=new Pancakeoman();
    	a.run();
    }  
}