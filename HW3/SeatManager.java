package hw3_2;

/*************************************************************************
 * 2016-2 Object Oriented Programming HW3-2
 * Name: Kim, Jin Seol
 * ID: 2011133024
 * Major: Chemistry
 * Due date: 10/7/2016
 *************************************************************************/

import java.io.*;
import java.util.*;

public class SeatManager
{

    public static void main(String[] args) throws IOException
    {
    	/* For Test */
    	//Scanner scan = new Scanner(System.in);
    	
    	Scanner scan = new Scanner(new File("c:/oop/hw3_2.txt"));
        System.out.println("***극장 예약 시스템에 오신것을 환영합니다(극장 관리자용 ver 1.0)***");
        System.out.println("***관리자님 어서오세요***\n");
        int m = scan.nextInt();
        int n = scan.nextInt();
        int reservedSeats =0;
        char[][] seats = new char[m][n];
        // initialize 'seats'
        for(int i=0;i<m;i++)
    	{
    		for(int j=0;j<n;j++)
    			seats[i][j]='O';
    	}
        while(true)
        {
        	printSeats(seats);
        	char menu;
        	System.out.println("명령을 선택하세요. 예약(R), 취소(C), 통계(S), 종료(Q): ");
        	String temp = scan.next();
        	if(temp.length()>1) // Input length exception: more than 1 character
        	{
        		System.out.println("올바르지 않은 입력입니다.");
        		continue;
        	}
        	menu = temp.charAt(0);
        	int inputRow =0;
        	int inputCol =0;
        	switch(menu)
        	{
        	case 'r':
        	case 'R':
        		System.out.println("행을 입력하세요: ");
        		inputRow = scan.nextInt();
        		System.out.println("열을 입력하세요: ");
        		inputCol = scan.nextInt();
        		if(seats[inputRow][inputCol]=='X')
        		{
        			System.out.println("이미 예약된 좌석입니다.");
        			break;
        		}
        		else
        		{
        			seats[inputRow][inputCol] = 'X';
        			reservedSeats++;
        			System.out.println("성공: ["+inputRow+","+inputCol+"] 위치에 예약되었습니다.");
        			break;
        		}
        	case 'c':
        	case 'C':
        		System.out.println("행을 입력하세요: ");
        		inputRow = scan.nextInt();
        		System.out.println("열을 입력하세요: ");
        		inputCol = scan.nextInt();
        		if(seats[inputRow][inputCol]=='O')
        		{
        			System.out.println("예약이 되어있지 않은 좌석입니다.");
        			break;
        		}
        		else
        		{
        			seats[inputRow][inputCol] = 'O';
        			reservedSeats--;
        			System.out.println("성공: ["+inputRow+","+inputCol+"] 위치의 예약이 취소되었습니다.");
        			break;
        		}
        	case 's':
        	case 'S':
        		System.out.println("총 "+m*n+"자리 중 예약된 자리는 "+reservedSeats+"개 입니다.");
        		System.out.printf("예약률은 %.1f%% 입니다.\n", (double)reservedSeats*100/(double)(m*n));
    			break;
        	case 'q':
        	case 'Q':
        		System.out.println("예약 시스템을 종료합니다...");
        		scan.close();
        		return;
        	default:
        		System.out.println("올바르지 않은 입력입니다.");
        	}
        }
        
    }
    
    private static void printSeats(char[][] arr)
    {
    	for(int i=0;i<arr.length;i++)
    	{
    		for(int j=0;j<arr[0].length;j++)
    			System.out.print(arr[i][j]);
    		System.out.println();
    	}
    }
}