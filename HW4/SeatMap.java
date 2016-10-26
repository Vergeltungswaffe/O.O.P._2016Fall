package OOPhw4;

import java.util.Scanner;

/*************************************************************************
 * 2016-2 Object Oriented Programming HW4
 * Name: Kim, Jin Seol
 * ID: 2011133024
 * Major: Chemistry
 * Due date: 11/2/2016
 *************************************************************************/

public class SeatMap
{
    private Seat[][] seats;
    private int numRow;
    private int numColumn;
    static private int numReserved;

    public SeatMap(int row, int column)
    {
        numRow = row;
        numColumn = column;
        seats = new Seat[row][column];
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<column;j++)
            {
                seats[i][j]=new Seat(null);
            }
        }
        numReserved =0;
    }

    public void reserve()
    {
        if(numReserved==numRow*numColumn)
        {
            System.out.println("All seats are occupied.");
            return;
        }
        Scanner scan = new Scanner(System.in);
        String name;
        int numSeats;
        int row, column;
        System.out.print("Name: ");
        name = scan.nextLine();
        System.out.print("How many seats: ");
        numSeats = scan.nextInt();
        System.out.print("Seat row symbol: ");
        row = scan.next().toLowerCase().charAt(0) -'a';
        System.out.print("Seat col number: ");
        column = scan.nextInt()-1;
        if(numSeats>numColumn-column)
        {
            System.out.println("Cannot reserve seats continuously.");
            return;
        }
        for(int i=0;i<numSeats;i++)
        {
            if(seats[row][column+i].isOccupied())
            {
                System.out.println("Already occupied seat(s).");
                return;
            }
        }
        for(int i=0;i<numSeats;i++)
        {
            seats[row][column++].setName(name);
            numReserved++;
        }
    }

    public void view()
    {
        int count =1;
        for(int i=0;i<numRow;i++)
        {
            for(int j=0;j<numColumn;j++)
            {
                if(seats[i][j].isOccupied())
                {
                    System.out.println((count++)+": "+(char)(i+'A')+""+(j+1)+", "+seats[i][j].getName());
                }
            }
        }
    }

    public void cancel(String name)
    {
        for(int i=0;i<numRow;i++)
        {
            for(int j=0;j<numColumn;j++)
            {
                if(seats[i][j].match(name))
                {
                    seats[i][j].cancel();
                    numReserved--;
                }
            }
        }
    }

    public void showMap()
    {
        System.out.println("****** Theater Reservation System ******");
        System.out.print("   ");
        for(int i =1;i<=numColumn;i++)
        {
            System.out.print(i+"  ");
        }
        System.out.println();

        for(int i=0;i<numRow;i++)
        {
            System.out.print((char)(i+'A')+":");
            for(int j=0;j<numColumn;j++)
            {
                if(seats[i][j].isOccupied())
                {
                    System.out.print("[O]");
                }
                else
                {
                    System.out.print("[ ]");
                }
            }
            System.out.println();
        }
    }
}
