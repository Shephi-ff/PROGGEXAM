/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.salesreport;

/**
 *
 * @author shephi
 */
import javax.swing.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;

public class GUIapplication extends JFrame {

    private JTextField txtCustomer;
    private JTextField txtPrice;
    private JComboBox<String> cmbProduct;

    // Constructor
    public GUIapplication() {

        setTitle("Product App");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Customer name
        JLabel lblCustomer = new JLabel("Customer Name:");
        lblCustomer.setBounds(30, 40, 120, 25);
        add(lblCustomer);

        txtCustomer = new JTextField();
        txtCustomer.setBounds(160, 40, 220, 25);
        add(txtCustomer);

        // Select product
        JLabel lblProduct = new JLabel("Select Product:");
        lblProduct.setBounds(30, 85, 120, 25);
        add(lblProduct);

        String[] products = {
            "Cozy Nights Monarch",
            "Restonic Barbados",
            "Sealy Phuket"
        };

        cmbProduct = new JComboBox<>(products);
        cmbProduct.setBounds(160, 85, 220, 25);
        add(cmbProduct);

        // Enter price
        JLabel lblPrice = new JLabel("Enter Price:");
        lblPrice.setBounds(30, 130, 120, 25);
        add(lblPrice);

        txtPrice = new JTextField();
        txtPrice.setBounds(160, 130, 220, 25);
        add(txtPrice);

        // Process button
        JButton btnProcess = new JButton("PROCESS");
        btnProcess.setBounds(160, 180, 150, 35);
        add(btnProcess);

        btnProcess.addActionListener(e -> process());

        // Menu bar
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenu toolsMenu = new JMenu("Tools");

        JMenuItem exitItem = new JMenuItem("Exit");
        JMenuItem processItem = new JMenuItem("Process");
        JMenuItem clearItem = new JMenuItem("Clear");

        fileMenu.add(exitItem);

        toolsMenu.add(processItem);
        toolsMenu.add(clearItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);

        setJMenuBar(menuBar);

        // Exit menu
        exitItem.addActionListener(e -> System.exit(0));

        // Process menu
        processItem.addActionListener(e -> process());

        // Clear menu
        clearItem.addActionListener(e -> {
            txtCustomer.setText("");
            txtPrice.setText("");
            cmbProduct.setSelectedIndex(0);
        });
    }

    // Process information
    private void process() {

        try {

            String customer = txtCustomer.getText().trim();
            String product = cmbProduct.getSelectedItem().toString();

            if (customer.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Please enter customer name.");
                return;
            }

            double price = Double.parseDouble(txtPrice.getText());

            if (price <= 0) {
                JOptionPane.showMessageDialog(this,
                        "Please enter a valid price.");
                return;
            }

            ProductCalculations calculation =
                    new ProductCalculations(price);

            double vat = calculation.GetVat();
            double commission = calculation.GetCommission();
            double total = calculation.GetTotal();

            String message = "Customer Name: " + customer
                    + "\nProduct: " + product
                    + "\nVAT: R " + vat
                    + "\nCOMMISSION: R " + commission
                    + "\nTOTAL: R " + total;

            JOptionPane.showMessageDialog(this, message);

            // Save information to data.txt
            try (FileWriter writer = new FileWriter("data.txt", true)) {

                writer.write("DATA LOG\n");
                writer.write("************************\n");
                writer.write("Customer Name: " + customer + "\n");
                writer.write("Product: " + product + "\n");
                writer.write("VAT: R " + vat + "\n");
                writer.write("COMMISSION: R " + commission + "\n");
                writer.write("TOTAL: R " + total + "\n");
                writer.write("************************\n\n");
            }

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(this,
                    "Please enter a valid price.");

        } catch (IOException ex) {

            JOptionPane.showMessageDialog(this,
                    "Error saving information.");
        }
    }

    
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            GUIapplication form = new GUIapplication();
            form.setVisible(true);
        });
    }
}