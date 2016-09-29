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
        System.out.println("***���� ���� �ý��ۿ� ���Ű��� ȯ���մϴ�(���� �����ڿ� ver 1.0)***");
        System.out.println("***�����ڴ� �������***\n");
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
        	System.out.println("����� �����ϼ���. ����(R), ���(C), ���(S), ����(Q): ");
        	String temp = scan.next();
        	if(temp.length()>1) // Input length exception: more than 1 character
        	{
        		System.out.println("�ùٸ��� ���� �Է��Դϴ�.");
        		continue;
        	}
        	menu = temp.charAt(0);
        	int inputRow =0;
        	int inputCol =0;
        	switch(menu)
        	{
        	case 'r':
        	case 'R':
        		System.out.println("���� �Է��ϼ���: ");
        		inputRow = scan.nextInt();
        		System.out.println("���� �Է��ϼ���: ");
        		inputCol = scan.nextInt();
        		if(seats[inputRow][inputCol]=='X')
        		{
        			System.out.println("�̹� ����� �¼��Դϴ�.");
        			break;
        		}
        		else
        		{
        			seats[inputRow][inputCol] = 'X';
        			reservedSeats++;
        			System.out.println("����: ["+inputRow+","+inputCol+"] ��ġ�� ����Ǿ����ϴ�.");
        			break;
        		}
        	case 'c':
        	case 'C':
        		System.out.println("���� �Է��ϼ���: ");
        		inputRow = scan.nextInt();
        		System.out.println("���� �Է��ϼ���: ");
        		inputCol = scan.nextInt();
        		if(seats[inputRow][inputCol]=='O')
        		{
        			System.out.println("������ �Ǿ����� ���� �¼��Դϴ�.");
        			break;
        		}
        		else
        		{
        			seats[inputRow][inputCol] = 'O';
        			reservedSeats--;
        			System.out.println("����: ["+inputRow+","+inputCol+"] ��ġ�� ������ ��ҵǾ����ϴ�.");
        			break;
        		}
        	case 's':
        	case 'S':
        		System.out.println("�� "+m*n+"�ڸ� �� ����� �ڸ��� "+reservedSeats+"�� �Դϴ�.");
        		System.out.printf("������� %.1f%% �Դϴ�.\n", (double)reservedSeats*100/(double)(m*n));
    			break;
        	case 'q':
        	case 'Q':
        		System.out.println("���� �ý����� �����մϴ�...");
        		scan.close();
        		return;
        	default:
        		System.out.println("�ùٸ��� ���� �Է��Դϴ�.");
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