package ooppractice;

public class Main {

	public static void main(String[] args) {
		
		Person kim = new Person("����", 1);
		Student lee = new Student("���л�", 21, "������", 20161101);
		GradStudent park = new GradStudent("�ڿ���", 26, "������", 20109999, GradStudent.MASTER);
		
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
			job = "���п���";
		}
		else if(person instanceof Student)
		{
			job = "�кλ�";
		}
		else if(person instanceof Person)
		{
			job = "����";
		}
		System.out.println("�̸�: "+person.getName());
		System.out.println("����: "+person.getYear());
		System.out.println("����: "+job);
		person.whatICanDo();
		System.out.println();
	}

}
