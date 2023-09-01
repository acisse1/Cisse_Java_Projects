import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.*;
import java.awt.print.PrinterException;

public class MyRestaurent extends JFrame {

    JLabel Customer, Name, Contact, food, drink, type;
    JTextField tfNumber, tfName, tfContact;
    JButton reset, print, receipt;
    JComboBox cb1, cb2;
    JRadioButton r1, r2;
    JTextArea area1, area2; 
    int total, fprice, dprice;

    MyRestaurent() {

        setTitle("Restaurent and Coffee");
        setSize(700, 500);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Customer = new JLabel("Customer No:");
        Customer.setBounds(20, 20, 120, 30);

        tfNumber = new JTextField();
        tfNumber.setBounds(150, 20, 200, 30);

        Name = new JLabel("Name:");
        Name.setBounds(20, 100, 120, 30);

        tfName = new JTextField();
        tfName.setBounds(150, 100, 200, 30);

        Contact = new JLabel("Contact:");
        Contact.setBounds(20, 150, 120, 30);

        tfContact = new JTextField();
        tfContact.setBounds(150, 150, 200, 30);

        food = new JLabel("Foods");
        food.setBounds(20, 200, 120, 30);

        String foods[] = {"Pizza", "KFC", "Burger"};
        cb1 = new JComboBox(foods);
        cb1.setBounds(200, 200,120, 30);

        drink = new JLabel("Drinks");
        drink.setBounds(20, 250, 120, 30);

        String drinks[] = {"Lemon Juice", "Apple Juice", "Orange Juice"};
        cb2 = new JComboBox(drinks);
        cb2.setBounds(200, 250,120, 30);

        type = new JLabel("Drinks");
        type.setBounds(20, 300, 120, 30);

        r1 = new JRadioButton("DIET");
        r1.setBounds(200, 300, 60, 30);

        r2 = new JRadioButton("NORMAL");
        r2.setBounds(300, 300, 60, 30);

        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);

        reset = new JButton("reset");
        reset.setBounds(400, 100, 80, 40);

        receipt = new JButton("receipt");
        receipt.setBounds(480, 100, 80, 40);

        print = new JButton("print");
        print.setBounds(560, 100, 80, 40);

        area1 = new JTextArea();
        area1.setBounds(400, 140, 240, 200);

        getContentPane().add(r1);
        getContentPane().add(r2);

        getContentPane().add(Customer);
        getContentPane().add(tfNumber);

        getContentPane().add(Name);
        getContentPane().add(tfName);

        getContentPane().add(Contact);
        getContentPane().add(tfContact);

        getContentPane().add(food);
        getContentPane().add(cb1);

        getContentPane().add(drink);
        getContentPane().add(cb2);
        getContentPane().add(type);

        getContentPane().add(reset);
        getContentPane().add(receipt);
        getContentPane().add(print);
        getContentPane().add(area1);
        
        reset.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
               
                tfNumber.setText("");
                tfContact.setText("");
                tfName.setText("");
                area1.setText("");
            }
        });

        print.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
               
                try {
                    area1.print();
                } catch (PrinterException e1) {
                    
                    e1.printStackTrace();
                }
                
            }
        });

        receipt.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
               
               area1.setText("Happy Restaurent and Coffe\n");
               area1.setText(area1.getText() +
               " Customer Number: " +
               tfNumber.getText() +
               "\n Name: " + tfName.getText() +
               "\n Contact: " + tfContact.getText()
               );

               area1.setText(area1.getText() +
               "\n Food: " +
               cb1.getSelectedItem() +
               "\n Drink: " +
               cb2.getSelectedItem()
               );
            // Food Selection 
               if (cb1.getSelectedIndex() == 0) {
                    fprice = 200;
               }

               if (cb1.getSelectedIndex() == 1) {
                    fprice = 300;
               }

               if (cb1.getSelectedIndex() == 2) {
                    fprice = 400;
               }

            // Drink selection
                if (cb2.getSelectedIndex() == 0) {
                    dprice = 158;
                    total = fprice + dprice;
                    area1.setText(area1.getText() + "\n Total = " + total);
                }

                if (cb2.getSelectedIndex() == 1) {
                    dprice = 657;
                    total = fprice + dprice;
                    area1.setText(area1.getText() + "\n Total = " + total);
                }

                if (cb2.getSelectedIndex() == 2) {
                    dprice = 954;
                    total = fprice + dprice;
                    area1.setText(area1.getText() + "\n Total = " + total);
               }

            }
        });
 
 


    }

    public static void main(String[] args) {

        new MyRestaurent();

    }

}