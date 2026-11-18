/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.salesreport;

/**
 *
 * @author shephi
 */

import java.util.Scanner;

public class Salesreport {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String[] products = {
            "Cozy Nights Monarch mattress",
            "Restonic Barbados mattress",
            "Sealy Phuket mattress"
        };

        int[][] sales = new int[3][3];

        for (int i = 0; i < products.length; i++) {

            for (int j = 0; j < sales[i].length; j++) {

                System.out.print("Enter number of sales for month "
                        + (j + 1) + " for " + products[i] + ": ");

                sales[i][j] = input.nextInt();
            }

            System.out.println();
        }

        product product = new product(product, sales);

        Printproduct report = new Printproduct(product);

        System.out.println("\nPRODUCT SALES REPORT - 2026");
        System.out.println("*************************************");

        report.PrintTotalProductSales();
        report.PrintAverageProductSales();
        report.PrintMostPopularProduct();

        input.close();
    }
}