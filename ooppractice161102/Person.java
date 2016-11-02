package ooppractice;

public class Person {
	
	private String name;
	private int year;
	
	public Person(String name, int year)
	{
		this.name = name;
		this.year = year;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getYear()
	{
		return year;
	}
	
	public void introduce()
	{
		System.out.println("제 이름은 "+name+"이고 나이는 "+year+"살 입니다.");
	}
	
	public void whatICanDo()
	{
		System.out.println("저는 먹고 자고 할 수 있습니다.");
	}
}
