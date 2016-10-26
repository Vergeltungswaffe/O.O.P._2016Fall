package ooppractice;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in= new Scanner(System.in);
		String direction;
		//map에 공 객체들을 생성
		Map map = new Map(5, 10);
		map.set_ball(0, 0, 0);
		map.set_ball(0, 5, 2);
		map.set_ball(2, 4, 5);
		map.set_ball(4, 8, 1);
		
		map.display_map();
		System.out.print("Up(w) Left(a) Down(s) Right(d): ");
		while(in.hasNext()) {
			direction = in.nextLine();
			//사용자는 0,0 위치의 공을 wasd키로 움직인다
			map.move_ball(direction);
			map.display_map();
			System.out.print("Up(w) Left(a) Down(s) Right(d): ");
		}
		in.close();

	}

}