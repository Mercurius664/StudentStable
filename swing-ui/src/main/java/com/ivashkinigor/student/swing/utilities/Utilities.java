package com.ivashkinigor.student.swing.utilities;


import com.ivashkinigor.student.model.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class Utilities {
    public static Color backgroundColor = Color.GRAY;


    public static void numberOfRowsOnPageLogic(ArrayList<Student> arrayList,
                                               DefaultTableModel defaultTableModel,
                                               int numberOfRows,
                                               int currentPage) {


        int rowCount = defaultTableModel.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            defaultTableModel.removeRow(0);
        }
        for (int i = (currentPage * numberOfRows - numberOfRows); i < arrayList.size(); i++) {
            if (defaultTableModel.getRowCount() >= numberOfRows) {
                break;
            }
            Object[] tableContent = new String[]{
                    arrayList.get(i).getName(),
                    arrayList.get(i).getFather().getName(),
                    String.valueOf(arrayList.get(i).getFather().getEarnings()),
                    arrayList.get(i).getMother().getName(),
                    String.valueOf(arrayList.get(i).getMother().getEarnings()),
                    String.valueOf(arrayList.get(i).getNumberOfBrothers()),
                    String.valueOf(arrayList.get(i).getNumberOfSisters())
            };
            defaultTableModel.addRow(tableContent);

        }

    }



    public static void jRadioButtonCheck(JRadioButton jRadioButton1, JRadioButton jRadioButton2,
                                          JTextField jTextField1, JTextField jTextField2) {
        
        if (jRadioButton1.isSelected() && jRadioButton2.isSelected()) {
            jTextField1.setEditable(true);
            jTextField1.setBackground(Color.WHITE);
            jTextField2.setEditable(true);
            jTextField2.setBackground(Color.WHITE);
        } else if (!jRadioButton1.isSelected() && !jRadioButton2.isSelected()) {
            jTextField1.setEditable(false);
            jTextField1.setBackground(backgroundColor);
            jTextField1.setText("");
            jTextField2.setEditable(false);
            jTextField2.setBackground(backgroundColor);
            jTextField2.setText("");
        } else if (jRadioButton1.isSelected()) {
            jTextField1.setEditable(true);
            jTextField1.setBackground(Color.WHITE);

            jTextField2.setEditable(false);
            jTextField2.setBackground(backgroundColor);
            jTextField2.setText("");
        } else {
            jTextField2.setEditable(true);
            jTextField2.setBackground(Color.WHITE);

            jTextField1.setEditable(false);
            jTextField1.setBackground(backgroundColor);
            jTextField1.setText("");
        }

    }
    
    public static void jRadioButtonCheck(JRadioButton jRadioButton1, JRadioButton jRadioButton2,
                                          JTextField jTextField1min, JTextField jTextField1max,
                                          JTextField jTextField2min, JTextField jTextField2max) {

        if (jRadioButton1.isSelected() && jRadioButton2.isSelected()) {
            jTextField1min.setEditable(true);
            jTextField1min.setBackground(Color.WHITE);
            jTextField1max.setEditable(true);
            jTextField1max.setBackground(Color.WHITE);
            jTextField2min.setEditable(true);
            jTextField2min.setBackground(Color.WHITE);
            jTextField2max.setEditable(true);
            jTextField2max.setBackground(Color.WHITE);
        } else if (!jRadioButton1.isSelected() && !jRadioButton2.isSelected()) {
            jTextField1min.setEditable(false);
            jTextField1min.setBackground(backgroundColor);
            jTextField1min.setText("");

            jTextField1max.setEditable(false);
            jTextField1max.setBackground(backgroundColor);
            jTextField1max.setText("");

            jTextField2min.setEditable(false);
            jTextField2min.setBackground(backgroundColor);
            jTextField2min.setText("");

            jTextField2max.setEditable(false);
            jTextField2max.setBackground(backgroundColor);
            jTextField2max.setText("");
        } else if (jRadioButton1.isSelected()) {
            jTextField1min.setEditable(true);
            jTextField1min.setBackground(Color.WHITE);

            jTextField1max.setEditable(true);
            jTextField1max.setBackground(Color.WHITE);

            jTextField2min.setEditable(false);
            jTextField2min.setBackground(backgroundColor);
            jTextField2min.setText("");

            jTextField2max.setEditable(false);
            jTextField2max.setBackground(backgroundColor);
            jTextField2max.setText("");
        } else {
            jTextField2min.setEditable(true);
            jTextField2min.setBackground(Color.WHITE);

            jTextField2max.setEditable(true);
            jTextField2max.setBackground(Color.WHITE);

            jTextField1min.setEditable(false);
            jTextField1min.setBackground(backgroundColor);
            jTextField1min.setText("");


            jTextField1max.setEditable(false);
            jTextField1max.setBackground(backgroundColor);
            jTextField1max.setText("");
        }

    }

}
