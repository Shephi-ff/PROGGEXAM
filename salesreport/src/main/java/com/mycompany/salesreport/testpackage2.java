/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.salesreport;

/**
 *
 * @author Delicia
 */
public class testpackage2 {
    

import org.junit.Test;
import static org.junit.Assert.*;

import mattressapp.ProductCalculations;

public class ProductCalculationsTest {

    // Unit Test 1
    @Test
    public void GetVat_WithValidData_ReturnsCorrectValue() {

        ProductCalculations product =
                new ProductCalculations(3500);

        double result = product.GetVat();

        assertEquals(525.0, result, 0.01);
    }

    // Unit Test 2
    public void GetTotal_WithValidData_ReturnsCorrectValue() {

        ProductCalculations product =
                new ProductCalculations(3500);

        double result = product.GetTotal();

        assertEquals(4200.0, result, 0.01);
    }
}
}
