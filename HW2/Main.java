/*
2016-2 Object Oriented Programming HW2
Name: Kim, Jin Seol
ID: 2011133024
Major: Chemistry
Due date: 9/26/2016
 */
import java.util.*;

public class Main
{

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Input the capacity of storage in GB: ");
        int input = scan.nextInt();
        System.out.print("H/W manufacturer's capacity: "+input+"GB\n");
        System.out.print("Available capacity in S/W: "+((long)input*1000000000L>>30)+"GiB ");
        System.out.println("("+((long)input*1000000000L>>30<<30)+"bytes)");
        scan.close();
    }
}
