package com.IvashkinIgor.dialog.find;

import com.IvashkinIgor.model.Model;
import com.IvashkinIgor.model.Student;
import com.IvashkinIgor.utilities.Utilities;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FindByParentEarningController {
    private static FindByParentEarningController findByParentEarningController;

    public static FindByParentEarningController getInstance() {
        if (findByParentEarningController == null){
            findByParentEarningController = new FindByParentEarningController();
        }
        return findByParentEarningController;
    }
    
    
    private FindByParentEarningController() {
        FindByParentEarningView findByParentEarningView = FindByParentEarningView.getInstance();
        FindDialogView findDialogView = FindDialogView.getInstance();
        ArrayList<Student> studentArrayListFind = Model.getInstance().getStudentArrayListForFind();
        ArrayList<Student> studentArrayList = Model.getInstance().getStudentArrayList();
        
        findByParentEarningView.getJRadioButtonFatherMoneyEnable().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jRadioButtonUpdate();
            }
        });
        findByParentEarningView.getJRadioButtonMotherMoneyEnable().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jRadioButtonUpdate();
            }
        });
        findByParentEarningView.getJButtonForFindIndex4().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Utilities.removeAllJTableElements(findDialogView.getDefaultTableModelForButtonFind());
                findDialogView.setCurrentPageNumberForFind(1);
                int studentArrayListForFindSize = studentArrayListFind.size();
                for (int i = 0; i < studentArrayListForFindSize; i++) {
                    studentArrayListFind.remove(0);
                }

                if (!findByParentEarningView.getJRadioButtonFatherMoneyEnable().isSelected() && 
                        !findByParentEarningView.getJRadioButtonMotherMoneyEnable().isSelected()) {
                    return;
                } else if (findByParentEarningView.getJRadioButtonFatherMoneyEnable().isSelected() &&
                        findByParentEarningView.getJRadioButtonMotherMoneyEnable().isSelected()) {
                    ArrayList<Student> fatherArrayList = new ArrayList<>();
                    ArrayList<Student> motherArrayList = new ArrayList<>();
                    String errorsFather = "";
                    boolean hasFatherErrorsMax = false;
                    boolean hasFatherErrorsMin = false;
                    int fatherMax = 0;
                    int fatherMin = 0;
                    try {
                        fatherMax = Integer.parseInt(findByParentEarningView.getJTextFieldFatherMaxForFindIndex4().getText());
                    } catch (Exception exception) {
                        hasFatherErrorsMax = true;
                        errorsFather += "Неправильно введено поле: Введите зарплату отца до \n";
                    }
                    try {
                        fatherMin = Integer.parseInt(findByParentEarningView.getJTextFieldFatherMinForFindIndex4().getText());
                    } catch (Exception exception) {
                        hasFatherErrorsMin = true;
                        errorsFather += "Неправильно введено поле: Введите зарплату отца от";
                    }
                    if (hasFatherErrorsMin && hasFatherErrorsMax) {
                        JOptionPane.showMessageDialog(null, errorsFather);
                        return;
                    }

                    String errorsMother = "";
                    boolean hasMotherErrorsMax = false;
                    boolean hasMotherErrorsMin = false;
                    int motherMax = 0;
                    int motherMin = 0;
                    try {
                        motherMax = Integer.parseInt(findByParentEarningView.getJTextFieldMotherMaxForFindIndex4().getText());
                    } catch (Exception exception) {
                        hasMotherErrorsMax = true;
                        errorsMother += "Неправильно введено поле: Введите зарплату матери до \n";
                    }
                    try {
                        motherMin = Integer.parseInt(findByParentEarningView.getJTextFieldMotherMinForFindIndex4().getText());
                    } catch (Exception exception) {
                        hasMotherErrorsMin = true;
                        errorsMother += "Неправильно введено поле: Введите зарплату матери от";
                    }
                    if (hasMotherErrorsMin && hasMotherErrorsMax) {
                        JOptionPane.showMessageDialog(null, errorsMother);
                        return;
                    }

                    if (!(hasFatherErrorsMin || hasFatherErrorsMax)) {
                        for (int i = 0; i < studentArrayList.size(); i++) {
                            if (studentArrayList.get(i).getFatherEarnings() >= fatherMin && studentArrayList.get(i).getFatherEarnings() <= fatherMax) {
                                fatherArrayList.add(studentArrayList.get(i));
                            }
                        }
                    } else if (!hasFatherErrorsMin) {
                        for (int i = 0; i < studentArrayList.size(); i++) {
                            if (studentArrayList.get(i).getFatherEarnings() >= fatherMin) {
                                fatherArrayList.add(studentArrayList.get(i));
                            }
                        }
                    } else {
                        for (int i = 0; i < studentArrayList.size(); i++) {
                            if (studentArrayList.get(i).getFatherEarnings() <= fatherMax) {
                                fatherArrayList.add(studentArrayList.get(i));
                            }
                        }
                    }

                    if (!(hasMotherErrorsMin || hasMotherErrorsMax)) {
                        for (int i = 0; i < studentArrayList.size(); i++) {
                            if (studentArrayList.get(i).getMotherEarnings() >= motherMin && studentArrayList.get(i).getMotherEarnings() <= motherMax) {
                                motherArrayList.add(studentArrayList.get(i));
                            }
                        }
                    } else if (!hasMotherErrorsMin) {
                        for (int i = 0; i < studentArrayList.size(); i++) {
                            if (studentArrayList.get(i).getMotherEarnings() >= motherMin) {
                                motherArrayList.add(studentArrayList.get(i));
                            }
                        }
                    } else {
                        for (int i = 0; i < studentArrayList.size(); i++) {
                            if (studentArrayList.get(i).getMotherEarnings() <= motherMax) {
                                motherArrayList.add(studentArrayList.get(i));
                            }
                        }
                    }


                    ArrayList<Integer> motherCheck = new ArrayList<>();
                    ArrayList<Integer> fatherCheck = new ArrayList<>();


                    for (int i = 0; i < fatherArrayList.size(); i++) {
                        for (int j = 0; j < motherArrayList.size(); j++) {
                            if (fatherArrayList.get(i).equals(motherArrayList.get(j))) {
                                if (motherCheck.contains(j) || fatherCheck.contains(i)) {
                                    continue;
                                }
                                motherCheck.add(j);
                                fatherCheck.add(i);
                                studentArrayListFind.add(fatherArrayList.get(i));
                                findDialogView.findFrameInformationUpdate();
                                if (findDialogView.getNumberOfRowsOnPageForFind() < studentArrayListFind.size()) {
                                    continue;
                                }
                                Utilities.jTableUpdate(findDialogView.getDefaultTableModelForButtonFind(), findDialogView.getJTableForButtonFind(), findDialogView.getJPanelForFind(), studentArrayListFind);
                            }
                        }
                    }


                } else if (findByParentEarningView.getJRadioButtonFatherMoneyEnable().isSelected()) {
                    String errors = "";
                    boolean hasErrorsMax = false;
                    boolean hasErrorsMin = false;
                    int fatherMax = 0;
                    int fatherMin = 0;
                    try {
                        fatherMax = Integer.parseInt(findByParentEarningView.getJTextFieldFatherMaxForFindIndex4().getText());
                    } catch (Exception exception) {
                        hasErrorsMax = true;
                        errors += "Неправильно введено поле: Введите зарплату отца до \n";
                    }
                    try {
                        fatherMin = Integer.parseInt(findByParentEarningView.getJTextFieldFatherMinForFindIndex4().getText());
                    } catch (Exception exception) {
                        hasErrorsMin = true;
                        errors += "Неправильно введено поле: Введите зарплату отца от";
                    }
                    if (hasErrorsMin && hasErrorsMax) {
                        JOptionPane.showMessageDialog(null, errors);
                        return;
                    }

                    if (!(hasErrorsMin || hasErrorsMax)) {
                        for (int i = 0; i < studentArrayList.size(); i++) {
                            if (studentArrayList.get(i).getFatherEarnings() >= fatherMin && studentArrayList.get(i).getFatherEarnings() <= fatherMax) {
                                studentArrayListFind.add(studentArrayList.get(i));
                                findDialogView.findFrameInformationUpdate();
                                if (findDialogView.getNumberOfRowsOnPageForFind() <= i) {
                                    continue;
                                }
                                Utilities.jTableUpdate(findDialogView.getDefaultTableModelForButtonFind(), findDialogView.getJTableForButtonFind(),
                                        findDialogView.getJPanelForFind(), studentArrayListFind);
                            }
                        }
                    } else if (!hasErrorsMin) {
                        for (int i = 0; i < studentArrayList.size(); i++) {
                            if (studentArrayList.get(i).getFatherEarnings() >= fatherMin) {
                                studentArrayListFind.add(studentArrayList.get(i));
                                findDialogView.findFrameInformationUpdate();
                                if (findDialogView.getNumberOfRowsOnPageForFind() <= i) {
                                    continue;
                                }
                                Utilities.jTableUpdate(findDialogView.getDefaultTableModelForButtonFind(), findDialogView.getJTableForButtonFind(),
                                        findDialogView.getJPanelForFind(), studentArrayListFind);
                            }
                        }
                    } else {
                        for (int i = 0; i < studentArrayList.size(); i++) {
                            if (studentArrayList.get(i).getFatherEarnings() <= fatherMax) {
                                studentArrayListFind.add(studentArrayList.get(i));
                                findDialogView.findFrameInformationUpdate();
                                if (findDialogView.getNumberOfRowsOnPageForFind() <= i) {
                                    continue;
                                }
                                Utilities.jTableUpdate(findDialogView.getDefaultTableModelForButtonFind(), findDialogView.getJTableForButtonFind(),
                                        findDialogView.getJPanelForFind(), studentArrayListFind);
                            }
                        }
                    }


                } else if (findByParentEarningView.getJRadioButtonMotherMoneyEnable().isSelected()) {
                    String errors = "";
                    boolean hasErrorsMax = false;
                    boolean hasErrorsMin = false;
                    int motherMax = 0;
                    int motherMin = 0;
                    try {
                        motherMax = Integer.parseInt(findByParentEarningView.getJTextFieldMotherMaxForFindIndex4().getText());
                    } catch (Exception exception) {
                        hasErrorsMax = true;
                        errors += "Неправильно введено поле: Введите зарплату матери до \n";
                    }
                    try {
                        motherMin = Integer.parseInt(findByParentEarningView.getJTextFieldMotherMinForFindIndex4().getText());
                    } catch (Exception exception) {
                        hasErrorsMin = true;
                        errors += "Неправильно введено поле: Введите зарплату матери от";
                    }
                    if (hasErrorsMin && hasErrorsMax) {
                        JOptionPane.showMessageDialog(null, errors);
                        return;
                    }

                    if (!(hasErrorsMin || hasErrorsMax)) {
                        for (int i = 0; i < studentArrayList.size(); i++) {
                            if (studentArrayList.get(i).getMotherEarnings() >= motherMin && studentArrayList.get(i).getMotherEarnings() <= motherMax) {
                                studentArrayListFind.add(studentArrayList.get(i));
                                findDialogView.findFrameInformationUpdate();
                                if (findDialogView.getNumberOfRowsOnPageForFind() <= i) {
                                    continue;
                                }
                                Utilities.jTableUpdate(findDialogView.getDefaultTableModelForButtonFind(), findDialogView.getJTableForButtonFind(),
                                        findDialogView.getJPanelForFind(), studentArrayListFind);
                            }
                        }
                    } else if (!hasErrorsMin) {
                        for (int i = 0; i < studentArrayList.size(); i++) {
                            if (studentArrayList.get(i).getMotherEarnings() >= motherMin) {
                                studentArrayListFind.add(studentArrayList.get(i));
                                findDialogView.findFrameInformationUpdate();
                                if (findDialogView.getNumberOfRowsOnPageForFind() <= i) {
                                    continue;
                                }
                                Utilities.jTableUpdate(findDialogView.getDefaultTableModelForButtonFind(), findDialogView.getJTableForButtonFind(),
                                        findDialogView.getJPanelForFind(), studentArrayListFind);
                            }
                        }
                    } else {
                        for (int i = 0; i < studentArrayList.size(); i++) {
                            if (studentArrayList.get(i).getMotherEarnings() <= motherMax) {
                                studentArrayListFind.add(studentArrayList.get(i));
                                findDialogView.findFrameInformationUpdate();
                                if (findDialogView.getNumberOfRowsOnPageForFind() <= i) {
                                    continue;
                                }
                                Utilities.jTableUpdate(findDialogView.getDefaultTableModelForButtonFind(), findDialogView.getJTableForButtonFind(), findDialogView.getJPanelForFind(), studentArrayListFind);
                            }
                        }
                    }


                }
                findDialogView.findFrameInformationUpdate();
            }
        });
        
    }
    
    private void jRadioButtonUpdate(){
        FindByParentEarningView variables = FindByParentEarningView.getInstance();
        Utilities.jRadioButtonCheck(variables.getJRadioButtonFatherMoneyEnable(), variables.getJRadioButtonMotherMoneyEnable(),
                variables.getJTextFieldFatherMinForFindIndex4(), variables.getJTextFieldFatherMaxForFindIndex4(),
                variables.getJTextFieldMotherMinForFindIndex4(), variables.getJTextFieldMotherMaxForFindIndex4());
    }
}
