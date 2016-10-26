package ooppractice;

//access modifier는 반드시 public과 private 중 하나를 사용한다
//단 필드는 모두 private
public class Map {
	private Ball map[][]; // 공이 배치될 맵
	private int row, col; // 사용자가 조종하는 공의 좌표
	
	public Map(int row, int col) // 맵의 크기를 인자로 받아 맵 생성
	{
		map = new Ball[row][col];
		this.row = 0;
		this.col = 0;
	}
	
	public Ball get_ball(int row, int col) // 좌표에 있는 공을 반환. 공이 없으면 null 반환
	{
		return map[row][col];
	}
	
	public void set_ball(int row, int col, int number) // 좌표에 number 값을 가지는 공을 생성
	{
		map[row][col] = new Ball(number);
	}
	
	public void merge_ball(Ball current, Ball target) //current공이 target공의 값을 흡수(누적) 
	{
		if(target!=null)
		{
			current.add_number(target.get_number());
			Ball.decrease_ball();
		}
	}
	public void display_map()  // 맵 출력 
	{
		System.out.println();
		for(Ball row[]:map) {
			for(Ball ball:row) {
				if (ball!=null)
					System.out.print(ball.get_number());
				else
					System.out.print(".");
			}
			System.out.println();
		}
		System.out.println("Ball left: " + Ball.get_num_ball());
	}
	
	void move_ball(int newRow, int newCol) // 공을 인자로 받은 좌표로 이동시키며 이동 위치에 다른 공이 있으면 값을 누적
	{
		merge_ball(get_ball(row,col), get_ball(newRow,newCol));
		map[newRow][newCol] = map[row][col];
		map[row][col] = null;
		row = newRow;
		col = newCol;
	}
	
	void move_ball(String direction) // 키보드 값으로 공을 이동 시킴 
	{ 
		switch (direction.toLowerCase()) {
		case "w":
			move_ball(row-1, col);
			break;
		case "a":
			move_ball(row, col-1);
			break;
		case "s":
			move_ball(row+1, col);
			break;
		case "d":
			move_ball(row, col+1);
			break;
		}
	}
}
