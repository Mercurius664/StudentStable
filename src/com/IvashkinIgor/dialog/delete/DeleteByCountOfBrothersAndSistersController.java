package com.IvashkinIgor.dialog.delete;

import com.IvashkinIgor.model.Model;
import com.IvashkinIgor.model.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import com.IvashkinIgor.main.*;

public class DeleteByCountOfBrothersAndSistersController {
    private static DeleteByCountOfBrothersAndSistersController deleteByCountOfBrothersAndSistersController;


    public static DeleteByCountOfBrothersAndSistersController getInstance(){
        if (deleteByCountOfBrothersAndSistersController == null){
            deleteByCountOfBrothersAndSistersController = new DeleteByCountOfBrothersAndSistersController();
        }
        return deleteByCountOfBrothersAndSistersController;
    }

    private DeleteByCountOfBrothersAndSistersController() {
        DeleteByCountOfBrothersAndSistersView deleteByCountOfBrothersAndSistersView = DeleteByCountOfBrothersAndSistersView.getInstance();
        deleteByCountOfBrothersAndSistersView.getJRadioButtonBrother().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateJRadioButton();
            }
        });
        deleteByCountOfBrothersAndSistersView.getJRadioButtonSister().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateJRadioButton();
            }
        });

        deleteByCountOfBrothersAndSistersView.getJButtonDelete().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Student> modelArrayList = Model.getInstance().getStudentArrayList();
                DeleteByCountOfBrothersAndSistersView deleteViewVariables = DeleteByCountOfBrothersAndSistersView.getInstance();

                if (!deleteByCountOfBrothersAndSistersView.getJRadioButtonBrother().isSelected() &&
                        !deleteByCountOfBrothersAndSistersView.getJRadioButtonSister().isSelected()) {
                    return;
                } else if (deleteByCountOfBrothersAndSistersView.getJRadioButtonBrother().isSelected() &&
                        deleteByCountOfBrothersAndSistersView.getJRadioButtonSister().isSelected()) {
                    int numberOfBrothers = 0;
                    try {
                        numberOfBrothers = Integer.parseInt(deleteByCountOfBrothersAndSistersView.getJTextFieldBrother().getText());
                    } catch (Exception exception) {
                        JOptionPane.showMessageDialog(null, "Ошибка ввода поля кол-во братьев");
                        return;
                    }
                    int numberOfSisters = 0;
                    try {
                        numberOfSisters = Integer.parseInt(deleteByCountOfBrothersAndSistersView.getJTextFieldFSister().getText());
                    } catch (Exception exception) {
                        JOptionPane.showMessageDialog(null, "Ошибка ввода поля кол-во сестёр");
                        return;
                    }
                    ArrayList<Student> arrayListDelete = new ArrayList<>();
                    for (int i = 0; i < Model.getInstance().getStudentArrayList().size(); i++) {
                        if (Model.getInstance().getStudentArrayList().get(i).getNumberOfBrothers() == numberOfBrothers &&
                                Model.getInstance().getStudentArrayList().get(i).getNumberOfSisters() == numberOfSisters) {
                            arrayListDelete.add(Model.getInstance().getStudentArrayList().get(i));

                        }

                    }
                    for (int i = 0; i < arrayListDelete.size(); i++) {
                        Model.getInstance().getStudentArrayList().remove(arrayListDelete.get(i));
                    }
                    JOptionPane.showMessageDialog(null, "Удалено " + arrayListDelete.size() + " записей");



                } else if (deleteViewVariables.getJRadioButtonBrother().isSelected()) {
                    int numberOfBrothers = 0;
                    try {
                        numberOfBrothers = Integer.parseInt(deleteViewVariables.getJTextFieldBrother().getText());
                    } catch (Exception exception) {
                        JOptionPane.showMessageDialog(null, "Ошибка ввода поля кол-во братьев");
                        return;
                    }
                    ArrayList<Student> arrayListDelete = new ArrayList<>();
                    for (int i = 0; i < modelArrayList.size(); i++) {
                        if (modelArrayList.get(i).getNumberOfBrothers() == numberOfBrothers) {
                            arrayListDelete.add(modelArrayList.get(i));
                        }

                    }
                    for (int i = 0; i < arrayListDelete.size(); i++) {
                        modelArrayList.remove(arrayListDelete.get(i));
                    }
                    JOptionPane.showMessageDialog(null, "Удалено " + arrayListDelete.size() + " записей");


                } else if (deleteViewVariables.getJRadioButtonSister().isSelected()) {
                    int numberOfSisters = 0;
                    try {
                        numberOfSisters = Integer.parseInt(deleteViewVariables.getJTextFieldFSister().getText());
                    } catch (Exception exception) {
                        JOptionPane.showMessageDialog(null, "Ошибка ввода поля кол-во сестёр");
                        return;
                    }
                    ArrayList<Student> arrayListDelete = new ArrayList<>();
                    for (int i = 0; i < modelArrayList.size(); i++) {
                        if (modelArrayList.get(i).getNumberOfSisters() == numberOfSisters) {
                            arrayListDelete.add(modelArrayList.get(i));

                        }

                    }
                    for (int i = 0; i < arrayListDelete.size(); i++) {
                        modelArrayList.remove(arrayListDelete.get(i));
                    }
                    JOptionPane.showMessageDialog(null, "Удалено " + arrayListDelete.size() + " записей");


                }
                MainDialogController.getInstance().updateNumberInformation();

            }
        });
    }



    private void updateJRadioButton(){
        DeleteByCountOfBrothersAndSistersView values = DeleteByCountOfBrothersAndSistersView.getInstance();
        jRadioButtonCheck(values.getJRadioButtonSister(), values.getJRadioButtonBrother(),
                values.getJTextFieldFSister(), values.getJTextFieldBrother());
    }

    private static void jRadioButtonCheck(JRadioButton jRadioButton1, JRadioButton jRadioButton2,
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
}
