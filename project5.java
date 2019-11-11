import java.util.Scanner;
import java.io.*;


public class project5{
public String name; // Name of the employee
public double hoursWorked; // Hours worked in the payroll period
public double payRate; // Hourly pay rate
public double grossPay; // Gross pay based on the number of hours worked
public double adjustedGrossPay; // Gross pay less amount for the IRA
public double netPay; // Gross pay less taxes
public double savingsAmount; // Amount of gross pay for savings
public double iraAmount; // Amount of gross pay for the IRA
public double taxAmount; // Amount of tax based on gross pay and tax rates
public double wealth; // Savings amount + iraAmount
// *******************************************************************
// *******************************************************************
/**
selectionSortArrayOfClass
Sort an array of the Employee class in ascending order.
The parameters are:
@param empl - an array of the Employee class. If the array is empty,
the method simply returns with no action taken
@param len - the number of possibly partially-filled elements in the
Employee array (i.e., it might be < empl.length)
@param sortType - a string that indicates the type of sort:
"Name" - sort by name
"Gross Pay" - sort by gross pay
@return 0, sort was completed successfully
1, the array to sort has no elements
2, the sortType is invalid
*/
public static int selectionSortArrayOfClass(
Employee[] empl,
int len,
String sortType) {
final String SORT_BY_NAME = "NAME";
final String SORT_BY_GROSS = "GROSS PAY";

Employee tempEmpl = new Employee();// Holds an entry being swapped

boolean isSortByName; // True if sort by name
boolean isSortByGross; // True if sort by gross pay
int k, i; // Indexes into the array to assist with the sort
int minIndex; // Index of the minimum value in the array
String howSort; // Upper case of the sort type

// Begin execution. If the employee array has no entries, there is nothing
// to sort, so simply return

if (empl.length == 0) {
return 1;
} // End if

// Set the flag for the entire sort based on whether we are sorting by
// a name (sortType = "Name") or we are sorting by the gross pay
// (sortType = "Gross Pay"). If the the sortType is not one of the two
// possibilities, the method returns with no action taken.

howSort = sortType.toUpperCase().trim(); // Deal only with upper case
isSortByName = (howSort.equals(SORT_BY_NAME)); // True means sort by name
isSortByGross = (howSort.equals(SORT_BY_GROSS)); // True means sort by gross

// If neither of the sort types is true, the user used an unrecognized sort
// type, so just return

if (!(isSortByName || isSortByGross)) {
return 2;
} // End if

// At this point, the empl array has at least one entry, and we are
// sorting by name or by gross pay.
// Each pass determines the location, minIndex, of the smallest value

for (k = 0; k < len - 1; k++)
{
// Find the location, minIndex, of the smallest value in row k
minIndex = k; // Assume the minimum value is at location k
// We check once for each pass of control variable k to see whether
// we are sorting by name or gross pay. This approach is in contrast
// to one inner for loop (control variable i) in which we ask each
// time through the loop what type of sort we are doing.
// This approach saves a whole bunch of times we ask what type
// of sort we're doing at the expense of a slightly larger program.
if (isSortByName) {
for (i = k + 1; i < len; i++) {
if (empl[i].name.compareTo(empl[minIndex].name) < 0) minIndex = i;
} // End for (i = k + 1; i < len; i++)
} // End 'if' sorting by name
else { // We are sorting by gross pay
for (i = k + 1; i < len; i++) {
if (empl[i].grossPay < empl[minIndex].grossPay) minIndex = i;
} // End for (i = k + 1; i < len; i++)
} // End 'else' sorting by gross pay
// Swap elements in the minIndex and k positions of the arrays
tempEmpl = empl[minIndex];
empl[minIndex] = empl[k];
empl[k] = tempEmpl;
} // End for (k = 0; k < len - 1; k++)
return 0; // Indicate the sort ended OK
} // End selectionSortArrayOfClass
// **************************************************************************
public static void calculateGrossPay(Employee[] empl,int n){
for(int i = 0;i<n;i++){
  if(empl[i].hoursWorked <= 40){
   empl[i].grossPay = empl[i].hoursWorked * empl[i].payRate;
  }else if(empl[i].hoursWorked <= 50){
   empl[i].grossPay = (40*empl[i].payRate) + ((empl[i].hoursWorked - 40)*empl[i].payRate*1.5);
  }else{
   empl[i].grossPay = (50*empl[i].payRate)+(10*empl[i].payRate*1.5) + ((empl[i].hoursWorked - 50)*empl[i].payRate*2);
  }
}
}

public static void calculateVariables(Employee[] empl,int n,EmployeeParameters params){
for(int i = 0;i<n;i++){
  empl[i].iraAmount = empl[i].grossPay*params.iraRate/100;
  empl[i].adjustedGrossPay = empl[i].grossPay - empl[i].iraAmount;
  empl[i].taxAmount = empl[i].adjustedGrossPay*(params.federalWithholdingRate+params.stateWithholdingRate)/100;
  empl[i].netPay = empl[i].adjustedGrossPay - empl[i].taxAmount;
  empl[i].savingsAmount = empl[i].adjustedGrossPay*params.savingsRate/100;
  empl[i].wealth = empl[i].savingsAmount + empl[i].iraAmount;
}
}

public static void printHeader(PrintWriter pw)throws Exception{
pw.println("                           Payroll Report");
System.out.println("                           Payroll Report");
pw.printf("\n%20s%20s%20s%20s%20s%20s%20s","Name","Gross Pay","Net Pay","Wealth","Taxes","Hours","Pay Rate");
System.out.printf("\n%20s%20s%20s%20s%20s%20s%20s","Name","Gross Pay","Net Pay","Wealth","Taxes","Hours","Pay Rate");
pw.printf("\n%20s%20s%20s%20s%20s%20s%20s","-------------------","-------------------","-------------------","-------------------","-------------------","-------------------","-------------------");
System.out.printf("\n%20s%20s%20s%20s%20s%20s%20s","-------------------","-------------------","-------------------","-------------------","-------------------","-------------------","-------------------");
}

public static void printEmployee(Employee empl,PrintWriter pw)throws Exception{
pw.printf("\n%20s,%20s,%20s,%20s,%20s,%20s,%20s",empl.name,""+empl.grossPay,""+empl.netPay,""+empl.wealth,""+empl.taxAmount,""+empl.hoursWorked,""+empl.payRate);
System.out.printf("\n%20s,%20s,%20s,%20s,%20s,%20s,%20s",empl.name,""+empl.grossPay,""+empl.netPay,""+empl.wealth,""+empl.taxAmount,""+empl.hoursWorked,""+empl.payRate);
}

public static void calculateAndPrint(Employee[] empl,int n,PrintWriter pw)throws Exception{
double totGrossPay = 0,totNetpay = 0,totWealth = 0,totTax = 0,totHour = 0,avgPayRate = 0;
pw.printf("\n%20s","Totals: ");
System.out.printf("\n%20s","Toatls: ");
for(int i = 0;i<n;i++){
  totHour += empl[i].hoursWorked;
  totGrossPay += empl[i].grossPay;
  totNetpay += empl[i].netPay;
  totWealth += empl[i].wealth;
  totTax += empl[i].taxAmount;
  avgPayRate += empl[i].payRate;
}
pw.printf("%20s,%20s,%20s,%20s",""+totGrossPay,""+totNetpay,""+totWealth,""+totTax);
pw.printf("%20s,%20s",""+totHour,"Avarage: "+(avgPayRate/n));
System.out.printf("%20s,%20s,%20s,%20s",""+totGrossPay,""+totNetpay,""+totWealth,""+totTax);
System.out.printf("%20s,%20s",""+totHour,"Avarage: "+(avgPayRate/n));
}
public static void printOutput(Employee[] empl,int n){
//printing the report
try{
  PrintWriter pw = new PrintWriter(new File("1050_Project_05_Output.txt"));
  printHeader(pw);
  for(int i = 0;i<n;i++){
   printEmployee(empl[i],pw);
  }
  calculateAndPrint(empl,n,pw);
  pw.close();
}catch(Exception e){
  e.printStackTrace();
  System.exit(0);
}
}
public static void main(String[] args) {
EmployeeParameters params = new EmployeeParameters();
try{
  params.getEmployeeParameters();
}catch(Exception e){
  e.printStackTrace();
  System.exit(0);
}
int maxEmployee = params.maxEmployees;
Employee[] empl = new Employee[maxEmployee];
int n = 0;
//reading input File
try{
  Scanner sc = new Scanner(new File("1050_Project_05_Input.txt"));
  while(sc.hasNextLine() && n < maxEmployee){
   String line = sc.nextLine();
   String[] str = line.split(" ");
   empl[n] = new Employee();
   empl[n].hoursWorked = Double.parseDouble(str[0]);
   empl[n].payRate = Double.parseDouble(str[1]);
   String name = "";
   for(int i = 2;i<str.length;i++){
    name += str[i];
   }
   name = name.trim();
   empl[n].name = name;
   n++;
  }
  sc.close();
}catch(Exception e){
  e.printStackTrace();
  System.out.println("Please check input File !!! ");
  System.exit(0);
}
calculateGrossPay(empl,n);
calculateVariables(empl,n,params);
printOutput(empl,n);
selectionSortArrayOfClass(empl,n,"NAME");
printOutput(empl,n);
selectionSortArrayOfClass(empl,n,"GROSS PAY");
printOutput(empl,n);
//end reading input file
}
} // End Employee