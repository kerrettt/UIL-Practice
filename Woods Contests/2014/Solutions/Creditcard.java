//Expression project.licensePath is undefined on line 4, column 14 in Templates/Classes/Class_1.java.import java.util.*;
import java.util.Scanner;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

//
public class Creditcard
{
	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("creditcard.dat"));
		long time = System.currentTimeMillis();
		//file.useDelimiter(".");
			//read in the number at the top of the data file
                double number = 0;
                double total = 0;
		while(file.hasNext()){
                    String str = file.next();
                    if(this.luhnTest(str)){
                    
                    //  long x  = Long.parseLong(str);
                      number++;
                      System.out.println(str);
                      System.out.println(number);
                    }
                    total++;
                }
                System.out.printf("%.2f",(number/total)*100);
                System.out.print("%\n");
               // System.out.println((System.currentTimeMillis()-time)/1000.0);
               
	}
				
       public static boolean luhnTest(String number){
        int s1 = 0, s2 = 0;
        String reverse = new StringBuffer(number).reverse().toString();
        for(int i = 0 ;i < reverse.length();i++){
            int digit = Character.digit(reverse.charAt(i), 10);
            if(i % 2 == 0){//this is for odd digits, they are 1-indexed in the algorithm
                s1 += digit;
            }else{//add 2 * digit for 0-4, add 2 * digit - 9 for 5-9
                s2 += 2 * digit;
                if(digit >= 5){
                    s2 -= 9;
                }
            }
        }
        return (s1 + s2) % 10 == 0;
    }
	public static void main(String[] args) throws Exception
	{
			//change this to whatever your class name is
		
		try{
			new Creditcard().run();
		}
		finally{
		//	System.out.println(Long.MAX_VALUE);
		}
	}	
	
}