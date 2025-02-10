package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestPayCalculator {

    PayCalculator payCalculator;

    @BeforeEach
    void setUp() {
        payCalculator = new PayCalculator();
    }

    @Test
    void itCalculatesThePayForZeroHours() {
        assertEquals(0, payCalculator.grossPay(0), "Gross pay should be 0 for 0 hours worked");
    }

    @Test
    void itCalculatesRegularPayForFortyHours() {
        // 40 hours * $16.78 = $671.20
        assertEquals(671.20, payCalculator.grossPay(40), 0.01, "Gross pay for 40 hours should be $671.20");
    }

    @Test
    void itCalculatesOvertimePayFor50Hours() {
        // Regular pay: 40 hours * $16.78 = $671.20
        // Overtime pay: 10 hours * (1.5 * $16.78) = $251.70
        // Total gross pay = $671.20 + $251.70 = $922.90 (rounded)
        assertEquals(922.90, payCalculator.grossPay(50), 0.01, "Gross pay for 50 hours should be $922.90");
    }

    @Test
    void itCalculatesDeductionsForZeroDependents() {
        double grossPay = payCalculator.grossPay(40); // 40 hours * $16.78 = $671.20
        double expectedDeductions = (grossPay * 0.06) + (grossPay * 0.14) + (grossPay * 0.05) + 10.00 + 15.00; // SS, Federal, State, Union, Insurance for 0 dependent
        assertEquals(expectedDeductions, payCalculator.deductions(grossPay, 0), 0.01, "Deductions for 0 dependent are incorrect");
    }

    @Test
    void itCalculatesDeductionsForOneDependent() {
        double grossPay = payCalculator.grossPay(40); // 40 hours * $16.78 = $671.20
        double expectedDeductions = (grossPay * 0.06) + (grossPay * 0.14) + (grossPay * 0.05) + 10.00 + 15.00; // SS, Federal, State, Union, Insurance for 1 dependent
        assertEquals(expectedDeductions, payCalculator.deductions(grossPay, 1), 0.01, "Deductions for 1 dependent are incorrect");
    }

    @Test
    void itCalculatesDeductionsForThreeDependents() {
        double grossPay = payCalculator.grossPay(40); // 40 hours * $16.78 = $671.20
        double expectedDeductions = (grossPay * 0.06) + (grossPay * 0.14) + (grossPay * 0.05) + 10.00 + 35.00; // SS, Federal, State, Union, Insurance for 3 dependents
        assertEquals(expectedDeductions, payCalculator.deductions(grossPay, 3), 0.01, "Deductions for 3 dependents are incorrect");
    }

    @Test
    void itCalculatesNetPay() {
        double grossPay = payCalculator.grossPay(40); // 40 hours * $16.78 = $671.20
        double totalDeductions = payCalculator.deductions(grossPay, 1); // Deductions for 1 dependent
        double expectedNetPay = grossPay - totalDeductions;
        assertEquals(expectedNetPay, payCalculator.netPay(grossPay, totalDeductions), 0.01, "Net pay calculation is incorrect");
    }
}
