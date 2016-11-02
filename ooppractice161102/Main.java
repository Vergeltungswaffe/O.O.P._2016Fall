package ooppractice;

public class Main {

	public static void main(String[] args) {
		
		Person kim = new Person("김사람", 1);
		Student lee = new Student("이학생", 21, "연세대", 20161101);
		GradStudent park = new GradStudent("박원생", 26, "연세대", 20109999, GradStudent.MASTER);
		
		kim.introduce();
		kim.whatICanDo();
		System.out.println();

		lee.introduceSchool();
		lee.whatICanDo();
		System.out.println();

		park.introduceGradSchool();
		park.whatICanDo();
		System.out.println();
		
		System.out.println("*****************");
		Person[] list = new Person[3];
		list[0] = kim;
		list[1] = lee;
		list[2] = park;
		for(Person p : list)
		{
			print(p);
		}
		
	}
	
	static void print(Person person)
	{
		String job = "";
		if(person instanceof GradStudent)
		{
			job = "대학원생";
		}
		else if(person instanceof Student)
		{
			job = "학부생";
		}
		else if(person instanceof Person)
		{
			job = "없음";
		}
		System.out.println("이름: "+person.getName());
		System.out.println("나이: "+person.getYear());
		System.out.println("직업: "+job);
		person.whatICanDo();
		System.out.println();
	}

}
