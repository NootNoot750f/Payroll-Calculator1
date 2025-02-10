package org.example;
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    // Getting user input
    Scanner scanner = new Scanner(System.in);
    PayCalculator calculator = new PayCalculator();

    System.out.println("Welcome to the Payroll Calculator!");
    System.out.print("Enter the number of dependents you have: ");
    int numberOfDependents = scanner.nextInt();

    System.out.print("Enter the number of hours you worked: ");
    double numberOfHours = scanner.nextDouble();
    scanner.close();

    // Calculations
    double grossPay = calculator.grossPay(numberOfHours);
    double totalDeductions = calculator.deductions(grossPay, numberOfDependents);
    double netPay = calculator.netPay(grossPay, totalDeductions);
    double socialSecurityDeduction = calculator.socialSecurity(grossPay);
    double federalTaxDeduction = calculator.federalTax(grossPay);
    double stateTaxDeduction = calculator.stateTax(grossPay);
    double unionDues = calculator.getUnionDues();
    double insuranceDeduction = calculator.insurance(grossPay, numberOfDependents);

    // Printing output
    System.out.printf("\nPayroll Stub:\n");
    System.out.printf("   Hours:   %.1f\n", numberOfHours);
    System.out.printf("    Rate:   16.78 $/hr\n");
    System.out.printf("   Gross:   $%.2f\n\n", grossPay);
    System.out.printf("  Social Security Deductions:   $%.2f\n", socialSecurityDeduction);
    System.out.printf("  Federal Tax Deductions:   $%.2f\n", federalTaxDeduction);
    System.out.printf("  State Tax Deductions:   $%.2f\n", stateTaxDeduction);
    System.out.printf("  Union Dues:   $%.2f\n", unionDues);
    System.out.printf("  Insurance Deductions:   $%.2f\n\n", insuranceDeduction);
    System.out.printf("  Total Deductions:   $%.2f\n\n", totalDeductions);
    System.out.printf("  Net Pay:   $%.2f\n", netPay);

    System.out.println("\nThank you for using the Payroll Program! Go back to work.");
  }
}
