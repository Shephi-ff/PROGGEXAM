/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.salesreport;

/**
 *
 * @author Delicia
 */
public class ProductCalculations {
   

public interface IProductCalculations {

    double GetVat();

    double GetCommission();

    double GetTotal();

}
}


public class ProductCalculations implements IProductCalculations {

    private double price;

    // Constructor
    public ProductCalculations(double price) {
        this.price = price;
    }

    // Calculate VAT (15%)
    @Override
    public double GetVat() {
        return price * 0.15;
    }

    // Calculate commission (5%)
    @Override
    public double GetCommission() {
        return price * 0.05;
    }

    // Calculate total amount
    @Override
    public double GetTotal() {
        return price + GetVat() + GetCommission();
    }
}