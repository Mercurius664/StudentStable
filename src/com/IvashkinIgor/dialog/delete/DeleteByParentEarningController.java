package com.IvashkinIgor.dialog.delete;

import com.IvashkinIgor.main.MainDialogController;
import com.IvashkinIgor.model.Model;
import com.IvashkinIgor.model.Student;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DeleteByParentEarningController {
    private static DeleteByParentEarningController deleteByParentEarningController;

    public static DeleteByParentEarningController getInstance(){
        if (deleteByParentEarningController == null){
            deleteByParentEarningController = new DeleteByParentEarningController();
        }
        return deleteByParentEarningController;
    }



    private DeleteByParentEarningController() {
        DeleteByParentEarningView valueVariables = DeleteByParentEarningView.getInstance();
        ArrayList<Student> studentArrayList = Model.getInstance().getStudentArrayList();
        valueVariables.getJRadioButtonFatherMoneyDeleteEnable().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateJRadioButton();
            }
        });
        valueVariables.getJRadioButtonMotherMoneyDeleteEnable().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateJRadioButton();
            }
        });

        valueVariables.getJButtonForDeleteIndex4().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!valueVariables.getJRadioButtonFatherMoneyDeleteEnable().isSelected() &&
                        !valueVariables.getJRadioButtonMotherMoneyDeleteEnable().isSelected()) {
                    return;
                } else if (valueVariables.getJRadioButtonFatherMoneyDeleteEnable().isSelected() &&
                        valueVariables.getJRadioButtonMotherMoneyDeleteEnable().isSelected()) {
                    ArrayList<Student> fatherArrayList = new ArrayList<>();
                    ArrayList<Student> motherArrayList = new ArrayList<>();
                    String errorsFather = "";
                    boolean hasFatherErrorsMax = false;
                    boolean hasFatherErrorsMin = false;
                    int fatherMax = 0;
                    int fatherMin = 0;
                    try {
                        fatherMax = Integer.parseInt(valueVariables.getJTextFieldFatherMaxForDeleteIndex4().getText());
                    } catch (Exception exception) {
                        hasFatherErrorsMax = true;
                        errorsFather += "Неправильно введено поле: Введите зарплату отца до \n";
                    }
                    try {
                        fatherMin = Integer.parseInt(valueVariables.getJTextFieldFatherMinForDeleteIndex4().getText());
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
                        motherMax = Integer.parseInt(valueVariables.getJTextFieldMotherMaxForDeleteIndex4().getText());
                    } catch (Exception exception) {
                        hasMotherErrorsMax = true;
                        errorsMother += "Неправильно введено поле: Введите зарплату матери до \n";
                    }
                    try {
                        motherMin = Integer.parseInt(valueVariables.getJTextFieldMotherMinForDeleteIndex4().getText());
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


                    ArrayList<Student> arrayListDelete = new ArrayList<>();
                    for (int i = 0; i < fatherArrayList.size(); i++) {
                        for (int j = 0; j < motherArrayList.size(); j++) {
                            if (fatherArrayList.get(i).equals(motherArrayList.get(j))) {
                                if (motherCheck.contains(j) || fatherCheck.contains(i)) {
                                    continue;
                                }
                                motherCheck.add(j);
                                fatherCheck.add(i);
                                arrayListDelete.add(fatherArrayList.get(i));


                            }
                        }
                    }
                    for (int i = 0; i < arrayListDelete.size(); i++) {
                        studentArrayList.remove(arrayListDelete.get(i));
                    }
                    JOptionPane.showMessageDialog(null, "Удалено " + arrayListDelete.size() + " записей");

                } else if (valueVariables.getJRadioButtonFatherMoneyDeleteEnable().isSelected()) {
                    String errors = "";
                    boolean hasErrorsMax = false;
                    boolean hasErrorsMin = false;
                    int fatherMax = 0;
                    int fatherMin = 0;
                    try {
                        fatherMax = Integer.parseInt(valueVariables.getJTextFieldFatherMaxForDeleteIndex4().getText());
                    } catch (Exception exception) {
                        hasErrorsMax = true;
                        errors += "Неправильно введено поле: Введите зарплату отца до \n";
                    }
                    try {
                        fatherMin = Integer.parseInt(valueVariables.getJTextFieldFatherMinForDeleteIndex4().getText());
                    } catch (Exception exception) {
                        hasErrorsMin = true;
                        errors += "Неправильно введено поле: Введите зарплату отца от";
                    }
                    if (hasErrorsMin && hasErrorsMax) {
                        JOptionPane.showMessageDialog(null, errors);
                        return;
                    }

                    if (!(hasErrorsMin || hasErrorsMax)) {
                        ArrayList<Student> arrayListDelete = new ArrayList<>();
                        for (int i = 0; i < studentArrayList.size(); i++) {
                            if (studentArrayList.get(i).getFatherEarnings() >= fatherMin && studentArrayList.get(i).getFatherEarnings() <= fatherMax) {
                                arrayListDelete.add(studentArrayList.get(i));

                            }
                        }
                        for (int i = 0; i < arrayListDelete.size(); i++) {
                            studentArrayList.remove(arrayListDelete.get(i));
                        }
                        JOptionPane.showMessageDialog(null, "Удалено " + arrayListDelete.size() + " записей");
                    } else if (!hasErrorsMin) {
                        ArrayList<Student> arrayListDelete = new ArrayList<>();
                        for (int i = 0; i < studentArrayList.size(); i++) {
                            if (studentArrayList.get(i).getFatherEarnings() >= fatherMin) {
                                arrayListDelete.add(studentArrayList.get(i));
                            }
                        }
                        for (int i = 0; i < arrayListDelete.size(); i++) {
                            studentArrayList.remove(arrayListDelete.get(i));
                        }
                        JOptionPane.showMessageDialog(null, "Удалено " + arrayListDelete.size() + " записей");
                    } else {
                        ArrayList<Student> arrayListDelete = new ArrayList<>();
                        for (int i = 0; i < studentArrayList.size(); i++) {
                            if (studentArrayList.get(i).getFatherEarnings() <= fatherMax) {
                                arrayListDelete.add(studentArrayList.get(i));

                            }
                        }
                        for (int i = 0; i < arrayListDelete.size(); i++) {
                            studentArrayList.remove(arrayListDelete.get(i));
                        }
                        JOptionPane.showMessageDialog(null, "Удалено " + arrayListDelete.size() + " записей");
                    }
                    MainDialogController.getInstance().updateNumberInformation();

                } else if (valueVariables.getJRadioButtonMotherMoneyDeleteEnable().isSelected()) {
                    String errors = "";
                    boolean hasErrorsMax = false;
                    boolean hasErrorsMin = false;
                    int motherMax = 0;
                    int motherMin = 0;
                    try {
                        motherMax = Integer.parseInt(valueVariables.getJTextFieldMotherMaxForDeleteIndex4().getText());
                    } catch (Exception exception) {
                        hasErrorsMax = true;
                        errors += "Неправильно введено поле: Введите зарплату матери до \n";
                    }
                    try {
                        motherMin = Integer.parseInt(valueVariables.getJTextFieldMotherMinForDeleteIndex4().getText());
                    } catch (Exception exception) {
                        hasErrorsMin = true;
                        errors += "Неправильно введено поле: Введите зарплату матери от";
                    }
                    if (hasErrorsMin && hasErrorsMax) {
                        JOptionPane.showMessageDialog(null, errors);
                        return;
                    }

                    if (!(hasErrorsMin || hasErrorsMax)) {
                        ArrayList<Student> arrayListDelete = new ArrayList<>();
                        for (int i = 0; i < studentArrayList.size(); i++) {
                            if (studentArrayList.get(i).getMotherEarnings() >= motherMin && studentArrayList.get(i).getMotherEarnings() <= motherMax) {
                                arrayListDelete.add(studentArrayList.get(i));

                            }
                        }
                        for (int i = 0; i < arrayListDelete.size(); i++) {
                            studentArrayList.remove(arrayListDelete.get(i));
                        }
                        JOptionPane.showMessageDialog(null, "Удалено " + arrayListDelete.size() + " записей");
                    } else if (!hasErrorsMin) {
                        ArrayList<Student> arrayListDelete = new ArrayList<>();
                        for (int i = 0; i < studentArrayList.size(); i++) {
                            if (studentArrayList.get(i).getMotherEarnings() >= motherMin) {
                                arrayListDelete.add(studentArrayList.get(i));

                            }

                        }
                        for (int i = 0; i < arrayListDelete.size(); i++) {
                            studentArrayList.remove(arrayListDelete.get(i));
                        }
                        JOptionPane.showMessageDialog(null, "Удалено " + arrayListDelete.size() + " записей");
                    } else {
                        ArrayList<Student> arrayListDelete = new ArrayList<>();
                        for (int i = 0; i < studentArrayList.size(); i++) {
                            if (studentArrayList.get(i).getMotherEarnings() <= motherMax) {
                                arrayListDelete.add(studentArrayList.get(i));

                            }
                        }
                        for (int i = 0; i < arrayListDelete.size(); i++) {
                            studentArrayList.remove(arrayListDelete.get(i));
                        }
                        JOptionPane.showMessageDialog(null, "Удалено " + arrayListDelete.size() + " записей");

                    }
                    MainDialogController.getInstance().updateNumberInformation();


                }
            }
        });
    }

   /* private void updateNumberInformation(){
        MainDialogView mainDialogView = MainDialogView.getInstance();
        mainDialogView.setCurrentPageNumber(1);
        mainDialogView.updateCurrentPageNumber();
        updateRowsOnPage();
        mainDialogView.updateJLabelNumbersOfRecords();
        mainDialogView.updateJLabelTotalPages();
        mainDialogView.updateJLabelNumberOfRecordsOnPage();
    }

    private void updateRowsOnPage() {
        MainDialogView mainDialogView = MainDialogView.getInstance();
        MainDialogController mainDialogController = MainDialogController.getInstance();
        numberOfRowsOnPageLogic(mainDialogView.getDefaultTableModel(), Model.getInstance().getStudentArrayList(),
                mainDialogController.getNumberOfRowsOnPage(), mainDialogView.getCurrentPageNumber());
    }

    private static void numberOfRowsOnPageLogic(DefaultTableModel defaultTableModel, ArrayList<Student> arrayList, int numberOfRows, int currentPage) {

        int rowCount = defaultTableModel.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            defaultTableModel.removeRow(0);
        }
        for (int i = (currentPage * numberOfRows - numberOfRows); i < arrayList.size(); i++) {
            if (defaultTableModel.getRowCount() >= numberOfRows) {
                break;
            }
            Object[] tableContent = new String[]{
                    arrayList.get(i).getStudentName(),
                    arrayList.get(i).getFatherName(),
                    String.valueOf(arrayList.get(i).getFatherEarnings()),
                    arrayList.get(i).getMotherName(),
                    String.valueOf(arrayList.get(i).getMotherEarnings()),
                    String.valueOf(arrayList.get(i).getNumberOfBrothers()),
                    String.valueOf(arrayList.get(i).getNumberOfSisters())
            };
            defaultTableModel.addRow(tableContent);

        }

    }*/


    private void updateJRadioButton(){
        DeleteByParentEarningView valueVariable = DeleteByParentEarningView.getInstance();
        jRadioButtonCheck(valueVariable.getJRadioButtonFatherMoneyDeleteEnable(),
                valueVariable.getJRadioButtonMotherMoneyDeleteEnable(),
                valueVariable.getJTextFieldFatherMinForDeleteIndex4(),
                valueVariable.getJTextFieldFatherMaxForDeleteIndex4(),
                valueVariable.getJTextFieldMotherMinForDeleteIndex4(),
                valueVariable.getJTextFieldMotherMaxForDeleteIndex4());
    }

    private static void jRadioButtonCheck(JRadioButton jRadioButton1, JRadioButton jRadioButton2,
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
