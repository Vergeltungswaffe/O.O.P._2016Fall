package OOPhw4;

import java.util.Scanner;

/*************************************************************************
 * 2016-2 Object Oriented Programming HW4
 * Name: Kim, Jin Seol
 * ID: 2011133024
 * Major: Chemistry
 * Due date: 11/2/2016
 *************************************************************************/

public class Theater
{
    private static final int row = 5;
    private static final int column = 9;

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        SeatMap seatsMap = new SeatMap(row,column);
        String input;
        seatsMap.showMap();
        System.out.print("(R)eserve, (V)iew, (C)ancel, (Q)uit: ");
        while(scan.hasNext())
        {
            input = scan.next();
            switch (input.toLowerCase())
            {
                case "r":
                    seatsMap.reserve();
                    break;
                case "v":
                    seatsMap.view();
                    break;
                case "c":
                    System.out.print("Name: ");
                    seatsMap.cancel(scan.next());
                    break;
                case "q":
                    scan.close();
                    return;
            }
            System.out.println();
            seatsMap.showMap();
            System.out.print("(R)eserve, (V)iew, (C)ancel, (Q)uit: ");
        }

    }

}
