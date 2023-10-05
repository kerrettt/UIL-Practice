import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;
public class prob4{
	public static void main(String[] args) throws Exception{
		new prob4().run();
	}
	public void run() throws Exception{
		Scanner file = new Scanner(new File("in4.txt"));
		int times = file.nextInt(); file.nextLine();
		for(int asdf = 0; asdf<times; asdf++){
			double petespd = file.nextDouble();
			double petedist = file.nextDouble();
			double trainspd = file.nextDouble();
			double traindist = file.nextDouble();
			double pete = petedist/petespd;
			double train = traindist/trainspd;
			if(train<=pete)
				System.out.println("No");
			else
				System.out.println("Yes");
		}
	}
}