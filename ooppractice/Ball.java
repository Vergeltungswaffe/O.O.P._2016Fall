package ooppractice;

//access modifier�� �ݵ�� public�� private �� �ϳ��� ����Ѵ�
//�� �ʵ�� ��� private
public class Ball {
	private int number;
	private static int num_balls = 0;
	
	public Ball(int number)
	{
		this.number = number;
		num_balls++;
	}
	
	public void add_number(int number) // ���� ���� ����
	{
		this.number += number;
	}
	
	public static void decrease_ball() //��ü ���� ������ 1�� ����
	{
		num_balls--;
	}
	
	public static int get_num_ball() //��ü ���� ������ ��ȯ
	{
		return num_balls;
	}
	
	public int get_number() // ���� ���� ��ȯ
	{
		return number;
	}
}
