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
		System.out.println("�� �̸��� "+name+"�̰� ���̴� "+year+"�� �Դϴ�.");
	}
	
	public void whatICanDo()
	{
		System.out.println("���� �԰� �ڰ� �� �� �ֽ��ϴ�.");
	}
}
