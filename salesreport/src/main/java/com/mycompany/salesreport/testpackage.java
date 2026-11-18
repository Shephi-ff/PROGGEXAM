/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.salesreport;

/**
 *
 * @author Delicia
 */
public class testpackage {
    package testpackagejava;

import org.junit.Test;
import static org.junit.Assert.*;

import productsales.Product;

public class ProductTest {

    // Unit Test 1
    public void GetTotalProductSales_WithValidData_ReturnsCorrectValue() {

        String[] products = {
            "Cozy Nights Monarch mattress",
            "Restonic Barbados mattress",
            "Sealy Phuket mattress"
        };

        int[][] sales = {
            {25, 18, 20},
            {15, 10, 12},
            {18, 15, 20}
        };

        Product product = new Product(products, sales);

        assertEquals(153, product.GetTotalProductsSold());
    }

    // Unit Test 2
    public void GetAverageSales_WithValidData_ReturnsCorrectValue() {

        String[] products = {
            "Cozy Nights Monarch mattress",
            "Restonic Barbados mattress",
            "Sealy Phuket mattress"
        };

        int[][] sales = {
            {25, 18, 20},
            {15, 10, 12},
            {18, 15, 20}
        };

        Product product = new Product(products, sales);

        assertEquals(17.0, product.GetAverageProductSold(), 0.01);
    }
}
}
