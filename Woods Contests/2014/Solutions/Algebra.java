/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

//
public class Algebra
{
        private char[][] mat;
	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("algebra.dat"));
		
			//read in the number at the top of the data file
		int times = file.nextInt(); 
			//pick up the left over enter key
		file.nextLine();
		
			//read in each data set
		for(int asdf = 0; asdf<times; asdf++)
		{
                    // y = mx + b
                    int size = file.nextInt();
                    mat = new char[size+1][size+1];
                    for(int r = 0;r<mat.length;r++){
                        for(int c = 0;c<mat[r].length;c++){
                            if(r==size||c==0){
                                mat[r][c] = '#';
                            }
                            else{
                                mat[r][c] = '.';
                            }
                        }
                    }
                    for(int z = file.nextInt();z>0;z--){
                        int x = file.nextInt();
                        int y = file.nextInt();
                        this.setcoordinate(x, y, size);
                    }
                    for(char[] asd : mat){
                        for(char c : asd){
                            System.out.print(c);
                        }
                        System.out.println();
                    }
		}
                //System.out.println();
                
	}
        public void setcoordinate(int x , int y,int size){
           mat[size-y][x] = '#';
        }

	public static void main(String[] args) throws Exception
	{
			//change this to whatever your class name is
		new Algebra().run();
	}	
	
}