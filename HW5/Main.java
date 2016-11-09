package hw5;

import java.util.LinkedList;
import java.util.Scanner;

/*************************************************************************
 * 2016-2 Object Oriented Programming HW5
 * Name: Kim, Jin Seol
 * ID: 2011133024
 * Major: Chemistry
 * Due date: 11/16/2016
 *************************************************************************/

public class Main {

	public static void main(String[] args) {
		
		int input, shapeInput, deleteInput;
		LinkedList<Shape> ll = new LinkedList<>();
		Scanner scan = new Scanner(System.in);
		
		while(true)
		{
			System.out.print("Insert(1), Delete(2), Display(3), Quit(4): ");
			try
			{
				input = scan.nextInt();
			}
			catch(Exception e)
			{
				printError();
				scan.next();
				continue;
			}
			switch(input)
			{
				case 1:
					System.out.print("Line(1), Rect(2), Circle(3): ");
					try
					{
						shapeInput = scan.nextInt();
					}
					catch(Exception e)
					{
						printError();
						scan.next();
						continue;
					}
					switch(shapeInput)
					{
						case 1:
							ll.add(new Line());
							break;
						case 2:
							ll.add(new Rect());
							break;
						case 3:
							ll.add(new Circle());
							break;
						default:
							printError();
					}
					break;
				case 2:
					System.out.print("Index to delete: ");
					try
					{
						deleteInput = scan.nextInt();
					}
					catch(Exception e)
					{
						printError();
						scan.next();
						continue;
					}
					try
					{
					ll.remove(deleteInput);
					}
					catch(Exception e)
					{
						printError();
					}
					break;
				case 3:
					for(int i=0;i<ll.size();i++)
					{
						ll.get(i).display();
					}
					break;
				case 4:
					scan.close();
					return;
				default:
					printError();
			}
		}
	}
	
	static void printError()
	{
		System.out.println("Invalid input");
	}

}
