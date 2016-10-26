package ooppractice;

//access modifier�� �ݵ�� public�� private �� �ϳ��� ����Ѵ�
//�� �ʵ�� ��� private
public class Map {
	private Ball map[][]; // ���� ��ġ�� ��
	private int row, col; // ����ڰ� �����ϴ� ���� ��ǥ
	
	public Map(int row, int col) // ���� ũ�⸦ ���ڷ� �޾� �� ����
	{
		map = new Ball[row][col];
		this.row = 0;
		this.col = 0;
	}
	
	public Ball get_ball(int row, int col) // ��ǥ�� �ִ� ���� ��ȯ. ���� ������ null ��ȯ
	{
		return map[row][col];
	}
	
	public void set_ball(int row, int col, int number) // ��ǥ�� number ���� ������ ���� ����
	{
		map[row][col] = new Ball(number);
	}
	
	public void merge_ball(Ball current, Ball target) //current���� target���� ���� ���(����) 
	{
		if(target!=null)
		{
			current.add_number(target.get_number());
			Ball.decrease_ball();
		}
	}
	public void display_map()  // �� ��� 
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
	
	void move_ball(int newRow, int newCol) // ���� ���ڷ� ���� ��ǥ�� �̵���Ű�� �̵� ��ġ�� �ٸ� ���� ������ ���� ����
	{
		merge_ball(get_ball(row,col), get_ball(newRow,newCol));
		map[newRow][newCol] = map[row][col];
		map[row][col] = null;
		row = newRow;
		col = newCol;
	}
	
	void move_ball(String direction) // Ű���� ������ ���� �̵� ��Ŵ 
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
