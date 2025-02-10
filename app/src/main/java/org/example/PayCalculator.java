package org.example;

public class PayCalculator {

    public double grossPay(double hoursWorked) {
        if (hoursWorked > regularHours) {
            return (regularHours * hourlyRate) + ((hoursWorked - regularHours) * overtimeRate);
        } else {
            return hoursWorked * hourlyRate;
        }
    }


    public double deductions(double grossPay, int numberOfDependents){
        double socialSecurity = grossPay * socialSecurityTax;
        double federalTax = grossPay * federalIncomeTax;
        double stateTax = grossPay * stateIncomeTax;
        double insurance = (numberOfDependents>=3) ? insuranceThreePlusDependents : insuranceThreeLessDependents;
        return socialSecurity + federalTax + stateTax + unionDues + insurance;
    }

    public double socialSecurity(double grossPay){
        double socialSecurity = grossPay*socialSecurityTax;
        return socialSecurity;
    }

    public double federalTax(double grossPay){
        double federalTax = grossPay*federalIncomeTax;
        return federalTax;
    }

    public double stateTax(double grossPay){
        double stateTax = grossPay*stateIncomeTax;
        return stateTax;
    }

    public double insurance(double grossPay, int numberOfDependents){
        double insurance = (numberOfDependents>=3) ? insuranceThreePlusDependents : insuranceThreeLessDependents;
        return insurance;
    }

    public double netPay(double grossPay, double totalDeductions){
        return grossPay - totalDeductions;
    }

    public double getUnionDues(){
        return unionDues;
    }

    private static double hourlyRate = 16.78;
    private static double socialSecurityTax = 0.06;
    private static double federalIncomeTax = 0.14;
    private static double stateIncomeTax = 0.05;
    private static double unionDues = 10.00;
    private static double insuranceThreePlusDependents = 35.00;
    private static double insuranceThreeLessDependents = 15.00;
    private static double regularHours = 40;
    private static double overtimeRate = 1.5 * hourlyRate;
}
