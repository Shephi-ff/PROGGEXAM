/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.salesreport;

/**
 *
 * @author shephi
 */
public class Printproduct {

    
    private product product;
    public Printproduct(product product) {
        this.product = product;
    }

    public void PrintTotalProductSales() {
        System.out.println("Total Products Sold: "
                + product.GetTotalProductsSold());
    }

    public void PrintAverageProductSales() {
        System.out.println("Average Product Sales: "
                + product.GetAverageProductSold());
    }

    public void PrintMostPopularProduct() {
        System.out.println("Most Popular Product: "
                + product.GetMostPopularProduct());
    }
}