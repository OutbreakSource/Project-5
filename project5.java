import java.util.Scanner;
import java.io.*; 

public class project5{

   public static void main(String[] args) throws IOException {
        final String INPUT_FILE = "1050_Project_05_Input.txt";
        final String OUTPUT_FILE = "1050_Project_05_Output.txt";

        // Access the input/output files
        File inputDataFile = new File(INPUT_FILE);
        Scanner inputFile = new Scanner(inputDataFile);

        FileWriter outputDataFile = new FileWriter(OUTPUT_FILE);
        PrintWriter outputFile = new PrintWriter(outputDataFile);
   }
   
   public class Employee {
		String name;				// Name of the employee
		public double hoursWorked;		// Hours worked in the payroll period
		public double payRate;			// Hourly pay rate
		public double grossPay;			// Gross pay based on the number of hours worked
		public double adjustedGrossPay;	// Gross pay less amount that goes into the IRA
		public double netPay;			// Gross pay less taxes
		public double savingsAmount;		// Amount of gross pay that goes to savings
		public double iraAmount;		// Amount of gross pay that goes into the IRA
		public double taxAmount;		// Amount of tax based on gross pay and tax rates
		public double wealth;			// Savings amount + IRA amount
		// You can add fields to this class if you want.
	} // End class

   
   public static void FileSection(String[] args) throws IOException{

   
   }
}