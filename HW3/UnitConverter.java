package hw3_1;

/*************************************************************************
 * 2016-2 Object Oriented Programming HW3-1
 * Name: Kim, Jin Seol
 * ID: 2011133024
 * Major: Chemistry
 * Due date: 10/7/2016
 *************************************************************************/

import java.text.DecimalFormat;
import java.util.*;
import java.io.*;


public class UnitConverter
{
    private static final double CMtoINCH = 0.393701;
    private static final double INCHtoCM = 2.54;
    private static final double KGtoPOUND = 2.20462;
    private static final double POUNDtoKG = 0.453592;

    public static void main(String[] args) throws IOException
    {
    	/* For Test */
    	//Scanner scan = new Scanner(System.in);
    	
    	Scanner scan = new Scanner(new File("c:/oop/hw3_1.txt"));
    	while(true)
        {
            System.out.println("단위 변환기");
            System.out.println("1. cm -> inch");
            System.out.println("2. inch -> cm");
            System.out.println("3. kg -> pound");
            System.out.println("4. pound -> kg");
            System.out.println("5. C(섭씨) -> F(화씨)");
            System.out.println("6. F(화씨) -> C(섭씨)");
            System.out.println("7. 종료");
            System.out.println("메뉴 번호 입력>> ");
            int menuSelect;
            try
            {
            	menuSelect = Integer.parseInt(scan.next());
            }
            catch(NumberFormatException e)
            {
            	System.out.println("잘못된 입력입니다.\n");
                continue;
            }
            double input =0;
            double output =0;
            String toUnit = "";
			switch (menuSelect)
            {
                case 1:
                    toUnit = "inch";
                    System.out.println("cm를 입력하세요>> ");
                    input = scan.nextDouble();
                    output = input*CMtoINCH;
                    break;
                case 2:
                    toUnit = "cm";
                    System.out.println("inch를 입력하세요>> ");
                    input = scan.nextDouble();
                    output = input*INCHtoCM;
                    break;
                case 3:
                    toUnit = "pound";
                    System.out.println("kg을 입력하세요>> ");
                    input = scan.nextDouble();
                    output = input*KGtoPOUND;
                    break;
                case 4:
                    toUnit = "kg";
                    System.out.println("pound를 입력하세요>> ");
                    input = scan.nextDouble();
                    output = input*POUNDtoKG;
                    break;
                case 5:
                    toUnit = "F";
                    System.out.println("C(섭씨)를 입력하세요>> ");
                    input = scan.nextDouble();
                    output = temperatureConverter(input, 0);
                    break;
                case 6:
                    toUnit = "C";
                    System.out.println("F(화씨)를 입력하세요>> ");
                    input = scan.nextDouble();
                    output = temperatureConverter(input, 1);
                    break;
                case 7:
                    System.out.println("종료합니다.");
                    scan.close();
                    return;
                default:
                    System.out.println("잘못된 입력입니다.\n");
                    continue;
            }
            DecimalFormat df = new DecimalFormat("#,###.0");
            System.out.println(df.format(output)+toUnit+" 입니다.\n");
        }
        
    }
    
    private static double temperatureConverter(double temperature, int foo)
    {
    	if(foo==0)
    		return ((temperature*9)/5)+32; // Celsius to Fahrenheit
    	else
    		return ((temperature-32)*5)/9; // Fahrenheit to Celsius
    		
    }
}
