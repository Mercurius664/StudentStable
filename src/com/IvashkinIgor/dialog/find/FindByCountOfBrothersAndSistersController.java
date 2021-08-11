package com.IvashkinIgor.dialog.find;

import com.IvashkinIgor.model.Model;
import com.IvashkinIgor.model.Student;
import com.IvashkinIgor.utilities.Utilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FindByCountOfBrothersAndSistersController {
    private static FindByCountOfBrothersAndSistersController findByCountOfBrothersAndSistersController;

    public static FindByCountOfBrothersAndSistersController getInstance() {
        if (findByCountOfBrothersAndSistersController == null){
            findByCountOfBrothersAndSistersController = new FindByCountOfBrothersAndSistersController();
        }
        return findByCountOfBrothersAndSistersController;
    }

    private FindByCountOfBrothersAndSistersController() {
        FindByCountOfBrothersAndSistersView valueVariables = FindByCountOfBrothersAndSistersView.getInstance();
        ArrayList<Student> studentArrayList = Model.getInstance().getStudentArrayList();
        ArrayList<Student> findArrayList = Model.getInstance().getStudentArrayListForFind();
        FindDialogView findDialogView = FindDialogView.getInstance();

        valueVariables.getJRadioButtonSisterEnable().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateJRadioButton();
            }
        });
        valueVariables.getJRadioButtonBrotherEnable().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateJRadioButton();
            }
        });

        valueVariables.getJButtonForFindIndex3().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findDialogView.setCurrentPageNumberForFind(1);
                Utilities.removeAllJTableElements(findDialogView.getDefaultTableModelForButtonFind());
                int studentArrayListForFindSize = findArrayList.size();
                for (int i = 0; i < studentArrayListForFindSize; i++) {
                    findArrayList.remove(0);
                }


                if (!valueVariables.getJRadioButtonBrotherEnable().isSelected() &&
                        !valueVariables.getJRadioButtonSisterEnable().isSelected()) {
                    return;
                } else if (valueVariables.getJRadioButtonBrotherEnable().isSelected() &&
                        valueVariables.getJRadioButtonSisterEnable().isSelected()) {
                    int numberOfBrothers = 0;
                    try {
                        numberOfBrothers = Integer.parseInt(valueVariables.getJTextFieldBrotherForFindIndex3().getText());
                    } catch (Exception exception) {
                        JOptionPane.showMessageDialog(null, "Ошибка ввода поля кол-во братьев");
                        return;
                    }
                    int numberOfSisters = 0;
                    try {
                        numberOfSisters = Integer.parseInt(valueVariables.getJTextFieldFSisterForFindIndex3().getText());
                    } catch (Exception exception) {
                        JOptionPane.showMessageDialog(null, "Ошибка ввода поля кол-во сестёр");
                        return;
                    }

                    for (int i = 0; i < studentArrayList.size(); i++) {
                        if (studentArrayList.get(i).getNumberOfBrothers() == numberOfBrothers &&
                                studentArrayList.get(i).getNumberOfSisters() == numberOfSisters) {
                            findArrayList.add(studentArrayList.get(i));
                            findDialogView.findFrameInformationUpdate();
                            if (findDialogView.getNumberOfRowsOnPageForFind() <= i) {
                                continue;
                            }
                            Utilities.jTableUpdate(findDialogView.getDefaultTableModelForButtonFind(), findDialogView.getJTableForButtonFind(),
                                    findDialogView.getJPanelForFind(), findArrayList);
                        }

                    }
                } else if (valueVariables.getJRadioButtonBrotherEnable().isSelected()) {
                    int numberOfBrothers = 0;
                    try {
                        numberOfBrothers = Integer.parseInt(valueVariables.getJTextFieldBrotherForFindIndex3().getText());
                    } catch (Exception exception) {
                        JOptionPane.showMessageDialog(null, "Ошибка ввода поля кол-во братьев");
                        return;
                    }
                    for (int i = 0; i < studentArrayList.size(); i++) {
                        if (studentArrayList.get(i).getNumberOfBrothers() == numberOfBrothers) {
                            findArrayList.add(studentArrayList.get(i));
                            findDialogView.findFrameInformationUpdate();
                            if (findDialogView.getNumberOfRowsOnPageForFind() <= i) {
                                continue;
                            }
                            Utilities.jTableUpdate(findDialogView.getDefaultTableModelForButtonFind(),
                                    findDialogView.getJTableForButtonFind(), findDialogView.getJPanelForFind(), findArrayList);
                        }

                    }
                } else if (valueVariables.getJRadioButtonSisterEnable().isSelected()) {
                    int numberOfSisters = 0;
                    try {
                        numberOfSisters = Integer.parseInt(valueVariables.getJTextFieldFSisterForFindIndex3().getText());
                    } catch (Exception exception) {
                        JOptionPane.showMessageDialog(null, "Ошибка ввода поля кол-во сестёр");
                        return;
                    }
                    for (int i = 0; i < studentArrayList.size(); i++) {
                        if (studentArrayList.get(i).getNumberOfSisters() == numberOfSisters) {
                            findArrayList.add(studentArrayList.get(i));
                            findDialogView.findFrameInformationUpdate();
                            if (findDialogView.getNumberOfRowsOnPageForFind()<= i) {
                                continue;
                            }
                            Utilities.jTableUpdate(findDialogView.getDefaultTableModelForButtonFind(), findDialogView.getJTableForButtonFind(),
                                    findDialogView.getJPanelForFind(), findArrayList);
                        }

                    }
                }
                findDialogView.findFrameInformationUpdate();
            }
        });
    }
    
    
    private void updateJRadioButton(){
        FindByCountOfBrothersAndSistersView variables = FindByCountOfBrothersAndSistersView.getInstance();
        Utilities.jRadioButtonCheck(variables.getJRadioButtonSisterEnable(),
                variables.getJRadioButtonBrotherEnable(),
                variables.getJTextFieldFSisterForFindIndex3(),
                variables.getJTextFieldBrotherForFindIndex3());
    }
}
