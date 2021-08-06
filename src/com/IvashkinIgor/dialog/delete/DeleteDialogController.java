package com.IvashkinIgor.dialog.delete;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DeleteDialogController {
    private static DeleteDialogController deleteDialogController;

    public static DeleteDialogController getInstance() {
        if (deleteDialogController == null){
            deleteDialogController = new DeleteDialogController();
        }
        return deleteDialogController;
    }

    private DeleteDialogController() {
        DeleteDialogView deleteDialogView = DeleteDialogView.getInstance();
        deleteDialogView.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                disableAllDeleteFrames();
            }
        });
        deleteDialogView.getJComboBoxForDelete().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                disableAllDeleteFrames();
                int selectedIndex = deleteDialogView.getJComboBoxForDelete().getSelectedIndex();

                if (selectedIndex == 1) {
                    DeleteByStudentNameView.getInstance().setVisible(true);
                } else if (selectedIndex == 2) {
                    DeleteByParentNameView.getInstance().setVisible(true);
                } else if (selectedIndex == 3) {
                    DeleteByCountOfBrothersAndSistersView.getInstance().setVisible(true);
                } else if (selectedIndex == 4) {
                    DeleteByParentEarningView.getInstance().setVisible(true);
                }

            }
        });
    }


    private void disableAllDeleteFrames(){
        DeleteByParentEarningView.getInstance().setVisible(false);
        DeleteByParentNameView.getInstance().setVisible(false);
        DeleteByStudentNameView.getInstance().setVisible(false);
        DeleteByCountOfBrothersAndSistersView.getInstance().setVisible(false);
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
            //jTextField1min.setBackground(MainDialog.getJFrameMain().getBackground());
            jTextField1min.setText("");

            jTextField1max.setEditable(false);
            //jTextField1max.setBackground(MainDialog.getJFrameMain().getBackground());
            jTextField1max.setText("");

            jTextField2min.setEditable(false);
           // jTextField2min.setBackground(MainDialog.getJFrameMain().getBackground());
            jTextField2min.setText("");

            jTextField2max.setEditable(false);
            //jTextField2max.setBackground(MainDialog.getJFrameMain().getBackground());
            jTextField2max.setText("");
        } else if (jRadioButton1.isSelected()) {
            jTextField1min.setEditable(true);
            jTextField1min.setBackground(Color.WHITE);

            jTextField1max.setEditable(true);
            jTextField1max.setBackground(Color.WHITE);

            jTextField2min.setEditable(false);
            //jTextField2min.setBackground(MainDialog.getJFrameMain().getBackground());
            jTextField2min.setText("");

            jTextField2max.setEditable(false);
           // jTextField2max.setBackground(MainDialog.getJFrameMain().getBackground());
            jTextField2max.setText("");
        } else {
            jTextField2min.setEditable(true);
            jTextField2min.setBackground(Color.WHITE);

            jTextField2max.setEditable(true);
            jTextField2max.setBackground(Color.WHITE);

            jTextField1min.setEditable(false);
            //jTextField1min.setBackground(MainDialog.getJFrameMain().getBackground());
            jTextField1min.setText("");


            jTextField1max.setEditable(false);
            //jTextField1max.setBackground(MainDialog.getJFrameMain().getBackground());
            jTextField1max.setText("");
        }

    }
}
