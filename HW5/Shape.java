package hw5;

/*************************************************************************
 * 2016-2 Object Oriented Programming HW5
 * Name: Kim, Jin Seol
 * ID: 2011133024
 * Major: Chemistry
 * Due date: 11/16/2016
 *************************************************************************/

public abstract class Shape {

	public abstract void display();
	
}

class Line extends Shape
{

	@Override
	public void display() {
		System.out.println("Line");
	}
	
}

class Rect extends Shape
{

	@Override
	public void display() {
		System.out.println("Rect");
	}
	
}

class Circle extends Shape
{

	@Override
	public void display() {
		System.out.println("Circle");
	}
	
}