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
		System.out.println("학교는 "+schoolName+"이고 학번은 "+id+"입니다.");
	}
	
	public void whatICanDo()
	{
		System.out.println("저는 공부를 할 수 있습니다!");
	}

}
