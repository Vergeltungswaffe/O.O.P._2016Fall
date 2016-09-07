/*
2016-2 Object Oriented Programming HW1
Name: Kim, Jin Seol
ID: 2011133024
Major: Chemistry
Due date: 9/12/2016
 */
import java.util.*;

public class HW1
{

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int a, b;
        System.out.print("Enter an expression: ");
        String input = scan.nextLine();

        // exception related to character
        if (input.equals(""))
        {
            System.out.println("End of Program");
            return;
        }
        if (input.length() != 5 || input.charAt(1) != ' ' || input.charAt(3) != ' ')
        {
            System.out.println("Invalid expression");
            return;
        }
        try
        {
            a = Integer.parseInt(input.substring(0, 1));
            b = Integer.parseInt(input.substring(4, 5));
        }
        catch (NumberFormatException e)
        {
            System.out.println("Invalid expression");
            return;
        }
        // exception related to operand
        if ((a > 9 || a < 1) || (b > 9 || b < 1))
        {
            System.out.println("Operands must be a one digit natural number");
            return;
        }
        if (a <= b)
        {
            System.out.println("First number must be greater than the second number");
            return;
        }
        switch (input.charAt(2))
        {
            case '+':
                System.out.println(Integer.toString(a - b) + Integer.toString(a + b));
                break;
            case '-':
                System.out.println(Integer.toString(a + b) + Integer.toString(a - b));
                break;
            default:
                // exception related to operator
                System.out.println("Invalid expression");
        }
        scan.close();
    }
}
