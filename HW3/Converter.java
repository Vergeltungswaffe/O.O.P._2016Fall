
import java.text.DecimalFormat;
import java.util.*;

public class Main
{
    private static final double CMtoINCH = 0.393701;
    private static final double INCHtoCM = 2.54;
    private static final double KGtoPOUND = 2.20462;
    private static final double POUNDtoKG = 0.453592;

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        do
        {
            System.out.println("Unit Converter");
            System.out.println("1. cm -> inch");
            System.out.println("2. inch -> cm");
            System.out.println("3. kg -> pound");
            System.out.println("4. pound -> kg");
            System.out.println("5. C(Celsius) -> F(Fahrenheit)");
            System.out.println("6. F(Fahrenheit) -> C(Celsius)");
            System.out.println("7. EXIT");
            System.out.print("Select menu>> ");
            int menuSelect = scan.nextInt();
            double input;
            double output =0;
            String toUnit = null;
            switch (menuSelect)
            {
                case 1:
                    toUnit = "inch";
                    System.out.print("input cm>> ");
                    input = scan.nextDouble();
                    output = input*CMtoINCH;
                    break;
                case 2:
                    toUnit = "cm";
                    System.out.print("input inch>> ");
                    input = scan.nextDouble();
                    output = input*INCHtoCM;
                    break;
                case 3:
                    toUnit = "pound";
                    System.out.print("input kg>> ");
                    input = scan.nextDouble();
                    output = input*KGtoPOUND;
                    break;
                case 4:
                    toUnit = "kg";
                    System.out.print("input pound>> ");
                    input = scan.nextDouble();
                    output = input*POUNDtoKG;
                    break;
                case 5:
                    toUnit = "F";
                    System.out.print("input C(Celsius)>> ");
                    input = scan.nextDouble();
                    output = ((input*9)/5)+32;
                    break;
                case 6:
                    toUnit = "C";
                    System.out.print("input F(Fahrenheit>> ");
                    input = scan.nextDouble();
                    output = ((input-32)*5)/9;
                    break;
                case 7:
                    System.out.println("Exit.");
                    return;
                default:
                    System.out.println("wrong input");
                    continue;
            }
            DecimalFormat df = new DecimalFormat("#.00");
            System.out.println("result is "+df.format(output)+toUnit+".\n");
        }while(scan.hasNext());
        scan.close();
    }
}
