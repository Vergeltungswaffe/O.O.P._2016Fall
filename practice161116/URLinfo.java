package practice;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;
/*
public class URLinfo {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a url: ");
		while(scan.hasNext())
		{
			//http://www.kma.go.kr/weather/images/rader_integrate.jsp?tm=2016.11.15.12%3A30&x=10&y=12&timeTerm=10&zoom_level=0&zoom_x=0000000&zoom_y=0000000&level=C&dtm=
			StringTokenizer st = new StringTokenizer(scan.nextLine(), ":/\\?=&");
			System.out.println("Protocol: \t" + st.nextToken());
			
			System.out.println("Domain name: \t" + st.nextToken());
			System.out.println();
			System.out.println("Variable\tValue");
			finder(st, "tm");
			finder(st, "x");
			finder(st, "y");
			finder(st, "timeTerm");
			finder(st, "zoom_level");
			finder(st, "zoom_x");
			finder(st, "zoom_y");
			finder(st, "level");
			finder(st, "dtm");
			
			System.out.print("\nEnter a url: ");
		}
		scan.close();
	}
	
	static void finder(StringTokenizer st, String str)
	{
		while(!st.nextToken().equals(str))
		{
		}
		try{
		System.out.println(str+":\t"+ st.nextToken());
		}
		catch(NoSuchElementException e)
		{
			System.out.println(str+":\tnull");
		}
	}

}
*/

public class URLinfo {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a url: ");
		while(scan.hasNext())
		{
			StringTokenizer st = new StringTokenizer(scan.nextLine(), "\\?");
			String[] domain = st.nextToken().split("/");
			String[] query = st.nextToken().split("&");
			
		}
	}

}
