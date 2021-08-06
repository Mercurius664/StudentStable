package com.IvashkinIgor.utilities;

import com.IvashkinIgor.dialog.delete.DeleteByCountOfBrothersAndSistersView;
import com.IvashkinIgor.dialog.delete.DeleteByParentEarningView;
import com.IvashkinIgor.model.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class Utilities {

    public static void removeAllJTableElements(DefaultTableModel defaultTableModel) {
        int tableElementsCount = defaultTableModel.getRowCount();
        for (int i = 0; i < tableElementsCount; i++) {
            defaultTableModel.removeRow(0);
        }
    }

    public static void jTableUpdate(DefaultTableModel defaultTableModel, JTable jTable, JPanel jPanel, ArrayList<Student> studentArrayList) {

        defaultTableModel.addRow(new String[]{studentArrayList.get(defaultTableModel.getRowCount()).getStudentName(),
                studentArrayList.get(defaultTableModel.getRowCount()).getFatherName(),
                String.valueOf(studentArrayList.get(defaultTableModel.getRowCount()).getFatherEarnings()),
                studentArrayList.get(jTable.getRowCount()).getMotherName(),
                String.valueOf(studentArrayList.get(jTable.getRowCount()).getMotherEarnings()),
                String.valueOf(studentArrayList.get(jTable.getRowCount()).getNumberOfBrothers()),
                String.valueOf(studentArrayList.get(jTable.getRowCount()).getNumberOfSisters())});

        jPanel.revalidate();
    }

    public static void jRadioButtonCheck(JRadioButton jRadioButton1, JRadioButton jRadioButton2,
                                          JTextField jTextField1, JTextField jTextField2) {
        DeleteByCountOfBrothersAndSistersView values = DeleteByCountOfBrothersAndSistersView.getInstance();
        if (jRadioButton1.isSelected() && jRadioButton2.isSelected()) {
            jTextField1.setEditable(true);
            jTextField1.setBackground(Color.WHITE);
            jTextField2.setEditable(true);
            jTextField2.setBackground(Color.WHITE);
        } else if (!jRadioButton1.isSelected() && !jRadioButton2.isSelected()) {
            jTextField1.setEditable(false);
            jTextField1.setBackground(values.getBackground());
            jTextField1.setText("");
            jTextField2.setEditable(false);
            jTextField2.setBackground(values.getBackground());
            jTextField2.setText("");
        } else if (jRadioButton1.isSelected()) {
            jTextField1.setEditable(true);
            jTextField1.setBackground(Color.WHITE);

            jTextField2.setEditable(false);
            jTextField2.setBackground(values.getBackground());
            jTextField2.setText("");
        } else {
            jTextField2.setEditable(true);
            jTextField2.setBackground(Color.WHITE);

            jTextField1.setEditable(false);
            jTextField1.setBackground(values.getBackground());
            jTextField1.setText("");
        }

    }

    public static void jRadioButtonCheck(JRadioButton jRadioButton1, JRadioButton jRadioButton2,
                                          JTextField jTextField1min, JTextField jTextField1max,
                                          JTextField jTextField2min, JTextField jTextField2max) {
        DeleteByParentEarningView deleteByParentEarningView = DeleteByParentEarningView.getInstance();
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
            jTextField1min.setBackground(deleteByParentEarningView.getBackground());
            jTextField1min.setText("");

            jTextField1max.setEditable(false);
            jTextField1max.setBackground(deleteByParentEarningView.getBackground());
            jTextField1max.setText("");

            jTextField2min.setEditable(false);
            jTextField2min.setBackground(deleteByParentEarningView.getBackground());
            jTextField2min.setText("");

            jTextField2max.setEditable(false);
            jTextField2max.setBackground(deleteByParentEarningView.getBackground());
            jTextField2max.setText("");
        } else if (jRadioButton1.isSelected()) {
            jTextField1min.setEditable(true);
            jTextField1min.setBackground(Color.WHITE);

            jTextField1max.setEditable(true);
            jTextField1max.setBackground(Color.WHITE);

            jTextField2min.setEditable(false);
            jTextField2min.setBackground(deleteByParentEarningView.getBackground());
            jTextField2min.setText("");

            jTextField2max.setEditable(false);
            jTextField2max.setBackground(deleteByParentEarningView.getBackground());
            jTextField2max.setText("");
        } else {
            jTextField2min.setEditable(true);
            jTextField2min.setBackground(Color.WHITE);

            jTextField2max.setEditable(true);
            jTextField2max.setBackground(Color.WHITE);

            jTextField1min.setEditable(false);
            jTextField1min.setBackground(deleteByParentEarningView.getBackground());
            jTextField1min.setText("");


            jTextField1max.setEditable(false);
            jTextField1max.setBackground(deleteByParentEarningView.getBackground());
            jTextField1max.setText("");
        }

    }

}
