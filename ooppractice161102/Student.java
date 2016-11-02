package ooppractice;

public class Student extends Person{
	
	private String schoolName;
	private int id;
	
	public Student(String name, int year, String schoolName, int id)
	{
		super(name, year);
		this.schoolName = schoolName;
		this.id = id;
	}
	
	public String getSchoolName()
	{
		return schoolName;
	}
	
	public int getID()
	{
		return id;
	}
	
	public void introduceSchool()
	{
		introduce();
		System.out.println("�б��� "+schoolName+"�̰� �й��� "+id+"�Դϴ�.");
	}
	
	public void whatICanDo()
	{
		System.out.println("���� ���θ� �� �� �ֽ��ϴ�!");
	}

}
