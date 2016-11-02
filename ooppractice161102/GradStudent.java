package ooppractice;

public class GradStudent extends Student{

	public static final int MASTER = 0;
	public static final int PHD = 1;
	private int degree;
	private String[] degree_type = {"석사과정", "박사과정"};
	
	public GradStudent(String name, int year, String schoolName, int id, int degree)
	{
		super(name, year, schoolName, id);
		this.degree = degree;
	}
	
	public String getDegree()
	{
		return degree_type[degree];
	}
	
	public void introduceGradSchool()
	{
		introduceSchool();
		System.out.println(degree_type[degree]+"생 입니다.");
	}
	
	public void whatICanDo()
	{
		System.out.println("저는 연구를 할 수 있습니다!");
	}

}
