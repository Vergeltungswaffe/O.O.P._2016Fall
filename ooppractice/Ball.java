package ooppractice;

//access modifier는 반드시 public과 private 중 하나를 사용한다
//단 필드는 모두 private
public class Ball {
	private int number;
	private static int num_balls = 0;
	
	public Ball(int number)
	{
		this.number = number;
		num_balls++;
	}
	
	public void add_number(int number) // 공의 값을 누적
	{
		this.number += number;
	}
	
	public static void decrease_ball() //전체 공의 개수를 1개 감소
	{
		num_balls--;
	}
	
	public static int get_num_ball() //전체 공의 개수를 반환
	{
		return num_balls;
	}
	
	public int get_number() // 공의 값을 반환
	{
		return number;
	}
}
