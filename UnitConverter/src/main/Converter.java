package main;

import java.util.Scanner;

public class Converter {
	
	// Method which Converts Miles to Kilometers
public static  double convertmiTOkm (double mi) {
	double km=mi*1.60934;
	return km;
}
//Method which Converts Kilograms to Pounds
public static  double convertkgTOlb (double kg) {
	double lb=kg*2.2046;
	return lb;
}
//Method which Converts Meters to Feets
public static  double convertmTOft (double m) {
	double ft=m*3.2808;
	return ft;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int menuSelection = 0;

		while (menuSelection != 4) {

			
			  System.out.println("Please select an option:");
			  System.out.println("1. Convert Miles to Kilometers ");
			  System.out.println("2. Convert Kilograms to Pounds");
			  System.out.println("3. Convert Meters to Feets");
			  System.out.println("4. Quit");
			 

			Scanner sc = new Scanner(System.in);
			
			
			try {
				menuSelection = sc.nextInt();
				switch (menuSelection) {
				case 1:
					  System.out.println("Please,enter the value in Mile to convert into Kilometer");
					  double mi1 =sc.nextDouble();
					  double km1=convertmiTOkm(mi1);
					  System.out.println(mi1+ "  Miles = " + km1 + "  Kilometers ");  
					  
					break;
				case 2:
					 System.out.println("Please,enter the value in Kilogram to convert into Pound");
					 double kg1 =sc.nextDouble();
					  double lb1=convertkgTOlb(kg1);
					  System.out.println(kg1+ "  Kilometers = " + lb1 + "  Pounds ");  
					break;
				case 3:
					System.out.println("Please,enter the value in Meter to convert into Feet");
					 double m1 =sc.nextDouble();
					  double ft1=convertmTOft(m1);
					  System.out.println(m1+ "  meters = " + ft1 + "  Feets "); 
					break;	
				case 4:
					 System.out.println("Thank you, Goodbye");
					  System.exit(0);
					  
					break; 
				default:
					  System.out.println("Please,choose a number between 1 and 4");
					  
					break;
					
				}
			
			} catch (Exception e) {
				  System.out.println("Please,choose a number between 1 and 4");
			}
			
	
			
		}
	}

}
